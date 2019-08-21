package com.atguigu.gmall.manage.mapper;

import com.atguigu.gmall.bean.BaseAttrInfo;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface BaseAttrInfoMapper extends Mapper<BaseAttrInfo>{

    //根据三级分类ID查询它所属下的平台属性值对其进行回显
    List<BaseAttrInfo> getBaseAttrInfoListByCatalog3Id(String catalog3Id);
}
