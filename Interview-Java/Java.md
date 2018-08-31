## ☕️Java
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-1.5.13-brightgreen.svg)
![build passing](https://img.shields.io/badge/build-passing-brightgreen.svg) 


  * [三大框架](#%E4%B8%89%E5%A4%A7%E6%A1%86%E6%9E%B6)
  * [第三方库](#%E7%AC%AC%E4%B8%89%E6%96%B9%E5%BA%93)
  * [中间件](#%E4%B8%AD%E9%97%B4%E4%BB%B6)
  * [关键字](#%E5%85%B3%E9%94%AE%E5%AD%97)
    * [8大基本类型](#8%E5%A4%A7%E5%9F%BA%E6%9C%AC%E7%B1%BB%E5%9E%8B)
    * [static](#static)
    * [Exception](#exception)
    * [synchronized](#synchronized)
    * [switch\.\.\.case\.\.\.default\.\.\.](#switchcasedefault)
    * [transient](#transient)
    * [Overload、Override](#overloadoverride)
    * [Thread、Runnable](#threadrunnable)
    * [String、StringBuilder、StringBuffer](#stringstringbuilderstringbuffer)
    * [final、finally、finalize](#finalfinallyfinalize)
  * [基础知识](#%E5%9F%BA%E7%A1%80%E7%9F%A5%E8%AF%86)
    * [四种引用](#%E5%9B%9B%E7%A7%8D%E5%BC%95%E7%94%A8)
    * [泛型](#%E6%B3%9B%E5%9E%8B)
    * [java\.util\.concurrent](#javautilconcurrent)
    * [Lambda 表达式](#lambda-%E8%A1%A8%E8%BE%BE%E5%BC%8F)
    * [集合](#%E9%9B%86%E5%90%88)
      * [Collection](#collection)
      * [Map](#map)
      * [fail\-fast、fail\-safe](#fail-fastfail-safe)
    * [IO、NIO](#ionio)
  * [JVM](#jvm)
    * [JVM 类加载机制](#jvm-%E7%B1%BB%E5%8A%A0%E8%BD%BD%E6%9C%BA%E5%88%B6)
    * [JVM 内存模型](#jvm-%E5%86%85%E5%AD%98%E6%A8%A1%E5%9E%8B)
    * [垃圾收集算法](#%E5%9E%83%E5%9C%BE%E6%94%B6%E9%9B%86%E7%AE%97%E6%B3%95)
    * [垃圾收集器](#%E5%9E%83%E5%9C%BE%E6%94%B6%E9%9B%86%E5%99%A8)


### 三大框架
+ [☕️Spring](https://github.com/GeJinTaiHua/Learn-Spring)
  - 依赖注入（DI）又称为控制反转（IOC）
  - 面向切片编程（AOP）是面向对象编程（OOP）的延续
  - [☕️Spring Boot](https://github.com/GeJinTaiHua/Learn-SpringBoot)
  - [☕️Spring Boot 2.0](https://github.com/GeJinTaiHua/Learn-SpringBoot2.0)
  - [☕️Spring Cloud](https://github.com/GeJinTaiHua/Learn-SpringCloud)
    + [📊Eureka](https://github.com/GeJinTaiHua/Learn-Eureka)：服务的注册与发现。
  - [Spring Data JPA]
+ Struts
  - 模型（M）
  - 视图（V）
  - 控制器（C）
  - [☕️SpringMVC](https://github.com/GeJinTaiHua/Learn-SpringMVC)
+ [☕️Hibernate](https://github.com/GeJinTaiHua/Learn-Hibernate)
  - ORM（对象关系映射）
  - [MyBatis]
  
### 第三方库
+ [♻️JAXB](https://github.com/GeJinTaiHua/Learn-JAXB)：XML 节点元素和 JavaBean 相互转换工具。
+ [♻️Gson](https://github.com/GeJinTaiHua/Learn-Gson)：Josn 序列化与反序列化工具。
+ [📆SLF4J](https://github.com/GeJinTaiHua/Learn-SLF4J)：日志工具。
+ [👫STOMP](https://github.com/GeJinTaiHua/STOMP)：面向消息的简单文本协议。
+ [☁️REST](https://github.com/GeJinTaiHua/Learn-HTTP)：HTTP 协议的 GET，POST，DELETE ...
+ [🌐WebService](https://github.com/GeJinTaiHua/Learn-WebService)：一种跨编程语言和跨操作系统平台的远程调用技术。

### 中间件
+ RPC框架
  + [💥Dubbo](https://github.com/GeJinTaiHua/Learn-Dubbo)：一款高性能Java RPC框架。
+ MQ消息
  + [🚗RabbitMQ](https://github.com/GeJinTaiHua/Learn-RabbitMQ)：是一个在AMQP基础上完成的，可复用的企业消息系统。他遵循Mozilla Public License开源协议。
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
  + Kubernetes
+ 分布式缓存
  + Redis
  + MemCache
  + EhCache 

### 关键字
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

#### static
+ 静态方法
  + 不依赖于任何对象就可以进行访问；
  + 在静态方法中不能访问类的非静态成员方法/变量；
  + 在非静态成员方法中可以访问静态成员方法/变量。
+ 静态变量
  + 被所有的对象所共享，在内存中只有一个副本；
  + 当且仅当在类初次加载时会被初始化。
+ 静态代码块
  + 优化程序性能；
  + 可以置于类中的任何地方，可以有多个static块；
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
+ 静态内部类
```
public class TestInnerClass{
   public static final class Builder {
        private Integer id;
   }
}
```
+ 静态导包
  + import static 代替 import；
  + 导入这个类里的静态方法。

#### Exception
+ Error：编译和系统的错误，不允许捕获；如：Java环境错误，文件丢失，服务器异常，配置错误等导致。
+ Exception：标准Java库方法所激发的异常。
  + Runtime_Exception：运行异常类，如：算数异常（如被0除）、下标异常（如数组越界）等。
  + Non_RuntimeException：非运行异常类
+ 常见异常
  + NullPointerException（空指针异常）
  + ClassCastException（类型强制转换异常）
  + ArrayIndexOutOfBoundsException（数组下标越界异常）
  + ArithmeticException（算术运算异常）
  + NumberFormatException（数字格式异常）

#### synchronized
+ 代码块（同步语句块）
  + 作用的范围是大括号{}括起来的代码；
  + 作用的对象是调用这个代码块的对象；
```
public class SyncThread implements Runnable {
   private static int count;

   public void run() {
      synchronized(this) {
         for (int i = 0; i < 5; i++) {
            // todo
         }
      }
   }
}
```
  1) 一个线程访问一个对象中的synchronized(this)同步代码块时，其他试图访问该对象的线程将被阻塞；
  2) 当一个线程访问对象的一个synchronized(this)同步代码块时，另一个线程仍然可以访问该对象中的非synchronized(this)同步代码块。

+ 方法（同步方法）
  + 作用的范围是整个方法；
  + 作用的对象是调用这个方法的对象；
```
public synchronized void method()
{
   // todo
}
```
  1) synchronized关键字不能继承；
  2) 在定义接口方法时不能使用synchronized关键字；
  3) 构造方法不能使用synchronized关键字，但可以使用synchronized代码块来进行同步。

+ 静态的方法
  + 作用的范围是整个静态方法；
  + 作用的对象是这个类的所有对象；
```
public synchronized static void method() {
   // todo
}
```
  1) 静态方法是属于类的而不属于对象的。同样的，synchronized修饰的静态方法锁定的是这个类的所有对象。

+ 类
  + 作用的范围是synchronized后面括号括起来的部分；
  + 作用主的对象是这个类的所有对象；
```
public class ClassName {
   public void method() {
      synchronized(ClassName.class) {
         // todo
      }
   }
}
```
 1) synchronized作用于一个类T时，是给这个类T加锁，T的所有对象用的是同一把锁。

#### switch...case...default...
+ switch(A)
  + A的取值只能是整型或者可以转换为整型的数值类型，比如byte、short、int、char、还有枚举；
  + JDK1.7之后，A的取值也支持String了；
+ case B:C
  + 常量表达式；B的取值只能是常量（需要定义一个final型的常量）或者int、byte、short、char、String；
+ default
  + 没有符合的case就执行它;
  + 并不是必须的。
```
// 运行结果输出：default
    int i = 6;
    switch(i){
    case 0:
    	System.out.print("0");
    case 1:
    	System.out.print("1");
    case 2:
    	System.out.print("2");
    default:
    	System.out.print("default");
    }
```
```
// 运行结果输出：2 3
    int i = 2;
    switch(i){
    case 0:
    	System.out.print("0");
    case 1:
    	System.out.print("1");
    case 2:
    	System.out.print("2");
    case 3:
    	System.out.print("3");break;
    default:
    	System.out.print("default");
    }
```

#### transient 
+ 序列化
  + 通过在运行时判断类的 serialVersionUID 来验证版本一致性；
  + serialVersionUID 生成方式：
    1) 默认的1L；
    2) 根据类名、接口名、成员方法以及属性等来生成一个64位的Hash字段。
  + Serializable接口：所有的序列化会自动进行；
  + Externalizable接口：没有任何东西可以自动序列化，需要在writeExternal方法中进行手工指定所要序列化的变量，这与是否被transient修饰无关。
```
public class User extends BaseRequest implements Serializable {
	      private static final long serialVersionUID = 1L;
       ... ...
```
+ transient：不需要序列化的属性。
  + 只能修饰变量，不能修饰方法和类；
  + 一个静态变量不管是否被transient修饰，均不能被序列化。反序列化后类中static型变量的值为当前JVM中对应static变量的值。

#### Overload、Override
+ Overload（重载）：一个类中多态性的表现；
+ Override（重写）：父类和子类多态性的表现；
![重载重写](http://www.runoob.com/wp-content/uploads/2013/12/overloading-vs-overriding.png)

#### Thread、Runnable
+ Thread（类）
  + start()：启动一个线程，这时此线程处于就绪（可运行）状态；
  + run()：只是类的一个普通方法而已。
  + 缺点：
    1) 每次通过new Thread()创建对象性能不佳；
    2) 线程缺乏统一管理，可能无限制新建线程，相互之间竞争，及可能占用过多系统资源导致死机或oom；
    3) 缺乏更多功能，如定时执行、定期执行、线程中断。
+ Runnable（接口）
  + 避免继承的局限，一个类可以继承多个接口；
  + 适合于资源的共享，节约资源。
```
public class Thread1 extends Thread{
    @Override
    public void run() {
        System.out.println("extend thread");
    }
}
public class Thread2 implements Runnable{
    public void run() {
        System.out.println("runbale interfance");   
    }    
}
public static void main(String[] args) {
        new Thread1().start();
	new Thread1().start();
	
	Thread2 thread2 = new Thread2()；
        new Thread(thread2).start();
	new Thread(thread2).start();
}
```
+ 线程池
  + newCachedThreadPool：可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程。
  + newFixedThreadPool：创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待。 
  + newScheduledThreadPool：创建一个定长线程池，支持定时及周期性任务执行。 
  + newSingleThreadExecutor：创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行。

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

### 基础知识
#### 四种引用
+ 强引用：是指创建一个对象并把这个对象赋给一个引用变量。
  + 强引用有引用变量指向时永远不会被垃圾回收，JVM宁愿抛出OutOfMemory错误也不会回收这种对象；
  + 想中断强引用和某个对象之间的关联，可以显式地将引用赋值为null。
```
Object object =new Object();
String str ="hello";
```
+ 软引用（SoftReference）：
  + 内存空间足够，垃圾回收器就不会回收它；
  + 可用来实现内存敏感的高速缓存,比如网页缓存、图片缓存等。使用软引用能防止内存泄露，增强程序的健壮性。   
+ 弱引用（WeakReference）：
  + 当JVM进行垃圾回收时，无论内存是否充足，都会回收被弱引用关联的对象。
+ 虚引用（PhantomReference）：
  + 并不影响对象的生命周期。

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

#### Stream API
Stream 是对集合（Collection）对象功能的增强，它专注于对集合对象进行各种非常便利、高效的聚合操作（aggregate operation），或者大批量数据操作 (bulk data operation)。
+ 聚合操作
```
List<Integer> transactionsIds = transactions.parallelStream().
  filter(t -> t.getType() == Transaction.GROCERY).
  sorted(comparing(Transaction::getValue).reversed()).
  map(Transaction::getId).
  collect(toList());
```
+ 流
![流管道 (Stream Pipeline) 的构成](https://www.ibm.com/developerworks/cn/java/j-lo-java8streamapi/img001.png)
  + 生成 Stream Source
    1) 

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
![集合](http://img.blog.csdn.net/20160706172512559?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQv/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/Center)
##### Collection
+ List
  1) ArrayList
     + 底层数据结构是数组；
     + 查询快，增删慢；
     + 线程不安全，效率高；
     + CopyOnWriteArrayList（CopyOnWrite）：写时拷贝；java.util.concurrent包。
  2) LinkedList
     + 底层数据结构是链表；
     + 查询慢，增删快；
     + 线程不安全，效率高。
  3) Vector（淘汰）
     + 底层数据结构是数组；
     + 查询快，增删慢；
     + 线程安全，效率低；
+ Set
  1) HashSet
     + 底层采用哈希表；
     + 无序；
     + 非线程安全；
     + linkedHashSet：有序；
  2) TreeSet
     + 底层使用红黑树算法，擅长于范围查询；
     + 有序；
     + 非线程安全；
  3) 线程安全：Set set = Collections.synchronizedSet(set 对象)。
    
##### Map 
1) HashMap：
   + 哈希表算法；
   + 非线程安全。； 
![链表散列](https://images0.cnblogs.com/blog/381060/201401/152128351581.png)
   + linkedHashMap：链表和哈希表算法。
2) Hashtable（淘汰）
   + 哈希表算法；
   + 线程安全；
   + 多线程下效率低下。
   + ConcurrentHashMap
     + 锁分离（JDK1.8放弃）：在HashMap的基础上，将数据分段存储，ConcurrentHashMap由多个Segment组成，每个Segment都有把锁。
     + CAS算法：如果valueOffset位置包含的值与expect值相同，则更新valueOffset位置的值为update，并返回true，否则不更新，返回false。
3) SortedMap  
   + TreeMap：红黑树算法；有序。

##### fail-fast、fail-safe
+ fail-fast（快速失败）
  + 当你在迭代一个集合的时候，如果有另一个线程正在修改你正在访问的那个集合时，就会抛出一个 ConcurrentModification 异常；
  + 在 java.util 包下的都是快速失败。
+ fail-safe（安全失败）
  + 你在迭代的时候会去底层集合做一个拷贝，所以你在修改上层集合的时候是不会受影响的，不会抛出 ConcurrentModification 异常；
  + 在 java.util.concurrent 包下的全是安全失败的。
  
#### java.util.concurrent
专为 Java并发编程而设计的包。转发：https://www.xmind.net/m/tJy5/
1) locks部分：显式锁(互斥锁和速写锁)相关；
```
Lock lock = new ReentrantLock();  
lock.lock();  
//critical section  
lock.unlock();
```
   + Lock：一个类似于 synchronized 块的线程同步机制接口。但是 Lock 比 synchronized 块更加灵活、精细。
     + ReentrantLock
   + ReadWriteLock：读写锁一种先进的线程锁机制。
     + ReentrantReadWriteLock
2) atomic部分：原子变量类相关，是构建非阻塞算法的基础；
3) executor部分：线程池相关；
   + ExecutorService
     + ScheduledThreadPoolExecutor：通过 Executors.newScheduledThreadPool(10)创建的
     + ThreadPoolExecutor: 除了第一种的其他三种方式创建的
   + ThreadPoolExecutor：使用其内部池中的线程执行给定任务(Callable 或者 Runnable)。
   + ForkJoinPool
4) collections部分：并发容器相关；
   + BlockingQueue：此接口是一个线程安全的 存取实例的队列。  
     + ArrayBlockingQueue：数组阻塞队列
     + DelayQueue：延迟队列
     + LinkedBlockingQueue：链阻塞队列
     + PriorityBlockingQueue： 具有优先级的阻塞队列
     + SynchronousQueue：同步队列
   + BlockingDeque：此接口表示一个线程安全放入和提取实例的双端队列。
     + LinkedBlockingDeque：链阻塞双端队列
   + ConcurrentMap：一个能够对别人的访问(插入和提取)进行并发处理的 java.util.Map接口。
     + ConcurrentHashMap
     + ConcurrentNavigableMap
5) tools部分：同步工具相关，如信号量、闭锁、栅栏等功能；
   + CountDownLatch：是一个并发构造，它允许一个或多个线程等待一系列指定操作的完成。
   + CyclicBarrier：是一种同步机制，它能够对处理一些算法的线程实现同步。
   + Exchanger：表示一种两个线程可以进行互相交换对象的会和点。
   + Semaphore：是一个计数信号量。acquire()、release()
     + 保护一个重要(代码)部分防止一次超过 N 个线程进入。
     + 在两个线程之间发送信号。
  
### JVM
#### JVM 类加载机制
![类加载](http://incdn1.b0.upaiyun.com/2017/06/2fb054008ca2898e0a17f7d79ce525a1.png)
+ 加载阶段：查找和导入Class文件。
  + 类加载器
    - 启动类加载器（Bootstrap ClassLoader）
    - 扩展类加载器（Extension ClassLoader）
    - 应用程序类加载器（Application ClassLoader）：程序默认的类加载器
+ 验证阶段：检查载入Class文件数据的正确性；
+ 准备阶段：给类的静态变量分配存储空间；
+ 解析阶段：将符号引用转成直接引用；
+ 初始化阶段：对类的静态变量，静态代码块执行初始化操作。
+ 类的实例化顺序
  1) 父类静态变量；
  1) 父类静态代码块；
  2) 子类静态变量；
  2) 子类静态代码块；
  3) 父类非静态变量；
  3) 父类构造函数；
  4) 子类非静态变量；
  4) 子类构造函数。

#### JVM 内存模型
![JVM 内存模型](https://images2017.cnblogs.com/blog/720994/201711/720994-20171111163050263-549527776.png)
+ 方法区：用于存储已被虚拟机加载的类信息、常量、静态变量、即时编译器编译后的代码等数据（JDK1.8 元数据区取代了永久代）。
  - 运行时常量池：存放编译期生成的各种字面量和符号引用。
+ 虚拟机栈：为虚拟机执行 Java 方法（也就是字节码）服务。
+ 本地方法栈：为虚拟机使用到的 Native 方法服务。
+ 堆：用来存放对象实例。
+ 程序计数器：这里记录了线程执行的字节码的行号，在分支、循环、跳转、异常、线程恢复等都依赖这个计数器。

#### 垃圾收集算法
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


#### 垃圾收集器
+ 垃圾收集器组合
  + 新生代收集器
    1) Serial：Serial（串行）垃圾收集器是最基本、发展历史最悠久的收集器。
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
         + 吞吐量=运行用户代码时间/（运行用户代码时间+垃圾收集时间）
  + 老年代收集器
    1) Serial Old：Serial收集器的老年代版本。
       + 采用"标记-整理"算法（还有压缩，Mark-Sweep-Compact）；
       + 单线程收集。
    2) Parallel Old：Parallel Scavenge收集器的老年代版本。
       + 采用"标记-整理"算法；
       + 多线程收集；
    3) CMS：也称为并发低停顿收集器（Concurrent Low Pause Collector）或低延迟（low-latency）垃圾收集器。
       + 基于"标记-清除"算法(不进行压缩操作，产生内存碎片)；           
       + 以获取最短回收停顿时间为目标；
       + 并发收集、低停顿；
       + 需要更多的内存。
  + 整堆收集器
    1) G1：JDK7-u4才推出商用的收集器。
       + 可以并行来缩短"Stop The World"停顿时间；也可以并发让垃圾收集与用户程序同时进行；
       + 分代收集，收集范围包括新生代和老年代；
       + 结合多种垃圾收集算法，空间整合，不产生碎片；
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



