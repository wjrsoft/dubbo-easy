package com.wonder;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.wonder.core.ProviderService;

import java.io.IOException;

/**
 * Hello world!
 * Api调用调用方式
 * 模拟调用10次接口，测试zookeeper是否有负载到多个dubbo接口
 */
public class AppApiCustomer
{
    public static void main( String[] args ) throws IOException {

        // 当前应用配置
        ApplicationConfig application = new ApplicationConfig();
        application.setName("consumer");
        application.setOwner("dubboApiOwner");

        // 连接注册中心配置
        RegistryConfig registry = new RegistryConfig();
        registry.setAddress("zookeeper://localhost:2181");

        // 注意：ReferenceConfig为重对象，内部封装了与注册中心的连接，以及与服务提供方的连接

        // 引用远程服务
        ReferenceConfig<ProviderService> reference = new ReferenceConfig<ProviderService>(); // 此实例很重，~封装了与注册中心的连接以及与提供者的连接，请自行缓存，否则可能造成内存和连接泄漏
        reference.setApplication(application);
        reference.setRegistry(registry); // 多个注册中心可以用setRegistries()
        reference.setInterface(ProviderService.class);

        for (int i = 0; i < 10; i++) {
            // 注意：此代理对象内部封装了所有通讯细节，对象较重，请缓存复用
            ProviderService providerService = reference.get();
            String str = providerService.SayHello("hello "+i);
            System.out.println(str);
        }
        // 和本地bean一样使用xxxService
        ProviderService providerService = reference.get(); // 注意：此代理对象内部封装了所有通讯细节，对象较重，请缓存复用
        providerService.SayHello("hello dubbo! I am sihai!");


    }
}
