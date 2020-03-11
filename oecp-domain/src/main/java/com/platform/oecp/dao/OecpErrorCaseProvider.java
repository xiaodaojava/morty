package com.platform.oecp.dao;

import com.platform.oecp.models.dos.OecpErrorCaseDO;
import com.platform.oecp.models.qc.OecpErrorCaseQC;
import red.lixiang.tools.common.mybatis.MapperUtils;
import org.apache.ibatis.builder.annotation.ProviderMethodResolver;
import org.apache.ibatis.jdbc.SQL;

/**
 * @author lixiang
 */
public class OecpErrorCaseProvider implements ProviderMethodResolver {

    private static final String TABLE_FIELDS = MapperUtils.getTableFieldName(OecpErrorCaseDO.class);

    public String listOecpErrorCases(OecpErrorCaseQC oecpErrorCaseQC){
        SQL sql = new SQL() {{
            SELECT(TABLE_FIELDS);
            FROM("oecp_error_case");
        }};
        MapperUtils.richWhereSql(sql, oecpErrorCaseQC);

        return sql.toString();
    }

    public String countOecpErrorCases(OecpErrorCaseQC oecpErrorCaseQC){
        SQL sql = new SQL() {{
            SELECT("count(1)");
            FROM("oecp_error_case");
        }};
        MapperUtils.richWhereSql(sql, oecpErrorCaseQC);

        return sql.toString();
    }

    public String insertOecpErrorCase(OecpErrorCaseDO oecpErrorCase){
        SQL sql = new SQL() {{
            INSERT_INTO("oecp_error_case");
        }};
        MapperUtils.richInsertSql(sql, oecpErrorCase);

        return sql.toString();
    }
    public String updateOecpErrorCase(OecpErrorCaseDO oecpErrorCase) {
        SQL sql = new SQL() {{
            UPDATE("oecp_error_case");

        }};
        MapperUtils.richUpdate(sql, oecpErrorCase);
        sql.WHERE("id = #{id}");
        return sql.toString();
    }

    public String removeOecpErrorCaseById(long id){
            SQL sql = new SQL() {{
                UPDATE("oecp_error_case");
                SET("delete_flag = 1");
            }};
            sql.WHERE("id = #{id}");
            return sql.toString();
    }

}