package com.simba.goodfitmanager.dao;

import com.simba.goodfitmanager.pojo.FitChange;
import com.simba.goodfitmanager.pojo.FitChangeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FitChangeMapper {
    long countByExample(FitChangeExample example);

    int deleteByExample(FitChangeExample example);

    int insert(FitChange record);

    int insertSelective(FitChange record);

    List<FitChange> selectByExample(FitChangeExample example);

    int updateByExampleSelective(@Param("record") FitChange record, @Param("example") FitChangeExample example);

    int updateByExample(@Param("record") FitChange record, @Param("example") FitChangeExample example);
}