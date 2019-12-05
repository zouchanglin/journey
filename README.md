# 一、关于本项目

这是一个支持Markdown写作的博客系统，由于用了一段时间的solo博客系统，所以决定自己也写一个更方便好用的系统，下面说说主要功能：

* 文章管理：文章增删改查、其中加入了回收站和草稿箱的设计、支持自动备份(@)

* 评论系统：支持匿名评论、评论回复、评论管理

* 分类和标签管理：分类和标签的增删改查都支持、分类信息可注释

* Markdown文件存储：文章中的文件、图片资源等既可以通过服务器本地保存，也可以设置七牛云等第三方云存储、并且可以直接可视化管理

# 二、如何使用

* 新建数据库journey，字符编码为UTF-8，校验规则 utf8_general_ci
* 执行journey.sql ，这会导入必要的配置项和表信息
* 安装 ElasticSearch ，具体安装方式后面完善
* 获取到源码后直接使用 `mvn package -Dmaven.test.skip=true`  打包即可
* 最后一步：`java -jar journey-0.0.1-SNAPSHOT.jar ` 即可，访问 localhost:8080 



# 二、表关系设计

![](https://s2.ax1x.com/2019/11/28/QFQuLD.png)

# 三、技术架构

使用SpringBoot作为基础架构

使用Thymeleaf 模板引擎实现的后端管理，集成了一些 BootStrap 组件

使用Freemarker 模板引擎实现的前端展示页面，其中移植了nexmoe这款hexo的皮肤

数据库使用 MySQL8.0 

数据库框架使用MyBatis 和 SpringDataJPA ，看实际情况而定

搜索引擎使用 ElasticSearch 实现全文检索

