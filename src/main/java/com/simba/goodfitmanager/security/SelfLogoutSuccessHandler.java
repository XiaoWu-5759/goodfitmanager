package com.simba.goodfitmanager.security;

import com.alibaba.fastjson.JSON;
import com.simba.goodfitmanager.common.ResponseGenerator;
import com.simba.goodfitmanager.utils.DateUtil;
import com.simba.goodfitmanager.utils.JwtTokenUtil;
import com.simba.goodfitmanager.utils.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 成功登出
 */
@Component
public class SelfLogoutSuccessHandler implements LogoutSuccessHandler {
    private Logger logger = LoggerFactory.getLogger(SelfLogoutSuccessHandler.class);

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public void onLogoutSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        String authHeader = httpServletRequest.getHeader(JwtTokenUtil.TOKEN_HEADER);
        if (authHeader != null && authHeader.startsWith(JwtTokenUtil.TOKEN_PREFIX)) {
            final String token = authHeader.substring(JwtTokenUtil.TOKEN_PREFIX.length());
            //将token放入黑名单中
//            redisUtil.hset("blacklist", authToken, DateUtil.getTime());
//                redisUtil.addBlackList(token);
            redisUtil.deleteKey(token);
            logger.info("用户登出成功！token:{}已被删除",token);
        }
        httpServletResponse.getWriter().write(JSON.toJSONString(ResponseGenerator.genUserLogoutSuccessReponse()));
    }
}
