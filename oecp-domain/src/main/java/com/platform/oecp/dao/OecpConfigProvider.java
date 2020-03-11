package com.platform.oecp.dao;

import com.platform.oecp.models.dos.OecpConfigDO;
import com.platform.oecp.models.qc.OecpConfigQC;
import red.lixiang.tools.common.mybatis.MapperUtils;
import org.apache.ibatis.builder.annotation.ProviderMethodResolver;
import org.apache.ibatis.jdbc.SQL;
import red.lixiang.tools.jdk.SnowflakeGenerator;

/**
 * @author lixiang
 */
public class OecpConfigProvider implements ProviderMethodResolver {

    private static final String TABLE_FIELDS = MapperUtils.getTableFieldName(OecpConfigDO.class);

    public String listOecpConfigs(OecpConfigQC oecpConfigQC){
        SQL sql = new SQL() {{
            SELECT(TABLE_FIELDS);
            FROM("oecp_config");
        }};
        MapperUtils.richWhereSql(sql, oecpConfigQC);

        return sql.toString();
    }

    public String countOecpConfigs(OecpConfigQC oecpConfigQC){
        SQL sql = new SQL() {{
            SELECT("count(1)");
            FROM("oecp_config");
        }};
        MapperUtils.richWhereSql(sql, oecpConfigQC);

        return sql.toString();
    }

    public String insertOecpConfig(OecpConfigDO oecpConfig){
        oecpConfig.setId(SnowflakeGenerator.generateKey());
        SQL sql = new SQL() {{
            INSERT_INTO("oecp_config");
        }};
        MapperUtils.richInsertSql(sql, oecpConfig);

        return sql.toString();
    }
    public String updateOecpConfig(OecpConfigDO oecpConfig) {
        SQL sql = new SQL() {{
            UPDATE("oecp_config");

        }};
        MapperUtils.richUpdate(sql, oecpConfig);
        sql.WHERE("id = #{id}");
        return sql.toString();
    }

    public String removeOecpConfigById(long id){
            SQL sql = new SQL() {{
                UPDATE("oecp_config");
                SET("delete_flag = 1");
            }};
            sql.WHERE("id = #{id}");
            return sql.toString();
    }

}