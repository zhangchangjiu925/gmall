package com.atguigu.gmall.bean;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

//二级分类
@Data
public class BaseCatalog2 implements Serializable{

    @Id
    @Column
    private String id;//编号
    @Column
    private String name;//二级分类名称
    @Column
    private String catalog1Id;//一级分类ID
}
