package com.simba.goodfitmanager.service.impl;

import com.simba.goodfitmanager.dao.UserMapper;
import com.simba.goodfitmanager.pojo.User;
import com.simba.goodfitmanager.security.SelfUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * 用户认证、权限
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        //通过username查询用户
//        User user = userMapper.getUser(username);
//        if (user == null){
//            //仍需要细化处理
//            throw new UsernameNotFoundException("该用户不存在");
//        }
//        return new SelfUserDetails(user);

        User user = null;
        try{
            user = userMapper.getUser(username);
            if (user == null) {
                throw new UsernameNotFoundException("该用户不存在");
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return new SelfUserDetails(user);
    }
}
