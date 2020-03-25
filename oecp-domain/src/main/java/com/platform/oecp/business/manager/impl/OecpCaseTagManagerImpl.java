package com.platform.oecp.business.manager.impl;

import com.platform.oecp.dao.OecpCaseTagMapper;
import com.platform.oecp.models.dos.OecpCaseTagDO;
import com.platform.oecp.models.qc.OecpCaseTagQC;
import red.lixiang.tools.jdk.ListTools;
import com.platform.oecp.business.manager.OecpCaseTagManager;
import red.lixiang.tools.common.mybatis.model.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class OecpCaseTagManagerImpl implements OecpCaseTagManager{

    @Autowired
    private OecpCaseTagMapper oecpCaseTagMapper;
    
    @Override
    public OecpCaseTagDO getOecpCaseTagById(Long id) {
        OecpCaseTagQC qc = new OecpCaseTagQC();
        qc.setId(id);
        qc.setPage(Page.getOne());
        List<OecpCaseTagDO> oecpCaseTagDOS = queryOecpCaseTag(qc);
        return ListTools.getOne(oecpCaseTagDOS);
    }
    

    @Override
    public List<OecpCaseTagDO> queryOecpCaseTag(OecpCaseTagQC qc){

        List<OecpCaseTagDO> oecpCaseTags = oecpCaseTagMapper.listOecpCaseTags(qc);
        return oecpCaseTags;
    }
    

    @Override
    public Long countOecpCaseTag(OecpCaseTagQC qc){

        Long count = oecpCaseTagMapper.countOecpCaseTags(qc);
        return count;
    }

    @Override
    public OecpCaseTagDO saveOecpCaseTag(OecpCaseTagDO oecpCaseTag){

        if(oecpCaseTag.getId()!=null){
             oecpCaseTagMapper.updateOecpCaseTag(oecpCaseTag);
        }else {
            oecpCaseTag.setCreateDate(new Date());
             oecpCaseTagMapper.insertOecpCaseTag(oecpCaseTag);
        }
        return oecpCaseTag;

    }

    @Override
    public int removeOecpCaseTagById(Long id){

        return oecpCaseTagMapper.removeOecpCaseTagById(id);

    }


}
