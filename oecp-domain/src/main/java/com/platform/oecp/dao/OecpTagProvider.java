package com.platform.oecp.dao;

import com.platform.oecp.models.dos.OecpTagDO;
import com.platform.oecp.models.qc.OecpTagQC;
import red.lixiang.tools.common.mybatis.MapperUtils;
import org.apache.ibatis.builder.annotation.ProviderMethodResolver;
import org.apache.ibatis.jdbc.SQL;
import red.lixiang.tools.jdk.SnowflakeGenerator;

/**
 * @author lixiang
 */
public class OecpTagProvider implements ProviderMethodResolver {

    private static final String TABLE_FIELDS = MapperUtils.getTableFieldName(OecpTagDO.class);

    public String listOecpTags(OecpTagQC oecpTagQC){
        SQL sql = new SQL() {{
            SELECT(TABLE_FIELDS);
            FROM("oecp_tag");
        }};
        MapperUtils.richWhereSql(sql, oecpTagQC);

        return sql.toString();
    }

    public String searchOecpTagsByTag(String tag) {
        SQL sql = new SQL() {{
            SELECT(TABLE_FIELDS);
            FROM("oecp_tag");
            WHERE("match(tag) against ('" + tag + "' in natural language mode)");
            LIMIT(20);
        }};
        return sql.toString();
    }

    public String countOecpTags(OecpTagQC oecpTagQC){
        SQL sql = new SQL() {{
            SELECT("count(1)");
            FROM("oecp_tag");
        }};
        MapperUtils.richWhereSql(sql, oecpTagQC);

        return sql.toString();
    }

    public String insertOecpTag(OecpTagDO oecpTag){
        oecpTag.setId(SnowflakeGenerator.generateKey());
        SQL sql = new SQL() {{
            INSERT_INTO("oecp_tag");
        }};
        MapperUtils.richInsertSql(sql, oecpTag);

        return sql.toString();
    }
    public String updateOecpTag(OecpTagDO oecpTag) {
        SQL sql = new SQL() {{
            UPDATE("oecp_tag");

        }};
        MapperUtils.richUpdate(sql, oecpTag);
        sql.WHERE("id = #{id}");
        return sql.toString();
    }

    public String removeOecpTagById(long id){
            SQL sql = new SQL() {{
                UPDATE("oecp_tag");
                SET("delete_flag = 1");
            }};
            sql.WHERE("id = #{id}");
            return sql.toString();
    }

}