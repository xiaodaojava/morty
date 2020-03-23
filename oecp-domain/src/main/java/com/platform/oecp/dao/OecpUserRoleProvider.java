package com.platform.oecp.dao;

import com.platform.oecp.models.dos.OecpUserRoleDO;
import com.platform.oecp.models.qc.OecpUserRoleQC;
import red.lixiang.tools.common.mybatis.MapperUtils;
import org.apache.ibatis.builder.annotation.ProviderMethodResolver;
import org.apache.ibatis.jdbc.SQL;
import red.lixiang.tools.jdk.SnowflakeGenerator;

/**
 * @author lixiang
 */
public class OecpUserRoleProvider implements ProviderMethodResolver {

    private static final String TABLE_FIELDS = MapperUtils.getTableFieldName(OecpUserRoleDO.class);

    public String listOecpUserRoles(OecpUserRoleQC oecpUserRoleQC){
        SQL sql = new SQL() {{
            SELECT(TABLE_FIELDS);
            FROM("oecp_user_role");
            WHERE("del_flag = 0");
        }};
        MapperUtils.richWhereSql(sql, oecpUserRoleQC);

        return sql.toString();
    }

    public String countOecpUserRoles(OecpUserRoleQC oecpUserRoleQC){
        SQL sql = new SQL() {{
            SELECT("count(1)");
            FROM("oecp_user_role");
            WHERE("del_flag = 0");
        }};
        MapperUtils.richWhereSql(sql, oecpUserRoleQC);

        return sql.toString();
    }

    public String insertOecpUserRole(OecpUserRoleDO oecpUserRole){
        oecpUserRole.setId(SnowflakeGenerator.generateKey());
        SQL sql = new SQL() {{
            INSERT_INTO("oecp_user_role");
        }};
        MapperUtils.richInsertSql(sql, oecpUserRole);

        return sql.toString();
    }
    public String updateOecpUserRole(OecpUserRoleDO oecpUserRole) {
        SQL sql = new SQL() {{
            UPDATE("oecp_user_role");

        }};
        MapperUtils.richUpdate(sql, oecpUserRole);
        sql.WHERE("id = #{id}");
        return sql.toString();
    }

    public String removeOecpUserRoleById(long id){
            SQL sql = new SQL() {{
                UPDATE("oecp_user_role");
                SET("del_flag = 1");
            }};
            sql.WHERE("id = #{id}");
            return sql.toString();
    }

}