package com.atguigu.gmall.bean;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Data
/**
 * SKU表
 */
public class SkuInfo implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column
    String id;//SKUID

    @Column
    String spuId;//SPUID

    @Column
    BigDecimal price;//价格

    @Column
    String skuName;//SKU名称

    @Column
    BigDecimal weight;//商品重量

    @Column
    String skuDesc;//商品描述

    @Column
    String catalog3Id;

    @Column
    String skuDefaultImg;

    @Transient
    List<SkuImage> skuImageList;

    @Transient
    List<SkuAttrValue> skuAttrValueList;

    @Transient
    List<SkuSaleAttrValue> skuSaleAttrValueList;
}
