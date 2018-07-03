## [📚技术心得](README.md)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-1.5.13-brightgreen.svg)
![build passing](https://img.shields.io/badge/build-passing-brightgreen.svg)

### 语言
+ [☕️Java](Interview-Java/Java.md)
+ [🆚C#](Interview-.NET/NET.md)
+ [📄HTML5](Interview-HTML5/HTML5.md)
### [💾数据库](Interview-DataBase/DataBase.md)

### [✒️设计模式](Interview-DesignPattern/DesignPattern.md)

### 常见锁
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

### 线程  
![线程的所有状态](http://mmbiz.qpic.cn/mmbiz_png/Bf4u9qKuXWupl2hClEIRRTBPpWAic4GicZDMAFRRWUIU5qYOYY9Ds9NTrI8GdwGZkOjPkgGZa234kCT7050dDk3g/640?wx_fmt=png&wxfrom=5&wx_lazy=1)  
+ 进程与线程的区别：
  - 线程是进程的子集，一个进程可以有很多线程，每条线程并行执行不同的任务；
  - 不同的进程使用不同的内存空间，而所有的线程共享一片相同的内存空间；
  - 进程间通讯依靠IPC资源，例如管道（pipes）、套接字（sockets）等；
  - 线程间通讯依靠JVM提供的API，例如wait方法、notify方法和notifyAll方法，线程间还可以通过共享的主内存来进行值的传递。



