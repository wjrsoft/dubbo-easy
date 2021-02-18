package com.wonder.customer.annotation;

import com.alibaba.dubbo.config.annotation.Reference;
import com.wonder.core.ProviderServiceAnnotation;
import org.springframework.stereotype.Component;

/**
 * 注解方式的service
 * 注解一个调用远程接口的service
 */
@Component("annotatedConsumer")
public class ConsumerAnnotationService {
    //com.alibaba.dubbo.config.annotation.Reference 远程接口
    @Reference
    private ProviderServiceAnnotation providerServiceAnnotation;

    // 调用远程接口
    public String doSayHello(String name) {
        return providerServiceAnnotation.SayHello(name);
    }

}
