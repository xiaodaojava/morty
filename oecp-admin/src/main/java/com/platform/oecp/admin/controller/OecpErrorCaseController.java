package com.platform.oecp.admin.controller;

import com.platform.oecp.business.manager.OecpErrorCaseManager;
import com.platform.oecp.models.dos.OecpErrorAndCaseInfoDO;
import com.platform.oecp.models.dos.OecpErrorCaseDO;
import com.platform.oecp.models.qc.OecpErrorCaseQC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import red.lixiang.tools.base.BaseResponse;
import red.lixiang.tools.base.PageData;
import red.lixiang.tools.common.mybatis.model.Page;

import java.util.List;

/**
 * @Author 造飞机团队
 **/
@Controller
public class OecpErrorCaseController  {
    @Autowired
    private OecpErrorCaseManager oecpErrorCaseManager;

//    @GetMapping("/oecpErrorCase/query")
//    @ResponseBody
//    public BaseResponse<PageData<OecpErrorCaseDO>> queryOecpErrorCase(OecpErrorCaseQC qc, Page page ){
//
//
//        Long totalCount = oecpErrorCaseManager.countOecpErrorCase(qc);
//        qc.setPage(page);
//        List<OecpErrorCaseDO> oecpErrorCases = oecpErrorCaseManager.queryOecpErrorCase(qc);
//
//        return  BaseResponse.assemblePageResponse(oecpErrorCases,totalCount,page.getPageIndex(),page.getPageSize());
//    }

    @GetMapping("/oecpErrorCase/query")
    @ResponseBody
    public BaseResponse<PageData<OecpErrorAndCaseInfoDO>> queryOecpErrorCase(OecpErrorCaseQC qc, Page page ){


        Long totalCount = oecpErrorCaseManager.countOecpErrorCase(qc);
        qc.setPage(page);
        List<OecpErrorAndCaseInfoDO> oecpErrorCases = oecpErrorCaseManager.queryOecpErrorCase(qc);

        return  BaseResponse.assemblePageResponse(oecpErrorCases,totalCount,page.getPageIndex(),page.getPageSize());
    }

    @PostMapping("/oecpErrorCase/save")
    @ResponseBody
    public BaseResponse<String> saveOecpErrorCase(OecpErrorCaseDO oecpErrorCase){
        BaseResponse<String> baseResponse = new BaseResponse<>();
        oecpErrorCaseManager.saveOecpErrorCase(oecpErrorCase);
        baseResponse.setData("OK");
        return  baseResponse;
    }


    
//    @GetMapping("/oecpErrorCase/get")
//    @ResponseBody
//    public BaseResponse<OecpErrorCaseDO> getOecpErrorCase(OecpErrorCaseQC qc){
//        qc.setPage(Page.getOne());
//        List<OecpErrorCaseDO> oecpErrorCases = oecpErrorCaseManager.queryOecpErrorCase(qc);
//        if(oecpErrorCases!=null && oecpErrorCases.size()>0){
//            return BaseResponse.success(oecpErrorCases.get(0));
//        }else{
//            return BaseResponse.fail("no data info");
//        }
//    }

    @GetMapping("/oecpErrorCase/remove")
    @ResponseBody
    public BaseResponse<String> remove(Long id){
        BaseResponse<String> baseResponse = new BaseResponse<>();
        oecpErrorCaseManager.removeOecpErrorCaseById(id);
        baseResponse.setData("OK");
        return  baseResponse;
    }

}
