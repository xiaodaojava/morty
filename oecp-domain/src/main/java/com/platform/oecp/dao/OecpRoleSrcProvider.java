package com.platform.oecp.dao;

import com.platform.oecp.models.dos.OecpRoleSrcDO;
import com.platform.oecp.models.qc.OecpRoleSrcQC;
import red.lixiang.tools.common.mybatis.MapperUtils;
import org.apache.ibatis.builder.annotation.ProviderMethodResolver;
import org.apache.ibatis.jdbc.SQL;
import red.lixiang.tools.jdk.SnowflakeGenerator;

/**
 * @author lixiang
 */
public class OecpRoleSrcProvider implements ProviderMethodResolver {

    private static final String TABLE_FIELDS = MapperUtils.getTableFieldName(OecpRoleSrcDO.class);

    public String listOecpRoleSrcs(OecpRoleSrcQC oecpRoleSrcQC){
        SQL sql = new SQL() {{
            SELECT(TABLE_FIELDS);
            FROM("oecp_role_src");
            WHERE("del_flag = 0");
        }};
        MapperUtils.richWhereSql(sql, oecpRoleSrcQC);

        return sql.toString();
    }

    public String countOecpRoleSrcs(OecpRoleSrcQC oecpRoleSrcQC){
        SQL sql = new SQL() {{
            SELECT("count(1)");
            FROM("oecp_role_src");
            WHERE("del_flag = 0");
        }};
        MapperUtils.richWhereSql(sql, oecpRoleSrcQC);

        return sql.toString();
    }

    public String insertOecpRoleSrc(OecpRoleSrcDO oecpRoleSrc){
        oecpRoleSrc.setId(SnowflakeGenerator.generateKey());
        SQL sql = new SQL() {{
            INSERT_INTO("oecp_role_src");
        }};
        MapperUtils.richInsertSql(sql, oecpRoleSrc);

        return sql.toString();
    }
    public String updateOecpRoleSrc(OecpRoleSrcDO oecpRoleSrc) {
        SQL sql = new SQL() {{
            UPDATE("oecp_role_src");

        }};
        MapperUtils.richUpdate(sql, oecpRoleSrc);
        sql.WHERE("id = #{id}");
        return sql.toString();
    }

    public String removeOecpRoleSrcById(long id){
            SQL sql = new SQL() {{
                UPDATE("oecp_role_src");
                SET("del_flag = 1");
            }};
            sql.WHERE("id = #{id}");
            return sql.toString();
    }

}