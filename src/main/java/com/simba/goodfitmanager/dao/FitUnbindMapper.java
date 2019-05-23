package com.simba.goodfitmanager.dao;

import com.simba.goodfitmanager.pojo.FitUnbind;
import com.simba.goodfitmanager.pojo.FitUnbindExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FitUnbindMapper {
    long countByExample(FitUnbindExample example);

    int deleteByExample(FitUnbindExample example);

    int insert(FitUnbind record);

    int insertSelective(FitUnbind record);

    List<FitUnbind> selectByExample(FitUnbindExample example);

    int updateByExampleSelective(@Param("record") FitUnbind record, @Param("example") FitUnbindExample example);

    int updateByExample(@Param("record") FitUnbind record, @Param("example") FitUnbindExample example);
}