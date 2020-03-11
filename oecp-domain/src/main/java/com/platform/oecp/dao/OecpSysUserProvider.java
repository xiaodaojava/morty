package com.platform.oecp.dao;

import com.platform.oecp.models.dos.OecpSysUserDO;
import com.platform.oecp.models.qc.OecpSysUserQC;
import red.lixiang.tools.common.mybatis.MapperUtils;
import org.apache.ibatis.builder.annotation.ProviderMethodResolver;
import org.apache.ibatis.jdbc.SQL;
import red.lixiang.tools.jdk.SnowflakeGenerator;

/**
 * @author lixiang
 */
public class OecpSysUserProvider implements ProviderMethodResolver {

    private static final String TABLE_FIELDS = MapperUtils.getTableFieldName(OecpSysUserDO.class);

    public String listOecpSysUsers(OecpSysUserQC oecpSysUserQC){
        SQL sql = new SQL() {{
            SELECT(TABLE_FIELDS);
            FROM("oecp_sys_user");
        }};
        MapperUtils.richWhereSql(sql, oecpSysUserQC);

        return sql.toString();
    }

    public String countOecpSysUsers(OecpSysUserQC oecpSysUserQC){
        SQL sql = new SQL() {{
            SELECT("count(1)");
            FROM("oecp_sys_user");
        }};
        MapperUtils.richWhereSql(sql, oecpSysUserQC);

        return sql.toString();
    }

    public String insertOecpSysUser(OecpSysUserDO oecpSysUser){
        oecpSysUser.setId(SnowflakeGenerator.generateKey());
        SQL sql = new SQL() {{
            INSERT_INTO("oecp_sys_user");
        }};
        MapperUtils.richInsertSql(sql, oecpSysUser);

        return sql.toString();
    }
    public String updateOecpSysUser(OecpSysUserDO oecpSysUser) {
        SQL sql = new SQL() {{
            UPDATE("oecp_sys_user");

        }};
        MapperUtils.richUpdate(sql, oecpSysUser);
        sql.WHERE("id = #{id}");
        return sql.toString();
    }

    public String removeOecpSysUserById(long id){
            SQL sql = new SQL() {{
                UPDATE("oecp_sys_user");
                SET("delete_flag = 1");
            }};
            sql.WHERE("id = #{id}");
            return sql.toString();
    }

}