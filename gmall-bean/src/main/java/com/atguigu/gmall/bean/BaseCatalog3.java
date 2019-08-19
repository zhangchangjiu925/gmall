package com.atguigu.gmall.bean;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

//三级分类
@Data
public class BaseCatalog3 implements Serializable{
    @Id
    @Column
    private String id;//编号
    @Column
    private String name;//三级分类的名称
    @Column
    private String catalog2Id;//二级分类ID
}
