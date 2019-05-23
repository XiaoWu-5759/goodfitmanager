package com.simba.goodfitmanager.controller;

import com.simba.goodfitmanager.common.Response;
import com.simba.goodfitmanager.service.ActiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/active")
public class ActiveController {
    @Autowired
    private ActiveService activeService;

    @RequestMapping(value = "/{icid}",method = RequestMethod.PUT)
    public Response activeByOne(@PathVariable("icid") String icid){
        System.out.println("activeByOne"+":"+icid);
        Response response = null;
        response = activeService.activeByOne(icid);
        return response;
    }

    @RequestMapping(value = "/{icid1}/{icid2}", method = RequestMethod.PUT)
    public Response activeByTwo(@PathVariable("icid1") String icid1, @PathVariable("icid2") String icid2){
        System.out.println("activeByTwo"+":"+icid1+"+"+icid2);
        Response response = null;
        response = activeService.activeByTwo(icid1,icid2);
        return response;
//        return null;
    }
}
