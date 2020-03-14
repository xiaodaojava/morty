package com.platform.oecp.admin.controller;

import com.platform.oecp.business.manager.OecpErrorInfoManager;
import com.platform.oecp.models.dos.OecpErrorInfoDO;
import com.platform.oecp.models.qc.OecpErrorInfoQC;
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
public class OecpErrorInfoController  {
    @Autowired
    private OecpErrorInfoManager oecpErrorInfoManager;

    @GetMapping("/oecpErrorInfo/query")
    @ResponseBody
    public BaseResponse<PageData<OecpErrorInfoDO>> queryOecpErrorInfo(OecpErrorInfoQC qc, Page page ){


        Long totalCount = oecpErrorInfoManager.countOecpErrorInfo(qc);
        qc.setPage(page);
        List<OecpErrorInfoDO> oecpErrorInfos = oecpErrorInfoManager.queryOecpErrorInfo(qc);

        return  BaseResponse.assemblePageResponse(oecpErrorInfos,totalCount,page.getPageIndex(),page.getPageSize());
    }

    @PostMapping("/oecpErrorInfo/save")
    @ResponseBody
    public BaseResponse<String> saveOecpErrorInfo(OecpErrorInfoDO oecpErrorInfo){
        BaseResponse<String> baseResponse = new BaseResponse<>();
        oecpErrorInfoManager.saveOecpErrorInfo(oecpErrorInfo);
        baseResponse.setData("OK");
        return  baseResponse;
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

    @GetMapping("/oecpErrorInfo/remove")
    @ResponseBody
    public BaseResponse<String> remove(Long id){
        BaseResponse<String> baseResponse = new BaseResponse<>();
        oecpErrorInfoManager.removeOecpErrorInfoById(id);
        baseResponse.setData("OK");
        return  baseResponse;
    }

}
