# sys-notice
系统公告模块服务

**项目说明** 

项目框架：springboot+jpa+mysql+resultful

<br> 

**项目结构** 
```
sys-notice
├─doc  项目SQL语句
├─common  java代码
├─RenrenApplication.java 项目启动类
│ 
├─resources 
│  ├─application.yml        全局配置文件
│  ├─application-dev.yml    开发环境配置文件
│  └─application-test.yml   测试环境配置文件
│  └─application-prod.yml    正式环境配置文件



```

<br>

 **本地部署**
- 通过git下载源码
- 创建数据库sys_notice，数据库编码为UTF-8
- 执行doc/db.sql文件，初始化数据【按需导入表结构及数据】
- 修改application-dev.yml，更新MySQL账号和密码
- Eclipse、IDEA运行ServiceNoticeApplication.java，则可启动项目
- 项目访问路径：http://localhost:8082/
- swagger文档路径：http://localhost:8082/swagger/index.html
