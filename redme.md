项目简介
====
 * dubbo-easy-core：提供ProviderService最简单的接口，打印入参，并返回入参
 * dubbo-easy-server:根据private.xml把接口ProviderService使用dubbo暴露，提供支持dubbo,zookeeper
 * dubbo-easy-customer:consumer.xml把配置远程接口ProviderService，提供支持dubbo,zookeeper

-------
#使用方法：

 * AppServer.java 使用mian方法启动，提供远程接口
 * AppCustomer.java 远程调用接口
