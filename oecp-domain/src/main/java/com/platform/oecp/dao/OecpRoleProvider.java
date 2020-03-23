package com.platform.oecp.dao;

import com.platform.oecp.models.dos.OecpRoleDO;
import com.platform.oecp.models.qc.OecpRoleQC;
import red.lixiang.tools.common.mybatis.MapperUtils;
import org.apache.ibatis.builder.annotation.ProviderMethodResolver;
import org.apache.ibatis.jdbc.SQL;
import red.lixiang.tools.jdk.SnowflakeGenerator;

/**
 * @author lixiang
 */
public class OecpRoleProvider implements ProviderMethodResolver {

    private static final String TABLE_FIELDS = MapperUtils.getTableFieldName(OecpRoleDO.class);

    public String listOecpRoles(OecpRoleQC oecpRoleQC){
        SQL sql = new SQL() {{
            SELECT(TABLE_FIELDS);
            FROM("oecp_role");
            WHERE("del_flag = 0");
        }};
        MapperUtils.richWhereSql(sql, oecpRoleQC);

        return sql.toString();
    }

    public String countOecpRoles(OecpRoleQC oecpRoleQC){
        SQL sql = new SQL() {{
            SELECT("count(1)");
            FROM("oecp_role");
            WHERE("del_flag = 0");
        }};
        MapperUtils.richWhereSql(sql, oecpRoleQC);

        return sql.toString();
    }

    public String insertOecpRole(OecpRoleDO oecpRole){
        oecpRole.setId(SnowflakeGenerator.generateKey());
        SQL sql = new SQL() {{
            INSERT_INTO("oecp_role");
        }};
        MapperUtils.richInsertSql(sql, oecpRole);

        return sql.toString();
    }
    public String updateOecpRole(OecpRoleDO oecpRole) {
        SQL sql = new SQL() {{
            UPDATE("oecp_role");

        }};
        MapperUtils.richUpdate(sql, oecpRole);
        sql.WHERE("id = #{id}");
        return sql.toString();
    }

    public String removeOecpRoleById(long id){
            SQL sql = new SQL() {{
                UPDATE("oecp_role");
                SET("del_flag = 1");
            }};
            sql.WHERE("id = #{id}");
            return sql.toString();
    }

}