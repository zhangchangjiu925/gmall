package com.atguigu.gmall.order.controller;

import com.atguigu.gmall.bean.UserAddress;
import com.atguigu.gmall.service.UserInfoService;
import jdk.nashorn.internal.ir.annotations.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class OrderController {

    @Reference
    private UserInfoService userInfoService;

    @ResponseBody
    public List<UserAddress> trade(String userId){
        return userInfoService.getUserAddressList(userId);
    }
}
