package com.simba.goodfitmanager.controller;

import com.simba.goodfitmanager.common.Response;
import com.simba.goodfitmanager.service.ActiveService;


import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "ActiveContoller",description = "提供iccid激活服务相关接口")
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/active")
public class ActiveController {
    private Logger logger = LoggerFactory.getLogger(ActiveController.class);

    @Autowired
    private ActiveService activeService;

    @ApiOperation(value = "激活iccid",notes = "根据传入的参数 iccid 查询配件并激活",httpMethod = "PUT")
    @ApiImplicitParams({
            // 参数名字要保持一直，icid如果存在的化
            @ApiImplicitParam(
                    name = "icid",
                    value = "配件码",
                    paramType = "path",
                    dataType = "String",
                    required = true
            )
    })
    @ApiResponses({
            @ApiResponse(
                    code = 200,
                    message = "成功",
                    response = com.simba.goodfitmanager.common.Response.class
            ),
            @ApiResponse(
                    code = 404,
                    message = "网络异常",
                    response = Exception.class
            )
    })
    @RequestMapping(value = "/{icid}",method = RequestMethod.PUT)
    public Response activeByOne(@PathVariable("icid") String icid){
        logger.info("激活iccid:"+"activeByOne:入参:iccid:{}",icid);
        Response response = null;
        response = activeService.activeByOne(icid);
        return response;
    }

    @RequestMapping(value = "/{icid1}/{icid2}", method = RequestMethod.PUT)
    public Response activeByTwo(@PathVariable("icid1") String icid1, @PathVariable("icid2") String icid2){
//        System.out.println("activeByTwo"+":"+icid1+"+"+icid2);
        logger.info("替换iccid:"+"activeByOne:入参:new iccid:{},old iccid{}",icid1,icid2);
        Response response = null;
        response = activeService.activeByTwo(icid1,icid2);
        return response;
//        return null;
    }
}
