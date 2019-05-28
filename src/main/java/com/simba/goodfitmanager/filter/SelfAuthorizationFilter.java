package com.simba.goodfitmanager.filter;

import com.alibaba.fastjson.JSON;
import com.simba.goodfitmanager.common.ResponseGenerator;
import com.simba.goodfitmanager.utils.AccessAddressUtil;
import com.simba.goodfitmanager.utils.JwtTokenUtil;
import com.simba.goodfitmanager.utils.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;

public class SelfAuthorizationFilter extends BasicAuthenticationFilter {
    private Logger logger = LoggerFactory.getLogger(SelfAuthorizationFilter.class);

    @Autowired
    private RedisUtil redisUtil;

    public SelfAuthorizationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain chain) throws IOException, ServletException {

        String tokenHeader = request.getHeader(JwtTokenUtil.TOKEN_HEADER);
        //获取请求的ip地址
        String currentIp = AccessAddressUtil.getIpAddress(request);

        // 如果请求头中没有Authorization信息则直接放行了
        if (tokenHeader == null || !tokenHeader.startsWith(JwtTokenUtil.TOKEN_PREFIX)) {
            chain.doFilter(request, response);
            return;
        }
        // 校验token是否在redis里面
        String token = tokenHeader.substring("JwtTokenUtil.TOKEN_PREFIX".length());
        if (redisUtil.isBlackList(token)) {
            logger.info("token:{}在黑名单之中，拒绝访问",token);
            response.getWriter().write(JSON.toJSONString(ResponseGenerator.genTokenIsBlacklistReponse()));
            return;
        }
        // 如果请求头中有token，则进行解析，并且设置认证信息
        SecurityContextHolder.getContext().setAuthentication(getAuthentication(tokenHeader));
        super.doFilterInternal(request, response, chain);
    }

    // 这里从token中获取用户信息并新建一个token
    private UsernamePasswordAuthenticationToken getAuthentication(String tokenHeader) {
        String token = tokenHeader.replace(JwtTokenUtil.TOKEN_PREFIX, "");
        String username = JwtTokenUtil.getUsername(token);
        String role = JwtTokenUtil.getUserRole(token);
        if (username != null){
            return new UsernamePasswordAuthenticationToken(username, null,
                    Collections.singleton(new SimpleGrantedAuthority(role))
            );
        }
        return null;
    }
}
