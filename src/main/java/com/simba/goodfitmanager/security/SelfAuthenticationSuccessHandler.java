package com.simba.goodfitmanager.security;

import com.alibaba.fastjson.JSON;
import com.simba.goodfitmanager.common.ResponseGenerator;
import com.simba.goodfitmanager.utils.AccessAddressUtil;
import com.simba.goodfitmanager.utils.JwtTokenUtil;
import com.simba.goodfitmanager.utils.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * 用户登录成功时返回给前端的数据
 */
@Component
public class SelfAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    private Logger logger = LoggerFactory.getLogger(SelfAuthenticationSuccessHandler.class);

    @Autowired
    private RedisUtil redisUtil;

    @Value("${token.expirationSeconds}")
    private int expirationSeconds;

    @Value("${token.validTime}")
    private int validTime;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
//        System.out.println("hello");

        // 获取请求的IP地址
        String ip = AccessAddressUtil.getIpAddress(httpServletRequest);
        Map<String,Object> claims = new HashMap<>();
        claims.put("ip",ip);

        // 查看源代码会发现调用getPrincipal()方法会返回一个实现了`UserDetails`接口的对象
        SelfUserDetails selfUserDetails = (SelfUserDetails) authentication.getPrincipal();
//        System.out.println("jwtUser:" + selfUserDetails.toString());
//        boolean isRemember = rememberMe.get() == 1;
        String role = "";

        Collection<? extends GrantedAuthority> authorities = selfUserDetails.getAuthorities();
        for (GrantedAuthority authority : authorities){
            role = authority.getAuthority();
        }
        claims.put("role",role);
        logger.info("登录成功successfulAuthentication:"+selfUserDetails.toString());
        // 根据用户名，角色创建token
        String token = JwtTokenUtil.generateToken(selfUserDetails.getUsername(), expirationSeconds, claims);
        logger.info("token:{},username:{},ip:{}",token,selfUserDetails.getUsername(),ip);
        redisUtil.setToken(token,selfUserDetails.getUsername(),ip);

//        redisUtil.setToken(token,selfUserDetails.getUsername(),ip);

        logger.info("生成token:{},信息已保存至redis",token);
        httpServletResponse.setHeader(JwtTokenUtil.TOKEN_HEADER, JwtTokenUtil.TOKEN_PREFIX + token);

        //封装结果集
        Map<String,Object> result = new HashMap<>();
        result.put("username",selfUserDetails.getUsername());
        result.put("role",role);
        result.put("Token",token);
        httpServletResponse.getWriter().write(JSON.toJSONString(ResponseGenerator.genUserLoginSuccessReponse(result)));

    }
}
