package com.simba.goodfitmanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
//@RequestMapping("/api/v4")
public class PageController {
    @RequestMapping(value = "/active",method = RequestMethod.GET)
    public String active(){
        return "active";
//        return null;
    }

    @RequestMapping(value = "/manager",method = RequestMethod.GET)
    public String manager(){
        return "manager";
    }

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(){
        return "login";
    }
}
