package com.platform.oecp.dao;

import com.platform.oecp.models.dos.OecpCaseTagDO;
import com.platform.oecp.models.qc.OecpCaseTagQC;
import red.lixiang.tools.common.mybatis.MapperUtils;
import org.apache.ibatis.builder.annotation.ProviderMethodResolver;
import org.apache.ibatis.jdbc.SQL;

/**
 * @author lixiang
 */
public class OecpCaseTagProvider implements ProviderMethodResolver {

    private static final String TABLE_FIELDS = MapperUtils.getTableFieldName(OecpCaseTagDO.class);

    public String listOecpCaseTags(OecpCaseTagQC oecpCaseTagQC){
        SQL sql = new SQL() {{
            SELECT(TABLE_FIELDS);
            FROM("oecp_case_tag");
        }};
        MapperUtils.richWhereSql(sql, oecpCaseTagQC);

        return sql.toString();
    }

    public String countOecpCaseTags(OecpCaseTagQC oecpCaseTagQC){
        SQL sql = new SQL() {{
            SELECT("count(1)");
            FROM("oecp_case_tag");
        }};
        MapperUtils.richWhereSql(sql, oecpCaseTagQC);

        return sql.toString();
    }

    public String insertOecpCaseTag(OecpCaseTagDO oecpCaseTag){
        SQL sql = new SQL() {{
            INSERT_INTO("oecp_case_tag");
        }};
        MapperUtils.richInsertSql(sql, oecpCaseTag);

        return sql.toString();
    }
    public String updateOecpCaseTag(OecpCaseTagDO oecpCaseTag) {
        SQL sql = new SQL() {{
            UPDATE("oecp_case_tag");

        }};
        MapperUtils.richUpdate(sql, oecpCaseTag);
        sql.WHERE("id = #{id}");
        return sql.toString();
    }

    public String removeOecpCaseTagById(long id){
            SQL sql = new SQL() {{
                UPDATE("oecp_case_tag");
                SET("delete_flag = 1");
            }};
            sql.WHERE("id = #{id}");
            return sql.toString();
    }

}