package com.platform.oecp.dao;

import com.platform.oecp.models.dos.OecpSearchSubDO;
import com.platform.oecp.models.qc.OecpSearchSubQC;
import red.lixiang.tools.common.mybatis.MapperUtils;
import org.apache.ibatis.builder.annotation.ProviderMethodResolver;
import org.apache.ibatis.jdbc.SQL;

/**
 * @author lixiang
 */
public class OecpSearchSubProvider implements ProviderMethodResolver {

    private static final String TABLE_FIELDS = MapperUtils.getTableFieldName(OecpSearchSubDO.class);

    public String listOecpSearchSubs(OecpSearchSubQC oecpSearchSubQC){
        SQL sql = new SQL() {{
            SELECT(TABLE_FIELDS);
            FROM("oecp_search_sub");
        }};
        MapperUtils.richWhereSql(sql, oecpSearchSubQC);

        return sql.toString();
    }

    public String countOecpSearchSubs(OecpSearchSubQC oecpSearchSubQC){
        SQL sql = new SQL() {{
            SELECT("count(1)");
            FROM("oecp_search_sub");
        }};
        MapperUtils.richWhereSql(sql, oecpSearchSubQC);

        return sql.toString();
    }

    public String insertOecpSearchSub(OecpSearchSubDO oecpSearchSub){
        SQL sql = new SQL() {{
            INSERT_INTO("oecp_search_sub");
        }};
        MapperUtils.richInsertSql(sql, oecpSearchSub);

        return sql.toString();
    }
    public String updateOecpSearchSub(OecpSearchSubDO oecpSearchSub) {
        SQL sql = new SQL() {{
            UPDATE("oecp_search_sub");

        }};
        MapperUtils.richUpdate(sql, oecpSearchSub);
        sql.WHERE("id = #{id}");
        return sql.toString();
    }

    public String removeOecpSearchSubById(long id){
            SQL sql = new SQL() {{
                UPDATE("oecp_search_sub");
                SET("delete_flag = 1");
            }};
            sql.WHERE("id = #{id}");
            return sql.toString();
    }

    public String removeOecpSearchMainByMainId(long mainId){
        SQL sql = new SQL() {{
            UPDATE("oecp_search_sub");
            SET("delete_flag = 1");
        }};
        sql.WHERE("search_main_id = #{mainId}");
        return sql.toString();
    }

    public String removeOecpSearchSubByCaseId(long caseId){
        SQL sql = new SQL() {{
            UPDATE("oecp_search_sub");
            SET("delete_flag = 1");
        }};
        sql.WHERE("case_tag = #{mainId}");
        return sql.toString();
    }

}