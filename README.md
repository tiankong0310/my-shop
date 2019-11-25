# my-shop
my-shop基于Spring+SpringMVC+Mybatis+ Shiro分布式敏捷开发系统架构，提供整套公共微服务服务模块：内容管理、支付中心、用户管理（包括第三方）、微信平台、存储系统、配置中心、日志分析、任务和通知等，支持服务治理、监控和追踪，努力为中小型企业打造全方位J2EE企业级开发解决方案。 致力打造通用综合管理平台。官方qq群：711281203

git：https://gitee.com/tiankong0310/my-shop.git
github:https://github.com/tiankong0310/my-shop

官方QQ群1：711281203 ,群2:685261895 欢迎大家fork,star,有兴趣的可一起参与开发，谢谢！(如有问题，请联系,小天qq:2366307000)

前言

my-shop项目不仅仅是一个开发架构，前后分离，而是努力打造一套从 前端模板 - 基础框架 - 分布式架构 - 开源项目 - 持续集成 - 自动化部署 - 系统监测 - 无缝升级 的全方位J2EE企业级开发解决方案。

2.项目介绍

　 基于Spring+SpringMVC+Mybatis+ shiro+vue+swagger2微信小程序式敏捷开发系统架构，提供整套公共微服务服务模块：内容管理、支付中心、用户管理（包括第三方）、微信平台、存储系统、配置中心、日志分析、任务和通知等，支持服务治理、监控和追踪， 努力为中小型企业打造全方位J2EE企业级开发解决方案。

3.项目组织结构描述：

输入图片说明

my-shop-manager --综合后台管理
my-shop-api --微信小程序商城api接口
my-shop-common --公共模块
my-shop-web --网站商城
my-shop-merchants  --运营商管理平台
my-shop-gen --代码生成
my-shop-schedule --定时任务
my-shop-shiro --登陆权限相关
my-shop-webchat --微信管理
my-shop-oss   --oss云存储管理
my-shop-pay   --支付管理
my-shop-pointsmall  --积分商城
my-shop-serach   --搜索模块
my-shop-goods   --商品模块
my-shop-member  --会员模块
my-shop-order  --订单管理
my-shop-fast   --文件存储
my-shop-im   --im消息
my-shop-ucenter   --用户认证中心
my-shop-mq  --消息机制
my-shop-config   --配置管理
my-shop-crm   --客户管理
my-shop-erp   --采购管理
my-shop-cms  -- 内容管理
my-shop-cache  -- 缓存管理
my-shop-wx-mall -- 微信小程序商城
my-shop-h5-vue -- h5商城
my-shop-activiti -- 工作流程
my-shop-reports -- 报表统计
my-shop-wms  --库存管理系统
后台swagger-API接口： 输入图片说明 4.技术选型

技术	名称	官网
Spring Framework	容器	http://projects.spring.io/spring-framework/
SpringMVC	MVC框架	http://docs.spring.io/spring/docs/current/spring-framework-reference/htmlsingle/#mvc
Apache Shiro	安全框架	http://shiro.apache.org/
Spring session	分布式Session管理	http://projects.spring.io/spring-session/
MyBatis	ORM框架	http://www.mybatis.org/mybatis-3/zh/index.html
MyBatis Generator	代码生成	http://www.mybatis.org/generator/index.html
PageHelper	MyBatis物理分页插件	http://git.oschina.net/free/Mybatis_PageHelper
Druid	数据库连接池	https://github.com/alibaba/druid
FluentValidator	校验框架	https://github.com/neoremind/fluent-validator
Thymeleaf	模板引擎	http://www.thymeleaf.org/
Velocity	模板引擎	http://velocity.apache.org
Redis	分布式缓存数据库	https://redis.io/
Solr & Elasticsearch	分布式全文搜索引擎	http://lucene.apache.org/solr/ 
Quartz	作业调度框架	http://www.quartz-scheduler.org/
Ehcache	进程内缓存框架	http://www.ehcache.org/
ActiveMQ	消息队列	http://activemq.apache.org/
JStorm	实时流式计算框架	http://jstorm.io/
FastDFS	分布式文件系统	https://github.com/happyfish100/fastdfs
Log4J	日志组件	http://logging.apache.org/log4j/1.2/
Swagger2	接口测试框架	http://swagger.io/
sequence	分布式高效ID生产	http://git.oschina.net/yu120/sequence
AliOSS & Qiniu & QcloudCOS	云存储	https://www.aliyun.com/product/oss/ http://www.qiniu.com/ 
https://www.qcloud.com/product/cos
Protobuf & json	数据序列化	https://github.com/google/protobuf
Jenkins	持续集成工具	https://jenkins.io/index.html
Maven	项目构建管理	http://maven.apache.org/
5.环境搭建（QQ群内有“my-shop环境搭建和系统部署文档.doc”）

	开发工具:
MySql: 数据库
jetty: 开发服务器
Tomcat: 应用服务器
SVN|Git: 版本管理
Nginx: 反向代理服务器
Varnish: HTTP加速器
IntelliJ IDEA: 开发IDE
PowerDesigner: 建模工具
Navicat for MySQL: 数据库客户端
开发环境：
Jdk8+
Mysql5.5+
Redis
ActiveMQ
工具安装
环境搭建和系统部署文档(作者：小天，qq:2366207000,群1:711281203 ,群2:685261895群共享提供下载)
6.架构图：

输入图片说明 输入图片说明 输入图片说明 演示图：

输入图片说明 输入图片说明 输入图片说明 _20180525144528.jpg") 输入图片说明 输入图片说明 输入图片说明

7.模块功能介绍

1.会员管理 会员管理 会员等级 收货地址管理 会员优惠劵 会员收藏 会员足迹 搜索历史 购物车

2.微信管理 微信会员 会员列表 微信配置 菜单配置 回复消息 回复内容 回复关键字 群发列表 会员消息 群发消息 文本回复 新增群发消息 图文回复 模板编号 模板列表 模板发送记录

3.cms管理 栏目管理 链接分类 文章管理 链接管理 站点管理

4.商城管理 区域配置 商品属性种类 品牌制造商 商品规格 订单管理 商品类型 渠道管理 商品问答 反馈 关键词

5.商品管理 所有商品 用户评论 产品设置 商品满减搭配 商品规格 商品回收站 团购设置

6.推广管理 广告列表 广告位置 优惠劵管理 专题管理 专题分类

7.支付管理 支付管理

8.报表管理 综合统计

9.库存管理 仓库管理 入库管理 出库管理 退库单 报损管理 退货管理

10.销售管理 销售管理

11.营销管理 营销管理

12.系统管理 管理员列表 角色管理 菜单管理 SQL监控 定时任务 参数管理 代码生成器 系统日志 文件上传 通用字典表

暂无演示地址 后期增加

项目部门来源于网络，在基础上做了增加扩展，欢迎大家交流，拍砖，反馈，共同进步，共同学习，共同成长； 不足的地方望大家多多包涵，后期会越做越好。

警告 本项目仅用于学习练习 部分数据库数据来自网络 项目代码目前还不完善，仍处在开发中 项目开源（MIT），但不承担任何使用后果

qq官方群1:711281203, 群2:685261895 （如有问题，请联系，小天qq：2366207000） 感谢！

git：https://gitee.com/tiankong0310/my-shop.git

github:https://github.com/tiankong0310/my-shop

如需获取项目最新源码，请fork、Star项目，同时也是对项目最好的支持
