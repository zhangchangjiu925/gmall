package com.atguigu.gmall.manage.mapper;

import com.atguigu.gmall.bean.SpuSaleAttr;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface SpuSaleAttrMapper extends Mapper<SpuSaleAttr>{

    /**
     * 根据SPU的ID查询销售属性
     * @param spuId
     * @return
     */
    List<SpuSaleAttr> getSpuSaleAttrList(String spuId);
}
