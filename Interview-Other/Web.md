## 🌏网络与并发

### OSI 七层和 TCP/IP 四层
<table>
    <tr>
        <td >OSI 七层网络模型</td> 
        <td >TCP/IP 四层概念模型</td> 
        <td >对应网络协议</td> 
    </tr>
    <tr>
        <td >应用层（Application）</td>    
        <td rowspan="3">应用层</td>  
        <td >HTTP、TFTP, FTP, NFS, WAIS、SMTP</td>      
    </tr>
    <tr>
        <td >表示层（Presentation</td>    
        <td >Telnet, Rlogin, SNMP, Gopher</td>      
    </tr>
    <tr>
        <td >会话层（Session）</td>    
        <td >SMTP, DNS</td>      
    </tr>
    <tr>
        <td >传输层（Transport）</td> 
        <td >传输层</td> 
        <td >TCP, UDP</td> 
    </tr>
    <tr>
        <td >网络层（Network）</td> 
        <td >网络层</td> 
        <td >IP, ICMP, ARP, RARP, AKP, UUCP</td> 
    </tr>
    <tr>
        <td >数据链路层（Data Link）</td> 
        <td rowspan="2">数据链路层</td> 
        <td >FDDI, Ethernet, Arpanet, PDN, SLIP, PPP/td> 
    </tr>
    <tr>
        <td >物理层（Physical）</td> 
        <td >IEEE 802.1A, IEEE 802.2到IEEE 802.11</td> 
    </tr>
</table>

### TCP 三次握手和四次挥手
+ 三次握手:   
![三次握手](https://images2017.cnblogs.com/blog/985821/201708/985821-20170802101806802-1497343688.png)  
  - 第一次握手：A的TCP客户进程也是首先创建传输控制块TCB，然后向B发出连接请求报文段，（首部的同步位SYN=1，初始序号seq=x），（SYN=1的报文段不能携带数据）但要消耗掉一个序号，此时TCP客户进程进入SYN-SENT（同步已发送）状态;
  - 第二次握手：B收到连接请求报文段后，如同意建立连接，则向A发送确认，在确认报文段中（SYN=1，ACK=1，确认号ack=x+1，初始序号seq=y），测试TCP服务器进程进入SYN-RCVD（同步收到）状态；
  - 第三次握手：TCP客户进程收到B的确认后，要向B给出确认报文段（ACK=1，确认号ack=y+1，序号seq=x+1）（初始为seq=x，第二个报文段所以要+1），ACK报文段可以携带数据，不携带数据则不消耗序号。TCP连接已经建立，A进入ESTABLISHED（已建立连接）;当B收到A的确认后，也进入ESTABLISHED状态。
  - 为什么A还要发送一次确认呢：主要为了防止已失效的连接请求报文段突然又传送到了B，因而产生错误。

+ 四次挥手:  
![四次挥手](https://images2017.cnblogs.com/blog/985821/201708/985821-20170802101823505-1177747613.png)  
  - 第一次握手：A的应用进程先向其TCP发出连接释放报文段（FIN=1，序号seq=u），并停止再发送数据，主动关闭TCP连接，进入FIN-WAIT-1（终止等待1）状态，等待B的确认；
  - 第二次握手：B收到连接释放报文段后即发出确认报文段，（ACK=1，确认号ack=u+1，序号seq=v），B进入CLOSE-WAIT（关闭等待）状态，此时的TCP处于半关闭状态，A到B的连接释放；A收到B的确认后，进入FIN-WAIT-2（终止等待2）状态，等待B发出的连接释放报文段
  - 第三次握手：B没有要向A发出的数据，B发出连接释放报文段（FIN=1，ACK=1，序号seq=w，确认号ack=u+1），B进入LAST-ACK（最后确认）状态，等待A的确认；
  - 第四次握手：A收到B的连接释放报文段后，对此发出确认报文段（ACK=1，seq=u+1，ack=w+1），A进入TIME-WAIT（时间等待）状态。此时TCP未释放掉，需要经过时间等待计时器设置的时间2MSL后，A才进入CLOSED状态。
  - 为什么A在TIME-WAIT状态必须等待2MSL的时间：保证A发送的最后一个ACK报文段能够到达；防止“已失效的连接请求报文段”出现在本连接中。
  
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
  
  
