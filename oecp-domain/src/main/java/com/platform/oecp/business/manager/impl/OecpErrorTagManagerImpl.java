package com.platform.oecp.business.manager.impl;

import com.platform.oecp.models.dos.OecpErrorTagDO;
import com.platform.oecp.models.qc.OecpErrorTagQC;
import red.lixiang.tools.jdk.ListTools;
import com.platform.oecp.business.manager.OecpErrorTagManager;
import com.platform.oecp.dao.OecpErrorTagMapper;
import red.lixiang.tools.common.mybatis.model.Page;
import red.lixiang.tools.common.mybatis.model.Sort;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Component
public class OecpErrorTagManagerImpl implements OecpErrorTagManager{

    @Autowired
    private OecpErrorTagMapper oecpErrorTagMapper;
    
    @Override
    public OecpErrorTagDO getOecpErrorTagById(Long id) {
        OecpErrorTagQC qc = new OecpErrorTagQC();
        qc.setId(id);
        qc.setPage(Page.getOne());
        List<OecpErrorTagDO> oecpErrorTagDOS = queryOecpErrorTag(qc);
        return ListTools.getOne(oecpErrorTagDOS);
    }
    

    @Override
    public List<OecpErrorTagDO> queryOecpErrorTag(OecpErrorTagQC qc){

        List<OecpErrorTagDO> oecpErrorTags = oecpErrorTagMapper.listOecpErrorTags(qc);
        return oecpErrorTags;
    }
    

    @Override
    public Long countOecpErrorTag(OecpErrorTagQC qc){

        Long count = oecpErrorTagMapper.countOecpErrorTags(qc);
        return count;
    }

    @Override
    public OecpErrorTagDO saveOecpErrorTag(OecpErrorTagDO oecpErrorTag){

        if(oecpErrorTag.getId()!=null){
            oecpErrorTag.preUpdate();
             oecpErrorTagMapper.updateOecpErrorTag(oecpErrorTag);
        }else {
            oecpErrorTag.preInsert();
             oecpErrorTagMapper.insertOecpErrorTag(oecpErrorTag);
        }
        return oecpErrorTag;

    }

    @Override
    public int removeOecpErrorTagById(Long id){

        return oecpErrorTagMapper.removeOecpErrorTagById(id);

    }

    @Override
    public List<OecpErrorTagDO> listOecpErrorTagByIds(Set<Long> codeIdSet) {
        return oecpErrorTagMapper.listOecpErrorTagByIds(codeIdSet);
    }
}
