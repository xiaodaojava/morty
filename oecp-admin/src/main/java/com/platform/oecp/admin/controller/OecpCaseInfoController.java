package com.platform.oecp.admin.controller;

import com.platform.oecp.business.manager.CommonManager;
import com.platform.oecp.business.manager.OecpCaseInfoManager;
import com.platform.oecp.common.OecpCommonConstants;
import com.platform.oecp.models.dos.OecpCaseInfoDO;
import com.platform.oecp.models.qc.OecpCaseInfoQC;
import com.platform.oecp.models.request.OecpCaseInfoRequest;
import com.platform.oecp.models.request.OecpDeleteCaseInfoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import red.lixiang.tools.base.BaseResponse;
import red.lixiang.tools.base.PageData;
import red.lixiang.tools.common.mybatis.model.Page;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @Author 造飞机团队
 **/
@Controller
public class OecpCaseInfoController  {
    @Autowired
    private OecpCaseInfoManager oecpCaseInfoManager;

    @Autowired
    private CommonManager commonManager;

    /**
     * 项目编码
     */
    @Value("${project.code}")
    private int projectCode;

    @GetMapping("/oecpCaseInfo/query")
    @ResponseBody
    public BaseResponse<PageData<OecpCaseInfoDO>> queryOecpCaseInfo(OecpCaseInfoQC qc, Page page ){


        Long totalCount = oecpCaseInfoManager.countOecpCaseInfo(qc);
        qc.setPage(page);
        List<OecpCaseInfoDO> oecpCaseInfos = oecpCaseInfoManager.queryOecpCaseInfo(qc);

        return  BaseResponse.assemblePageResponse(oecpCaseInfos,totalCount,page.getPageIndex(),page.getPageSize());
    }

    /**
     * @author: LILIANG
     * @date: 2020/3/25 11:16
     * @Param : oecpCaseInfoRequest
     * @return: red.lixiang.tools.base.BaseResponse<java.lang.String>
     * @description: 案例的的保存和修改
     */
    @PostMapping("/saveOecpCaseInfo")
    @ResponseBody
    public BaseResponse<String> saveOecpCaseInfo(@NotNull(message = "请检查不为空信息是否填写") @Valid
                                                     @RequestBody OecpCaseInfoRequest oecpCaseInfoRequest){
        BaseResponse<String> baseResponse = new BaseResponse<>();
        commonManager.saveCaseInfo(oecpCaseInfoRequest);
        baseResponse.setData("OK");
        return  baseResponse;
    }

    /**
     * @author: LILIANG
     * @date: 2020/3/25 13:21
     * @Param : oecpDeleteCaseInfoRequest
     * @return: red.lixiang.tools.base.BaseResponse<java.lang.String>
     * @description: 删除案例信息
     */
    @PostMapping("/deleteOecpCaseInfo")
    @ResponseBody
    public BaseResponse<String> deleteOecpCaseInfo(OecpDeleteCaseInfoRequest oecpDeleteCaseInfoRequest){
        int resultFlag = commonManager.deleteCaseInfo(oecpDeleteCaseInfoRequest);
        if(resultFlag > 0){
            return  BaseResponse.success("删除成功");
        }
        return BaseResponse.fail(String.valueOf(projectCode+ OecpCommonConstants.DELETE_CASE_INFO_FAIL),"删除案例信息失败");
    }
    
    @GetMapping("/oecpCaseInfo/get")
    @ResponseBody
    public BaseResponse<OecpCaseInfoDO> getOecpCaseInfo(OecpCaseInfoQC qc){
        qc.setPage(Page.getOne());
        List<OecpCaseInfoDO> oecpCaseInfos = oecpCaseInfoManager.queryOecpCaseInfo(qc);
        if(oecpCaseInfos!=null && oecpCaseInfos.size()>0){
            return BaseResponse.success(oecpCaseInfos.get(0));
        }else{
            return BaseResponse.fail("no data info");
        }
    }

    @GetMapping("/oecpCaseInfo/remove")
    @ResponseBody
    public BaseResponse<String> remove(Long id){
        BaseResponse<String> baseResponse = new BaseResponse<>();
        oecpCaseInfoManager.removeOecpCaseInfoById(id);
        baseResponse.setData("OK");
        return  baseResponse;
    }

}
