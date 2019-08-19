package com.atguigu.gmall.bean;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

//一级分类
@Data
public class BaseCatalog1 implements Serializable{

    @Id
    @Column
    private String id;//编号
    @Column
    private String name;//分类名称
}
