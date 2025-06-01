# LoveAdoption 宠物领养平台

![Java](https://img.shields.io/badge/Java-17-blue)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.2.5-brightgreen)
![MySQL](https://img.shields.io/badge/MySQL-8.0-lightblue)

## 项目简介

LoveAdoption是一个基于Spring Boot的宠物领养平台后端系统，提供完整的宠物领养业务流程管理，包括：
- 用户注册/登录(JWT认证)
- 宠物信息管理
- 领养申请流程
- 管理员审核功能
- 文件上传(阿里云OSS)

## 技术栈

### 核心框架
- Spring Boot 3.2.5
- MyBatis + PageHelper分页
- Lombok

### 安全认证
- JWT令牌认证
- 基于角色的权限控制

### 数据库
- MySQL 8.0
- 软删除设计

### 其他组件
- 阿里云OSS文件存储
- Knife4j API文档
- Swagger 3.0

## 功能模块

### 用户模块
- 注册/登录/登出
- 用户信息管理
- 账号冻结/解冻

### 宠物模块
- 宠物信息CRUD
- 宠物状态管理(未领养/已领养/已删除)
- 多条件分页查询

### 申请模块
- 提交领养申请
- 申请状态管理(待审核/通过/拒绝/已撤回)
- 管理员审核功能

### 管理员模块
- 用户管理
- 申请审核
- 系统监控

## 数据库设计

主要数据表：
- `user` - 用户信息表
- `animal` - 宠物信息表
- `application` - 领养申请表

## 快速开始

### 环境要求
- JDK 17
- MySQL 8.0+
- Maven 3.6+

### 配置步骤
1. 克隆项目：
```bash
git clone https://github.com/your-repo/LoveAdoption.git
```
### 修改配置

编辑 `src/main/resources/application.yaml`:

```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/LoveAdoption
    username: your_username
    password: your_password
la:
  alioss:
    endpoint: your_oss_endpoint
    access-key-id: your_access_key
    access-key-secret: your_secret_key
    bucket-name: your_bucket_name
```

连接自己的数据库：
```yaml
spring:
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://localhost:3306/LoveAdoption?useSSL=false&serverTimezone=UTC&characterEncoding=utf8
    username: your_username
    password: your_password
```

### 添加数据库表
找到项目根目录里的SQL文件夹，执行里面的SQL脚本，创建数据库表。
里面还有两个测试数据

### 启动项目
```bash
mvn spring-boot:run
```

## 项目结构
```agsl
src/
├── main/
│   ├── java/
│   │   └── com/KevinCx/
│   │       ├── config/        # 配置类
│   │       ├── controller/    # 控制器
│   │       ├── domain/        # 领域模型
│   │       ├── interceptor/   # 拦截器
│   │       ├── mapper/        # MyBatis映射
│   │       ├── properties/    # 配置属性
│   │       ├── service/       # 服务层
│   │       └── utils/         # 工具类
│   └── resources/
│       ├── mapper/            # MyBatis XML
│       ├── SQL/               # SQL脚本
│       └── application.yaml   # 应用配置
└── test/                      # 测试代码
```
