package com.atguigu.gmall.bean;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

//物品属性值表
@Data
public class BaseAttrValue implements Serializable{

    @Id
    @Column
    private String id;//编号
    @Column
    private String valueName;//属性值名称
    @Column
    private String attrId;//属性的ID
}
