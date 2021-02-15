package com.wonder.core;

/**
 * xml方式服务提供者实现类
 * 就是一个普通的接口，传入什么参数，返回什么参数
 */
public class ProviderServiceImpl implements ProviderService{

    public ProviderServiceImpl(){
        System.out.println("ProviderServiceImpl init");
    }

    public String SayHello(String word) {
        System.out.println("收到一个远程调用请求，请求参数："+word);
        return word;
    }
}

