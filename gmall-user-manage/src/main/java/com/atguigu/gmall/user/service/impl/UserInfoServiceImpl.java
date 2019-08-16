package com.atguigu.gmall.user.service.impl;


import com.alibaba.dubbo.config.annotation.Service;
import com.atguigu.gmall.bean.UserAddress;
import com.atguigu.gmall.bean.UserInfo;
import com.atguigu.gmall.service.UserInfoService;
import com.atguigu.gmall.user.mapper.UserAddressMapper;
import com.atguigu.gmall.user.mapper.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private UserAddressMapper userAddressMapper;


    //查询所有
    public List<UserInfo> findAllList(){
        return userInfoMapper.selectAll();
    }

    
    //根据条件查询
    @Override
    public List<UserInfo> selectUserByAny(UserInfo userInfo) {
        Example example = new Example(UserInfo.class);
        return userInfoMapper.selectByExample(example);
    }

    //模糊查询
    @Override
    public List<UserInfo> selectUserByLike(UserInfo userInfo) {
        Example example = new Example(UserInfo.class);
        example.createCriteria().andLike("nickName","%"+userInfo.getNickName()+"%");
        return userInfoMapper.selectByExample(example);
    }

    //添加用户
    @Override
    public void addUser(UserInfo userInfo) {
        userInfoMapper.insertSelective(userInfo);
    }


    //修改用户
    @Override
    public void updateUser(UserInfo userInfo) {
        Example example = new Example(UserInfo.class);
        example.createCriteria().andEqualTo("name",userInfo.getName());
        userInfoMapper.updateByExampleSelective(userInfo,example);
    }


    //删除用户
    @Override
    public void delete(UserInfo userInfo) {
        userInfoMapper.deleteByPrimaryKey(userInfo);
    }


    //根据用户ID查询地址
    @Override
    public List<UserAddress> getUserAddressList(String userId) {
        UserAddress userAddress = new UserAddress();
        userAddress.setId(userId);
        return userAddressMapper.select(userAddress);
    }

}
