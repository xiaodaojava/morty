package com.platform.oecp.dao;

import com.platform.oecp.models.dos.OecpCaseInfoDO;
import com.platform.oecp.models.qc.OecpCaseInfoQC;
import red.lixiang.tools.common.mybatis.MapperUtils;
import org.apache.ibatis.builder.annotation.ProviderMethodResolver;
import org.apache.ibatis.jdbc.SQL;

/**
 * @author lixiang
 */
public class OecpCaseInfoProvider implements ProviderMethodResolver {

    private static final String TABLE_FIELDS = MapperUtils.getTableFieldName(OecpCaseInfoDO.class);

    public String listOecpCaseInfos(OecpCaseInfoQC oecpCaseInfoQC){
        SQL sql = new SQL() {{
            SELECT(TABLE_FIELDS);
            FROM("oecp_case_info");
        }};
        MapperUtils.richWhereSql(sql, oecpCaseInfoQC);

        return sql.toString();
    }

    public String countOecpCaseInfos(OecpCaseInfoQC oecpCaseInfoQC){
        SQL sql = new SQL() {{
            SELECT("count(1)");
            FROM("oecp_case_info");
        }};
        MapperUtils.richWhereSql(sql, oecpCaseInfoQC);

        return sql.toString();
    }

    public String insertOecpCaseInfo(OecpCaseInfoDO oecpCaseInfo){
        SQL sql = new SQL() {{
            INSERT_INTO("oecp_case_info");
        }};
        MapperUtils.richInsertSql(sql, oecpCaseInfo);

        return sql.toString();
    }
    public String updateOecpCaseInfo(OecpCaseInfoDO oecpCaseInfo) {
        SQL sql = new SQL() {{
            UPDATE("oecp_case_info");

        }};
        MapperUtils.richUpdate(sql, oecpCaseInfo);
        sql.WHERE("id = #{id}");
        return sql.toString();
    }

    public String removeOecpCaseInfoById(long id){
            SQL sql = new SQL() {{
                UPDATE("oecp_case_info");
                SET("delete_flag = 1");
            }};
            sql.WHERE("id = #{id}");
            return sql.toString();
    }

}