package com.github.islsy.mininc.pub.remoteservice;


import com.github.islsy.mininc.pub.rpc.RemoteClass;

// 该注解相当于NC中的upm文件, 用途是对接口和文件进行注册
@RemoteClass("com.github.islsy.mininc.server.service.impl.SchoolServiceImpl")
public interface ISchoolService {
    String querySchoolName(Integer id);
}
