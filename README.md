## ShoppingCartAPI
本项目实现了购物车API的基础功能，主要有以下几个特点：
- 用MVC架构分类并分层实现了购物车功能，采用Maven包管理代码
- 用SpringBoot实现RESTful路由的增删改查及Session管理，结合Postman发送HTTP请求测试
- 用DAO设计模式抽象出数据处理方法，并采用依赖注入模式实现
- 用ORM实现了购物车服务端数据的MySQL访问和存储

### 结构
横向上，主要分为5个模块：User, Product, Cart, Order, Session，分别对应用户、产品、购物车、订单、登录会话的功能实现

纵向上，采用MVC架构的设计模式，将每个模块的代码根据功能按Model, View, Controller分块，使得代码逻辑更加清晰，便于维护

### 功能
用SpringBoot实现了RESTful路由的增删改查，Hibernate等ORM框架简化了数据库JDBC的相关代码编写，然后用DAO类抽象出数据处理方法，注入Controller实现各个模块的增删改查。此外，Session模块用Cookie来维持客户端与服务端的会话