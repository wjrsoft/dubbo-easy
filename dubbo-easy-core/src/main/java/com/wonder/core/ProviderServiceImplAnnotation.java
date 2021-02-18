package com.wonder.core;

import com.alibaba.dubbo.config.annotation.Service;

/**
 * 注解方式实现类
 */
@Service(timeout = 5000)
public class ProviderServiceImplAnnotation implements ProviderServiceAnnotation {
    public ProviderServiceImplAnnotation() {
        System.out.println("ProviderServiceImpl init");
    }

    public String SayHello(String word) {
        System.out.println("收到一个远程调用请求，请求参数：" + word);
        return word;
    }
}
