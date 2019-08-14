package com.atguigu.gamll.gamllusermanage.service.impl;

import com.atguigu.gamll.gamllusermanage.bean.UserInfo;
import com.atguigu.gamll.gamllusermanage.mapper.UserInfoMapper;
import com.atguigu.gamll.gamllusermanage.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserInfoServiceImpl implements UserInfoService{

    @Autowired
    private UserInfoMapper userInfoMapper;


    public List<UserInfo> findAllList(){
        return userInfoMapper.selectAll();
    }

}
