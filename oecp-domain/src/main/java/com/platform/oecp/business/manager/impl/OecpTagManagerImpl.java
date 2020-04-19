package com.platform.oecp.business.manager.impl;

import com.platform.oecp.models.dos.OecpSysUserDO;
import com.platform.oecp.models.dos.OecpTagDO;
import com.platform.oecp.models.qc.OecpTagQC;
import com.platform.oecp.utils.UserUtil;
import red.lixiang.tools.jdk.ListTools;
import com.platform.oecp.business.manager.OecpTagManager;
import com.platform.oecp.dao.OecpTagMapper;
import red.lixiang.tools.common.mybatis.model.Page;
import red.lixiang.tools.common.mybatis.model.Sort;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Component
public class OecpTagManagerImpl implements OecpTagManager{

    @Autowired
    private OecpTagMapper oecpTagMapper;
    
    @Override
    public OecpTagDO getOecpTagById(Long id) {
        OecpTagQC qc = new OecpTagQC();
        qc.setId(id);
        qc.setPage(Page.getOne());
        List<OecpTagDO> oecpTagDOS = queryOecpTag(qc);
        return ListTools.getOne(oecpTagDOS);
    }
    

    @Override
    public List<OecpTagDO> queryOecpTag(OecpTagQC qc){
        OecpSysUserDO user = UserUtil.currentUser();
        qc.setCreateBy(String.valueOf(user.getId()));
        List<OecpTagDO> oecpTags = oecpTagMapper.listOecpTags(qc);
        return oecpTags;
    }

    @Override
    public List<OecpTagDO> searchByTag(String tag) {
        return oecpTagMapper.searchOecpTagsByTag(tag);
    }


    @Override
    public Long countOecpTag(OecpTagQC qc){
        OecpSysUserDO user = UserUtil.currentUser();
        qc.setCreateBy(String.valueOf(user.getId()));
        Long count = oecpTagMapper.countOecpTags(qc);
        return count;
    }

    @Override
    public OecpTagDO saveOecpTag(OecpTagDO oecpTag){

        if(oecpTag.getId()!=null){
            oecpTag.preUpdate();
             oecpTagMapper.updateOecpTag(oecpTag);
        }else {
            oecpTag.preInsert();
             oecpTagMapper.insertOecpTag(oecpTag);
        }
        return oecpTag;

    }

    @Override
    public int removeOecpTagById(Long id){

        return oecpTagMapper.removeOecpTagById(id);

    }


    @Override
    public List<OecpTagDO> listOecpTagById(Set<Long> ids) {
        return oecpTagMapper.listOecpTagByIDS(ids);
    }


}
