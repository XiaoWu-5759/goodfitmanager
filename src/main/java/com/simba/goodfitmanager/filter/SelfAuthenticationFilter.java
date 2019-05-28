package com.simba.goodfitmanager.filter;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.simba.goodfitmanager.common.ResponseGenerator;
import com.simba.goodfitmanager.model.LoginUser;
import com.simba.goodfitmanager.security.SelfUserDetails;
import com.simba.goodfitmanager.utils.JwtTokenUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class SelfAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    private Logger logger = LoggerFactory.getLogger(SelfAuthenticationFilter.class);

    private AuthenticationManager authenticationManager;
    // 升级功能 是否记住
    private ThreadLocal<Integer> rememberMe = new ThreadLocal<>();

    private LoginUser loginUser = null;

    public SelfAuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
        super.setFilterProcessesUrl("/auth/login");
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        // 从输入流中获取登录的信息
        try {
            loginUser = new ObjectMapper().readValue(request.getInputStream(), LoginUser.class);
            rememberMe.set(loginUser.getRememberMe());
            return authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginUser.getUsername(), loginUser.getPassword(), new ArrayList<>()));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // 成功验证后调用的方法
    // 如果验证成功，就生成token并返回
    @Override
    protected void successfulAuthentication(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        // 查看源代码会发现调用getPrincipal()方法会返回一个实现了`UserDetails`接口的对象
        SelfUserDetails selfUserDetails = (SelfUserDetails) authResult.getPrincipal();
//        System.out.println("jwtUser:" + selfUserDetails.toString());
        boolean isRemember = rememberMe.get() == 1;
        String role = "";

        Collection<? extends GrantedAuthority> authorities = selfUserDetails.getAuthorities();
        for (GrantedAuthority authority : authorities){
            role = authority.getAuthority();
        }
        logger.info("登录成功successfulAuthentication:"+loginUser.toString()+"+"+"role:{}",role);
        // 根据用户名，角色创建token
        String token = JwtTokenUtil.generateToken(selfUserDetails.getUsername(), role, isRemember);
        logger.info("生成token:{}",token);
        httpServletResponse.setHeader("token", JwtTokenUtil.TOKEN_PREFIX + token);

        //封装结果集
        Map result = new HashMap();
        result.put("username",selfUserDetails.getUsername());
        result.put("role",role);
        result.put("Token",token);
        httpServletResponse.getWriter().write(JSON.toJSONString(ResponseGenerator.genUserLoginSuccessReponse(result)));
    }

    // 这是验证失败时候调用的方法
    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
        logger.info("登录失败unsuccessfulAuthentication:"+loginUser.toString());
        response.getWriter().write(JSON.toJSONString(ResponseGenerator.genUserLoginFailedReponse()));
    }
}
