package com.simba.goodfitmanager.controller;

import com.simba.goodfitmanager.common.Response;
import com.simba.goodfitmanager.pojo.User;
import com.simba.goodfitmanager.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public Response authRegister(@RequestBody User user){
        System.out.println("authRegister:"+user.toString());
        Response response = null;
        response = authService.authRegister(user);
        return response;
    }

//    @RequestMapping(value = "/login",method = RequestMethod.POST)
//    public Response authLogin(){
//        Response response = null;
//        return response;
//    }


}
