package com.github.islsy.mininc.pub.rpc;

import com.alibaba.fastjson.JSON;
import com.sun.org.slf4j.internal.LoggerFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;


public class ServiceProxy<T> implements InvocationHandler {

    static Logger logger = Logger.getLogger("日志");

    private T target;

    public ServiceProxy(T target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 日志系统记录
        LocalTime start = LocalTime.now();

        // 真正调用server的地方
        Object result = rpc(proxy, method, args);

        LocalTime end = LocalTime.now();
        Duration period = Duration.between(start, end);
        logger.info(start.toString() + " 调用 " + target.toString() + " 耗时:" + period.toMillis());

        return result;

    }

    public Object rpc(Object proxy, Method method, Object[] args) throws Throwable {
        RemoteClass remoteClass = method.getDeclaringClass().getAnnotation(RemoteClass.class);
        if (remoteClass == null) {
            throw new Exception("远程类标志未指定");
        }

        List<String> argTypeList = new ArrayList<>();
        if (args != null) {
            for (Object obj : args) {
                argTypeList.add(obj.getClass().getName());
            }
        }

        String argTypes = JSON.toJSONString(argTypeList);
        String argValues = JSON.toJSONString(args);

        Result result = HttpUtil.callRemoteService(remoteClass.value(), method.getName(), argTypes, argValues);

        if (result.isSuccess()) {
            return JSON.parseObject(result.getResultValue(), Class.forName(result.getResultType()));
        } else {
            throw new Exception("远程调用异常：" + result.getMessage());

        }
    }
}