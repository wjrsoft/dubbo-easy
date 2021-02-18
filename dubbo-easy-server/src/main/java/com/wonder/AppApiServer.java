package com.wonder;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.ServiceConfig;
import com.wonder.core.ProviderService;
import com.wonder.core.ProviderServiceImpl;

import java.io.IOException;

/**
 * 启动提供远程接口
 * Api实现方式
 */
public class AppApiServer
{
    public static void main( String[] args ) throws IOException {

        // 服务实现-自定义接口

        ProviderService providerService = new ProviderServiceImpl();

        // 当前应用配置
        ApplicationConfig application = new ApplicationConfig();
        application.setName("provider");
        application.setOwner("dubboApiOwner");

        // 连接注册中心配置
        RegistryConfig registry = new RegistryConfig();
        registry.setAddress("zookeeper://localhost:2181");
//        registry.setUsername("aaa");
//        registry.setPassword("bbb");

        // 服务提供者协议配置
        ProtocolConfig protocol = new ProtocolConfig();
        protocol.setName("dubbo");
        protocol.setPort(20880);
        //protocol.setThreads(200);

        // 注意：ServiceConfig为重对象，内部封装了与注册中心的连接，以及开启服务端口

        // 服务提供者暴露服务配置
        // 此实例很重，封装了与注册中心的连接，请自行缓存，否则可能造成内存和连接泄漏
        ServiceConfig<ProviderService> service = new ServiceConfig<ProviderService>();
        service.setApplication(application);
        service.setRegistry(registry); // 多个注册中心可以用setRegistries()
        service.setProtocol(protocol); // 多个协议可以用setProtocols()
        service.setInterface(ProviderService.class);
        service.setRef(providerService);
//        service.setVersion("1.0.0");

        // 暴露及注册服务
        service.export();

        System.in.read(); // 按任意键退出
    }

}
