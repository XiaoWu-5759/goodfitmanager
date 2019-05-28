package com.simba.goodfitmanager.service.impl;

import com.simba.goodfitmanager.common.Response;
import com.simba.goodfitmanager.common.ResponseGenerator;
import com.simba.goodfitmanager.dao.UserMapper;
import com.simba.goodfitmanager.pojo.User;
import com.simba.goodfitmanager.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @Override
    public Response authRegister(User user) {
        // 判空操作
        if (user.getUsername() == null || user.getPassword() == null || user.getRole() == null) {
            return ResponseGenerator.genIllegalArgumentReponse();
        }
        if (userMapper.getUser(user.getUsername()) != null) {
            return ResponseGenerator.genErrorReponse("账号已存在");
        }

        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userMapper.insertSelective(user);
        // 封装结果集
        Map<String,Object> result = new HashMap<>();
        result.put("username",user.getUsername());
        return ResponseGenerator.genSucessReponse(result,"注册成功");
    }
}
