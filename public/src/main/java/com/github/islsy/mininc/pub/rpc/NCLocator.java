package com.github.islsy.mininc.pub.rpc;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: lsy
 * @Date: 2020/7/27 11:00 上午
 */
public class NCLocator {

    private static volatile NCLocator ncLocator;

    private static ConcurrentHashMap instanceMap = new ConcurrentHashMap<>();


    private NCLocator() {
    }

    public static NCLocator getInstance() {
        if (ncLocator == null) {
            synchronized (NCLocator.class) {
                if (ncLocator == null) {
                    ncLocator = new NCLocator();
                }
            }
        }
        return ncLocator;
    }

    public <T>T lookup(Class<T> interfaceType) {
        InvocationHandler handler = new ServiceProxy<>(interfaceType);
        return (T) Proxy.newProxyInstance(interfaceType.getClassLoader(),
                new Class[]{interfaceType}, handler);
    }

}
