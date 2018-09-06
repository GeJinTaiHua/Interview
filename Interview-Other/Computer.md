## 💻计算机


  * [线程](#%E7%BA%BF%E7%A8%8B)
    * [进程、线程](#%E8%BF%9B%E7%A8%8B%E7%BA%BF%E7%A8%8B)
    * [线程同步的方法](#%E7%BA%BF%E7%A8%8B%E5%90%8C%E6%AD%A5%E7%9A%84%E6%96%B9%E6%B3%95)
  * [内存溢出和内存泄漏](#%E5%86%85%E5%AD%98%E6%BA%A2%E5%87%BA%E5%92%8C%E5%86%85%E5%AD%98%E6%B3%84%E6%BC%8F)


### 线程  
#### 进程、线程
![线程的所有状态](http://mmbiz.qpic.cn/mmbiz_png/Bf4u9qKuXWupl2hClEIRRTBPpWAic4GicZDMAFRRWUIU5qYOYY9Ds9NTrI8GdwGZkOjPkgGZa234kCT7050dDk3g/640?wx_fmt=png&wxfrom=5&wx_lazy=1)  
+ 进程与线程的区别：
  - 线程是进程的子集，一个进程可以有很多线程，每条线程并行执行不同的任务；
  - 不同的进程使用不同的内存空间，而所有的线程共享一片相同的内存空间；
  - 进程间通讯依靠IPC资源，例如管道（pipes）、套接字（sockets）等；
  - 线程间通讯依靠JVM提供的API，例如wait方法、notify方法和notifyAll方法，线程间还可以通过共享的主内存来进行值的传递。
+ [阻塞队列](//Interview-Java/src/test/java/Thread/ArrayBlockingQueueN.java)：用Lock和Condition实现一个阻塞队列。
+ [流量控制](/Interview-Java/src/test/java/Thread/SemaphoreTest.java):30个线程只允许10个同时：30个线程只允许10个同时存在。
  
#### 线程同步的方法
+ 方法
  + wait()：等待状态，释放所持有对象的lock；
  + sleep()：睡眠状态，静态方法；
  + notify()：唤醒一个等待状态的线程；
  + Allnotify()：唤醒所有等待状态的线程，竞争。
+ Java 中 Obj.wait() 与 Obj.notify() 必须要与 synchronized(Obj) 一起使用
  + wait就是说线程在获取对象锁后，主动释放对象锁，同时本线程休眠。直到有其它线程调用对象的notify()唤醒该线程，才能继续获取对象锁，并继续执行。相应的notify()就是对对象锁的唤醒操作；
  + notify()调用后，并不是马上就释放对象锁的，而是在相应的synchronized(){}语句块执行结束，自动释放锁后，JVM会在wait()对象锁的线程中随机选取一线程，赋予其对象锁，唤醒线程，继续执行。如果是notifyAll()就会释放所有的锁。

### 内存溢出和内存泄漏
+ 内存溢出（out of memory）：程序在申请内存时，没有足够的内存空间供其使用。
+ 内存泄漏（memory leak）：程序在申请内存后，无法释放已申请的内存空间。
 
 
