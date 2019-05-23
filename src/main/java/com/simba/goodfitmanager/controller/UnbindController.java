package com.simba.goodfitmanager.controller;

import com.simba.goodfitmanager.common.Response;
import com.simba.goodfitmanager.service.UnbindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/unbind")
public class UnbindController {
    @Autowired
    private UnbindService unbindService;

    @RequestMapping(value = "/{icid}",method = RequestMethod.POST)
    public Response unbind(@PathVariable("icid") String iccid){
        Response response = null;
        response = unbindService.unbind(iccid);
        return response;
    }
}
