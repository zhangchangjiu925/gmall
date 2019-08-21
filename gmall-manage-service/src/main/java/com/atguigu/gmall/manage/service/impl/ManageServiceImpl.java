package com.atguigu.gmall.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.atguigu.gmall.bean.*;
import com.atguigu.gmall.manage.mapper.*;
import com.atguigu.gmall.service.ManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class ManageServiceImpl implements ManageService {


    @Autowired
    private BaseCatalog1Mapper baseCatalog1Mapper;

    @Autowired
    private BaseCatalog2Mapper baseCatalog2Mapper;

    @Autowired
    private BaseCatalog3Mapper baseCatalog3Mapper;

    @Autowired
    private BaseAttrInfoMapper baseAttrInfoMapper;

    @Autowired
    private BaseAttrValueMapper baseAttrValueMapper;

    @Autowired
    private SpuInfoMapper spuInfoMapper;

    @Autowired
    private BaseSaleAttrMapper baseSaleAttrMapper;

    @Autowired
    private SpuImageMapper spuImageMapper;

    @Autowired
    private SpuSaleAttrMapper spuSaleAttrMapper;

    @Autowired
    private SpuSaleAttrValueMapper spuSaleAttrValueMapper;

    @Autowired
    private SkuInfoMapper skuInfoMapper;

    @Autowired
    private SkuAttrValueMapper skuAttrValueMapper;

    @Autowired
    private SkuImageMapper skuImageMapper;

    @Autowired
    private SkuSaleAttrValueMapper skuSaleAttrValueMapper;


    @Override
    //查询所有一级分类
    public List<BaseCatalog1> getCatalog1() {
        return baseCatalog1Mapper.selectAll();
    }

    @Override
    //根据一级分类ID查询二级分类
    public List<BaseCatalog2> getCatalog2(String catalog1Id) {
        Example example = new Example(BaseCatalog2.class);
        example.createCriteria().andEqualTo("catalog1Id", catalog1Id);
        return baseCatalog2Mapper.selectByExample(example);
    }

    @Override
    //根据二级分类查询三级分类
    public List<BaseCatalog3> getCatalog3(String catalog2Id) {
        Example example = new Example(BaseCatalog3.class);
        example.createCriteria().andEqualTo("catalog2Id", catalog2Id);
        return baseCatalog3Mapper.selectByExample(example);
    }

    @Override
    ////根据三级分类ID查询它所属下的平台属性值对其进行回显
    public List<BaseAttrInfo> getAttrList(String catalog3Id) {
        return baseAttrInfoMapper.getBaseAttrInfoListByCatalog3Id(catalog3Id);
    }


    //添加属性和属性值
    @Override
    @Transactional
    public void saveAttrInfo(BaseAttrInfo baseAttrInfo) {

        //判断该属性是否存在(添加或修改)
        if (baseAttrInfo.getId() != null && baseAttrInfo.getId().length() > 0) {
            //存在,则修改
            baseAttrInfoMapper.updateByPrimaryKey(baseAttrInfo);
        } else {
            //不存在则添加
            baseAttrInfo.setId(null);
            baseAttrInfoMapper.insertSelective(baseAttrInfo);
        }

        //在进行属性值操作时,将前端页面的属性值作为整体操作,所有要将原属性值删除,将修改后的属性值赋予数据库
        BaseAttrValue baseAttrValue = new BaseAttrValue();
        baseAttrValue.setAttrId(baseAttrInfo.getId());
        baseAttrValueMapper.delete(baseAttrValue);

        if (baseAttrInfo.getAttrValueList() != null && baseAttrInfo.getAttrValueList().size() > 0) {
            for (BaseAttrValue attrValue : baseAttrInfo.getAttrValueList()) {
                attrValue.setId(null);
                attrValue.setAttrId(baseAttrInfo.getId());
                baseAttrValueMapper.insert(attrValue);
            }
        }
    }

    @Override
    //根据属性ID查询所有属性值,并封装为属性返回
    public BaseAttrInfo getAttrInfo(String attrId) {
        BaseAttrInfo baseAttrInfo = baseAttrInfoMapper.selectByPrimaryKey(attrId);
        BaseAttrValue attrValue = new BaseAttrValue();
        attrValue.setAttrId(baseAttrInfo.getId());
        List<BaseAttrValue> baseAttrValues = baseAttrValueMapper.select(attrValue);
        baseAttrInfo.setAttrValueList(baseAttrValues);
        return baseAttrInfo;
    }


    @Override
    //查询所有商品
    public List<SpuInfo> getSpuInfoList(SpuInfo spuInfo) {
        return spuInfoMapper.select(spuInfo);
    }

    @Override
    public List<BaseSaleAttr> getBaseSaleAttrList() {
        return baseSaleAttrMapper.selectAll();
    }

    //保存SPU
    @Override
    @Transactional
    public void addSaveSpuInfo(SpuInfo spuInfo) {

        // 什么情况下是保存，什么情况下是更新 spuInfo
        if (spuInfo.getId() == null || spuInfo.getId().length() == 0) {
            //保存数据
            spuInfo.setId(null);
            spuInfoMapper.insertSelective(spuInfo);

        } else {
            spuInfoMapper.updateByPrimaryKeySelective(spuInfo);
        }

        //  spuImage 图片列表 先删除，在新增
        //  delete from spuImage where spuId =?
        SpuImage spuImage = new SpuImage();
        spuImage.setSpuId(spuInfo.getId());
        spuImageMapper.delete(spuImage);

        // 保存数据，先获取数据
        List<SpuImage> spuImageList = spuInfo.getSpuImageList();
        if (spuImageList != null && spuImageList.size() > 0) {
            // 循环遍历
            for (SpuImage image : spuImageList) {
                image.setId(null);
                image.setSpuId(spuInfo.getId());
                spuImageMapper.insertSelective(image);
            }
        }
        // 销售属性 删除，插入
        SpuSaleAttr spuSaleAttr = new SpuSaleAttr();
        spuSaleAttr.setSpuId(spuInfo.getId());
        spuSaleAttrMapper.delete(spuSaleAttr);

        // 销售属性值 删除，插入
        SpuSaleAttrValue spuSaleAttrValue = new SpuSaleAttrValue();
        spuSaleAttrValue.setSpuId(spuInfo.getId());
        spuSaleAttrValueMapper.delete(spuSaleAttrValue);

        // 获取数据
        List<SpuSaleAttr> spuSaleAttrList = spuInfo.getSpuSaleAttrList();
        if (spuSaleAttrList != null && spuSaleAttrList.size() > 0) {
            // 循环遍历
            for (SpuSaleAttr saleAttr : spuSaleAttrList) {
                saleAttr.setId(null);
                saleAttr.setSpuId(spuInfo.getId());
                spuSaleAttrMapper.insertSelective(saleAttr);

                // 添加销售属性值
                List<SpuSaleAttrValue> spuSaleAttrValueList = saleAttr.getSpuSaleAttrValueList();
                if (spuSaleAttrValueList != null && spuSaleAttrValueList.size() > 0) {
                    // 循环遍历
                    for (SpuSaleAttrValue saleAttrValue : spuSaleAttrValueList) {
                        saleAttrValue.setId(null);
                        saleAttrValue.setSpuId(spuInfo.getId());
                        spuSaleAttrValueMapper.insertSelective(saleAttrValue);
                    }
                }

            }
        }
    }


    @Override
    //spuSaleAttrList查询该SPU的所有销售属性
    public List<SpuSaleAttr> spuSaleAttrListBySpoInfo(String spuId) {
        return spuSaleAttrMapper.getSpuSaleAttrList(spuId);
    }


    @Override
    //根据Spu查询它的图片
    public List<SpuImage> spuImageListBySpoInfo(String spuId) {
        SpuImage spuImage = new SpuImage();
        spuImage.setSpuId(spuId);
        return spuImageMapper.select(spuImage);
    }

    @Override
    //保存SKU
    public void addSaveSkuInfo(SkuInfo skuInfo) {

        if(skuInfo.getId()==null || skuInfo.getId().length()==0){
            //增
            skuInfo.setId(null);
            skuInfoMapper.insertSelective(skuInfo);
        }else {
            skuInfoMapper.updateByPrimaryKeySelective(skuInfo);
        }

        List<SkuAttrValue> skuAttrValueList = skuInfo.getSkuAttrValueList();
        if(skuAttrValueList != null && skuAttrValueList.size()>0){

            for (SkuAttrValue skuAttrValue : skuAttrValueList) {
                if(skuAttrValue.getId()==null && skuAttrValue.getId().length()==0){
                    skuAttrValue.setSkuId(null);
                }
                skuAttrValue.setSkuId(skuInfo.getId());
                skuAttrValueMapper.insertSelective(skuAttrValue);
            }
        }


        SkuSaleAttrValue skuSaleAttrValue = new SkuSaleAttrValue();
        skuSaleAttrValue.setSkuId(skuInfo.getId());
        skuSaleAttrValueMapper.delete(skuSaleAttrValue);

        List<SkuSaleAttrValue> skuSaleAttrValueList = skuInfo.getSkuSaleAttrValueList();
        if (skuSaleAttrValueList!=null && skuSaleAttrValueList.size()>0){
            for (SkuSaleAttrValue saleAttrValue : skuSaleAttrValueList) {
                if (saleAttrValue.getId()!=null && saleAttrValue.getId().length()==0){
                    saleAttrValue.setId(null);
                }
                // skuId
                saleAttrValue.setSkuId(skuInfo.getId());
                skuSaleAttrValueMapper.insertSelective(saleAttrValue);
            }
        }
    }
}


