package com.simba.goodfitmanager.controller;


import com.simba.goodfitmanager.common.Response;
import com.simba.goodfitmanager.common.ResponseGenerator;
import com.simba.goodfitmanager.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/manager")
public class ManagerController {
    @Autowired
    private ManagerService managerService;

    @RequestMapping(value = "/{icid}", method = RequestMethod.PUT)
    public Response updateType(@PathVariable("icid") String icid,@RequestBody Map<String,Object> map){
        // json数据判空操作
        if (map.get("type") == null) {
            return ResponseGenerator.genIllegalArgumentReponse();
        }
        int type = Integer.valueOf(map.get("type").toString());
        //@RequestParam("type") int type
        System.out.println("updateType:"+icid+"+"+type);
        // 接受数据都应该有个判空过程
        // TODO:添加枚举判断
        // IntelliJ IDEA “condition always true”
        // || 或 && 与关系 要准确
        if (type != 0 && type != 1){
            return ResponseGenerator.genErrorReponse("type种类错误");
        }
        Response response = null;
        response = managerService.updateType(icid,type);
        return response;
    }

    @RequestMapping(value = "/{style}/{content}", method = RequestMethod.POST)
    public Response queryByStyle(@PathVariable String style, @PathVariable String content,
                                  @RequestBody Map<String,Object> map){
        // @RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize
        // 判空操作 默认spring就帮助操作了，但是json数据不行
        if(map.get("pageNum") == null || map.get("pageSize") ==null){
            return ResponseGenerator.genIllegalArgumentReponse();
        }
        int pageNum = Integer.parseInt(map.get("pageNum").toString());
        int pageSize = Integer.parseInt(map.get("pageSize").toString());
        System.out.println("queryByStyle:"+style+":"+content+"+pageNum:"+pageNum+"+pageSize:"+pageSize);
        //  判0操作
        if (pageNum == 0){
            pageNum = 1;  //设置默认当前页
        }
        if (pageNum <= 0){
            pageNum = 1;
        }
        if (pageSize == 0) {
            pageSize = 10;
        }
        Response response = null;
        response = managerService.queryByStyle(style,content,pageNum,pageSize);
        return response;
    }

    @RequestMapping(value = "/fit",method = RequestMethod.POST)
    // 根本不需要RequestParam，好像是直接从FormData中直接获取name = file
    // 加上RequestParam,可能会出现400错误，缺参数
    // RequestParam 获取键值
    public Response uploadExcel(@RequestParam("file") MultipartFile fileTest){

        // 这里 @RequestParam("file") 里面参数 没有任何用处
        // 这里也有用 可以变换名称？
        // @RequestParam 在序列化的键值对中找值
        // @RequestParam 也不需要加，但是可以加
        // 同时需要判空,找不到 会NPE
        Response response = null;
        if (!fileTest.isEmpty()) {
            try {
                // TODO:
                // 这里只是简单例子，文件直接输出到项目路径下。
                // 实际项目中，文件需要输出到指定位置，需要在增加代码处理。
                // 还有关于文件格式限制、文件大小限制
//                String uploadFileName = file.getOriginalFilename();
                BufferedOutputStream out = new BufferedOutputStream(
                        new FileOutputStream(new File(fileTest.getOriginalFilename())));
                out.write(fileTest.getBytes());
                out.flush();
                out.close();
                response = managerService.uploadExcel(fileTest.getOriginalFilename());
                return response;
            } catch (Exception e) {
                e.printStackTrace();
                return ResponseGenerator.genErrorReponse("上传失败，"+e.getMessage());
            }
        } else{
            return ResponseGenerator.genErrorReponse("上传失败，文件是空的");
        }
    }
}
