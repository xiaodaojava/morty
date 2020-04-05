package com.platform.oecp.admin.controller;

import com.platform.oecp.business.manager.CommonManager;
import com.platform.oecp.business.manager.OecpErrorInfoManager;
import com.platform.oecp.common.OecpCommonConstants;
import com.platform.oecp.dto.ErrorInfoAndCaseDto;
import com.platform.oecp.models.dos.OecpErrorInfoDO;
import com.platform.oecp.models.qc.OecpErrorInfoQC;
import com.platform.oecp.models.request.OecpErrorInfoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import red.lixiang.tools.base.BaseResponse;
import red.lixiang.tools.base.PageData;
import red.lixiang.tools.common.mybatis.model.Page;

import javax.naming.CommunicationException;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @Author 造飞机团队
 **/
@Controller
public class OecpErrorInfoController  {
    @Autowired
    private OecpErrorInfoManager oecpErrorInfoManager;

    @Autowired
    private CommonManager commonManager;

    /**
     * 项目编码
     */
    @Value("${project.code}")
    private int projectCode;

    @GetMapping("/oecpErrorInfo/query")
    @ResponseBody
    public BaseResponse<PageData<OecpErrorInfoDO>> queryOecpErrorInfo(OecpErrorInfoQC qc, Page page ){
        Long totalCount = oecpErrorInfoManager.countOecpErrorInfo(qc);
        qc.setPage(page);
        List<OecpErrorInfoDO> oecpErrorInfos = oecpErrorInfoManager.queryOecpErrorInfo(qc);
        return  BaseResponse.assemblePageResponse(oecpErrorInfos,totalCount,page.getPageIndex(),page.getPageSize());
    }

    /**
     * @author: LILIANG
     * @date: 2020/3/24 22:56
     * @Param : oecpErrorInfo
     * @return: red.lixiang.tools.base.BaseResponse<java.lang.String>
     * @description: 错误的保存和修改
     */
    @PostMapping("/saveOecpErrorInfo")
    @ResponseBody
    public BaseResponse<String> saveOecpErrorInfo(@NotNull(message = "请检查不为空信息是否填写") @Valid @RequestBody OecpErrorInfoRequest oecpErrorInfoRequest) throws CommunicationException {
        BaseResponse<String> baseResponse = new BaseResponse<>();
        commonManager.saveErrorInfo(oecpErrorInfoRequest);
        baseResponse.setData("OK");
        return  baseResponse;
    }

    /**
     * @author: LILIANG
     * @date: 2020/3/25 13:18
     * @Param : codeId
     * @return: red.lixiang.tools.base.BaseResponse<java.lang.String>
     * @description: 删除错误信息
     */
    @PostMapping("/deleteOecpErrorInfo")
    @ResponseBody
    public BaseResponse<String> deleteOecpErrorInfo(@RequestParam("codeId") Long codeId){
        int resultFlag = commonManager.deleteErrorInfo(codeId);
        if(resultFlag > 0){
            return  BaseResponse.success("删除成功");
        }
        return BaseResponse.fail(String.valueOf(projectCode+OecpCommonConstants.DELETE_ERROR_INFO_FAIL),"删除错误信息失败");
    }

    /**
     * @author: LILIANG
     * @date: 2020/3/25 9:36
     * @Param : errorCode
     * @return: red.lixiang.tools.base.BaseResponse<com.platform.oecp.models.dos.OecpErrorInfoDO>
     * @description:  错误码重复校验
     */
    @GetMapping("/checkErrorCodeRepeat")
    @ResponseBody
    public BaseResponse<OecpErrorInfoDO> checkErrorCodeRepeat(@RequestParam("errorCode")String errorCode){
        OecpErrorInfoDO oecpErrorInfoDO = commonManager.checkErrorCodeRepeat(errorCode);
        if(oecpErrorInfoDO != null){
            return BaseResponse.fail(String.valueOf(projectCode+OecpCommonConstants.ERROR_CODE_REPEAT),"errorCode is repeat");
        }
        return BaseResponse.success(oecpErrorInfoDO);
    }

    @GetMapping("/oecpErrorInfo/get")
    @ResponseBody
    public BaseResponse<OecpErrorInfoDO> getOecpErrorInfo(OecpErrorInfoQC qc){
        qc.setPage(Page.getOne());
        List<OecpErrorInfoDO> oecpErrorInfos = oecpErrorInfoManager.queryOecpErrorInfo(qc);
        if(oecpErrorInfos!=null && oecpErrorInfos.size()>0){
            return BaseResponse.success(oecpErrorInfos.get(0));
        }else{
            return BaseResponse.fail("no data info");
        }
    }

    @GetMapping("/getErrorInfoAndCase")
    @ResponseBody
    public BaseResponse<PageData<ErrorInfoAndCaseDto>> getErrorInfoAndCase(Page page){
        //先获取总数量
        Long totalCount = commonManager.countErrorInfos();
        List<ErrorInfoAndCaseDto> errorInfoAndCaseDtos = commonManager.getErrorInfos(page);
        if(errorInfoAndCaseDtos!=null && errorInfoAndCaseDtos.size()>0){
            return BaseResponse.assemblePageResponse(errorInfoAndCaseDtos,totalCount,page.getPageIndex(),page.getPageSize());
        }else{
            return BaseResponse.fail("no data info");
        }
    }

    @GetMapping("/getPlatformErrorInfoAndCase")
    @ResponseBody
    public BaseResponse<List<ErrorInfoAndCaseDto>> getPlatformErrorInfoAndCase(){
        List<ErrorInfoAndCaseDto> errorInfoAndCaseDtos = commonManager.getErrorInfos(null);
        if(errorInfoAndCaseDtos!=null && errorInfoAndCaseDtos.size()>0){
            return BaseResponse.success(errorInfoAndCaseDtos);
        }else{
            return BaseResponse.fail("no data info");
        }
    }

    @GetMapping("/oecpErrorInfo/remove")
    @ResponseBody
    public BaseResponse<String> remove(Long id){
        BaseResponse<String> baseResponse = new BaseResponse<>();
        oecpErrorInfoManager.removeOecpErrorInfoById(id);
        baseResponse.setData("OK");
        return  baseResponse;
    }

    /**
     * 快速申请错误码
     * @param oecpErrorInfo
     * @return
     */
    @PostMapping("/oecpErrorInfo/save")
    @ResponseBody
    public BaseResponse<String> save(@NotNull(message = "请检查不为空信息是否填写") @Valid @RequestBody OecpErrorInfoDO oecpErrorInfo) throws CommunicationException {
        BaseResponse<String> baseResponse = new BaseResponse<>();
        oecpErrorInfoManager.saveOecpErrorInfo(oecpErrorInfo);
        baseResponse.setData("OK");
        return  baseResponse;
    }



}
