package com.simba.goodfitmanager.service.impl;

import com.simba.goodfitmanager.common.Response;
import com.simba.goodfitmanager.common.ResponseGenerator;
import com.simba.goodfitmanager.dao.FitMapper;
import com.simba.goodfitmanager.dao.FitUnbindMapper;
import com.simba.goodfitmanager.pojo.Fit;
import com.simba.goodfitmanager.pojo.FitExample;
import com.simba.goodfitmanager.pojo.FitUnbind;
import com.simba.goodfitmanager.service.UnbindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service
public class UnbindServiceImpl implements UnbindService {
    @Autowired
    private FitMapper fitMapper;
    @Autowired
    private FitUnbindMapper fitUnbindMapper;

    @Override
    public Response unbind(String iccid) {
        FitExample fitExample = new FitExample();
        FitExample.Criteria fitExampleCriteria = fitExample.createCriteria();
        fitExampleCriteria.andIcidEqualTo(iccid);
        List<Fit> fitList = fitMapper.selectByExample(fitExample);
        if(fitList.size() == 0){
            return ResponseGenerator.genErrorReponse("配件码未找到，可能被删除了");
        }
        // 更新配件表状态
        Fit updateFit = fitList.get(0);
        updateFit.setIsActive(0);
        // TODO: 解绑的时候，激活的时候 不刷新激活时间
        fitMapper.updateByExampleSelective(updateFit,fitExample);
        // 插入解绑信息
        String icid = fitList.get(0).getIcid();
        Timestamp relieveTime = new Timestamp(new Date().getTime());
        String relieveCar = null;
        FitUnbind fitUnbind = new FitUnbind(icid,relieveTime,relieveCar);
        fitUnbindMapper.insertSelective(fitUnbind);
        return ResponseGenerator.genSucessReponse("解绑成功");
    }
}
