package com.platform.oecp.dao;

import com.platform.oecp.models.dos.OecpErrorTagDO;
import com.platform.oecp.models.qc.OecpErrorTagQC;
import red.lixiang.tools.common.mybatis.MapperUtils;
import org.apache.ibatis.builder.annotation.ProviderMethodResolver;
import org.apache.ibatis.jdbc.SQL;
import red.lixiang.tools.jdk.SnowflakeGenerator;

/**
 * @author lixiang
 */
public class OecpErrorTagProvider implements ProviderMethodResolver {

    private static final String TABLE_FIELDS = MapperUtils.getTableFieldName(OecpErrorTagDO.class);

    public String listOecpErrorTags(OecpErrorTagQC oecpErrorTagQC){
        SQL sql = new SQL() {{
            SELECT(TABLE_FIELDS);
            FROM("oecp_error_tag");
            WHERE("del_flag = 0");
        }};
        MapperUtils.richWhereSql(sql, oecpErrorTagQC);

        return sql.toString();
    }

    public String countOecpErrorTags(OecpErrorTagQC oecpErrorTagQC){
        SQL sql = new SQL() {{
            SELECT("count(1)");
            FROM("oecp_error_tag");
            WHERE("del_flag = 0");
        }};
        MapperUtils.richWhereSql(sql, oecpErrorTagQC);

        return sql.toString();
    }

    public String insertOecpErrorTag(OecpErrorTagDO oecpErrorTag){
        oecpErrorTag.setId(SnowflakeGenerator.generateKey());
        SQL sql = new SQL() {{
            INSERT_INTO("oecp_error_tag");
        }};
        MapperUtils.richInsertSql(sql, oecpErrorTag);

        return sql.toString();
    }
    public String updateOecpErrorTag(OecpErrorTagDO oecpErrorTag) {
        SQL sql = new SQL() {{
            UPDATE("oecp_error_tag");

        }};
        MapperUtils.richUpdate(sql, oecpErrorTag);
        sql.WHERE("id = #{id}");
        return sql.toString();
    }

    public String removeOecpErrorTagById(long id){
            SQL sql = new SQL() {{
                UPDATE("oecp_error_tag");
                SET("del_flag = 1");
            }};
            sql.WHERE("id = #{id}");
            return sql.toString();
    }

}