## ☕️Java
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-1.5.13-brightgreen.svg)
![build passing](https://img.shields.io/badge/build-passing-brightgreen.svg) 


  * [三大框架](#%E4%B8%89%E5%A4%A7%E6%A1%86%E6%9E%B6)
  * [常用工具](#%E5%B8%B8%E7%94%A8%E5%B7%A5%E5%85%B7)
  * [推荐书籍](#%E6%8E%A8%E8%8D%90%E4%B9%A6%E7%B1%8D)
  * [基础知识](#%E5%9F%BA%E7%A1%80%E7%9F%A5%E8%AF%86)
    * [8个基本类型](#8%E4%B8%AA%E5%9F%BA%E6%9C%AC%E7%B1%BB%E5%9E%8B)
    * [static](#static)
    * [集合](#%E9%9B%86%E5%90%88)
  * [IO 与 NIO](#io-%E4%B8%8E-nio)
  * [JVM](#jvm)
    * [JVM 类加载机制](#jvm-%E7%B1%BB%E5%8A%A0%E8%BD%BD%E6%9C%BA%E5%88%B6)
    * [JVM 内存模型](#jvm-%E5%86%85%E5%AD%98%E6%A8%A1%E5%9E%8B)
    * [JVM 新生代、老年代](#jvm-%E6%96%B0%E7%94%9F%E4%BB%A3%E8%80%81%E5%B9%B4%E4%BB%A3)


### 三大框架
+ [☕️Spring](https://github.com/GeJinTaiHua/Learn-Spring)
  - 依赖注入（DI）又称为控制反转（IOC）
  - 面向切片编程（AOP）是面向对象编程（OOP）的延续
  - [☕️Spring Boot](https://github.com/GeJinTaiHua/Learn-SpringBoot)
  - [☕️Spring Boot 2.0](https://github.com/GeJinTaiHua/Learn-SpringBoot2.0)
  - [☕️Spring Cloud](https://github.com/GeJinTaiHua/Learn-SpringCloud)
+ Struts
  - 模型（M）
  - 视图（V）
  - 控制器（C）
+ [☕️Hibernate](https://github.com/GeJinTaiHua/Learn-Hibernate)
  - ORM（对象关系映射）
  
### 常用工具
+ [♻️JAXB](https://github.com/GeJinTaiHua/JAXB)：XML 节点元素和 JavaBean 相互转换工具。
+ [♻️Gson](https://github.com/GeJinTaiHua/Gson)：Josn 序列化与反序列化工具。
+ [📆SLF4J](https://github.com/GeJinTaiHua/SLF4J)：日志工具。
+ [👫STOMP](https://github.com/GeJinTaiHua/STOMP)：面向消息的简单文本协议。
+ [☁️REST](https://github.com/GeJinTaiHua/HTTP)：HTTP 协议的 GET，POST，DELETE ...

### 推荐书籍
+ [📖《Head First Java》](https://github.com/GeJinTaiHua/HeadFirstJava)
+ 《java核心技术卷》系列
+ 《Effective Java》
+ 《Java编程思想》
+ ... ...

### 基础知识
#### 8大基本类型
基本类型|包装类|位数|  |
---|---|---|---|
boolean|Boolean|1|布尔型|
byte|Byte|8|整数值型|
char|Character|16|字符型|
short|Short|16|整数值型|
int|Integer|32|整数值型|
float|Float|32|浮点类型|
long|Long|64|整数值型|
double|Double|64|浮点类型|
+ String：引用类型，final，字符串常量。

#### static
+ 静态方法
  + 不依赖于任何对象就可以进行访问。
  + 在静态方法中不能访问类的非静态成员方法/变量。
  + 在非静态成员方法中可以访问静态成员方法/变量。
+ 静态变量
  + 被所有的对象所共享，在内存中只有一个副本。
  + 当且仅当在类初次加载时会被初始化。
+ 静态代码块
  + 优化程序性能。
  + 可以置于类中的任何地方，可以有多个static块。
  + 类初次被加载的时候，会按照static块的顺序来执行每个static块，并且只会执行一次。
```
class Person{
    private Date birthDate;
    private static Date startDate,endDate;
    static{
        startDate = Date.valueOf("1946");
        endDate = Date.valueOf("1964");
    }
     
    public Person(Date birthDate) {
        this.birthDate = birthDate;
    }
     
    boolean isBornBoomer() {
        return birthDate.compareTo(startDate)>=0 && birthDate.compareTo(endDate) < 0;
    }
}
```
+ 静态导包
  + import static 代替 import。
  + 导入这个类里的静态方法。

#### java.util包
+ Comparator：比较接口
+ Iterator：迭代接口
+ AbstractXXX：骨架类，核心代码实现
+ 集合、数组
![](https://img-blog.csdn.net/20170227215859844?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvejU1ODg3/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

#### 集合
+ [Collection](/Interview-Java/src/test/java/基本数据类型/Collection.java)
  - Set
  - List
+ [Map](/Interview-Java/src/test/java/基本数据类型/Map.java)
  - HashMap
    + 非线程安全
    + 链表散列
  - Hashtable
    + 线程安全
    + 遗留类，多线程建议 ConcurrentHashMap
  - SortedMap  
    + TreeMap：有序
![集合](http://img.blog.csdn.net/20160706172512559?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQv/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/Center)

+ fail-fast（快速失败）
  + 当你在迭代一个集合的时候，如果有另一个线程正在修改你正在访问的那个集合时，就会抛出一个 ConcurrentModification 异常。
  + 在 java.util 包下的都是快速失败。
+ fail-safe（安全失败）
  + 你在迭代的时候会去底层集合做一个拷贝，所以你在修改上层集合的时候是不会受影响的，不会抛出 ConcurrentModification 异常。
  + 在 java.util.concurrent 包下的全是安全失败的。

### IO 与 NIO
+ 管道（Channel）：实际上就像传统IO中的流，到任何目的地(或来自任何地方)的所有数据都必须通过一个 Channel 对象。一个 Buffer 实质上是一个容器对象。
+ 选择器（Selector）：用于监听多个管道的事件，使用传统的阻塞IO时我们可以方便的知道什么时候可以进行读写，而使用非阻塞通道，我们需要一些方法来知道什么时候通道准备好了，选择器正是为这个需要而诞生的。

IO|NIO
---|---
面向流|面向缓冲
阻塞IO|非阻塞IO
无|选择器

+ 推荐 IO
  + 少量的连接。
  + 连接每次要发送大量的数据。
+ 推荐 NIO
  + 大量的连接。
  + 连接每次发送少量的数据。
  + 聊天服务器。
  
### JVM
#### JVM 类加载机制
![类加载](http://incdn1.b0.upaiyun.com/2017/06/2fb054008ca2898e0a17f7d79ce525a1.png)
+ 加载阶段
  1) 通过一个类的全限定名来获取定义此类的二进制字节流；
  2) 将这个字节流所代表的静态存储结构转化为方法区的运行时数据结构；
  2) 在内存中生成一个代表这个类的 java.lang.Class 对象，作为方法区这个类的各种数据访问入口。
  + 类加载器
    - 启动类加载器（Bootstrap ClassLoader）
    - 扩展类加载器（Extension ClassLoader）
    - 应用程序类加载器（Application ClassLoader）：程序默认的类加载器
+ 验证阶段 
  - 文件格式验证：验证字节流是否符合Class文件格式的规范，并且能被当前版本的虚拟机处理。
  - 元数据验证：对字节码描述的信息进行语义分析，以保证其描述的信息符合Java语言的规范的要求。
  - 字节码验证：通过数据流和控制流分析，确定程序语法是否是合法的，符合逻辑的。
  - 符号引用验证：对类自身以外的信息进行匹配性校验。
+ 准备阶段：正式为[类变量]分配内存并设置变量初始值的阶段，这些变量所使用的内存都将在方法区中进行分配，记住，只为类变量分配内存，不包括实例变量，实例变量将会在对象实例化时随对象一起分配在java堆中。如果类字段的字段属性表中存在ConstantValue属性，那么在准备阶段变量value就会被初始化为 ConstantValue 属性所指定的值。
+ 解析阶段：虚拟机将常量池内的符号引用替换为直接引用的过程。
+ 初始化阶段
+ 类的实例化顺序
  1) 父类静态变量
  1) 父类静态代码块
  2) 子类静态变量
  2) 子类静态代码块
  3) 父类非静态变量
  3) 父类构造函数
  4) 子类非静态变量
  4) 子类构造函数

#### JVM 内存模型
![JVM 内存模型](https://images2017.cnblogs.com/blog/720994/201711/720994-20171111163050263-549527776.png)
+ 方法区：用于存储已被虚拟机加载的类信息、常量、静态变量、即时编译器编译后的代码等数据（JDK1.8 元数据区取代了永久代）。
  - 运行时常量池：存放编译期生成的各种字面量和符号引用。
+ 虚拟机栈：为虚拟机执行 Java 方法（也就是字节码）服务。
+ 本地方法栈：为虚拟机使用到的 Native 方法服务。
+ 堆：用来存放对象实例。
+ 程序计数器：这里记录了线程执行的字节码的行号，在分支、循环、跳转、异常、线程恢复等都依赖这个计数器。

#### JVM 新生代、老年代
![新生代、老年代](http://images0.cnblogs.com/blog/587773/201409/061921034534396.png)
+ 新生代：
  - 存活时间较短，因此基于**复制算法**来进行回收。
  - 划分为三个区域：Eden、From Survivor、To Survivor。
  - Minor GC
+ 老年代：
  - 对象存活的时间比较长，比较稳定，因此采用**标记（Mark）算法**来进行回收。
  - Full GC




