package com.platform.oecp.dao;

import com.platform.oecp.models.dos.OecpErrorInfoDO;
import com.platform.oecp.models.qc.OecpErrorInfoQC;
import red.lixiang.tools.common.mybatis.MapperUtils;
import org.apache.ibatis.builder.annotation.ProviderMethodResolver;
import org.apache.ibatis.jdbc.SQL;
import red.lixiang.tools.jdk.SnowflakeGenerator;

/**
 * @author lixiang
 */
public class OecpErrorInfoProvider implements ProviderMethodResolver {

    private static final String TABLE_FIELDS = MapperUtils.getTableFieldName(OecpErrorInfoDO.class);

    public String listOecpErrorInfos(OecpErrorInfoQC oecpErrorInfoQC){
        SQL sql = new SQL() {{
            SELECT(TABLE_FIELDS);
            FROM("oecp_error_info");
            WHERE("del_flag = 0");
        }};
        MapperUtils.richWhereSql(sql, oecpErrorInfoQC);

        return sql.toString();
    }

    public String countOecpErrorInfos(OecpErrorInfoQC oecpErrorInfoQC){
        SQL sql = new SQL() {{
            SELECT("count(1)");
            FROM("oecp_error_info");
            WHERE("del_flag = 0");
        }};
        MapperUtils.richWhereSql(sql, oecpErrorInfoQC);

        return sql.toString();
    }

    public String getByCode(String code) {
        SQL sql = new SQL() {{
            SELECT(TABLE_FIELDS);
            FROM("oecp_error_info");
            WHERE("code=" + code);
        }};

        return sql.toString();
    }

    public String insertOecpErrorInfo(OecpErrorInfoDO oecpErrorInfo){
        oecpErrorInfo.setId(SnowflakeGenerator.generateKey());
        SQL sql = new SQL() {{
            INSERT_INTO("oecp_error_info");
        }};
        MapperUtils.richInsertSql(sql, oecpErrorInfo);

        return sql.toString();
    }
    public String updateOecpErrorInfo(OecpErrorInfoDO oecpErrorInfo) {
        SQL sql = new SQL() {{
            UPDATE("oecp_error_info");

        }};
        MapperUtils.richUpdate(sql, oecpErrorInfo);
        sql.WHERE("id = #{id}");
        return sql.toString();
    }

    public String removeOecpErrorInfoById(long id){
            SQL sql = new SQL() {{
                UPDATE("oecp_error_info");
                SET("del_flag = 1");
            }};
            sql.WHERE("id = #{id}");
            return sql.toString();
    }

}