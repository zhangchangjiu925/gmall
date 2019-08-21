package com.atguigu.gmall.bean;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * 商品实体类
 */
@Data
public class SpuInfo implements Serializable{

    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;//商品ID

    @Column
    private String spuName;//商品名称

    @Column
    private String description;//商品描述

    @Column
    private  String catalog3Id;//三级分类ID

    @Transient
    private List<SpuSaleAttr> spuSaleAttrList;

    @Transient
    private List<SpuImage> spuImageList;
}
