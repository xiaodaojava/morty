package com.platform.oecp.business.manager;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.body.VariableDeclarator;
import com.github.javaparser.ast.expr.Expression;
import com.github.javaparser.ast.expr.ObjectCreationExpr;
import com.github.javaparser.ast.stmt.ThrowStmt;
import com.github.javaparser.symbolsolver.JavaSymbolSolver;
import com.github.javaparser.symbolsolver.resolution.typesolvers.CombinedTypeSolver;
import com.github.javaparser.symbolsolver.resolution.typesolvers.ReflectionTypeSolver;
import com.platform.oecp.dao.OecpErrorInfoMapper;
import com.platform.oecp.models.dos.OecpErrorInfoDO;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import red.lixiang.tools.base.exception.BusinessException;

import javax.annotation.PostConstruct;
import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author gaozhirong 2020/3/22 14:57
 * @version 1.0
 * @description 代码检测逻辑类
 */
@Service
public class CodeDetectManager {

    @Autowired
    private OecpErrorInfoMapper oecpErrorInfoMapper;

    /**
     * 日志
     */
    private static final Logger logger = LoggerFactory.getLogger(CodeDetectManager.class);

    /**
     * 初始化时执行.
     */
    @PostConstruct
    public void init() {
        CombinedTypeSolver combinedTypeSolver = new CombinedTypeSolver();
        combinedTypeSolver.add(new ReflectionTypeSolver());

        // Configure JavaParser to use type resolution
        JavaSymbolSolver symbolSolver = new JavaSymbolSolver(combinedTypeSolver);
        StaticJavaParser.getConfiguration().setSymbolResolver(symbolSolver);
    }

    /**
     * 错误码检测代码.
     *
     * @param code 用户提交用于检测的代码
     */
    public void detectCode(String code) {
        Map<String, Object> variables = new HashMap<>();

        // Parse some code
        CompilationUnit cu;
        try{
            cu = StaticJavaParser.parse(code);
        } catch (Exception e) {
            throw new BusinessException("请填入正确有效的代码");
        }

        // 读取所有变量
        cu.findAll(FieldDeclaration.class).forEach(fieldDeclaration -> {
            NodeList<VariableDeclarator> nodeList = fieldDeclaration.getVariables();
            nodeList.forEach(variableDeclarator -> {
                Expression expression = variableDeclarator.getInitializer().get();
                variables.put(variableDeclarator.getNameAsString(), getValue(expression));
            });
        });

        Set<String> errorCodes = new HashSet<>();
        // Find all the calculations with two sides:
        cu.findAll(ThrowStmt.class).forEach(throwStmt -> {
            Expression expression = ((ObjectCreationExpr) throwStmt.getExpression()).getArguments().get(0);
            if (expression.isStringLiteralExpr()) {
                errorCodes.add(expression.asStringLiteralExpr().getValue());
            }
            if (expression.isNameExpr()) {
                errorCodes.add(String.valueOf(variables.get(expression.asNameExpr().getNameAsString())));
            }
        });

        errorCodes.stream()
                .filter(StringUtils::isNotBlank)
                .forEach(errorCode -> {
                    OecpErrorInfoDO oecpErrorInfoDO = oecpErrorInfoMapper.getByCode(errorCode);
                    if (oecpErrorInfoDO == null) {
                        throw new BusinessException("错误码【" + errorCode + "】不存在");
                    }
                });
    }

    /**
     * 根据 expression 获取对应的值.
     *
     * @param expression 各种表达式
     * @return 对应的值
     */
    private Object getValue(Expression expression) {
        if (expression.isStringLiteralExpr()) {
            return expression.asStringLiteralExpr().getValue();
        }
        if (expression.isIntegerLiteralExpr()) {
            return expression.asIntegerLiteralExpr().getValue();
        }
        return null;
    }

}
