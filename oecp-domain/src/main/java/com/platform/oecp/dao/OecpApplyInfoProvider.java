package com.platform.oecp.dao;

import com.platform.oecp.models.dos.OecpApplyInfoDO;
import com.platform.oecp.models.qc.OecpApplyInfoQC;
import red.lixiang.tools.common.mybatis.MapperUtils;
import org.apache.ibatis.builder.annotation.ProviderMethodResolver;
import org.apache.ibatis.jdbc.SQL;
import red.lixiang.tools.jdk.SnowflakeGenerator;

/**
 * @author lixiang
 */
public class OecpApplyInfoProvider implements ProviderMethodResolver {

    private static final String TABLE_FIELDS = MapperUtils.getTableFieldName(OecpApplyInfoDO.class);

    public String listOecpApplyInfos(OecpApplyInfoQC oecpApplyInfoQC){
        SQL sql = new SQL() {{
            SELECT(TABLE_FIELDS);
            FROM("oecp_apply_info");
            WHERE("del_flag = 0");
        }};
        MapperUtils.richWhereSql(sql, oecpApplyInfoQC);

        return sql.toString();
    }

    public String countOecpApplyInfos(OecpApplyInfoQC oecpApplyInfoQC){
        SQL sql = new SQL() {{
            SELECT("count(1)");
            FROM("oecp_apply_info");
            WHERE("del_flag = 0");
        }};
        MapperUtils.richWhereSql(sql, oecpApplyInfoQC);

        return sql.toString();
    }

    public String insertOecpApplyInfo(OecpApplyInfoDO oecpApplyInfo){
        oecpApplyInfo.setId(SnowflakeGenerator.generateKey());
        SQL sql = new SQL() {{
            INSERT_INTO("oecp_apply_info");
        }};
        MapperUtils.richInsertSql(sql, oecpApplyInfo);

        return sql.toString();
    }
    public String updateOecpApplyInfo(OecpApplyInfoDO oecpApplyInfo) {
        SQL sql = new SQL() {{
            UPDATE("oecp_apply_info");

        }};
        MapperUtils.richUpdate(sql, oecpApplyInfo);
        sql.WHERE("id = #{id}");
        return sql.toString();
    }

    public String removeOecpApplyInfoById(long id){
            SQL sql = new SQL() {{
                UPDATE("oecp_apply_info");
                SET("del_flag = 1");
            }};
            sql.WHERE("id = #{id}");
            return sql.toString();
    }

}