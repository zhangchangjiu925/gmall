package com.atguigu.gmall.bean;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

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
}
