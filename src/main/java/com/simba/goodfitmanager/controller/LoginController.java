package com.simba.goodfitmanager.controller;

import com.simba.goodfitmanager.common.Response;
import com.simba.goodfitmanager.common.ResponseGenerator;
import com.simba.goodfitmanager.pojo.Account;
import com.simba.goodfitmanager.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
public class LoginController {
    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Response login(@RequestBody Account account){
        // 这里@RequestBody 是必须的
        // json数据，判空操作
//        System.out.println(account.toString());
        if(account.getAccountName() == null || account.getPassword() == null){
            return ResponseGenerator.genIllegalArgumentReponse();
        }
        String name = account.getAccountName();
        String password = account.getPassword();
        System.out.println("login:"+name+"+"+password);
        Response response = null;
        response = loginService.login(name,password);
        return response;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Response register(@RequestBody Map<String,Object> map){
        // json数据判空操作
        if (map.get("accountName") == null || map.get("password") == null || map.get("role") == null) {
            return ResponseGenerator.genIllegalArgumentReponse();
        }
        String accountName = map.get("accountName").toString();
        String password = map.get("password").toString();
        System.out.println("register:"+accountName+"+"+password+"+"+map.get("role").toString());
        int role = 1;
        switch(map.get("role").toString()){
            case "4s":
                role = 1;
                break;
            case "admin":
                role = 2;
                break;
            default:
                return ResponseGenerator.genIllegalArgumentReponse();
        }
        Account account = new Account(accountName,password,role);
        Response response = null;
        response = loginService.register(account);
        return response;
    }

}
