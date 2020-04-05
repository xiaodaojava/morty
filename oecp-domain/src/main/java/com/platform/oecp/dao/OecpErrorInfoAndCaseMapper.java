package com.platform.oecp.dao;

import com.platform.oecp.dto.CaseInfoDto;
import com.platform.oecp.dto.ErrorInfoAndCaseDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import red.lixiang.tools.common.mybatis.model.Page;

import java.util.List;

@Mapper
@Repository
public interface OecpErrorInfoAndCaseMapper {

    /**
     * 查询错误码列表和案例信息
     * @param userId
     * @return
     */
    List<ErrorInfoAndCaseDto> errorInfoList(@Param("userId") String userId,@Param("page") Page page);

    @Select("select count(1)" +
            " from oecp_error_info" +
            " where del_flag = 0 "+
            " AND create_by = #{userId}")
    Long  countErrorInfo(@Param("userId") String userId);

    /**
     * 获取此人下的这个错误的相关案例信息
     * @param userId
     * @param codeId
     * @return
     */
    List<CaseInfoDto> caseInfoList(@Param("userId") String userId, @Param("codeId") Long codeId);
}
