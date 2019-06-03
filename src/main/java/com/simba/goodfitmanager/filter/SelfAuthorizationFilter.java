package com.simba.goodfitmanager.filter;

import com.alibaba.fastjson.JSON;
import com.simba.goodfitmanager.common.ResponseGenerator;
import com.simba.goodfitmanager.utils.AccessAddressUtil;
import com.simba.goodfitmanager.utils.DateUtil;
import com.simba.goodfitmanager.utils.JwtTokenUtil;
import com.simba.goodfitmanager.utils.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;

@Component
/**
 * 判断令牌得有效性
 */
public class SelfAuthorizationFilter extends OncePerRequestFilter {
    private Logger logger = LoggerFactory.getLogger(SelfAuthorizationFilter.class);

//    private RedisUtil redisUtil = new RedisUtil();

    // 过期时间
    @Value("${token.expirationSeconds}")
    private int expirationSeconds;

    @Value("${token.validTime}")
    private int validTime;

    @Autowired
    private RedisUtil redisUtil;


    @Override
    public void doFilterInternal(HttpServletRequest request,
                                 HttpServletResponse response,
                                 FilterChain chain) throws IOException, ServletException {

        String tokenHeader = request.getHeader(JwtTokenUtil.TOKEN_HEADER);
//        String token = tokenHeader.replace(JwtTokenUtil.TOKEN_PREFIX, "");
        String token = null;
        String refrshToken = null;
        //获取请求的ip地址
        String currentIp = AccessAddressUtil.getIpAddress(request);
        //能否获取当前登录用户
        // TODO:是否存在不安全的情况



        // 如果请求头中没有Authorization信息则直接放行了
        if (tokenHeader == null || !tokenHeader.startsWith(JwtTokenUtil.TOKEN_PREFIX)) {
            chain.doFilter(request, response);
            return;
        }

        token = tokenHeader.replace(JwtTokenUtil.TOKEN_PREFIX, "");

        // 进入黑名单验证
//        if (redisUtil.isBlackList(token)) {
//            logger.info("token:{}在黑名单之中，拒绝访问",token);
//            response.getWriter().write(JSON.toJSONString(ResponseGenerator.genTokenIsBlacklistReponse()));
//            return;
//        }

        // 判断redis是否有保存
        // 防止非法登录
        /**
         * 过期的话，从redis中读取有效时间（比如七天登录有效），再refreshToken（根据以后业务加入，现在直接refresh
         * 同时，已过期的token加入黑名单
         */


        if(redisUtil.hasKey(token)){
            // 加强安全判别，对访问ip地址进行筛选
            if(!currentIp.equals(String.valueOf(redisUtil.getIPByToken(token)))){
                // 没有也会发生这种情况
                logger.info("当前ip:{}访问不安全",currentIp);
                response.getWriter().write(JSON.toJSONString(ResponseGenerator.genLoginIsOverdueReponse()));
//            chain.doFilter(request, response);  //不能继续放行
                return;
            }
            // 判断token是否过期
            if (JwtTokenUtil.isExpiration(token)) {
                // 获得redis中用户的token 有效存活期
                String tokenValidTime = (String) redisUtil.getTokenValidTimeByToken(token);
                String currentTime = DateUtil.getTime();
//                // 将这个token加入黑名单
//                redisUtil.addBlackList(token);
//                logger.info("token:{}已加入黑名单",token);
                if(DateUtil.compareDate(currentTime,tokenValidTime)){
                    // 超过有效存活期
                    response.getWriter().write(JSON.toJSONString(ResponseGenerator.genLoginIsOverdueReponse()));
                    logger.info("{}超过有效存活期，不予刷新",token);
                }
                // 仍在 有效存活期，则刷新token，放入response头中
                String username = String.valueOf(redisUtil.getUsernameByToken(token));
                Map<String, Object> claims = JwtTokenUtil.getClaims(token);
                claims.put("ip",currentIp);
                refrshToken = JwtTokenUtil.generateToken(username, expirationSeconds, claims);
                //删除旧的token保存的redis
                redisUtil.deleteKey(token);
                //新的token保存到redis中
                redisUtil.setTokenRefresh(refrshToken,username,currentIp,tokenValidTime);
                logger.info("已删除旧token:{},新的token:{}已添加",token,refrshToken);
                response.setHeader(JwtTokenUtil.TOKEN_HEADER,JwtTokenUtil.TOKEN_PREFIX+refrshToken);
                SecurityContextHolder.getContext().setAuthentication(getAuthentication(refrshToken));
            } else {
                refrshToken = token;
                // 如果请求头中有token，则进行解析，并且设置认证信息
                response.setHeader(JwtTokenUtil.TOKEN_HEADER,JwtTokenUtil.TOKEN_PREFIX+refrshToken);
                SecurityContextHolder.getContext().setAuthentication(getAuthentication(refrshToken));
            }

        }else{
            logger.info("当前token:{}，已失效不在redis中",token);
            // TODO: token失效，即跳转到登录界面，每次修改密码或者退出登录时都会这样操作
            response.getWriter().write(JSON.toJSONString(ResponseGenerator.genLoginIsOverdueReponse()));
//            chain.doFilter(request, response);  //不能继续放行
            return;

        }

        chain.doFilter(request, response);
    }

    // 这里从token中获取用户信息并新建一个token
    // 获取相关权限 重构继续下一步
    private UsernamePasswordAuthenticationToken getAuthentication(String token) {

        String username = JwtTokenUtil.getUsername(token);
        String role = (String) JwtTokenUtil.getClaims(token).get("role");
        if (username != null){
            return new UsernamePasswordAuthenticationToken(username, null,
                    Collections.singleton(new SimpleGrantedAuthority(role))
            );
        }
        return null;
    }
}
