package com.github.islsy.mininc.server.service.impl;

import com.github.islsy.mininc.pub.remoteservice.ISchoolService;

public class SchoolServiceImpl implements ISchoolService {

    @Override
    public String querySchoolName(Integer id) {
        System.out.println("Method querySchoolName called:");
        System.out.println("Arg id=" + id);
        System.out.println("*************************");
        return "Sunny School";
    }
}
