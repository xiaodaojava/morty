package com.platform.oecp.dao;

import com.platform.oecp.models.dos.OecpSearchUseDO;
import com.platform.oecp.models.qc.OecpSearchUseQC;
import red.lixiang.tools.common.mybatis.MapperUtils;
import org.apache.ibatis.builder.annotation.ProviderMethodResolver;
import org.apache.ibatis.jdbc.SQL;

/**
 * @author lixiang
 */
public class OecpSearchUseProvider implements ProviderMethodResolver {

    private static final String TABLE_FIELDS = MapperUtils.getTableFieldName(OecpSearchUseDO.class);

    public String listOecpSearchUses(OecpSearchUseQC oecpSearchUseQC){
        SQL sql = new SQL() {{
            SELECT(TABLE_FIELDS);
            FROM("oecp_search_use");
        }};
        MapperUtils.richWhereSql(sql, oecpSearchUseQC);

        return sql.toString();
    }

    public String countOecpSearchUses(OecpSearchUseQC oecpSearchUseQC){
        SQL sql = new SQL() {{
            SELECT("count(1)");
            FROM("oecp_search_use");
        }};
        MapperUtils.richWhereSql(sql, oecpSearchUseQC);

        return sql.toString();
    }

    public String insertOecpSearchUse(OecpSearchUseDO oecpSearchUse){
        SQL sql = new SQL() {{
            INSERT_INTO("oecp_search_use");
        }};
        MapperUtils.richInsertSql(sql, oecpSearchUse);

        return sql.toString();
    }
    public String updateOecpSearchUse(OecpSearchUseDO oecpSearchUse) {
        SQL sql = new SQL() {{
            UPDATE("oecp_search_use");

        }};
        MapperUtils.richUpdate(sql, oecpSearchUse);
        sql.WHERE("id = #{id}");
        return sql.toString();
    }

    public String removeOecpSearchUseById(long id){
            SQL sql = new SQL() {{
                UPDATE("oecp_search_use");
                SET("delete_flag = 1");
            }};
            sql.WHERE("id = #{id}");
            return sql.toString();
    }

}