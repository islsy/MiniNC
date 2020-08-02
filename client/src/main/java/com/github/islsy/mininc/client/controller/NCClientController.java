package com.github.islsy.mininc.client.controller;


import com.github.islsy.mininc.pub.remoteservice.ISchoolService;
import com.github.islsy.mininc.pub.remoteservice.IStudentService;
import com.github.islsy.mininc.pub.remoteservice.IUserService;
import com.github.islsy.mininc.pub.rpc.NCLocator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * @Author: lsy
 * @Date: 2020/7/28 10:58 上午
 * 在这里对从程序进行操作,模拟client端的操作调用
 */
@RestController
@Api(tags = "NCClientController", description = "模拟NC client/web端的用户操作")
@RequestMapping("/NCClient")
public class NCClientController {

    @ApiOperation("获取用户数量")
    @GetMapping("/getUserCount")
    public String getUserCount() {
        Integer userCount = NCLocator.getInstance().lookup(IUserService.class).getUserCount();
        return userCount.toString();
    }

    @ApiOperation("获取用户信息")
    @GetMapping("/getUserInfo")
    public String getUserInfo() {
        String userInfo = NCLocator.getInstance().lookup(IUserService.class).getUserInfo(1);
        return userInfo;
    }

    @ApiOperation("添加用户")
    @GetMapping("/addUser")
    public String addUser() {
        Integer userId = NCLocator.getInstance().lookup(IUserService.class).addUser("name", "abc@gmail.com", 16, 0, "Garden School");
        return userId.toString();
    }

    @ApiOperation("查询学校")
    @GetMapping("/querySchoolName")
    public String querySchoolName() {
        return NCLocator.getInstance().lookup(ISchoolService.class).querySchoolName(5);
    }

    @ApiOperation("查询学生个数")
    @GetMapping("/queryStudentNumber")
    public String queryStudentNum() {
        return NCLocator.getInstance().lookup(IStudentService.class).getStudentNum().toString();
    }

    @ApiOperation("查询学生优劣")
    @GetMapping("/isStudentGood")
    public String isStudentGood(@RequestParam Integer studentNo) {
        return NCLocator.getInstance().lookup(IStudentService.class).isGoodStudent(studentNo) ? "是个好学生" : "不是个好学生";
    }
}