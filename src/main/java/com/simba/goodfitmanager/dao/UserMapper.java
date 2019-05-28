package com.simba.goodfitmanager.dao;

import com.simba.goodfitmanager.pojo.User;
import com.simba.goodfitmanager.security.SelfUserDetails;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User getUser(@Param("username") String username);
}