# 管家婆记账软件
## 一、项目功能
### 1、查询账务
### 2、多条件组合查询账务
### 3、添加账务
### 4、编辑账务
### 5、删除账务
## 二、项目环境搭建
### 1、技术选型和jar包
    （1）commons-dbutils-1.4.jar:封装并简化了JDBC
    （2）commons-dbcp-1.4.jar:数据库连接池组件
    （3）commons-pool-1.3.jar:DBCP连接池依赖该jar包
### 2、工具类
     JDBCUtils：用来创建数据库连接池对象
## 三、项目的分层设计
### 1、view层
     视图层，项目中的界面
### 2、controller层
     控制层，获取界面上的数据，为界面设置数据；将要实现的功能交给业务层处理
### 3、service层
     业务层，功能的实现，与controller层和DAO层交互，将对数据库的操作交给DAO数据访问层来处理
### 4、DAO层
     数据访问层，用来操作数据库表的数据
## 四、工程创建及包管理
### 1、使用Eclipse创建Java工程
### 2、创建工程包
    cn.itcast.gjp.app:存放main方法类
    cn.itcast.gjp.domain:存放JavaBean
    cn.itcast.gjp.view:存放界面及表现层类
    cn.itcast.gjp.service:存放业务层类
    cn.itcast.gjp.dao:存放数据访问层类
    cn.itcast.gjp.tools:存放工具类