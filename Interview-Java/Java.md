## ☕️Java
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-1.5.13-brightgreen.svg)
![build passing](https://img.shields.io/badge/build-passing-brightgreen.svg) 

  * [三大框架](#%E4%B8%89%E5%A4%A7%E6%A1%86%E6%9E%B6)
  * [第三方库](#%E7%AC%AC%E4%B8%89%E6%96%B9%E5%BA%93)
  * [中间件](#%E4%B8%AD%E9%97%B4%E4%BB%B6)
  * [关键字](#%E5%85%B3%E9%94%AE%E5%AD%97)
    * [8大基本类型](#8%E5%A4%A7%E5%9F%BA%E6%9C%AC%E7%B1%BB%E5%9E%8B)
    * [static](#static)
    * [Error、Exception](#errorexception)
    * [final、finally、finalize](#finalfinallyfinalize)
    * [synchronized](#synchronized)
    * [switch\.\.\.case\.\.\.default\.\.\.](#switchcasedefault)
    * [Comparable 、Comparator](#comparable-comparator)
    * [String、StringBuilder、StringBuffer](#stringstringbuilderstringbuffer)
    * [Thread、Runnable、Callable](#threadrunnablecallable)
  * [基础知识](#%E5%9F%BA%E7%A1%80%E7%9F%A5%E8%AF%86)
    * [四种引用](#%E5%9B%9B%E7%A7%8D%E5%BC%95%E7%94%A8)
    * [泛型](#%E6%B3%9B%E5%9E%8B)
    * [Lambda 表达式](#lambda-%E8%A1%A8%E8%BE%BE%E5%BC%8F)
    * [Stream API](#stream-api)
    * [IO、NIO](#ionio)
    * [集合](#%E9%9B%86%E5%90%88)
    * [接口](#%E6%8E%A5%E5%8F%A3)
    * [Spring事务](#Spring事务)
    * [Crontab表达式](#crontab%E8%A1%A8%E8%BE%BE%E5%BC%8F)
    * [四种访问修饰符](#四种访问修饰符)
  * [并发](#并发)
    * [Synchronized](#Synchronized)
    * [Lock](#Lock)
    * [ThreadLocal](#ThreadLocal)
    * [BlockingQueue](#BlockingQueue)
    * [Semaphore](#Semaphore)
  * [JVM](#jvm)
    * [JVM 类加载机制](#jvm-%E7%B1%BB%E5%8A%A0%E8%BD%BD%E6%9C%BA%E5%88%B6)
    * [JVM 内存模型](#jvm-%E5%86%85%E5%AD%98%E6%A8%A1%E5%9E%8B)
    * [JVM 种类](#jvm-%E5%86%85%E5种类)
    * [GC 收集算法](#gc-%E6%94%B6%E9%9B%86%E7%AE%97%E6%B3%95)
    * [GC 种类](#gc-%E7%A7%8D%E7%B1%BB)
    * [GC When What How](#gc-when-what-how)
    * [常见配置](#常见配置)
    + [常用命令](#常用命令)
  * [JIT](#JIT)
    * [逃逸分析](#逃逸分析)
    * [同步省略](#同步省略)
    * [标量替换](#标量替换)
    * [栈上分配](#栈上分配) 
    * [即时编译](#即时编译) 

### 三大框架
+ [☕️SSH](https://github.com/GeJinTaiHua/Demo-SSH)
  + [☕️Spring](https://github.com/GeJinTaiHua/Learn-Spring)
    - [☕️Spring Boot](https://github.com/GeJinTaiHua/Learn-SpringBoot)
    - [☕️Spring Boot 2.0](https://github.com/GeJinTaiHua/Learn-SpringBoot2.0)
    - [☕️Spring Cloud](https://github.com/GeJinTaiHua/Learn-SpringCloud)
      + [📊Eureka](https://github.com/GeJinTaiHua/Learn-Eureka)：注册中心。
      + Hystrix：熔断。
      + Spring Cloud Config：配置中心。
      + Spring Cloud Zuul：服务网关。
    - Spring Data JPA
    - [☕️Spring Cloud Alibaba](https://github.com/GeJinTaiHua/Spring-Cloud-Alibaba-Learn)
  + Struts
  + [☕️Hibernate](https://github.com/GeJinTaiHua/Learn-Hibernate)
+ [☕️SSM](https://github.com/GeJinTaiHua/Demo-SSM)
  + [☕️Spring](https://github.com/GeJinTaiHua/Learn-Spring)
  + [☕️SpringMVC](https://github.com/GeJinTaiHua/Learn-SpringMVC)
  + MyBatis
  
### 第三方库
+ [♻️JAXB](https://github.com/GeJinTaiHua/Learn-JAXB)：XML 节点元素和 JavaBean 相互转换工具。
+ [♻️Gson](https://github.com/GeJinTaiHua/Learn-Gson)：Josn 序列化与反序列化工具。
+ [📆SLF4J](https://github.com/GeJinTaiHua/Learn-SLF4J)：日志工具。
+ [👫STOMP](https://github.com/GeJinTaiHua/STOMP)：面向消息的简单文本协议。
+ [☁️REST](https://github.com/GeJinTaiHua/Learn-HTTP)：HTTP 协议的 GET，POST，DELETE ...
+ [🌐WebService](https://github.com/GeJinTaiHua/Learn-WebService)：一种跨编程语言和跨操作系统平台的远程调用技术。

### 中间件
+ RPC框架
  + [💥Dubbo](https://github.com/GeJinTaiHua/Learn-Dubbo)
  + [☀️gRPC](https://github.com/GeJinTaiHua/Learn-gRPC)
+ MQ消息
  + [🚗RabbitMQ](https://github.com/GeJinTaiHua/Learn-RabbitMQ)
  + ActiveMQ
  + Kafka
+ 分布式协调服务
  + ZooKeeper 
  + Keepalived
+ 配置管理
  + Apollo
+ 大数据
  + Hbase
  + Hadoop
  + Hive
+ 容器
  + Docker
  + K8s
+ 分布式缓存
  + Redis
  + MemCache
  + EhCache 
+ 自动化
  + Jenkins

### 关键字
#### 8大基本类型
基本类型|包装类|位数|  |
---|---|---|---|
boolean|Boolean|1|布尔型|
char|Character|16|字符型|
byte|Byte|8|整数值型|
short|Short|16|整数值型|
int|Integer|32|整数值型|
long|Long|64|整数值型|
float|Float|32|浮点类型|
double|Double|64|浮点类型|

+ String：引用类型；
+ var：Java10，本地变量类型推断；
+ 自动装箱与拆箱：装箱过程是通过调用包装器的 valueOf 方法实现的，而拆箱过程是通过调用包装器的 xxxValue 方法实现的。

#### static
1. 静态方法
  + 不依赖于任何对象就可以进行访问；
  + 在静态方法中不能访问类的非静态成员方法/变量；
  + 在非静态成员方法中可以访问静态成员方法/变量。
2. 静态变量
  + 被所有的对象所共享，在内存中只有一个副本；
  + 当且仅当在类初次加载时会被初始化。
3. [静态代码块](/Interview-Java/src/test/java/StaticD/Code.java)
  + 优化程序性能；
  + 可以置于类中的任何地方，可以有多个static块；
  + 类初次被加载的时候，会按照static块的顺序来执行每个static块，并且只会执行一次。
4. [静态内部类](/Interview-Java/src/test/java/StaticD/InnerClass.java)
5. 静态导包
  + import static 代替 import；
  + 导入这个类里的静态方法。

#### Error、Exception
+ Error：Java 运行时系统的内部错误和资源耗尽错误。
+ Exception：标准Java库方法所激发的异常。
  + Runtime_Exception
    + 错误的类型转换（ClassCastException）；
    + 数组访问越界（ArrayIndexOutOfBoundsException）； 
    + 访问 null 指针（NullPointerException）； 
  + 非RuntimeException
    + 试图在文件尾部后面读取数据；
    + 试图打开一个不存在的文件；
    + 试图根据给定的字符串查找 Class 对象， 而这个字符串表示的类并不存在。
+ try catch finally return 执行顺序
  + finally语句总会执行；
  + 如果try、catch中有return语句，finally中没有return，那么在finally中修改除包装类型和静态变量、全局变量以外的数据都不会对try、catch中返回的变量有任何的影响；
  + 在finally中使用return语句，会忽略try、catch中的return语句，也会忽略try、catch中的异常，屏蔽了错误的发生；
  + finally中避免再次抛出异常，一旦finally中发生异常，代码执行将会抛出finally中的异常信息，try、catch中的异常将被忽略
  + [示例](/Interview-Java/src/test/java/TryExceptionFinally/tryTest.java)

#### final、finally、finalize
+ final
  + 类
    + 表明这个类不能被继承。
    + final类中的所有成员方法都会被隐式地指定为final方法。
  + 方法
    + 把方法锁定，以防任何继承类修改它的含义；
    + 类的private方法会隐式地被指定为final方法。
  + 变量
    + 基本数据类型：数值一旦在初始化之后便不能更改；
    + 引用类型：在对其初始化之后便不能再让其指向另一个对象。	
+ finally：在异常处理时提供 finally 块来执行任何清除操作。
+ finalize：方法名；finalize() 方法在垃圾收集器将对象从内存中清除出去之前做必要的清理工作。

#### synchronized
1) [代码块](/Interview-Java/src/test/java/Synchronized/SyncThread.java#L14)（同步语句块）
  + 作用的范围：大括号{}括起来的代码；
  + 作用的对象：调用这个代码块的对象；
  + 注意：
    + 一个线程访问一个对象中的synchronized(this)同步代码块时，其他试图访问该对象的线程将被阻塞；
    + 当一个线程访问对象的一个synchronized(this)同步代码块时，另一个线程仍然可以访问该对象中的非synchronized(this)同步代码块。

2) [方法](/Interview-Java/src/test/java/Synchronized/SyncThread.java#L22)（同步方法）
  + 作用的范围：整个方法；
  + 作用的对象：调用这个方法的对象；
  + 注意：
    + synchronized关键字不能继承；
    + 在定义接口方法时不能使用synchronized关键字；
    + 构造方法不能使用synchronized关键字，但可以使用synchronized代码块来进行同步。

3) [静态的方法](/Interview-Java/src/test/java/Synchronized/SyncThread.java#L29)
  + 作用的范围：整个静态方法；
  + 作用的对象：这个类的所有对象；
  + 注意：静态方法是属于类的而不属于对象的。同样的，synchronized修饰的静态方法锁定的是这个类的所有对象。

4) [类](/Interview-Java/src/test/java/Synchronized/SyncThread.java#L36)
  + 作用的范围：synchronized后面括号括起来的部分；
  + 作用的对象：这个类的所有对象；
  + 注意：synchronized作用于一个类T时，是给这个类T加锁，T的所有对象用的是同一把锁。

#### switch...case...default...
+ switch(A)
  + A的取值只能是整型或者可以转换为整型的数值类型，比如byte、short、int、char、还有枚举；
  + Java 7：取值支持String；通过equals()和hashCode()方法来实现的。
+ case B:C
  + 常量表达式；B的取值只能是常量（需要定义一个final型的常量）或者byte、short、int、char、String；
  + Java 12：允许合并多个条件；
+ default
  + 没有符合的case就执行它;
  + 并不是必须的。

#### Comparable 、Comparator
+ Comparable：接口强行对实现它的每个类的对象进行整体排序（自然排序）（内部排序）。
  + 是由对象自己实现的
```
public int compareTo(T o);
```
+ Comparator：接口新建一个比较器，通过该比较器来对类进行排序（外部排序）。
  + 由外部实现
  + 策略模式
```
int compare(T o1, T o2);
boolean equals(Object obj);
```

#### String、StringBuilder、StringBuffer
+ String
  + 字符串常量；
  + final 修饰，不可被继承；
  + hashCode() 源码：
```
    public int hashCode() {
        int h = hash;
        if (h == 0 && value.length > 0) {
            char val[] = value;
 
            for (int i = 0; i < value.length; i++) {
                h = 31 * h + val[i];
            }
            hash = h;
        }
        return h;
    }
```
+ StringBuilder 
  + 字符串变量（非线程安全）；
  + 默认容量16；
  + toString() 源码：
```
public String toString() {
  // Create a copy, don't share the array
  return new String(value, 0, count);
}
```
+ StringBuffer 
  + 字符串变量（线程安全）；
  + toString()方法会进行对象缓存，以减少元素的复制开销；
  + toString() 源码：
```
public synchronized String toString() {
  if (toStringCache == null) {
    toStringCache = Arrays.copyOfRange(value, 0, count);
  }
  return new String(toStringCache, true);
}
```

#### Thread、Runnable、Callable
1) [Thread](/Interview-Java/src/test/java/Thread/ThreadT.java)（类）
   + start()：启动一个线程，这时此线程处于就绪（可运行）状态；
   + run()：只是类的一个普通方法而已。
   + 缺点：
     + 每次通过new Thread()创建对象性能不佳；
     + 线程缺乏统一管理，可能无限制新建线程，相互之间竞争，及可能占用过多系统资源导致死机或oom；
     + 缺乏更多功能，如定时执行、定期执行、线程中断。
2) Runnable（接口）
   + 避免继承的局限，一个类可以继承多个接口；
   + 适合于资源的共享，节约资源。
3) Callable（接口）
4) [ExecutorService、Callable、Future](/Interview-Java/src/test/java/Thread/ESF.java)
+ 简单示例：
  + [3个线程交替输出 1-100](/Interview-Java/src/test/java/Thread/ThreeAlternate.java)
  + [3个线程顺序执行](/Interview-Java/src/test/java/Thread/ThreadByOrder.java)

### 基础知识
#### 四种引用
1) 强引用：是指创建一个对象并把这个对象赋给一个引用变量。
  + 强引用有引用变量指向时永远不会被垃圾回收，JVM宁愿抛出OutOfMemory错误也不会回收这种对象；
  + 想中断强引用和某个对象之间的关联，可以显式地将引用赋值为null。
```
Object object =new Object();
String str ="hello";
```

2) 软引用（SoftReference）：用来描述一些还有用但并非必要的对象。
  + 内存空间足够，垃圾回收器就不会回收它；
  + 可用来实现内存敏感的高速缓存，比如网页缓存、图片缓存等。使用软引用能防止内存泄露，增强程序的健壮性。 
  
3) 弱引用（WeakReference）：用来描述非必须对象的，强度比弱引用更弱。
  + 当JVM进行垃圾回收时，无论内存是否充足，都会回收被弱引用关联的对象。
  
4) 虚引用（PhantomReference）：幽灵引用、幻影引用；是最弱的一种引用关系。
  + 并不影响对象的生命周期；
  + 唯一作用：在这个对象被收集器回收时收到一个系统通知。
![四种引用](https://images2015.cnblogs.com/blog/249993/201703/249993-20170306195851516-1068507269.png)

#### 泛型
+ T 
+ extends
  + 上界 <? extends T>
  + 不能往里存，只能往外取  
  ![extends](https://images2018.cnblogs.com/blog/1043143/201804/1043143-20180414164334299-153062921.jpg)
+ super
  + 下界 <? super T>  
  + 往外取只能赋值给Object变量，不影响往里存  
  ![super](https://images2018.cnblogs.com/blog/1043143/201804/1043143-20180414164527508-811736127.jpg)
+ 语法糖实现原理：虚拟机中没有泛型，只有普通类和普通方法；所有泛型类的类型参数在编译时都会被擦除，泛型类并没有自己独有的Class类对象。比如并不存在List<String>.class或是List<Integer>.class，而只有List.class。
	
#### Lambda 表达式
1) expression = (variable) -> action
   + variable：这是一个变量，一个占位符。像x、y、z可以是多个变量；
   + action：这是我们实现的代码逻辑部分，它可以是一行代码也可以是一个代码片段。
```
\\创建了一个函数，用来计算两个操作数的和。
int sum = (x, y) -> x + y;
```
2) [函数式接口](/Interview-Java/src/test/java/BaseData/FunctionInterfaceDemo.java)

接口|参数|返回值|类别|
---|---|---|---|
Consumer|T|void|消费型接口|
Supplier|none|T|供给型接口|
Function|T|R|函数型接口|
Predicate|T|boolean|断言型接口|

+ [方法引用](/Interview-Java/src/main/java/www/wjl/com/Interview/service/StreamService.java#L38)：仅仅调用特点方法的 Lambda 快捷写法

Lambda|等效的方法引用|
---|---|
(Apple a)->a.getWeight()|Apple::getWeight|
()->Thread.currentThread().dumpStack()|Thread.currentThread()::dumpStack|
(str,i)->str.substring(i)|String::substring|
(String s)->System.out.println(s)|System.out::println|

#### Stream API
+ [构造](/Interview-Java/src/main/java/www/wjl/com/Interview/service/StreamService.java#L17)
  1) 从 Collection 和数组
     + Collection.stream()
     + Collection.parallelStream()
     + Arrays.stream(T array) or Stream.of()
  2) 从 BufferedReader
     + java.io.BufferedReader.lines()
  3) 静态工厂
     + java.util.stream.IntStream.range()
     + java.nio.file.Files.walk()
  4) 自己构建
     + java.util.Spliterator
  5) 其它
     + Random.ints()
     + BitSet.stream()
     + Pattern.splitAsStream(java.lang.CharSequence)
     + JarFile.stream()
+ 操作类型
  + Intermediate：中间操作
    + map(mapToInt, flatMap 等)：把 input Stream 的每一个元素，映射成 output Stream 的另外一个元素
    + filter：过滤
    + distinct、sorted、peek、limit、skip、parallel、sequential、unordered
  + Terminal：终结操作
    + forEach、forEachOrdered、toArray、reduce、collect、min、max、count、anyMatch、allMatch、noneMatch、findFirst、findAny、iterator
  + Short-circuiting：
    + anyMatch、allMatch、noneMatch、findFirst、findAny、limit 
    
+ lambda表达式
  + Java 11：局部变量类型推断var；
  + 实现其实是依赖了一些底层的api，在编译阶段，编译器会把lambda表达式进行解糖，转换成调用内部api的方式。
    
#### IO、NIO
+ 管道（Channel）：实际上就像传统IO中的流，到任何目的地(或来自任何地方)的所有数据都必须通过一个 Channel 对象。一个 Buffer 实质上是一个容器对象。
+ 选择器（Selector）：用于监听多个管道的事件，使用传统的阻塞IO时我们可以方便的知道什么时候可以进行读写，而使用非阻塞通道，我们需要一些方法来知道什么时候通道准备好了，选择器正是为这个需要而诞生的。

IO|NIO
---|---
面向流|面向缓冲
阻塞IO|非阻塞IO
无|选择器

+ 推荐 [🔘IO](https://github.com/GeJinTaiHua/Learn-IO)
  + 少量的连接。
  + 连接每次要发送大量的数据。
+ 推荐 [🔘NIO](https://github.com/GeJinTaiHua/Learn-IO)
  + 大量的连接。
  + 连接每次发送少量的数据。
  + 聊天服务器。

#### 集合
1. Collection
+ List：有序，元素可重复。
  1) ArrayList
     + 底层数据结构【数组】；
     + 查询快，增删慢；
     + 线程不安全，效率高；
     + 默认大小10，1.5倍长度扩容；
       + CopyOnWriteArrayList（CopyOnWrite）：写时拷贝；java.util.concurrent包。
  2) LinkedList
     + 底层数据结构【链表】；
     + 查询慢，增删快；
     + 线程不安全，效率高。
  3) Vector
     + 底层数据结构【数组】；
     + 线程安全，效率低；
     + 默认大小10，2倍长度扩容。
+ Set：不可重复
  1) HashSet
     + 底层数据结构【哈希表】；
     + 无序；
     + 线程不安全，效率高；
       + linkedHashSet：【链表】，有序，线程不安全；
  2) TreeSet
     + 底层数据结构【平衡二叉排序树】；
     + 有序；
     + 线程不安全；
  3) 线程安全：Set set = Collections.synchronizedSet(set 对象)。
    
2. Map 
表示一个键值对 (key-value) 的映射；
+  HashMap（替代Hashtable）：
   + 底层数据结构【哈希表】链地址法解决冲突；
      + 链表长度大于阈值（默认为 8）时，将链表转化为红黑树。
   + 可存一个null键，多个null值；
   + 线程不安全； 
     + Map m = Collections.synchronizeMap(hashMap)实现同步；  
     + linkedHashMap：【双向链表】，线程不安全。
     + ConcurrentHashMap
       + 锁分离（JDK1.8放弃）：在HashMap的基础上，将数据分段存储，ConcurrentHashMap由多个Segment组成，每个Segment都有把锁（可重入锁ReentrantLock）。
       + CAS算法：如果valueOffset位置包含的值与expect值相同，则更新valueOffset位置的值为update，并返回true，否则不更新，返回false。
       ![HashMap](/Interview-Java/Pic/HashMap.png)
+  Hashtable
   + 底层数据结构【哈希散列表】双重散列法（闭散列法）解决冲突；
   + 不可以存null键，null值；
   + 线程安全；
   + 多线程下效率低下。
+  TreeMap  
   + 底层数据结构【平衡二叉排序树】
   + 有序。

3. fail-fast、fail-safe
+ fail-fast（快速失败）
  + 当你在迭代一个集合的时候，如果有另一个线程正在修改你正在访问的那个集合时，就会抛出一个 ConcurrentModification 异常；
  + 在 java.util 包下的都是快速失败。
+ fail-safe（安全失败）
  + 你在迭代的时候会去底层集合做一个拷贝，所以你在修改上层集合的时候是不会受影响的，不会抛出 ConcurrentModification 异常；
  + 在 java.util.concurrent 包下的全是安全失败的。
  
#### 接口
+ <Java 7
  1) 常量
  2) 抽象方法
+ Java 8 
  1) 常量
  2) 抽象方法
  3) **默认方法**
  4) **静态方法**
+ Java 9 
  1) 常量
  2) 抽象方法
  3) 默认方法
  4) 静态方法
  5) **私有方法**
  
#### Spring事务
+ 5种事务隔离级别

|Isolation|隔离级别|不可避免|
|----|----|----|
|DEFAULT|默认|使用数据库默认级别|
|READ_UNCOMMITTED|读未提交|脏读、不可重复读、幻读|
|READ_COMMITTED|读已提交|不可重复读、幻读|
|REPEATABLE_READ|可重复读|幻读|
|SERIALIZABLE|串行化||

+ 7种事务传播行为

|Propagation|传播行为|
|----|----|
|REQUIRED|如果当前无事务则开启一个事务，否则加入当前事务。|
|SUPPORTS|如果当前有事务则加入当前事务。|
|MANDATORY|如果当前无事务则抛出异常，否则加入当前事务。|
|REQUIRES_NEW|如果当前无事务则开启一个事务，否则挂起当前事务并开启新事务。|
|NOT_SUPPORTED|如果当前有事务，则挂起当前事务以无事务状态执行方法。|
|NEVER|如果当前有事务，则抛出异常。|
|NESTED|创建一个嵌套事务，如果当前无事务则创建一个事务。|

+ @transactional 失效情况：
  + 方法不是public；
  + 新建了调用对象；
  + unchecked、捕获异常；

#### Crontab表达式
字段|允许值（整数）|允许的特殊字符| 
---|---|---|
秒（Seconds）|0~59|, - * /    四个字符|
分（Minutes）|0~59|, - * /    四个字符|
小时（Hours）|0~23|, - * /    四个字符|
日期（DayofMonth）|1~31|,- * ? / L W C     八个字符|
月份（Month）|1~12 或 <br>JAN, FEB, MAR, APR, MAY, JUN, <br>JUL, AUG, SEP, OCT, NOV, DEC|, - * /    四个字符|
星期（DayofWeek）|1~7 （1=SUN=星期日）或 <br>SUN, MON, TUE, WED, THU, FRI, SAT|, - * ? / L C #     八个字符|
年(可选，留空)（Year）|1970~2099|, - * /    四个字符|

```
每秒：* * * * * ? *
每分：0 * * * * ? *
每时：0 0 * * * ? *
每日：0 0 0 * * ? *
```

#### 四种访问修饰符
|访问权限|同类|同包|子类|其他包| 
|:----:|:----:|:----:|:----:|:----:|
|public|✔|✔|✔|✔|
|protect|✔|✔|✔|❌|
|default|✔|✔|❌|❌|
|private|✔|❌|❌|❌|

### 并发
#### Synchronized
+ 公平，悲观，独享，互斥，可重入的重量级锁。
+ 实现原理：
  1) Contention List：竞争队列，所有请求锁的线程首先被放在这个竞争队列中；
  2) Entry List：Contention List中那些有资格成为候选资源的线程被移动到Entry List中；
  3) OnDeck：任意时刻，最多只有一个线程正在竞争锁资源，该线程被成为OnDeck；
  4) Owner：当前已经获取到所资源的线程被称为Owner；
  5) Wait Set：哪些调用wait方法被阻塞的线程被放置在这里；
  6) !Owner：当前释放锁的线程。
  ![实现原理](https://img-blog.csdn.net/20170418221917277?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvenF6X3pxeg==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)
+ Obj.wait() 与 Obj.notify() 必须要与 synchronized(Obj) 一起使用
  + wait就是说线程在获取对象锁后，主动释放对象锁，同时本线程休眠。直到有其它线程调用对象的notify()唤醒该线程，才能继续获取对象锁，并继续执行。相应的notify()就是对对象锁的唤醒操作；
  + notify()调用后，并不是马上就释放对象锁的，而是在相应的synchronized(){}语句块执行结束，自动释放锁后，JVM会在wait()对象锁的线程中随机选取一线程，赋予其对象锁，唤醒线程，继续执行。如果是notifyAll()就会释放所有的锁。

#### Lock
+ ReentrantLock：默认非公平但可实现公平的，悲观，独享，互斥，可重入，重量级锁。
+ ReadWriteLock（实现类ReentrantReadWriteLocK）：默认非公平但可实现公平的，悲观，写独享，读共享，读写，可重入，重量级锁。
+ [阻塞队列](/Interview-Java/src/test/java/Thread/ArrayBlockingQueueN.java)：用Lock和Condition实现一个阻塞队列。

#### ThreadLocal
+ 线程本地变量，内部使用ThreadLocalMap维护值；
+ 方法：
  + get()
  + set()
  + remove()：必须，否则会发生内存泄漏！
+ 使用场景：
  + 数据库连接；
  + Session管理；
  + 用户上下文；
  
#### BlockingQueue
+ 不接受 null 元素，NullPointerException；
+ 线程安全；
+ 具体实现：
  + 数组阻塞队列：ArrayBlockingQueue
  + 延迟队列：DelayQueue
  + 链阻塞队列：LinkedBlockingQueue
  + 具有优先级的阻塞队列：PriorityBlockingQueue
  + 同步队列：SynchronousQueue
  + 阻塞双端队列：BlockingDeque
  + 链阻塞双端队列：LinkedBlockingDeque

| |抛出异常|特殊值|阻塞|超时|
|:----:|:----:|:----:|:----:|:----:|
|插入|add(e)|offer(e)|put(e)|offer(e, time, unit)|
|移除|remove()|poll()|take()|poll(time, unit)|
|检查|element()|peek()|-|-|

#### Semaphore
+ 一个计数信号量，必须由获取它的线程释放；
+ 操作：
  + acquire()：获取许可证
  + release()：归还许可证
+ [流量控制](/Interview-Java/src/test/java/Thread/SemaphoreTest.java)：30个线程只允许10个同时存在。

### JVM
#### JVM 类加载机制
+ 类加载过程
  1) 加载（Loading）：查找和导入Class文件。
     - 启动类加载器（Bootstrap ClassLoader）
     - 扩展类加载器（Extension ClassLoader）
     - 系统类加载器（Application ClassLoader）
     - 自定义类加载器
     + 双亲委派机制：类加载器收到类加载请求，自己不加载，向上委托给父类加载，父类加载不了，再自己加载。
  2) 验证（Verification）：确保Class文件的字节流中包含的信息符合当前虚拟机的要求，并且不会危害虚拟机自身的安全。
     + 文件格式验证
     + 元数据验证
     + 字节码验证
     + 符号引用验证
  3) 准备（Preparation）：正式为类变量分配内存并设置类变量初始值的阶段，这些变量所使用的内存都将在方法区中进行分配。
     + 类变量（被static修饰的变量）
     + 标注为final之后，value的值在准备阶段初始化
  4) 解析（Resolution）：将符号引用转成直接引用；
  5) 初始化（Initialization）：对类的静态变量，静态代码块执行初始化操作。
  6) 使用（Using）
  7) 卸载（Unloading）
  ![类加载过程](http://incdn1.b0.upaiyun.com/2017/06/2fb054008ca2898e0a17f7d79ce525a1.png)
  
+ 类的实例化顺序
  1) 父类静态变量；
  1) 父类静态代码块；
  2) 子类静态变量；
  2) 子类静态代码块；
  3) 父类非静态变量；
  3) 父类构造函数；
  4) 子类非静态变量；
  4) 子类构造函数。
+ [静态字段](/Interview-Java/src/test/java/ClassLoad/NotInitialization/NotInitialization.java)：对于静态字段，只有直接定义这个字段的类才会被初始化，因此通过其子类来引用父类中定义的静态字段，只会触发父类的初始化而不会触发子类的初始化：
+ [顺序](/Interview-Java/src/test/java/ClassLoad/StaticTest.java)：实例初始化不一定要在类初始化结束之后才开始初始化

#### JVM 内存模型
![内存模型](https://mmbiz.qpic.cn/mmbiz_png/iaIdQfEric9TwVibBF785ic5RU2iafKlnVEsCEed3urDicyv4ObhWyriadrWIr293APDicN5gwEAzuQ2WhqDhyF7wwUZIA/640?wx_fmt=png&tp=webp&wxfrom=5&wx_lazy=1&wx_co=1)
+ 堆：用来存放对象实例。
  + 是垃圾收集器管理的主要区域，因此也被称作GC堆；
+ 方法区（Non-Heap 非堆）：用于存储已被虚拟机加载的类信息、常量、静态变量、即时编译器编译后的代码等数据。
  + 运行时常量池：存放编译期生成的各种字面量和符号引用。
  + Hotspot在 JDK 1.8中移除整个永久代，取而代之的是一个叫元空间（Metaspace）的区域（永久代使用的是JVM的堆内存空间，而元空间使用的是物理内存，直接受到本机的物理内存限制）。
![堆](http://incdn1.b0.upaiyun.com/2019/01/19307619b4ddae3ef19002bc6ac51b5c.png)
    
+ 虚拟机栈：为虚拟机执行 Java 方法（也就是字节码）服务。
  + 局部变量表：存放了编译器可知的各种数据类型（boolean、byte、char、short、int、float、long、double）、对象引用（reference类型）、returnAddress类型（指向一套字节码指令的地地址）；
  + 操作数栈、动态链接、方法出口信息。
+ 本地方法栈：为虚拟机使用到的 Native 方法服务。
  + 在 HotSpot 虚拟机中和 Java 虚拟机栈合二为一。
+ 程序计数器：是唯不会出现 OutOfMemoryError 的内存区域，它的生命周期随着线程的创建而创建，随着线程的结束而死亡。
  1) 字节码解释器通过改变程序计数器来依次读取指令，从而实现代码的流程控制，如：顺序执行、选择、循环、异常处理；
  2) 在多线程的情况下，程序计数器用于记录当前线程执行的位置，从而当线程被切换回来的时候能够知道该线程上次运行到哪儿了。
+ 直接内存：直接内存并不是虚拟机运行时数据区的一部分，也不是虚拟机规范中定义的内存区域，但是这部分内存也被频繁地使用。而且也可能导致OutOfMemoryError异常出现。

+ Java堆栈区别：
  1) 栈内存（虚拟机栈中局部变量表部分）：基本数据类型、局部变量、对象的引用；
  2) 堆内存：new创建的对象、数组 ；
  3) static修饰的类变量：程序在加载的时候就在堆中为类变量分配内存，堆中的内存地址存放在栈中；

#### JVM 种类
+ Sun HotSpot 
+ Oracle JRockit
+ IBM J9

#### GC 收集算法
+ 引用计数法
  + 引用计数是垃圾收集器中的早期策略。
  + 堆中每个对象实例都有一个引用计数。
  + 优点：引用计数收集器可以很快的执行，交织在程序运行中；对程序需要不被长时间打断的实时环境比较有利。
  + 缺点：无法检测出循环引用。
+ 标记-清除算法
  1) 首先标记出所有需要回收的对象；
  2) 在标记完成后统一回收所有被标记的对象。  
  ![标记-清除算法](https://upload-images.jianshu.io/upload_images/3985563-1b31d5ebe8dec659.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/267)
  + 缺点：标记和清除两个过程的效率都不高；产生大量不连续的内存碎片。
+ 复制算法（商业虚拟机采用）
  1) 将可用内存按容量大小划分为大小相等的两块，每次只使用其中的一块；
  2) 当一块内存使用完了，就将还存活着的对象复制到另一块上面，然后再把已使用过的内存空间一次清理掉。  
  ![复制算法](https://upload-images.jianshu.io/upload_images/3985563-1b7d8f53a44cdfdb.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/700)
  + 缺点：将内存缩小为了原来的一半。
+ 标记-整理算法
  1) 首先标记出所有需要回收的对象；
  2) 让所有存活的对象都向一端移动，然后直接清理掉边界以外的内存。  
  ![标记-整理算法](https://upload-images.jianshu.io/upload_images/3985563-1bd60604e0c0f46a.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/571)
+ 分代收集算法
  + 新生代：
    - 存活时间较短，因此基于**复制算法**来进行回收。
    - 划分为三个区域：Eden、From Survivor、To Survivor。
    - Minor GC
  + 老年代：
    - 对象存活的时间比较长，比较稳定，因此采用**标记（Mark）算法**来进行回收。
    - Full GC  
  ![新生代老年代](http://images0.cnblogs.com/blog/587773/201409/061921034534396.png)

#### GC 种类
+ 新生代收集器
  1) Serial：（串行）垃圾收集器是最基本、发展历史最悠久的收集器。
     + 采用复制算法；
     + 单线程收集；
     + 进行垃圾收集时，必须暂停所有工作线程，直到完成；"Stop The World"。     
  2) ParNew：Serial收集器的多线程版本。
     + 除了多线程外，其余的行为、特点和Serial收集器一样；
     + 除Serial外，目前只有它能与CMS收集器配合工作。
  3) Parallel Scavenge：吞吐量收集器（Throughput Collector）。
     + 采用复制算法；
     + 多线程收集；
     + 目标则是达一个可控制的吞吐量（Throughput），即减少垃圾收集时间，让用户代码获得更长的运行时间。
       + 吞吐量 = 运行用户代码时间/（运行用户代码时间+垃圾收集时间）
+ 老年代收集器
  1) Serial Old：Serial收集器的老年代版本。
     + 采用"标记-整理"算法（还有压缩，Mark-Sweep-Compact）；
     + 单线程收集。
  2) Parallel Old：Parallel Scavenge收集器的老年代版本。
     + 采用"标记-整理"算法；
     + 多线程收集；
  3) CMS：也称为并发低停顿收集器（Concurrent Low Pause Collector）或低延迟（low-latency）垃圾收集器。
     + 基于"标记-清除"算法(不进行压缩操作，产生内存碎片)；       
       1. 初始标记
       2. 并发标记
       3. 并发预清理
       4. 重新标记
       5. 并发清理
       6. 重置
     + 优点：
       + 以获取最短回收停顿时间为目标；
       + 并发收集、低停顿；
     + 缺点：
       + 对CPU资源非常敏感；
       + 无法处理浮动垃圾；
       + 产生空间碎片；
       + 需要更多的内存。
+ 整堆收集器
  1) G1：JDK7-u4才推出商用的收集器。
     + 并行并发：可以并行来缩短"Stop The World"停顿时间；也可以并发让垃圾收集与用户程序同时进行；
     + 分代收集：收集范围包括新生代和老年代；
     + 空间整合：结合多种垃圾收集算法，空间整合，不产生碎片；
       1. 初始标记
       2. 并发标记
       3. 最终标记
       4. 筛选回收
     + 可预测的停顿：低停顿的同时实现高吞吐量。
+ 并发垃圾收集、并行垃圾收集的区别
  + 并发（Concurrent）
    + 指用户线程与垃圾收集线程同时执行（但不一定是并行的，可能会交替执行）；
    + 用户程序在继续运行，而垃圾收集程序线程运行于另一个CPU上；
    + 如CMS、G1（也有并行）；  
  + 并行（Parallel）
    + 指多条垃圾收集线程并行工作，但此时用户线程仍然处于等待状态；
    + 如 ParNew、Parallel Scavenge、Parallel Old）。
+ Minor GC、Full GC 区别
  + Minor GC（新生代GC）
    + 发生在新生代的垃圾收集动作；
    + 非常频繁，一般回收速度也比较快。
  + Full GC（Major GC）（老年代GC）
    + 出现Full GC经常会伴随至少一次的Minor GC；
    + 速度一般比Minor GC慢10倍以上。
    
#### GC When What How 
+ 触发时机
  + 在程序空闲的时候；
  + 程序不可预知的时候、手动调用system.gc()；
  + Java堆内存不足时。
+ 回收对象
  + 超出作用域的对象、引用计数为空的对象；
  + 从GC Root开始搜索，搜索不到的对象；
  + 从root搜索不到，而且经过第一次标记、清理后，仍然没有复活的对象。
+ 做什么
  + 回收对象，腾出空间；
    
#### 常见配置
1) 堆设置
   + -Xms:初始堆大小
   + -Xmx:最大堆大小
   + -XX:NewSize=n:设置年轻代大小
   + -XX:NewRatio=n:设置年轻代和年老代的比值。如:为3，表示年轻代与年老代比值为1：3，年轻代占整个年轻代年老代和的1/4
   + -XX:SurvivorRatio=n:年轻代中Eden区与两个Survivor区的比值。注意Survivor区有两个。如：3，表示Eden：Survivor=3：2，一个Survivor区占整个年轻代的1/5
   + -XX:MaxPermSize=n:设置持久代大小
2) 收集器设置
   + -XX:+UseSerialGC:设置串行收集器
   + -XX:+UseParallelGC:设置并行收集器
   + -XX:+UseParalledlOldGC:设置并行年老代收集器
   + -XX:+UseConcMarkSweepGC:设置并发收集器
3) 垃圾回收统计信息
   + -XX:+PrintGC
   + -XX:+PrintGCDetails
   + -XX:+PrintGCTimeStamps
   + -Xloggc:filename
4) 并行收集器设置
   + -XX:ParallelGCThreads=n:设置并行收集器收集时使用的CPU数。并行收集线程数。
   + -XX:MaxGCPauseMillis=n:设置并行收集最大暂停时间
   + -XX:GCTimeRatio=n:设置垃圾回收时间占程序运行时间的百分比。公式为1/(1+n)
5) 并发收集器设置
   + -XX:+CMSIncrementalMode:设置为增量模式。适用于单CPU情况。
   + -XX:ParallelGCThreads=n:设置并发收集器年轻代收集方式为并行收集时，使用的CPU数。并行收集线程数。
+ 逃逸分析
  + -XX:+DoEscapeAnalysis：开启逃逸分析（JDK1.7后默认开启）
  + -XX:-DoEscapeAnalysis：关闭逃逸分析

#### 常用命令
+ jps -l：显示虚拟机执行主类名称和进程唯一ID；  
![jps](/Interview-Java/Pic/jps.png)
+ jstat -gc 4124 250 20：每250毫秒查询进程4124详细信息，一共查询20次；  
![jstat](/Interview-Java/Pic/jstat.png)
+ jinfo 4124：查看和调整虚拟机各项参数；
+ jmap 4124：生成堆转储快照；
+ jhat：与jamp搭配使用，分析生成的堆转储快照；
+ jstack：生成虚拟机当前时刻的线程快照；

###  JIT
#### 逃逸分析
+ 方法逃逸：当一个对象在方法中被定义后，它可能被外部方法所引用，例如作为调用参数传递到其他地方中。
```
public static StringBuffer craeteStringBuffer(String s1, String s2) {
    StringBuffer sb = new StringBuffer();
    sb.append(s1);
    sb.append(s2);
    return sb;//sb逃逸了
}
```
使用逃逸分析，编译器可以对代码做如下优化：
+ [同步省略](#同步省略)
+ [分离对象或标量替换](#标量替换)
+ [将堆分配转化为栈分配](#栈上分配)

#### 同步省略
+ 同步省略（锁消除）：在动态编译同步块的时候，JIT编译器可以借助逃逸分析来判断同步块所使用的锁对象是否只能够被一个线程访问而没有被发布到其他线程。
如果同步块所使用的锁对象通过这种分析被证实只能够被一个线程访问，那么JIT编译器在编译这个同步块的时候就会取消对这部分代码的同步。
```
public void f() {
    Object hollis = new Object();
    synchronized(hollis) {
        System.out.println(hollis);
    }
}
```
优化为：
```
public void f() {
    Object hollis = new Object();
    System.out.println(hollis);
}
```

#### 标量替换
+ 标量（Scalar）：指一个无法再分解成更小数据的数据；Java中的原始数据类型就是标量。
+ 聚合量（Aggregate）：还可以分解的数据；Java中的对象就是聚合量。
+ 标量替换：在JIT阶段，如果经过逃逸分析，发现一个对象不会被外界访问的话，那么经过JIT优化，就会把这个对象拆解成若干个其中包含的若干个成员变量来代替。
  + 优点：大大减少堆内存的占用；为栈上分配提供了很好的基础。
```
public static void main(String[] args) {
   alloc();
}
 
private static void alloc() {
   Point point = new Point（1,2）;
   System.out.println("point.x="+point.x+"; point.y="+point.y);
}
class Point{
    private int x;
    private int y;
}
```
被替换为：
```
private static void alloc() {
   int x = 1;
   int y = 2;
   System.out.println("point.x="+x+"; point.y="+y);
}
```

#### 栈上分配
+ 栈上分配：如果经过逃逸分析后发现，一个对象并没有逃逸出方法的话，那么就可能被优化成栈上分配。
  + 优点：这样就无需在堆上分配内存，也无须进行垃圾回收了。

#### 即时编译
+ 热点代码：会以整个方法为编译对象。
  1. 被多次调用的方法；
  2. 被多次执行的循环体：因为发生在方法执行过程，所以被称为栈上替换（OSR编译），即方法栈帧还在栈上，方法就被替换了。
+ 热点探测：判断方法是不是热点代码，是否触发即时编译的行为。
  1. 基于采样的热点探测：周期性检查各个线程的栈顶，发现经常出现的方法；
  2. 基于计数器的热点探测：为每个方法建立计数器，统计方法的执行次数。（HotSpot使用）
     + 方法调用计数器：一段时间内被调用的次数；计数器热度的衰减；
     + 回边计数器
+ 即时编译器优化技术一览：
  + 编译器策略
    + 延迟编译
    + 分层编译
    + 栈上替换：
    + 延迟优化
    + 程序依赖图表示
    + 静态单赋值表示
  + 基于性能监控的优化技术
    + 乐观空值断言
    + 乐观类型断言
    + 乐观类型增强
    + 乐观数组长度增强
    + 裁剪未被选择的分支
    + 乐观的多态内联
    + 分支频率预测
    + 调用频率预测
  + 基于证据的优化技术
    + 精确类型推断
    + 内存值推断
    + 内存值跟踪
    + 常量拆叠
    + 重组
    + 操作符退化
    + 空值检查消除
    + 类型检测退化
    + 类型检测消除
    + 代数化简
    + 公共子表达式消除
  + 数据流敏感重写
    + 条件常量传播
    + 基于流承载的类型缩减转换
    + 无用代码清除
  + 语言相关的优化技术
    + 类型继承关系分析
    + 去虚拟机化
    + 符号常量传播
    + 自动装箱传播
    + 逃逸分析：
    + 锁清除：
    + 锁膨胀
    + 清除反射
  + 内存及代码位置变换
    + 表达式提升
    + 表达式下沉
    + 冗余存储消除
    + 相邻存储合并
    + 交汇点分离
  + 循环变换
    + 循环展开
    + 循环剥离
    + 安全点消除
    + 迭代范围分离
    + 范围检查消除
    + 循环向量化
  + 全局代码调整
    + 内联
    + 全局代码外提
    + 基于热度的代码布局：
    + Switch调整
  + 控制流图变换
    + 本地代码编排
    + 本地代码封包
    + 延迟槽填充
    + 着色图寄存器分配
    + 线性扫描寄存器分配
    + 复写聚合
    + 常量分裂
    + 复写移除
    + 地址模式匹配
    + 指令窥孔优化
    + 基于确定有限状态机的代码生成




