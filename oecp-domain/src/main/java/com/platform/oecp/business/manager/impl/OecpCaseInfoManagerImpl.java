package com.platform.oecp.business.manager.impl;

import com.platform.oecp.models.dos.OecpCaseInfoDO;
import com.platform.oecp.models.qc.OecpCaseInfoQC;
import red.lixiang.tools.jdk.ListTools;
import com.platform.oecp.business.manager.OecpCaseInfoManager;
import com.platform.oecp.dao.oecpcaseinfo.OecpCaseInfoMapper;
import red.lixiang.tools.common.mybatis.model.Page;
import red.lixiang.tools.common.mybatis.model.Sort;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class OecpCaseInfoManagerImpl implements OecpCaseInfoManager{

    @Autowired
    private OecpCaseInfoMapper oecpCaseInfoMapper;
    
    @Override
    public OecpCaseInfoDO getOecpCaseInfoById(Long id) {
        OecpCaseInfoQC qc = new OecpCaseInfoQC();
        qc.setId(id);
        qc.setPage(Page.getOne());
        List<OecpCaseInfoDO> oecpCaseInfoDOS = queryOecpCaseInfo(qc);
        return ListTools.getOne(oecpCaseInfoDOS);
    }
    

    @Override
    public List<OecpCaseInfoDO> queryOecpCaseInfo(OecpCaseInfoQC qc){

        List<OecpCaseInfoDO> oecpCaseInfos = oecpCaseInfoMapper.listOecpCaseInfos(qc);
        return oecpCaseInfos;
    }
    

    @Override
    public Long countOecpCaseInfo(OecpCaseInfoQC qc){

        Long count = oecpCaseInfoMapper.countOecpCaseInfos(qc);
        return count;
    }

    @Override
    public OecpCaseInfoDO saveOecpCaseInfo(OecpCaseInfoDO oecpCaseInfo){

        if(oecpCaseInfo.getId()!=null){
             oecpCaseInfoMapper.updateOecpCaseInfo(oecpCaseInfo);
        }else {
            oecpCaseInfo.setCreateTime(new Date());
             oecpCaseInfoMapper.insertOecpCaseInfo(oecpCaseInfo);
        }
        return oecpCaseInfo;

    }

    @Override
    public int removeOecpCaseInfoById(Long id){

        return oecpCaseInfoMapper.removeOecpCaseInfoById(id);

    }


}
