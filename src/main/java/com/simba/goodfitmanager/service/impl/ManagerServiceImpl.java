package com.simba.goodfitmanager.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.simba.goodfitmanager.common.Response;
import com.simba.goodfitmanager.common.ResponseGenerator;
import com.simba.goodfitmanager.dao.FitMapper;
import com.simba.goodfitmanager.pojo.Fit;
import com.simba.goodfitmanager.pojo.FitExample;
import com.simba.goodfitmanager.service.ManagerService;
import com.simba.goodfitmanager.util.ExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class ManagerServiceImpl implements ManagerService {
    @Autowired
    private FitMapper fitMapper;

    @Override
    public Response updateType(String icid, int type) {
//        // TODO:添加枚举判断
//        // IntelliJ IDEA “condition always true”
//        // || 或 && 与关系 要准确
//        if (type != 0 && type != 1){
//            return ResponseGenerator.genErrorReponse("type种类错误");
//        }

        FitExample fitExample = new FitExample();
        FitExample.Criteria fitExampleCriteria = fitExample.createCriteria();
        fitExampleCriteria.andIcidEqualTo(icid);
        List<Fit> fitList = fitMapper.selectByExample(fitExample);
        if (fitList.size() == 0){
            return ResponseGenerator.genErrorReponse("配件码未找到，可能被删除了");
        } else {
            Fit updateFit = fitList.get(0);
            updateFit.setType(type);
            fitMapper.updateByExample(updateFit,fitExample);
            return ResponseGenerator.genSucessReponse("修改状态成功");
        }
    }

    @Override
    public Response queryByStyle(String style, String content, int pageNum, int pageSize) {


        // 判断style，进行搜索
        if (style.equals("icid")){
            // 设置分页
            PageHelper.startPage(pageNum, pageSize);
            // 执行查询
            FitExample fitExample = new FitExample();
            FitExample.Criteria fitExampleCriteria = fitExample.createCriteria();
            fitExampleCriteria.andIcidLike(content+'%');
            List<Fit> fitList = fitMapper.selectByExample(fitExample);
            if (fitList.size() == 0) {
                return ResponseGenerator.genErrorReponse("未搜索到相关结果");
            }
            // 获取分页查询数据
            PageInfo<Fit> pageInfo = new PageInfo<>(fitList);
            // 封装返回的分页实体
            Map result = new HashMap();
            result.put("num",pageInfo.getTotal());
            result.put("pageNum",pageInfo.getPageNum());
            result.put("pageSize",pageInfo.getPageSize());
            result.put("data",pageInfo.getList());
            return ResponseGenerator.genSucessReponse(result,"查询成功");
        } else if(style.equals("type")){
            if (Integer.parseInt(content) != 0 && Integer.parseInt(content) != 1 ) {
                return ResponseGenerator.genErrorReponse("未搜索到相关结果");
            }
            // 设置分页
            PageHelper.startPage(pageNum, pageSize);
            // 执行查询
            FitExample fitExample = new FitExample();
            FitExample.Criteria fitExampleCriteria = fitExample.createCriteria();
            fitExampleCriteria.andTypeEqualTo(Integer.valueOf(content));
            List<Fit> fitList = fitMapper.selectByExample(fitExample);
            // 获取分页查询数据
            PageInfo<Fit> pageInfo = new PageInfo<>(fitList);
            // 封装返回的分页实体
            Map result = new HashMap();
            result.put("num",pageInfo.getTotal());
            result.put("pageNum",pageInfo.getPageNum());
            result.put("pageSize",pageInfo.getPageSize());
            result.put("data",pageInfo.getList());
            return ResponseGenerator.genSucessReponse(result,"查询成功");
        } else {
            return ResponseGenerator.genErrorReponse("未搜索到相关结果");
        }
    }

//    Fit addFit = new Fit();

//    int num = 0;
//    int repeat = 0;
    @Override
    public Response uploadExcel(String uploadFileName) throws Exception {
        List<Fit> fits = new ArrayList<>();
        fits = ExcelUtil.importExcel(uploadFileName);
        int num = 0;
        int repeat = 0;
        for (int i = 0; i < fits.size(); i++) {

            // 入库判别，如果有重名，覆盖它
            FitExample fitExample = new FitExample();
            FitExample.Criteria fitExampleCriteria = fitExample.createCriteria();
            fitExampleCriteria.andIcidEqualTo(fits.get(i).getIcid());
            List<Fit> fitList = fitMapper.selectByExample(fitExample);
            if (fitList.size() != 0) {
                fitMapper.updateByExampleSelective(fits.get(i),fitExample);
                System.out.println("更新一条数据");
                repeat++;
            } else {
                fitMapper.insertSelective(fits.get(i));
                System.out.println("插入一条数据");
                num++;
            }
        }
        //封装结果集
        Map result = new HashMap();
        result.put("num",num);
        result.put("repeat",repeat);
        return ResponseGenerator.genSucessReponse(result,"添加成功");
    }
}
