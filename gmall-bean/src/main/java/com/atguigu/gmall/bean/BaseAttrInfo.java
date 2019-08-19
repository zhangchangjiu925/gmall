package com.atguigu.gmall.bean;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

//物品属性表
@Data
public class BaseAttrInfo implements Serializable{

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;//编号
    @Column
    private String attrName;//属性名称
    @Column
    private String catalog3Id;//三级分类ID
    @Transient
    private List<BaseAttrValue>  attrValueList;


}
