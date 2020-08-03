# [MiniNC](https://github.com/islsy/MiniNC)

![language](https://img.shields.io/badge/language-java-green.svg)
![license](https://img.shields.io/badge/license-Apache-brightgreen.svg)
---

MiniNC是对NC(NCC)代码架构的及其简实现, 它使用极少的类、方法演示了NC中Client->public->server端调用的实现原理，是一个学习NC系统工作原理的良好示例。

该项目十分简单，包括客户端(NCC中可以认为为web端)MiniNCClient,中间共用的public端和服务端MiniNCServer三部分。演示时，Client会通过public端代码使用NCLocator调用Server中的方法。

# 功能演示

启动client,和server模块下的启动类


启动com.github.islsy.mininc.server.ServerApplication类
Server启动，并工作在`12311`端口。

启动com.github.islsy.mininc.client.ClientApplication类
Client启动，并工作在`12310`端口。

然后可以访问一下链接选择接口进行调用(模拟client端或web端的用户操作):

- http://127.0.0.1:12310/swagger-ui.html

上面几个方法会被则Client接收。然后，Client会通过NCLocator(public)调用Server获得操作结果，并返回。

# 功能实现

## Client实现

业务代码类为`MainController`。其中`MainController`类负责接收外部请求并通过NCLocator来进行接口调用, 接口的实现在server端,由于代码隔离不能直接进行调用。


## public实现

接口定义放在public模块中, public被client和server模块引用接口在两边都可生效

远程调用代码类public模块的`rpc`子包中，主要完成动态代理、远程调用参数序列化、远程调用发起、远程调用结果反序列化等工作。

## Server实现

业务带代码类在service.impl包中，其中类包含接口的具体实现。Client通过NCLocator最终调用了这里的代码。

远程代码类在`rpc`子包中，主要完成远程调用接收、调用参数反序列化、调用实际触发、调用结果序列化等工作。

