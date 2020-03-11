package com.platform.oecp.dao;

import com.platform.oecp.models.dos.OecpOrgDO;
import com.platform.oecp.models.qc.OecpOrgQC;
import red.lixiang.tools.common.mybatis.MapperUtils;
import org.apache.ibatis.builder.annotation.ProviderMethodResolver;
import org.apache.ibatis.jdbc.SQL;
import red.lixiang.tools.jdk.SnowflakeGenerator;

/**
 * @author lixiang
 */
public class OecpOrgProvider implements ProviderMethodResolver {

    private static final String TABLE_FIELDS = MapperUtils.getTableFieldName(OecpOrgDO.class);

    public String listOecpOrgs(OecpOrgQC oecpOrgQC){
        SQL sql = new SQL() {{
            SELECT(TABLE_FIELDS);
            FROM("oecp_org");
        }};
        MapperUtils.richWhereSql(sql, oecpOrgQC);

        return sql.toString();
    }

    public String countOecpOrgs(OecpOrgQC oecpOrgQC){
        SQL sql = new SQL() {{
            SELECT("count(1)");
            FROM("oecp_org");
        }};
        MapperUtils.richWhereSql(sql, oecpOrgQC);

        return sql.toString();
    }

    public String insertOecpOrg(OecpOrgDO oecpOrg){
        oecpOrg.setId(SnowflakeGenerator.generateKey());
        SQL sql = new SQL() {{
            INSERT_INTO("oecp_org");
        }};
        MapperUtils.richInsertSql(sql, oecpOrg);

        return sql.toString();
    }
    public String updateOecpOrg(OecpOrgDO oecpOrg) {
        SQL sql = new SQL() {{
            UPDATE("oecp_org");

        }};
        MapperUtils.richUpdate(sql, oecpOrg);
        sql.WHERE("id = #{id}");
        return sql.toString();
    }

    public String removeOecpOrgById(long id){
            SQL sql = new SQL() {{
                UPDATE("oecp_org");
                SET("delete_flag = 1");
            }};
            sql.WHERE("id = #{id}");
            return sql.toString();
    }

}