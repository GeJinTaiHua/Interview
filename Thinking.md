## 🎴编程思想

  * [面向过程](#面向过程)
  * [面向对象](#面向对象)
    * [四大基本特性](#四大基本特性)
    * [七大设计原则](#七大设计原则)
  * [23种设计模式](#23种设计模式)
    * [创建型模式](#%E5%88%9B%E5%BB%BA%E5%9E%8B%E6%A8%A1%E5%BC%8F)
    * [结构型模式](#%E7%BB%93%E6%9E%84%E5%9E%8B%E6%A8%A1%E5%BC%8F)
    * [行为型模式](#%E8%A1%8C%E4%B8%BA%E5%9E%8B%E6%A8%A1%E5%BC%8F)
  * [理论](#%E7%90%86%E8%AE%BA)
    * [CAP](#cap)
    * [ACID](#acid)
    * [BASE](#base)
    * [RESTful](#RESTful)
  * [其他](#其他)
    * [类之间的关系：继承、依赖、关联、聚合、组合](#%E7%B1%BB%E4%B9%8B%E9%97%B4%E7%9A%84%E5%85%B3%E7%B3%BB%E7%BB%A7%E6%89%BF%E4%BE%9D%E8%B5%96%E5%85%B3%E8%81%94%E8%81%9A%E5%90%88%E7%BB%84%E5%90%88)
    * [系统可用性](#%E7%B3%BB%E7%BB%9F%E5%8F%AF%E7%94%A8%E6%80%A7)
    * [中台](#%E4%B8%AD%E5%8F%B0)
    * [分布式一致性ID](#分布式一致性ID)
    * [微服务跨域](#微服务跨域)

### 面向过程    
    
### 面向对象
#### 四大基本特性
+ 抽象
+ 封装
+ 继承
+ 多态

#### 七大设计原则
1. 单一职责原则（SRP）
   + 单一功能
   + 解耦和增强内聚性（高内聚，低耦合）
   
2. 开闭原则（OCP）
   + 对扩展开放，对修改关闭
   
3. 里氏替换原则（LSP）
   + 在任何父类出现的地方都可以用他的子类来替代。
   + 子类可以有自己的个性。
   + 覆盖或实现父类的方法时输入参数可以被放大，输出结果可以被缩小。
   
4. 接口隔离原则（ISP）
   + 一个接口不需要提供太多的行为，一个接口应该只提供一种对外的功能，不应该把所有的操作都封装到一个接口当中。
   
5. 依赖倒置原则（DIP）
   + 高层模块不应该依赖低层模块，两者都应该依赖其抽象（抽象类或接口）。
   + 抽象不应该依赖细节（具体实现）。
   + 细节（具体实现）应该依赖抽象。
   
6. 合成复用原则（CRP）

7. 迪米特法则（最少知识原则）（LOD）
   + 一个对象应当对其他对象有尽可能少的了解。
   + 类间解耦，低耦合

### 23种设计模式
#### 创建型模式
1. 单例模式：保证一个类仅有一个实例，并提供一个访问它的全局访问点。
   + 一些单例写法：
     + [double check](/Interview-Java/src/test/java/Pattern/Singleton/SingletonDC.java)
     + [饿汉模式](/Interview-Java/src/test/java/Pattern/Singleton/SingletonHungry.java)
     + [静态内部类](/Interview-Java/src/test/java/Pattern/Singleton/SingletonIODH.java)
     + [枚举单例](/Interview-Java/src/test/java/Pattern/Singleton/SingletonEnum.java)
     + [CAS单例](/Interview-Java/src/test/java/Pattern/Singleton/SingletonCAS.java)
   + [容器管理单例](/Interview-Java/src/test/java/Pattern/Singleton/SingletonManager.java)
   + [破坏单例的2种方法](/Interview-Java/src/test/java/Pattern/DestroySingle.java#L19)
   + 使用场景：
     1. Spring 下默认的 bean 均为单利，提供一个全局访问点；
     2. Mybatis 中 ErrorContext 用在每个线程范围内的单例，用于记录该线程的执行环境错误信息；
     3. Mybatis 中 LogFactory 是提供给整个 Mybatis 使用的日志工厂，用于获得针对项目配置好的日志对象。
  
2. 工厂模式
   + 简单工厂模式：用来生产同一等级结构中的任意产品。
     + 优点：
       1. 屏蔽产品的具体实现，调用者只关心产品的接口；
       2. 实现简单。
     + 缺点：
       1. 增加产品，需要增加新的工厂类，导致系统类的个数成对增加，在一定程度上增加了系统的复杂性。
     + 使用场景：
       1. Spring 中的 BeanFactory，根据传入一个唯一的标识来获得 bean 对象；
       2. Mybatis 中的 SqlSessionFactory、ObjectFactory、MapperProxyFactory。
   ![简单工厂模式](/Pic/SimpleFactory.png)  
    
   + 工厂模式：用来生产同一等级结构中的固定产品。
     + 优点：
       1. 继承了简单工厂模式的优点；
       2. 符合开放-封闭原则。
     + 缺点：
       1. 增加产品，需要增加新的工厂类，导致系统类的个数成对增加，在一定程度上增加了系统的复杂性。 
   ![工厂模式](/Pic/Factory.png)
    
3. 抽象工厂模式：用来生产不同产品族的全部产品。
   + 优点：
     1. 隔离了具体类的生成，使得客户并不需要知道什么被创建；
     2. 每次可以通过具体工厂类创建一个产品族中的多个对象，增加或者替换产品族比较方便，增加新的具体工厂和产品族很方便。
   + 缺点：
     1. 增加新的产品等级结构很复杂，需要修改抽象工厂和所有的具体工厂类，对“开闭原则”的支持呈现倾斜性。
   ![抽象工厂模式](/Pic/AbstractFactory.png)

4. 建造者模式：使用多个简单的对象一步一步构建成一个复杂的对象。
   + 使用场景：
     1. JDK1.8 stream 的流水线理念；
     2. Mybatis 环境的初始化过程中，SqlSessionFactoryBuilder 会调用 XMLConfigBuilder 构建 Configuration 对象。
  
5. [原型模式](/Interview-Java/src/main/java/www/wjl/com/Interview/entity/ConcretePrototype.java)：用于创建重复的对象，同时又能保证性能。

#### 结构型模式
6. 适配器模式：作为两个不兼容的接口之间的桥梁。
   + 使用场景：
     + slf4j 与各种日志（log4j、logging）适配。

7. 装饰器模式：允许向一个现有的对象添加新的功能，同时又不改变其结构。

8. 代理模式
   + 静态代理
   + 动态代理
   + 使用场景：
     1. Spring 的 Aop，原理就是使用代理模式对类进行方法级别的切面增强。

9. 外观模式：隐藏系统的复杂性，并向客户端提供了一个客户端可以访问系统的接口。
   + 使用场景：
     1. Socket：把复杂的TCP/IP协议族隐藏在Socket接口后面，对用户来说，一组简单的接口就是全部，让Socket去组织数据，以符合指定的协议。

10. 桥接模式

11. 组合模式（整体模式）：把一组相似的对象当作一个单一的对象。
    + 创建了一个包含自己对象组的类。
    + 据树形结构来组合对象，用来表示部分以及整体层次。 
    + 使用场景：
      1. Mybatis 动态SQL中的 if、trim 等动态元素，根据条件来生成不同情况下的SQL，SqlSource、tSqlNode。
      ![](/Pic/SqlNode.jpg)

12. 享元模式

#### 行为型模式 
13. 策略模式
    + 使用场景：
      1. Java 的 Comparator 外部排序。
    
14. 模板方法模式
    + 使用场景：
      1. Spring 的 JdbcTemplate 数据库操作模板。

15. 观察者模式（发布—订阅模式）（事件监听模式）
    + 对象间存在一对多关系
    + 当一个对象被修改时，则会自动通知它的依赖对象。    
    + 使用场景：
      1. Spring 的监听事件 ApplicationListener 和 ApplicationEvent；
      2. Dubbo的customer启动时从注册中心订阅需要的服务，开启一个listener。注册中心会每5秒定时检查是否有服务更新。

16. 迭代子模式

17. 责任链模式：通常每个接收者都包含对另一个接收者的引用。如果一个对象不能处理该请求，那么它会把相同的请求传给下一个接收者，依此类推。
    + 使用场景：
      1. Servlet 中的 Filter；  
      ![](/Pic/ServletFilter.jpg)
      2. Dubbo 中 的 Filter；  
      ![](/Pic/DubboFilter.jpg)
      3. MyBatis  中 的 Plugin。  
      ![](/Pic/MybatisPlugin.jpg)

18. 命令模式

19. 备忘录模式

20. 状态模式：类的行为是基于它的状态改变的。

21. 访问者模式

22. 中介者模式

23. 解释器模式

### 理论
#### CAP
布鲁尔定理：对于一个分布式计算系统来说，不可能同时满足以下三点：
+ 一致性（Consistency)：所有节点在同一时间具有相同的数据；
+ 可用性（Availability）：保证每个请求不管成功或者失败都有响应；
+ 分隔容忍性（Partition tolerance）：系统中任意信息的丢失或失败不会影响系统的继续运作。

#### ACID 
指数据库管理系统（DBMS）在写入/异动资料的过程中，为保证交易（transaction）是正确可靠的，所必须具备的四个特性：
+ 原子性（Atomicity，或称不可分割性）
+ 一致性（Consistency）
+ 隔离性（Isolation，又称独立性）
+ 持久性（Durability）

#### BASE 
完全不同ACID模型，牺牲高一致性，获得可用性或可靠性：
+ 基本可用（Basically Available）：支持分区失败(e.g. sharding碎片划分数据库)；
+ 软状态（Soft state）：状态可以有一段时间不同步，异步；
+ 最终一致（Eventually consistent）：最终数据是一致的就可以了，而不是时时高一致。

#### RESTful
+ 资源：以json(或其他Representation)为载体的、面向用户的一组数据集。
+ URI：用一个URI（统一资源定位符）指向资源，即每个URI都对应一个特定的资源。
+ 统一接口：数据的元操作，分别对应于HTTP方法：
  + GET（SELECT）：从服务器取出资源（一项或多项）；
  + POST（CREATE）：在服务器新建一个资源；
  + PUT（UPDATE）：在服务器更新资源（客户端提供完整资源数据）；
  + PATCH（UPDATE）：在服务器更新资源（客户端提供需要修改的资源数据）；
  + DELETE（DELETE）：从服务器删除资源。
+ 无状态

### 其他
#### 类之间的关系：继承、依赖、关联、聚合、组合  
+ 继承（实现）：是一种【is-a】关系；
  + 优点：
    + 子类能自动继承父类的接口；
    + 创建子类的对象时，无须创建父类的对象。
  + 缺点：
    + 破坏封装，子类与父类之间紧密耦合，子类依赖于父类的实现，子类缺乏独立性；
    + 支持扩展，但是往往以增加系统结构的复杂度为代价；
    + 不支持动态继承。在运行时，子类无法选择不同的父类；
    + 子类不能改变父类的接口。
+ [依赖](/Interview-Java/src/main/java/www/wjl/com/Interview/entity/Me.java)：一个类A中的方法使用到了另一个类B；
+ [关联](/Interview-Java/src/main/java/www/wjl/com/Interview/entity/You.java)：两个类、或者类与接口之间语义级别的一种强依赖关系；
  + 被关联类B以类属性的形式出现在关联类A中，或者关联类A引用了一个类型为被关联类B的全局变量的这种关系。
+ [聚合](/Interview-Java/src/main/java/www/wjl/com/Interview/entity/Family.java)：关联关系的一种特例，他体现的是整体与部分、拥有的关系，即【has-a】的关系；
+ [组合](/Interview-Java/src/main/java/www/wjl/com/Interview/entity/Nose.java)：一种【contains-a】的关系，这种关系比聚合更强，也称为强聚合。
  + 优点：
    + 不破坏封装，整体类与局部类之间松耦合，彼此相对独立；
    + 具有较好的可扩展性；
    + 支持动态组合。在运行时，整体对象可以选择不同类型的局部对象；
    + 整体类可以对局部类进行包装，封装局部类的接口，提供新的接口。
  + 缺点：
    + 整体类不能自动获得和局部类同样的接口；
    + 创建整体类的对象时，需要创建所有局部类的对象。

#### 系统可用性
+ 重要指标：
  + MTTF：平均无故障时间。指系统无故障运行的平均时间，取所有从系统开始正常运行到发生故障之间的时间段的平均值。
  + MTTR：平均修复时间。指系统从发生故障到维修结束之间的时间段的平均值。
  + MTBF：平均失效间隔。指系统两次故障发生时间之间的时间段的平均值。  
```
MTBF = MTTF + MTTR
```
```
系统的可用性 = MTTF / MTBR * 100% = MTTF / ( MTTF + MTTR ) * 100%
```
+ 衡量指标：
  + SLA：意思是服务等级协议。

| 描述 | 通俗叫法 | 可用性级别 | 年度宕机时间 | 每天宕机时间 | |
|---|---|---|---|---|---| 
|可用|1个9|90%|36.5d|2.4h| | 
|基本可用性|2个9|99%|87.6h|14min| | 
|较高可用性|3个9|99.9%|8.76h|86s| | 
|具有故障自动回复能力|4个9|99.99%|52.6min|8.6s|淘宝、JD| 
|极高可用性|5个9|99.999%|5.25min|0.86s| | 

+ 可用性的保障：

|问题|典型案例|增大MTBF|减小MTTR| 
|---|---|---|---|
|程序配置bug|程序配置bug|提升研发、测试质量，灰度发布|监控报告、快速回滚|
|机器、机房故障|宕机、机房断电|硬件冗余、多机房|自动故障转移，切换到其他冗余机器、机房|
|突发流量|上游系统异常重试、外部攻击|上游调度防雪崩、流量配额、防攻击、防抓取|其他同容量不足|
|容量不足|主流程容量不足|容量归化、容量预警|限流、降级、熔断弱依赖、快速扩容|
|依赖服务器故障|依赖服务失败率高、超时严重|弱依赖降级解耦、强依赖递归使用前述方法可靠性|熔断弱依赖|

#### 中台
共享业务服务中心
+ SOA：面向服务的架构
+ ESB：企业服务总线
+ 分布式微服务
 
#### 分布式一致性ID
+ 要求：
  + 全局唯一性
  + 递增
  + 高可用高性能
  + 信息安全
+ 解决方案： 
  + UUID
    优点：性能非常高；本地生成，没有网络消耗；
    缺点：UUID太长，不易于存储；信息不安全。
  + [snowflake方案](https://github.com/GeJinTaiHua/Sum-Up-Up-Up/blob/master/Interview-DSAndA/Algorithm.md#%E9%9B%AA%E8%8A%B1%E7%AE%97%E6%B3%95)
  + 数据库生成
  + Leaf-segment数据库方案
  + Leaf-snowflake方案

#### 微服务跨域
+ 同源策略
  + 同源：指"协议+域名+端口"三者相同；
  + 限制内容：
    + Cookie、LocalStorage、IndexedDB 等存储性内容；
    + DOM 节点；
    + AJAX 请求发送后，结果被浏览器拦截了；
    ```
    允许跨域的标签：
    <img src=XXX>
    <link href=XXX>
    <script src=XXX>
    ```

+ 解决方法：
  1. jsonp：只支持 GET 请求，优势在于支持老式浏览器，以及可以向不支持 CORS 的网站请求数据。
  2. cors：支持所有类型的 HTTP 请求，是跨域 HTTP 请求的根本解决方案。
  3. postMessage
  4. websocket
  5. Node 中间件代理/nginx 反向代理：同源策略是浏览器需要遵循的标准，而如果是服务器向服务器请求就无需遵循同源策略。
  6. window.name/location.hash/document.domain + iframe

