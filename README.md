# 知识小抄集
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-1.5.13-brightgreen.svg)
![jQuery](https://img.shields.io/badge/jQuery-1.10.2-orange.svg)
![build passing](https://img.shields.io/badge/build-passing-brightgreen.svg)

[TOC]



## 一、Java
### 1.1 目录
+ /Interview-Java/src/test/java 
+ /Interview-Java/src/main/java/www/wjl/com/Interview

### 1.2 基础问题
[10 个有关 String 的面试问题](https://mp.weixin.qq.com/s/uaytl6QKKTqLitvXxlcU2g)

[面试的角度诠释 Java工程师（1）](https://mp.weixin.qq.com/s?__biz=MjM5NzMyMjAwMA==&mid=2651479600&idx=1&sn=7f310d3fe836232e72491e595ffbaa1f&chksm=bd25324f8a52bb59863fa0c133e6d381def118bed4d820ef523afb12ec62bac8d508202da214&mpshare=1&scene=1&srcid=061265cmoVaAepudXykwsdN6#rd)

[面试的角度诠释 Java工程师（2）](https://mp.weixin.qq.com/s?__biz=MjM5NzMyMjAwMA==&mid=2651479604&idx=1&sn=2a4d352795d60297e236dc4d06b59a04&chksm=bd25324b8a52bb5d87856ceb2dc0e5338ab37c24da9f30297435f001ef43f1c49efc570e8606&mpshare=1&scene=1&srcid=0612FgwBictVHwxAhjHOc4ec#rd)

[2017秋，阿里、京东、美团、滴滴面试案](https://mp.weixin.qq.com/s/BGo3RY6JLFeg87hH3Y60KA)

### 1.3 集合
[30个Java集合面试问题及答案](https://mp.weixin.qq.com/s?__biz=MzAwNDE2NTgzNQ==&mid=2247484485&idx=1&sn=e25d097893b232403d74b2110e5b1fab&chksm=9b315de1ac46d4f72b703b2c85e57019b481bdcc59dc53447a27909d7b8f70f0ed1ee4854159&mpshare=1&scene=23&srcid=0608pXE8NxhkbmuVbGvu5Qpd#rd)

[Java 集合框架面试问题集锦](https://mp.weixin.qq.com/s?__biz=MjM5NzMyMjAwMA==&mid=2651480544&idx=1&sn=7b853579f783bf6d4ade4a79ca2dee6c&chksm=bd250d9f8a5284898ba1ba298e4367956ba6c7a15c01597ae70c56f30b1e72982d7a7d764c73&mpshare=1&scene=1&srcid=0612q9YIyiWAjSrjP6mEZ2A9#rd)

![集合](http://img.blog.csdn.net/20160706172512559?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQv/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/Center)

### 1.4 JVM 类加载机制
![类加载](http://incdn1.b0.upaiyun.com/2017/06/2fb054008ca2898e0a17f7d79ce525a1.png)
#### 1）加载
在加载阶段，虚拟机主要完成以下3件事：
1. 通过一个类的全限定名来获取定义此类的二进制字节流；
2. 将这个字节流所代表的静态存储结构转化为方法区的运行时数据结构；
3. 在内存中生成一个代表这个类的java.lang.Class对象，作为方法区这个类的各种数据访问入口。

#### 2）验证
+ 文件格式验证：验证字节流是否符合Class文件格式的规范，并且能被当前版本的虚拟机处理；
+ 元数据验证：对字节码描述的信息进行语义分析，以保证其描述的信息符合Java语言的规范的要求；
+ 字节码验证：通过数据流和控制流分析，确定程序语法是否是合法的，符合逻辑的；
+ 符号引用验证：对类自身以外的信息进行匹配性校验。

#### 3）准备
正式为[类变量]分配内存并设置变量初始值的阶段，这些变量所使用的内存都将在方法区中进行分配，记住，只为类变量分配内存，不包括实例变量，实例变量将会在对象实例化时随对象一起分配在java堆中。

如果类字段的字段属性表中存在ConstantValue属性，那么在准备阶段变量value就会被初始化为ConstantValue属性所指定的值。

#### 4）解析
虚拟机将常量池内的符号引用替换为直接引用的过程。

#### 5）初始化

#### 类加载器
+ 启动类加载器（Bootstrap ClassLoader）
+ 扩展类加载器（Extension ClassLoader）
+ 应用程序类加载器（Application ClassLoader）：一般情况下这个是程序默认的类加载器



## 二、.Net
### 2.1 目录
+ /Interview-.NET/Subject/ 
+ /Interview-.NET/NETSubject/Controllers

### 2.2 基础问题



## 三、HTML、CSS、javascript
### 3.1 目录
+ /Interview-.NET/NETSubject/Views

### 3.2 基础问题



## 四、其他
### 4.1 目录
+ /Interview-.NET/Subject/设计模式/

### 4.2 基础问题
[20个设计模式和软件设计面试问题](https://mp.weixin.qq.com/s?__biz=MjM5NzMyMjAwMA==&mid=2651479456&idx=1&sn=0f9d07bd3aa5a53aaa6d61b87125a31a&chksm=bd2531df8a52b8c9ec0aef2fb318e53f81027c2871511f0f474737bc81d10b7fdc90d339c3c2&mpshare=1&scene=1&srcid=0612kHCAY5DNOO2NI9emkMuw#rd)

[面试常见其他问题](https://mp.weixin.qq.com/s/dc6z7G7ej0m5dCc80r1Rlw)

### 4.3 常见锁
+ 互斥锁（Mutex）
  - 同步块 synchronized block
  - 对象锁 object.lock()
  - 可重入锁（递归锁）
+ 信号量（Semaphore）
+ 乐观锁（CAS）：
假设不会发生并发冲突，只在提交操作时检查是否违反数据完整性。能解决脏读的问题（适合读取操较频繁的场景）。
+ 悲观锁：
假定会发生并发冲突，屏蔽一切可能违反数据完整性的操作（适合写入操作频繁的场景）。
+ 分布式锁：用来协调多个进程下的所有线程多共享资源的同步访问。
  + 基于数据库实现分布式锁：锁表、数据库排他锁
  + 基于缓存实现分布式锁：Redis、memcached
  + 基于Zookeeper实现分布式锁

### 4.4 常用设计模式
+ 单例模式：保证一个类仅有一个实例，并提供一个访问它的全局访问点。
```
public class SingletonClass{
    private static SingletonClass instance=null;
    public static SingletonClass getInstance(){
        if(instance==null){
            synchronized(SingletonClass.class){
                if(instance==null){
                    instance=new SingletonClass();
                }
            }
        }
        return instance;
    }
}
```
+ 工厂模式

![工厂模式](https://raw.githubusercontent.com/aalansehaiyang/technology-talk/master/basic-knowledge/img/10.jpg)

+ 装饰模式：在保持原有功能不变的情况下将一个类重新装饰，使其具有更强大的功能。

+ 适配器模式：一个类的接口不能被客户端接受，需要转换为另一种接口，从而使两个不匹配的接口能在一起工作。

![适配器模式](https://raw.githubusercontent.com/aalansehaiyang/technology-talk/master/basic-knowledge/img/5.png)

+ 观察者模式：也叫发布—订阅模式，或者事件监听模式。

+ 责任链模式：很多对象由每个对象对其下家的引用串连起来形成一条链，请求在这条链上传递，直到最终处理完。

+ 策略模式：完成某个操作可能会有多种方法，适用于多种场合。我们需要把每个操作方法当做一个实现策略，调用者可根据需要（特定的规则）选择合适的策略。

+ 模板模式：在框架设计中，提供了一个方便的开发程序的模板，你只要实现模板中的一些接口或方法就能完成一个复杂的任务。

+ 代理模式：为其它对象提供一种代理以控制对这个对象的访问。

+ RBAC：基于角色的权限访问控制。

### 4.5 事务
+ 原子性（atomicity）

一个事务是一个不可分割的工作单位，事务中包括的诸操作要么都做，要么都不做。
+ 一致性（consistency）

事务必须是使数据库从一个一致性状态变到另一个一致性状态。一致性与原子性是密切相关的。
+ 隔离性（isolation）

一个事务的执行不能被其他事务干扰。即一个事务内部的操作及使用的数据对并发的其他事务是隔离的，并发执行的各个事务之间不能互相干扰。
+ 持久性（durability）

持久性也称永久性（permanence），指一个事务一旦提交，它对数据库中数据的改变就应该是永久性的。接下来的其他操作或故障不应该对其有任何影响。

### 4.6 死锁
+ 互斥条件：一个资源每次只能被一个进程使用。
+ 请求与保持条件：一个进程因请求资源而阻塞时，对已获得的资源保持不放。
+ 不剥夺条件：进程已获得的资源，在末使用完之前，不能强行剥夺。
+ 循环等待条件：若干进程之间形成一种头尾相接的循环等待资源关系。

### 4.7 线程
+ 进程与线程的区别：
  - 线程是进程的子集，一个进程可以有很多线程，每条线程并行执行不同的任务；
  - 不同的进程使用不同的内存空间，而所有的线程共享一片相同的内存空间；
  - 进程间通讯依靠IPC资源，例如管道（pipes）、套接字（sockets）等；
  - 线程间通讯依靠JVM提供的API，例如wait方法、notify方法和notifyAll方法，线程间还可以通过共享的主内存来进行值的传递。

![线程的所有状态](http://mmbiz.qpic.cn/mmbiz_png/Bf4u9qKuXWupl2hClEIRRTBPpWAic4GicZDMAFRRWUIU5qYOYY9Ds9NTrI8GdwGZkOjPkgGZa234kCT7050dDk3g/640?wx_fmt=png&wxfrom=5&wx_lazy=1)

