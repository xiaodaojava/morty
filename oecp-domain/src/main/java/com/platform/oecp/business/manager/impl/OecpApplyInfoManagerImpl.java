package com.platform.oecp.business.manager.impl;

import com.platform.oecp.models.dos.OecpApplyInfoDO;
import com.platform.oecp.models.qc.OecpApplyInfoQC;
import red.lixiang.tools.jdk.ListTools;
import com.platform.oecp.business.manager.OecpApplyInfoManager;
import com.platform.oecp.dao.apply_info.OecpApplyInfoMapper;
import red.lixiang.tools.common.mybatis.model.Page;
import red.lixiang.tools.common.mybatis.model.Sort;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class OecpApplyInfoManagerImpl implements OecpApplyInfoManager{

    @Autowired
    private OecpApplyInfoMapper oecpApplyInfoMapper;
    
    @Override
    public OecpApplyInfoDO getOecpApplyInfoById(Long id) {
        OecpApplyInfoQC qc = new OecpApplyInfoQC();
        qc.setId(id);
        qc.setPage(Page.getOne());
        List<OecpApplyInfoDO> oecpApplyInfoDOS = queryOecpApplyInfo(qc);
        return ListTools.getOne(oecpApplyInfoDOS);
    }
    

    @Override
    public List<OecpApplyInfoDO> queryOecpApplyInfo(OecpApplyInfoQC qc){

        List<OecpApplyInfoDO> oecpApplyInfos = oecpApplyInfoMapper.listOecpApplyInfos(qc);
        return oecpApplyInfos;
    }
    

    @Override
    public Long countOecpApplyInfo(OecpApplyInfoQC qc){

        Long count = oecpApplyInfoMapper.countOecpApplyInfos(qc);
        return count;
    }

    @Override
    public OecpApplyInfoDO saveOecpApplyInfo(OecpApplyInfoDO oecpApplyInfo){

        if(oecpApplyInfo.getId()!=null){
             oecpApplyInfoMapper.updateOecpApplyInfo(oecpApplyInfo);
        }else {
            oecpApplyInfo.setCreateTime(new Date());
             oecpApplyInfoMapper.insertOecpApplyInfo(oecpApplyInfo);
        }
        return oecpApplyInfo;

    }

    @Override
    public int removeOecpApplyInfoById(Long id){

        return oecpApplyInfoMapper.removeOecpApplyInfoById(id);

    }


}
