package com.github.islsy.mininc.server.service.impl;

import com.alibaba.fastjson.JSON;
import com.github.islsy.mininc.pub.remoteservice.IUserService;

import java.util.HashMap;
import java.util.Map;

public class UserServiceImpl implements IUserService {

    @Override
    public Integer getUserCount() {
        System.out.println("Method getUserCount called:");
        System.out.println("*************************");

        return 18;
    }

    @Override
    public String getUserInfo(Integer id) {
        System.out.println("Method getUserInfo called:");
        System.out.println("Arg id=" + id);
        Map<String, Object> userModel = new HashMap<>();
        userModel.put("id", 1);
        userModel.put("name", "name");
        userModel.put("email", "name@sample.com");
        userModel.put("age", 19);
        userModel.put("sex", 0);
        userModel.put("schoolName", "Sunny School");
        System.out.println("*************************");

        return JSON.toJSONString(userModel);
    }

    @Override
    public Integer addUser(String name, String email, Integer age, Integer sex, String schoolName) {
        System.out.println("Method addUser called:");
        System.out.println("Arg name=" + name);
        System.out.println("Arg email=" + email);
        System.out.println("Arg age=" + age);
        System.out.println("Arg sex=" + sex);
        System.out.println("Arg schoolName=" + schoolName);
        System.out.println("*************************");

        return 19;
    }
}
