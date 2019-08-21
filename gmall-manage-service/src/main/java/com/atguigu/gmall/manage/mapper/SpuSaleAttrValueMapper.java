package com.atguigu.gmall.manage.mapper;

import com.atguigu.gmall.bean.SpuInfo;
import com.atguigu.gmall.bean.SpuSaleAttr;
import com.atguigu.gmall.bean.SpuSaleAttrValue;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface SpuSaleAttrValueMapper extends Mapper<SpuSaleAttrValue>{

    /**
     * 根据SPU的ID查询它的平台属性
     * @param spuId
     * @return
     */
    List<SpuSaleAttr> selectSpuSaleAttrList(String spuId);

}
