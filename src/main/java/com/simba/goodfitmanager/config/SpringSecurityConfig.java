package com.simba.goodfitmanager.config;

import com.simba.goodfitmanager.filter.SelfAuthorizationFilter;
import com.simba.goodfitmanager.security.*;
import com.simba.goodfitmanager.service.impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.CorsUtils;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.Collections;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
/**
 * 配置SpringSecurity
 */
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    SelfAuthenticationEntryPoint authenticationEntryPoint;//未登陆时返回 JSON 格式的数据给前端（否则为 html）

    @Autowired
    SelfAuthenticationSuccessHandler authenticationSuccessHandler; //登录成功返回的 JSON 格式数据给前端（否则为 html）

    @Autowired
    SelfAuthenticationFailureHandler authenticationFailureHandler; //登录失败返回的 JSON 格式数据给前端（否则为 html）

    @Autowired
    SelfLogoutSuccessHandler logoutSuccessHandler;//注销成功返回的 JSON 格式数据给前端（否则为 登录时的 html）

    @Autowired
    SelfAccessDeniedHandler accessDeniedHandler;//无权访问返回的 JSON 格式数据给前端（否则为 403 html 页面）

    @Autowired
    // 因为UserDetailsService的实现类实在太多啦，这里设置一下我们要注入的实现类
//    @Qualifier("userDetailsServiceImpl")
    UserDetailsServiceImpl userDetailsService; // 自定义user

    @Autowired
    SelfAuthorizationFilter selfAuthorizationFilter;

    // 信息加密
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    // user Details Service验证
    // AuthenticationProvider
    // UserDetailsService
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
    }

    //配置Spring Security 忽略静态资源
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/resources/**");
    }

    //对每个请求进行细粒度安全性控制的关键在于重载一下方法
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()  // 关闭防跨站伪请求攻击，默认启用
                .cors()
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)  // 不需要session

                .and()
                .authorizeRequests()  // 该方法所返回的对象的方法来配置请求级别的安全细节
                    .antMatchers("/auth/register").permitAll()  // 对于登录注册，全部开放
                    .antMatchers("/tasks/**").authenticated()  // 只有登录用户才能访问
                    .antMatchers("/active/**").authenticated()
                    .antMatchers("/manager/**").hasAuthority("ROLE_ADMIN")
                    .antMatchers("/unbind/**").hasAuthority("ROLE_ADMIN")
                    .requestMatchers(CorsUtils::isPreFlightRequest).permitAll()
                    // 只有管理员权限才能删除
                    .antMatchers(HttpMethod.DELETE, "/tasks/**").hasAuthority("ROLE_ADMIN")
                    .anyRequest().permitAll()  //其余的都通过

                .and()
                    .formLogin()//配置登录页面
                    .loginProcessingUrl("/auth/login")
//                    .loginPage("/auth/login")//登录页面的访问路径
////                    .loginProcessingUrl("/check")//登录页面下表单提交的路径
////                    .failureUrl("/login")//登录失败后跳转的路径
////                    .defaultSuccessUrl("/show")//登录成功后默认跳转的路径
                    .successHandler(authenticationSuccessHandler) // 登录成功
                    .failureHandler(authenticationFailureHandler) // 登录失败
                    .permitAll()

                .and()
                    .logout()//用户退出操作
//                    .logoutUrl("/logout")//用户退出所访问的路径，需要使用Post方式
                    .logoutUrl("/auth/logout")
                    .logoutSuccessHandler(logoutSuccessHandler)
                    .permitAll()
//                    .logoutSuccessUrl("/login?logout=true")

                // 配置拦截器
                .and()
//                    .addFilter(new SelfAuthenticationFilter(authenticationManager()))
//                    .addFilter(new SelfAuthorizationFilter(authenticationManager()))
                .exceptionHandling().authenticationEntryPoint(authenticationEntryPoint)

                .and()
                .addFilterBefore(selfAuthorizationFilter, BasicAuthenticationFilter.class);
    }
    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("*"));
        configuration.setAllowedMethods(Arrays.asList("*"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}
