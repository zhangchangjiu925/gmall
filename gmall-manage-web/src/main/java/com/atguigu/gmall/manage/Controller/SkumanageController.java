package com.atguigu.gmall.manage.Controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.gmall.bean.SkuInfo;
import com.atguigu.gmall.service.ManageService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class SkumanageController {

    @Reference
    private ManageService manageService;

    @RequestMapping("saveSkuInfo")
    public String saveSkuInfo(@RequestBody SkuInfo skuInfo){
        manageService.addSaveSkuInfo(skuInfo);
        return "ok";
    }
}
