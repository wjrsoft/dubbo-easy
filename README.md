# dubbo-easy

项目简介
====
-------
###XML配置方式及说明
 * ProviderService最简单的接口，打印入参，并返回入参
 * private.xml把接口ProviderService使用dubbo暴露，提供支持dubbo,zookeeper
 * onsumer.xml把配置远程接口ProviderService，提供支持dubbo,zookeeper

###XML配置方式调用方法：

 * AppServer.java 使用mian方法启动，提供远程接口
 * AppCustomer.java 远程调用接口

-----
###API调用方式-不建议使用，一般用于测试
 AppApiServer.java 
 AppAPICustomer.java
----
###注解方式
  
  ProviderServiceAnnotation：注解接口实现方法
  
  DubboConfiguration：注解远程配置
  AppAnnotationServer:服务提供者启动
  
  
  ConsumerConfiguration：注解消费者配置
  ConsumerAnnotationService：消费者服务实现，reference远程接口
  AppAnnotationCustomer:消费者启动
   
-----


ZooKeeper服务命令:
     在准备好相应的配置之后，可以直接通过zkServer.sh 这个脚本进行服务的相关操作
1. 启动ZK服务:          sh bin/zkServer.sh start
2. 查看ZK服务状态:    sh bin/zkServer.sh status
3. 停止ZK服务:       sh bin/zkServer.sh stop
4. 重启ZK服务:       sh bin/zkServer.sh restart
