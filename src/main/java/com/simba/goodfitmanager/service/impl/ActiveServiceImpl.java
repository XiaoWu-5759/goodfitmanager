package com.simba.goodfitmanager.service.impl;

import com.simba.goodfitmanager.common.Response;
import com.simba.goodfitmanager.common.ResponseGenerator;
import com.simba.goodfitmanager.dao.FitChangeMapper;
import com.simba.goodfitmanager.dao.FitMapper;
import com.simba.goodfitmanager.pojo.Fit;
import com.simba.goodfitmanager.pojo.FitChange;
import com.simba.goodfitmanager.pojo.FitExample;
import com.simba.goodfitmanager.service.ActiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service
public class ActiveServiceImpl implements ActiveService {
    @Autowired
    private FitMapper fitMapper;
    @Autowired
    private FitChangeMapper fitChangeMapper;


    @Override
    public Response activeByOne(String icid) {
        FitExample fitExample = new FitExample();
        FitExample.Criteria fitExampleCriteria = fitExample.createCriteria();
        fitExampleCriteria.andIcidEqualTo(icid);
        List<Fit> fitList = fitMapper.selectByExample(fitExample);

        if (fitList.size() == 0) {
            // 配件码不存在
            return ResponseGenerator.genErrorReponse("icid码不存在");
        } else if (fitList.get(0).getType() == 1) {
            return ResponseGenerator.genErrorReponse("icid码是备件码");
        } else if (fitList.get(0).getIsBad() == 1){
            return ResponseGenerator.genErrorReponse("配件是坏件");
        } else if (fitList.get(0).getIsActive() == 1) {
            return ResponseGenerator.genErrorReponse("配件已经被激活了");
        } else {
            Fit updateFit = fitList.get(0);
            updateFit.setIsActive(1);
            // TODO: java存入时间，存在8小时误差
            updateFit.setActiveTime(new Timestamp(new Date().getTime()));
            fitMapper.updateByExampleSelective(updateFit, fitExample);
            return ResponseGenerator.genSucessReponse("激活成功");
        }


    }

    @Override
    public Response activeByTwo(String icid1, String icid2) {
        FitExample fitExample1 = new FitExample();
        FitExample.Criteria fitExampleCriteria1 = fitExample1.createCriteria();
        fitExampleCriteria1.andIcidEqualTo(icid1);
        List<Fit> fitList1 = fitMapper.selectByExample(fitExample1);

        FitExample fitExample2 = new FitExample();
        FitExample.Criteria fitExampleCriteria2 = fitExample2.createCriteria();
        fitExampleCriteria2.andIcidEqualTo(icid2);
        List<Fit> fitList2 = fitMapper.selectByExample(fitExample2);

        if (fitList1.size() == 0 || fitList2.size() ==0){
            return ResponseGenerator.genErrorReponse("iccid码不存在");
        } else if (fitList1.get(0).getType() != 1 || fitList1.get(0).getIsActive() == 1) {
            return ResponseGenerator.genErrorReponse("新的iccid码不是合理备件码");
        } else if (fitList2.get(0).getIsActive() != 1 || fitList2.get(0).getIsBad() == 1){
            return ResponseGenerator.genErrorReponse("旧的iccid码不是合理激活件");
        } else {
            // 更新激活件属性
            Fit updateFit2 = fitList2.get(0);
            Timestamp activeTime = new Timestamp(updateFit2.getActiveTime().getTime());
            updateFit2.setIsBad(1);
            fitMapper.updateByExampleSelective(updateFit2, fitExample2);

            // 更新备件属性
            Fit updateFit1 = fitList1.get(0);
            updateFit1.setIsActive(1);
            updateFit1.setActiveTime(activeTime);
            fitMapper.updateByExampleSelective(updateFit1,fitExample1);

            // 插入替换记录
            FitChange fitChange = new FitChange();
            fitChange.setChangeTime(new Timestamp(new Date().getTime()));
            fitChange.setNewIcid(updateFit1.getIcid());
            fitChange.setOldIcid(updateFit2.getIcid());
            // TODO: $4sId 需要添加
            // ReflectionException: There is no getter for property named '$4sId'
            fitChangeMapper.insertSelective(fitChange);

            return ResponseGenerator.genSucessReponse("替换成功");
        }
    }
}
