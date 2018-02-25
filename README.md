# spring-cloud-study
## eureka 例子
### 简单例子启动erueka
  cloud-package-dep/cloud-eureka-server/
### 创建集群eureka
  cloud-package-dep/cloud-eureka-server-A/；cloud-package-dep/cloud-eureka-server-B/

## config 例子
### 简单的例子启动config
  cloud-package-dep/cloud-config-server/ 服务注册到eureka，多个config注册到eureka可以达到集群的效果

## web 例子
### 简单的web启动
  cloud-web/cloud-web-a-simpleweb 从eureka读取config配置数据读取配置
