package com.platform.oecp.admin.controller;

import com.platform.oecp.business.manager.OecpConfigManager;
import com.platform.oecp.models.dos.OecpConfigDO;
import com.platform.oecp.models.qc.OecpConfigQC;
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
public class OecpConfigController  {
    @Autowired
    private OecpConfigManager oecpConfigManager;

    @GetMapping("/oecpConfig/query")
    @ResponseBody
    public BaseResponse<PageData<OecpConfigDO>> queryOecpConfig(OecpConfigQC qc, Page page ){


        Long totalCount = oecpConfigManager.countOecpConfig(qc);
        qc.setPage(page);
        List<OecpConfigDO> oecpConfigs = oecpConfigManager.queryOecpConfig(qc);

        return  BaseResponse.assemblePageResponse(oecpConfigs,totalCount,page.getPageIndex(),page.getPageSize());
    }

    @PostMapping("/oecpConfig/save")
    @ResponseBody
    public BaseResponse<String> saveOecpConfig(OecpConfigDO oecpConfig){
        BaseResponse<String> baseResponse = new BaseResponse<>();
        oecpConfigManager.saveOecpConfig(oecpConfig);
        baseResponse.setData("OK");
        return  baseResponse;
    }


    
    @GetMapping("/oecpConfig/get")
    @ResponseBody
    public BaseResponse<OecpConfigDO> getOecpConfig(OecpConfigQC qc){
        qc.setPage(Page.getOne());
        List<OecpConfigDO> oecpConfigs = oecpConfigManager.queryOecpConfig(qc);
        if(oecpConfigs!=null && oecpConfigs.size()>0){
            return BaseResponse.success(oecpConfigs.get(0));
        }else{
            return BaseResponse.fail("no data info");
        }
    }

    @GetMapping("/oecpConfig/remove")
    @ResponseBody
    public BaseResponse<String> remove(Long id){
        BaseResponse<String> baseResponse = new BaseResponse<>();
        oecpConfigManager.removeOecpConfigById(id);
        baseResponse.setData("OK");
        return  baseResponse;
    }

}
