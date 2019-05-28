package com.simba.goodfitmanager.security;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.simba.goodfitmanager.common.ResponseGenerator;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 用户未登录时返回给前端的数据
 */
@Component
public class SelfAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        httpServletResponse.getWriter().write(JSON.toJSONString(ResponseGenerator.genUserNeedAuthoritiesReponse()));
//        httpServletResponse.getWriter().write(JSONObject.toJSONString(ResponseGenerator.genUserNeedAuthoritiesReponse()));
    }
}
