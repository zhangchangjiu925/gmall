package com.atguigu.gmall.bean;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

@Data
/**
 *SKU的销售属性
 */
public class SkuSaleAttrValue implements Serializable{

    @Id
    @Column
    String id;

    @Column
    String skuId;

    @Column
    String saleAttrId;

    @Column
    String saleAttrValueId;

    @Column
    String saleAttrName;

    @Column
    String saleAttrValueName;
}
