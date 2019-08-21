package com.atguigu.gmall.manage.Controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.gmall.bean.*;
import com.atguigu.gmall.service.ManageService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class SpumanageController {

    @Reference
    private ManageService manageService;

    //获取销售属性名称
    @RequestMapping("baseSaleAttrList")
    public List<BaseSaleAttr> baseSaleAttrList(){
        return manageService.getBaseSaleAttrList();
    }

    //保存添加SPU
    @RequestMapping("saveSpuInfo")
    public String saveSpuInfo(@RequestBody SpuInfo spuInfo){
        manageService.addSaveSpuInfo(spuInfo);
        return "success";
    }

    //spuSaleAttrList查询该SPU的所有销售属性
    @RequestMapping("spuSaleAttrList")
    public List<SpuSaleAttr> spuSaleAttrList(String spuId){
        return manageService.spuSaleAttrListBySpoInfo(spuId);
    }

    //spuImageList查询该SPU的图片
    @RequestMapping("spuImageList")
    public List<SpuImage> spuImageList(String spuId){
        return manageService.spuImageListBySpoInfo(spuId);
    }
}
