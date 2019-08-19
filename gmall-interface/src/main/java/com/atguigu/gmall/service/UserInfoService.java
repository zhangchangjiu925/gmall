package com.atguigu.gmall.service;

import com.atguigu.gmall.bean.UserAddress;
import com.atguigu.gmall.bean.UserInfo;

import java.util.List;


public interface UserInfoService {


    //查询所有
    public List<UserInfo> findAllList();

    //条件查询
    public List<UserInfo> selectUserByAny(UserInfo userInfo);

    //模糊查询
    public List<UserInfo> selectUserByLike(UserInfo userInfo);


    //添加用户
    public void addUser(UserInfo userInfo);

    //修改用户
    public void updateUser(UserInfo userInfo);


    //删除用户
    public void delete(UserInfo userInfo);

    public List<UserAddress> getUserAddressList(String userId);

}
