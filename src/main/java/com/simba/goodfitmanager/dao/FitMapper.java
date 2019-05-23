package com.simba.goodfitmanager.dao;

import com.simba.goodfitmanager.pojo.Fit;
import com.simba.goodfitmanager.pojo.FitExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FitMapper {
    long countByExample(FitExample example);

    int deleteByExample(FitExample example);

    int insert(Fit record);

    int insertSelective(Fit record);

    List<Fit> selectByExample(FitExample example);

    int updateByExampleSelective(@Param("record") Fit record, @Param("example") FitExample example);

    int updateByExample(@Param("record") Fit record, @Param("example") FitExample example);
}