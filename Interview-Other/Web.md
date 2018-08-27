## 🌏网络并发


  * [常见锁](#%E5%B8%B8%E8%A7%81%E9%94%81)
    * [互斥锁（Mutex）](#%E4%BA%92%E6%96%A5%E9%94%81mutex)
    * [乐观锁、悲观锁](#%E4%B9%90%E8%A7%82%E9%94%81%E6%82%B2%E8%A7%82%E9%94%81)
    * [分布式锁](#%E5%88%86%E5%B8%83%E5%BC%8F%E9%94%81)
    * [死锁、活锁](#%E6%AD%BB%E9%94%81%E6%B4%BB%E9%94%81)
  * [线程](#%E7%BA%BF%E7%A8%8B)
    * [进程、线程](#%E8%BF%9B%E7%A8%8B%E7%BA%BF%E7%A8%8B)
    * [线程同步的方法](#%E7%BA%BF%E7%A8%8B%E5%90%8C%E6%AD%A5%E7%9A%84%E6%96%B9%E6%B3%95)
  * [网路](#%E7%BD%91%E8%B7%AF)
    * [OSI 七层和 TCP/IP 四层](#osi-%E4%B8%83%E5%B1%82%E5%92%8C-tcpip-%E5%9B%9B%E5%B1%82)
    * [TCP 三次握手和四次挥手](#tcp-%E4%B8%89%E6%AC%A1%E6%8F%A1%E6%89%8B%E5%92%8C%E5%9B%9B%E6%AC%A1%E6%8C%A5%E6%89%8B)
    * [GET、POST](#getpost)
  * [分布式 session](#%E5%88%86%E5%B8%83%E5%BC%8F-session)
  
  
### 常见锁
#### 互斥锁（Mutex）
- 同步块 synchronized block
- 对象锁 object.lock()
- 可重入锁（递归锁）

#### 乐观锁、悲观锁
+ 乐观锁（CAS）：假设不会发生并发冲突，只在提交操作时检查是否违反数据完整性。能解决脏读的问题（适合读取操较频繁的场景）。
+ 悲观锁：假定会发生并发冲突，屏蔽一切可能违反数据完整性的操作（适合写入操作频繁的场景）。

#### 分布式锁
用来协调多个进程下的所有线程多共享资源的同步访问。
+ 基于数据库实现分布式锁：锁表、数据库排他锁
+ 基于缓存实现分布式锁：Redis、memcached
+ 基于Zookeeper实现分布式锁
  
#### 死锁、活锁
+ 死锁
  + 互斥条件：一个资源每次只能被一个进程使用。
  + 请求与保持条件：一个进程因请求资源而阻塞时，对已获得的资源保持不放。
  + 不剥夺条件：进程已获得的资源，在末使用完之前，不能强行剥夺。
  + 循环等待条件：若干进程之间形成一种头尾相接的循环等待资源关系。
+ 活锁：任务或者执行者没有被阻塞，由于某些条件没有满足，导致一直重复尝试—失败—尝试—失败的过程。

### 线程  
#### 进程、线程
![线程的所有状态](http://mmbiz.qpic.cn/mmbiz_png/Bf4u9qKuXWupl2hClEIRRTBPpWAic4GicZDMAFRRWUIU5qYOYY9Ds9NTrI8GdwGZkOjPkgGZa234kCT7050dDk3g/640?wx_fmt=png&wxfrom=5&wx_lazy=1)  
+ 进程与线程的区别：
  - 线程是进程的子集，一个进程可以有很多线程，每条线程并行执行不同的任务；
  - 不同的进程使用不同的内存空间，而所有的线程共享一片相同的内存空间；
  - 进程间通讯依靠IPC资源，例如管道（pipes）、套接字（sockets）等；
  - 线程间通讯依靠JVM提供的API，例如wait方法、notify方法和notifyAll方法，线程间还可以通过共享的主内存来进行值的传递。
  
#### 线程同步的方法
+ wait()：等待状态，释放所持有对象的lock；
+ sleep()：睡眠状态，静态方法；
+ notify()：唤醒一个等待状态的线程；
+ Allnotify()：唤醒所有等待状态的线程，竞争。

### 网路
#### OSI 七层和 TCP/IP 四层
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

#### TCP 三次握手和四次挥手
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
  
#### GET、POST
+ GET
  + 从服务器获得数据；
  + url后面 v=value& 明文传输；不安全；
  + 传输量小；
+ POST
  + 向服务器上传数据；
  + 将表单数据放到 Request.Form 体传输；
  + 传输量大；
+ PUT
  + 从客户端向服务器传送的数据取代指定的文档的内容；
+ DELETE
  + 请求服务器删除指定的页面；
  + 3种返回码：
    + 200（OK）——删除成功，同时返回已经删除的资源；
    + 202（Accepted）——删除请求已经接受，但没有被立即执行（资源也许已经被转移到了待删除区域）；
    + 204（No Content）——删除请求已经被执行，但是没有返回资源（也许是请求删除不存在的资源造成的）。  

#### Session、Cookie
+ Session
  + 存放在服务器端；
  + Session ID用来唯一标识这个Session；
  + 会话（Session）跟踪。
+ Cookie
  + 存储在客户端（浏览器）；
  + 不安全；
  + 典型应用：
    1) 判断用户是否登陆过网站，以便下次登录时能够直接登录;
    2) 在线商城“购物车”中处理和设计。
  
#### 分布式 session
+ 基于数据库的session共享
  + 原理：拿出一个数据库，专门用来存储session信息。
  + 优点：服务器出现问题，session不会丢失。
  + 缺点：如果网站的访问量很大，把session存储到数据库中，会对数据库造成很大压力，还需要增加额外的开销维护数据库。
+ 基于NFS共享文件系统
  + 原理：拿出一个服务器，搭建NFS服务器来共享session。
  + 优点：过期后可以实现自动清除，须自己设定回收机制。
  + 缺点：量比较大并且所有的session文件都在同一个子目录下的话，可能带来严重的负载问题，甚至导致网站无法使用。
+ 基于memcached 的session（不提倡）
+ 基于resin/tomcat web容器本身的session复制机制（session复制）
  + 原理：将一台机器上的Session数据广播复制到集群中其余机器上。
  + 优点：实现简单、配置较少、当网络中有机器Down掉时不影响用户访问。
  + 缺点：在机器较少，网络流量较小广播式复制到其余机器上，当机器数量增多时候会有一定廷时，带来一定网络开销。
+ 基于TT/Redis 或 jbosscache 进行 session 共享
  + 优点：memcache或则redis本身就是一个分布式缓存，便于扩展。网络开销较小，几乎没有IO。性能也更好。
  + 缺点：受制于Memcache的容量，如果用户量突然增多cache由于容量的限制会将一些数据挤出缓存，另外memcache故障或重启session会完全丢失掉。所以更偏向于redis。
+ 基于cookie 进行session共享
  + 原理：将用户的session数据全部存放在cookie中。
  + 优点：服务器架构变得简单，每台web服务器都可以很独立。没有网络开销和对磁盘IO，服务器重启也不会导致数据的丢失。
  + 缺点：cookie过于庞大会耗费单位页面的下载时间。
  

