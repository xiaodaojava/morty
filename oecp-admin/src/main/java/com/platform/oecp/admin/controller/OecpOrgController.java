package com.platform.oecp.admin.controller;

import com.platform.oecp.business.manager.OecpOrgManager;
import com.platform.oecp.models.dos.OecpOrgDO;
import com.platform.oecp.models.qc.OecpOrgQC;
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
public class OecpOrgController  {
    @Autowired
    private OecpOrgManager oecpOrgManager;

    @GetMapping("/oecpOrg/query")
    @ResponseBody
    public BaseResponse<PageData<OecpOrgDO>> queryOecpOrg(OecpOrgQC qc, Page page ){


        Long totalCount = oecpOrgManager.countOecpOrg(qc);
        qc.setPage(page);
        List<OecpOrgDO> oecpOrgs = oecpOrgManager.queryOecpOrg(qc);

        return  BaseResponse.assemblePageResponse(oecpOrgs,totalCount,page.getPageIndex(),page.getPageSize());
    }

    @PostMapping("/oecpOrg/save")
    @ResponseBody
    public BaseResponse<String> saveOecpOrg(OecpOrgDO oecpOrg){
        BaseResponse<String> baseResponse = new BaseResponse<>();
        oecpOrgManager.saveOecpOrg(oecpOrg);
        baseResponse.setData("OK");
        return  baseResponse;
    }


    
    @GetMapping("/oecpOrg/get")
    @ResponseBody
    public BaseResponse<OecpOrgDO> getOecpOrg(OecpOrgQC qc){
        qc.setPage(Page.getOne());
        List<OecpOrgDO> oecpOrgs = oecpOrgManager.queryOecpOrg(qc);
        if(oecpOrgs!=null && oecpOrgs.size()>0){
            return BaseResponse.success(oecpOrgs.get(0));
        }else{
            return BaseResponse.fail("no data info");
        }
    }

    @GetMapping("/oecpOrg/remove")
    @ResponseBody
    public BaseResponse<String> remove(Long id){
        BaseResponse<String> baseResponse = new BaseResponse<>();
        oecpOrgManager.removeOecpOrgById(id);
        baseResponse.setData("OK");
        return  baseResponse;
    }

}
