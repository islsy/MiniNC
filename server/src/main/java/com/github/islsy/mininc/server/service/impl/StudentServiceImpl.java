package com.github.islsy.mininc.server.service.impl;

import com.github.islsy.mininc.pub.remoteservice.IStudentService;

/**
 * @Author: lsy
 * @Date: 2020/7/28 2:51 下午
 */
public class StudentServiceImpl implements IStudentService {
    @Override
    public boolean isGoodStudent(Integer studentId) {
        if (studentId > 100){
            return true;
        }
        return false;
    }

    @Override
    public Integer getStudentNum() {
        return 500;
    }
}
