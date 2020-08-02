package com.github.islsy.mininc.pub.remoteservice;

import com.github.islsy.mininc.pub.rpc.RemoteClass;

/**
 * @Author: lsy
 * @Date: 2020/7/28 11:01 上午
 */

// 该注解相当于NC中的upm文件, 用途是对接口和文件进行注册
@RemoteClass("com.github.islsy.mininc.server.service.impl.StudentServiceImpl")
public interface IStudentService {

    boolean isGoodStudent(Integer studentId);

    Integer getStudentNum();
}
