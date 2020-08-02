//package com.github.islsy.mininc.client.rpctool;
//
//import com.github.islsy.mininc.pub.rpc.ServiceProxy;
//import org.springframework.beans.factory.FactoryBean;
//
//import java.lang.reflect.InvocationHandler;
//import java.lang.reflect.Proxy;
//
///**
// * NCLocator不需要该类, @Autowired 进行server注入的时候才需要本类在应用启动的时候进行加载
// * @param <T>
// */
//public class ServiceFactory<T> implements FactoryBean<T> {
//
//    private Class<T> interfaceType;
//
//    public ServiceFactory(Class<T> interfaceType) {
//        this.interfaceType = interfaceType;
//    }
//
//    @Override
//    public T getObject() {
//        InvocationHandler handler = new ServiceProxy<>(interfaceType);
//        return (T) Proxy.newProxyInstance(interfaceType.getClassLoader(),
//                new Class[]{interfaceType}, handler);
//    }
//
//    @Override
//    public Class<T> getObjectType() {
//        return interfaceType;
//    }
//
//    @Override
//    public boolean isSingleton() {
//        return true;
//    }
//}