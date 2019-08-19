package com.atguigu.gmall.user.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.gmall.bean.UserAddress;
import com.atguigu.gmall.bean.UserInfo;
import com.atguigu.gmall.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserInfoController {

    @Reference
    private UserInfoService userInfoService;


    //查询所有
    @RequestMapping("findAll")
    public List<UserInfo> findAll(){
        return userInfoService.findAllList();
    }

    //按条件查询
    @RequestMapping("selectUser")
    public List<UserInfo> selectUser(UserInfo userInfo){
        return userInfoService.selectUserByAny(userInfo);
    }

    //模糊查询
    @RequestMapping("updateUser")
    public List<UserInfo> updateUser(UserInfo userInfo){
        return userInfoService.selectUserByLike(userInfo);
    }

    //添加用户
    @RequestMapping("insertUser")
    public void insertUser(UserInfo userInfo){
        userInfoService.addUser(userInfo);
    }

    //修改用户 8001/updateUserInfo?name=?&id=?
    @RequestMapping("updateUserInfo")
    public void updateUserInfo(UserInfo userInfo){
        userInfoService.updateUser(userInfo);
    }


    //删除用户
    @RequestMapping("deleteUserInfo")
    public void deleteUserInfo(UserInfo userInfo){
        userInfoService.delete(userInfo);
    }

    //根据用户ID查询地址 8001/selectAddress?userId=1
    @RequestMapping("selectAddress")
    public List<UserAddress> selectAddress(String userId){
        return userInfoService.getUserAddressList(userId);
    }
}
