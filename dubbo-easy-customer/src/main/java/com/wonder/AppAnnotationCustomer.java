package com.wonder;

import com.alibaba.dubbo.config.annotation.Reference;
import com.wonder.core.ProviderServiceAnnotation;
import com.wonder.customer.annotation.ConsumerAnnotationService;
import com.wonder.customer.annotation.ConsumerConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

/**
 * main方法启动
 * 远程调用注解方式的消费者
 */
public class AppAnnotationCustomer {


    public static void main( String[] args ) throws IOException {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConsumerConfiguration.class);
        context.start(); // 启动
        ConsumerAnnotationService consumerAnnotationService = context.getBean(ConsumerAnnotationService.class);
        String hello = consumerAnnotationService.doSayHello("annotation"); // 调用方法
        System.out.println("result: " + hello); // 输出结果

    }

}
