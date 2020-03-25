package com.platform.oecp.business.manager.impl;

import com.platform.oecp.business.manager.OecpErrorInfoManager;
import com.platform.oecp.dao.OecpErrorInfoMapper;
import com.platform.oecp.models.dos.OecpErrorInfoDO;
import com.platform.oecp.models.qc.OecpErrorInfoQC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import red.lixiang.tools.common.mybatis.model.Page;
import red.lixiang.tools.jdk.ListTools;

import java.util.List;

@Component
public class OecpErrorInfoManagerImpl implements OecpErrorInfoManager{

    @Autowired
    private OecpErrorInfoMapper oecpErrorInfoMapper;
    
    @Override
    public OecpErrorInfoDO getOecpErrorInfoById(Long id) {
        OecpErrorInfoQC qc = new OecpErrorInfoQC();
        qc.setId(id);
        qc.setPage(Page.getOne());
        List<OecpErrorInfoDO> oecpErrorInfoDOS = queryOecpErrorInfo(qc);
        return ListTools.getOne(oecpErrorInfoDOS);
    }
    

    @Override
    public List<OecpErrorInfoDO> queryOecpErrorInfo(OecpErrorInfoQC qc){

        List<OecpErrorInfoDO> oecpErrorInfos = oecpErrorInfoMapper.listOecpErrorInfos(qc);
        return oecpErrorInfos;
    }
    

    @Override
    public Long countOecpErrorInfo(OecpErrorInfoQC qc){

        Long count = oecpErrorInfoMapper.countOecpErrorInfos(qc);
        return count;
    }

    @Override
    public OecpErrorInfoDO saveOecpErrorInfo(OecpErrorInfoDO oecpErrorInfo){

        if(oecpErrorInfo.getId()!=null){
            oecpErrorInfo.preUpdate();
             oecpErrorInfoMapper.updateOecpErrorInfo(oecpErrorInfo);
        }else {
             oecpErrorInfo.preInsert();
             oecpErrorInfoMapper.insertOecpErrorInfo(oecpErrorInfo);
        }
        return oecpErrorInfo;

    }

    @Override
    public int removeOecpErrorInfoById(Long id){

        return oecpErrorInfoMapper.removeOecpErrorInfoById(id);

    }


}
