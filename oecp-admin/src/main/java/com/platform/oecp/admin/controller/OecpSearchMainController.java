package com.platform.oecp.admin.controller;

import com.platform.oecp.business.manager.OecpSearchMainManager;
import com.platform.oecp.models.dos.OecpSearchMainDO;
import com.platform.oecp.models.qc.OecpSearchMainQC;
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
public class OecpSearchMainController  {
    @Autowired
    private OecpSearchMainManager oecpSearchMainManager;

    @GetMapping("/oecpSearchMain/query")
    @ResponseBody
    public BaseResponse<PageData<OecpSearchMainDO>> queryOecpSearchMain(OecpSearchMainQC qc, Page page ){


        Long totalCount = oecpSearchMainManager.countOecpSearchMain(qc);
        qc.setPage(page);
        List<OecpSearchMainDO> oecpSearchMains = oecpSearchMainManager.queryOecpSearchMain(qc);

        return  BaseResponse.assemblePageResponse(oecpSearchMains,totalCount,page.getPageIndex(),page.getPageSize());
    }

    @PostMapping("/oecpSearchMain/save")
    @ResponseBody
    public BaseResponse<String> saveOecpSearchMain(OecpSearchMainDO oecpSearchMain){
        BaseResponse<String> baseResponse = new BaseResponse<>();
        oecpSearchMainManager.saveOecpSearchMain(oecpSearchMain);
        baseResponse.setData("OK");
        return  baseResponse;
    }


    
    @GetMapping("/oecpSearchMain/get")
    @ResponseBody
    public BaseResponse<OecpSearchMainDO> getOecpSearchMain(OecpSearchMainQC qc){
        qc.setPage(Page.getOne());
        List<OecpSearchMainDO> oecpSearchMains = oecpSearchMainManager.queryOecpSearchMain(qc);
        if(oecpSearchMains!=null && oecpSearchMains.size()>0){
            return BaseResponse.success(oecpSearchMains.get(0));
        }else{
            return BaseResponse.fail("no data info");
        }
    }

    @GetMapping("/oecpSearchMain/remove")
    @ResponseBody
    public BaseResponse<String> remove(Long id){
        BaseResponse<String> baseResponse = new BaseResponse<>();
        oecpSearchMainManager.removeOecpSearchMainById(id);
        baseResponse.setData("OK");
        return  baseResponse;
    }

}
