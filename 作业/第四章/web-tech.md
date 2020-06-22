# 一个典型互联网应用系统使用了哪些技术方案和手段，主要解决什么样的问题？
## 负载均衡、反向代理
Nginx
主要用于软件负载及反向代理

## 网关
Spring Cloud Gateway、ZUUL、Kong
解决微服务的统一路由、鉴权、限流

## 微服务框架
SpringCloud框架、RPC框架（Dubbo）

## 数据库中间件
分表分库MyCat、ShardingJDBC(ShardingSphere)
主要解决高并发下对数据请求以及存储的问题。

## 消息队列MQ
KafKa、RocketMQ、RabbitMQ
主要解决问题有：
    1.异步处理
    2.服务或模块之间解耦
    3.高并发系统的流量消峰（如：高并发场景下数据写的性能问题）
    4.……

## 缓存框架
MemCached、Redis、阿里Tair
主要解决高并发场景下数据读的性能问题

## 分布式全文搜索引擎
Solr、ElasticSearch
主要解决分布式环境下全文搜索问题，具有快速存储、搜索、分析海量数据的能力。

## 分布式定时任务
Quartz、Elastic-Job、XXL-Job
主要解决分布式系统中任务调度问题。

## 分布式ID发号器
分布式系统中全局唯一ID问题
1.基于SnowFlake雪花算法实现
2.数据库自增ID机制实现
3.基于MySQL+Redis实现
4.……

## 全链路监控系统
PinPoint、SkyWalking
主要解决微服务应用链接调用监控等功能

## 统一配置中心
SpringCloud Config、DisConf、Apollo
主要解决分布式系统中集中化配置统一管理及动态维护等