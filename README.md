## 技术心得
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-1.5.13-brightgreen.svg)
![jQuery](https://img.shields.io/badge/jQuery-1.10.2-orange.svg)
![build passing](https://img.shields.io/badge/build-passing-brightgreen.svg)

### 语言
+ [Java](Interview-Java/Java.md)
+ [C#](Interview-.NET/NET.md)


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
+ 死锁
  + 互斥条件：一个资源每次只能被一个进程使用。
  + 请求与保持条件：一个进程因请求资源而阻塞时，对已获得的资源保持不放。
  + 不剥夺条件：进程已获得的资源，在末使用完之前，不能强行剥夺。
  + 循环等待条件：若干进程之间形成一种头尾相接的循环等待资源关系。

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

### 4.5 数据库
#### 事务
+ 原子性（atomicity）：
一个事务是一个不可分割的工作单位，事务中包括的诸操作要么都做，要么都不做。
+ 一致性（consistency）：
事务必须是使数据库从一个一致性状态变到另一个一致性状态。一致性与原子性是密切相关的。
+ 隔离性（isolation）：
一个事务的执行不能被其他事务干扰。即一个事务内部的操作及使用的数据对并发的其他事务是隔离的，并发执行的各个事务之间不能互相干扰。
+ 持久性（durability）：
也称永久性（permanence），指一个事务一旦提交，它对数据库中数据的改变就应该是永久性的。接下来的其他操作或故障不应该对其有任何影响。

#### 范式
+ 第一范式（1NF）：确保每一列的原子性
+ 第二范式：非键字段必须依赖于键字段
+ 第三范式：在1NF基础上，除了主键以外的其它列都不传递依赖于主键列，或者说任何非主属性不依赖于其它非主属性（在2NF基础上消除传递依赖）

#### 数据库垂直水平切分
+ 垂直拆分：把表按模块划分到不同数据库表中。
+ 水平拆分：把一个表按照某种规则（时间、用户...）把数据划分到不同表或数据库里。

### 4.6 线程  
![线程的所有状态](http://mmbiz.qpic.cn/mmbiz_png/Bf4u9qKuXWupl2hClEIRRTBPpWAic4GicZDMAFRRWUIU5qYOYY9Ds9NTrI8GdwGZkOjPkgGZa234kCT7050dDk3g/640?wx_fmt=png&wxfrom=5&wx_lazy=1)  
+ 进程与线程的区别：
  - 线程是进程的子集，一个进程可以有很多线程，每条线程并行执行不同的任务；
  - 不同的进程使用不同的内存空间，而所有的线程共享一片相同的内存空间；
  - 进程间通讯依靠IPC资源，例如管道（pipes）、套接字（sockets）等；
  - 线程间通讯依靠JVM提供的API，例如wait方法、notify方法和notifyAll方法，线程间还可以通过共享的主内存来进行值的传递。



