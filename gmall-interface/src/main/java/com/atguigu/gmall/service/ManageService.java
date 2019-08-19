package com.atguigu.gmall.service;

import com.atguigu.gmall.bean.*;

import java.util.List;


public interface ManageService {

    //查询所有一级分类
    public List<BaseCatalog1> getCatalog1();

    //根据一级分类ID查询二级分类
    public List<BaseCatalog2> getCatalog2(String catalog1Id);

    //根据二级分类查询三级分类
    public List<BaseCatalog3> getCatalog3(String catalog2Id);

    //根据三级分类查询其属性
    public List<BaseAttrInfo> getAttrList(String catalog3Id);

    //添加属性和属性值
    void saveAttrInfo(BaseAttrInfo baseAttrInfo);

    //根据属性ID查询所有属性值,并封装为属性返回
    BaseAttrInfo getAttrInfo(String attrId);

    //查询所有商品
    List<SpuInfo> getSpuInfoList(SpuInfo spuInfo);
}
