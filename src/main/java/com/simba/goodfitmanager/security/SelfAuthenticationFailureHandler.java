package com.simba.goodfitmanager.security;

import com.alibaba.fastjson.JSON;
import com.simba.goodfitmanager.common.ResponseGenerator;
import com.simba.goodfitmanager.filter.SelfAuthenticationFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 用户登录失败时返回给前端的数据
 */
@Component
public class SelfAuthenticationFailureHandler implements AuthenticationFailureHandler {

    private Logger logger = LoggerFactory.getLogger(SelfAuthenticationFailureHandler.class);

    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
////        logger.info("登录失败unsuccessfulAuthentication:"+loginUser.toString());
//        logger.info("登录失败unsuccessfulAuthentication:"+httpServletRequest.getInputStream().toString());
//        httpServletResponse.getWriter().write(JSON.toJSONString(ResponseGenerator.genUserLoginFailedReponse()));

    }
}
