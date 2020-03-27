package com.platform.oecp.dao;

import com.platform.oecp.models.dos.OecpSearchMainDO;
import com.platform.oecp.models.qc.OecpSearchMainQC;
import red.lixiang.tools.common.mybatis.MapperUtils;
import org.apache.ibatis.builder.annotation.ProviderMethodResolver;
import org.apache.ibatis.jdbc.SQL;

/**
 * @author lixiang
 */
public class OecpSearchMainProvider implements ProviderMethodResolver {

    private static final String TABLE_FIELDS = MapperUtils.getTableFieldName(OecpSearchMainDO.class);

    public String listOecpSearchMains(OecpSearchMainQC oecpSearchMainQC){
        SQL sql = new SQL() {{
            SELECT(TABLE_FIELDS);
            FROM("oecp_search_main");
        }};
        MapperUtils.richWhereSql(sql, oecpSearchMainQC);

        return sql.toString();
    }

    public String countOecpSearchMains(OecpSearchMainQC oecpSearchMainQC){
        SQL sql = new SQL() {{
            SELECT("count(1)");
            FROM("oecp_search_main");
        }};
        MapperUtils.richWhereSql(sql, oecpSearchMainQC);

        return sql.toString();
    }

    public String insertOecpSearchMain(OecpSearchMainDO oecpSearchMain){
        SQL sql = new SQL() {{
            INSERT_INTO("oecp_search_main");
        }};
        MapperUtils.richInsertSql(sql, oecpSearchMain);

        return sql.toString();
    }
    public String updateOecpSearchMain(OecpSearchMainDO oecpSearchMain) {
        SQL sql = new SQL() {{
            UPDATE("oecp_search_main");

        }};
        MapperUtils.richUpdate(sql, oecpSearchMain);
        sql.WHERE("id = #{id}");
        return sql.toString();
    }

    public String removeOecpSearchMainById(long id){
            SQL sql = new SQL() {{
                UPDATE("oecp_search_main");
                SET("delete_flag = 1");
            }};
            sql.WHERE("id = #{id}");
            return sql.toString();
    }

}