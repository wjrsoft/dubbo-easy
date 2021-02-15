package com.wonder;

import com.wonder.core.ProviderService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class AppCustomer
{
    public static void main( String[] args ) throws IOException {

        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("consumer.xml");
        context.start();

        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < 10; i++) {
            ProviderService providerService = (ProviderService) context.getBean("providerService");
            String str = providerService.SayHello("hello "+i);
            System.out.println(str);
        }
        System.in.read();

    }
}
