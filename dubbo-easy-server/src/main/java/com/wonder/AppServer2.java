package com.wonder;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * 再启动一个，用zookeeper实现负载均衡
 */
public class AppServer2
{
    public static void main( String[] args ) throws IOException {
        //加载xml配置文件启动
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("provider2.xml");
        context.start();
        System.in.read(); // 按任意键退出
    }
}
