package com.atguigu.gamll.gamllusermanage.controller;

import com.atguigu.gamll.gamllusermanage.bean.UserInfo;
import com.atguigu.gamll.gamllusermanage.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;


    @RequestMapping("findAll")
    public List<UserInfo> findAll(){
        return userInfoService.findAllList();
    }
}
