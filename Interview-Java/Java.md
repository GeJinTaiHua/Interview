## ☕️Java
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-1.5.13-brightgreen.svg)
![build passing](https://img.shields.io/badge/build-passing-brightgreen.svg) 


  * [三大框架](#%E4%B8%89%E5%A4%A7%E6%A1%86%E6%9E%B6)
  * [第三方库](#%E7%AC%AC%E4%B8%89%E6%96%B9%E5%BA%93)
  * [中间件](#%E4%B8%AD%E9%97%B4%E4%BB%B6)
  * [关键字](#%E5%85%B3%E9%94%AE%E5%AD%97)
    * [8大基本类型](#8%E5%A4%A7%E5%9F%BA%E6%9C%AC%E7%B1%BB%E5%9E%8B)
    * [final](#final)
    * [static](#static)
    * [transient](#transient)
    * [Thread、Runnable](#threadrunnable)
    * [String、StringBuilder、StringBuffer](#stringstringbuilderstringbuffer)
  * [基础知识](#%E5%9F%BA%E7%A1%80%E7%9F%A5%E8%AF%86)
    * [java\.util包](#javautil%E5%8C%85)
    * [集合](#%E9%9B%86%E5%90%88)
    * [IO 与 NIO](#io-%E4%B8%8E-nio)
  * [JVM](#jvm)
    * [JVM 类加载机制](#jvm-%E7%B1%BB%E5%8A%A0%E8%BD%BD%E6%9C%BA%E5%88%B6)
    * [JVM 内存模型](#jvm-%E5%86%85%E5%AD%98%E6%A8%A1%E5%9E%8B)
    * [垃圾收集算法](#%E5%9E%83%E5%9C%BE%E6%94%B6%E9%9B%86%E7%AE%97%E6%B3%95)


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
  - [☕️SpringMVC](https://github.com/GeJinTaiHua/Learn-SpringMVC)
+ [☕️Hibernate](https://github.com/GeJinTaiHua/Learn-Hibernate)
  - ORM（对象关系映射）
  
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
  + Dubbox
  + Motan
+ MQ消息
  + [🚗RabbitMQ](https://github.com/GeJinTaiHua/Learn-RabbitMQ)：是一个在AMQP基础上完成的，可复用的企业消息系统。他遵循Mozilla Public License开源协议。
  + ActiveMQ
  + Kafka
+ 分布式协调服务
  + ZooKeeper 
  + Keepalived
  + Eureka
+ 配置管理
  + Apollo
+ 大数据
  + Hbase
  + Hadoop
  + Hive
  + Spark
  + Storm
+ 容器
  + Docker
  + Kubernetes
  + Mesos
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

#### final
+ 类
  + 表明这个类不能被继承。
  + final类中的所有成员方法都会被隐式地指定为final方法。
+ 方法
  + 把方法锁定，以防任何继承类修改它的含义；
  + 类的private方法会隐式地被指定为final方法。
+ 变量
  + 基本数据类型：数值一旦在初始化之后便不能更改；
  + 引用类型：在对其初始化之后便不能再让其指向另一个对象。	
  
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

#### Thread、Runnable
+ Thread（类）
  + start()：启动一个线程，这时此线程处于就绪（可运行）状态；
  + run()：只是类的一个普通方法而已。
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

### 基础知识
#### java.util包
+ Comparator：比较接口
+ Iterator：迭代接口
  + Iterator：存在于 java.util 包中，核心的方法next()，hasnext()，remove()。
  ```
	List list = new ArrayList(); //产生一个 List 集合，典型实现为 ArrayList。
	list.add("a");
	list.add("b");
	list.add("c");
	Iterator it = list.iterator(); //构造 List 的迭代器
	while(it.hasNext()){ //通过迭代器遍历元素
	    Object obj = it.next();
	    System.out.println(obj);
	}
  ```
  + Iterable:存在于 java.lang 包中，里面封装了 Iterator 接口。所以只要实现了Iterable接口的类，就可以使用Iterator迭代器了。
+ AbstractXXX：骨架类，核心代码实现
+ 集合、数组

#### 集合
+ [Collection](/Interview-Java/src/test/java/基本数据类型/Collection.java)
  - List：有序，可以重复的集合。
    + ArrayList：底层数据结构是数组。查询快，增删慢；线程不安全，效率高；
      +  CopyOnWriteArrayList（CopyOnWrite）：写时拷贝；java.util.concurrent包。
    + Vector（淘汰）：底层数据结构是数组。查询快，增删慢；线程安全，效率低；
    + LinkedList：底层数据结构是链表。查询慢，增删快；线程不安全，效率高。
  - Set：不可重复的集合。
    + HashSet：底层采用哈希表。无序；非线程安全；
    + linkedHashSet：底层采用链表和哈希表。有序；非线程安全；
    + TreeSet：底层使用红黑树算法，擅长于范围查询。有序；非线程安全；
    + 线程安全：Set set = Collections.synchronizedSet(set 对象)。
+ [Map](/Interview-Java/src/test/java/基本数据类型/Map.java)：key-value 的键值对，key 不允许重复，value 可以。
  - HashMap：哈希表算法。非线程安全。
  - linkedHashMap：链表和哈希表算法。
  - Hashtable（淘汰）：哈希表算法。线程安全；多线程下效率低下。
    + ConcurrentHashMap
      + 锁分离（JDK1.8放弃）：在HashMap的基础上，将数据分段存储，ConcurrentHashMap由多个Segment组成，每个Segment都有把锁。
      + CAS算法：如果valueOffset位置包含的值与expect值相同，则更新valueOffset位置的值为update，并返回true，否则不更新，返回false。
  - SortedMap  
    + TreeMap：红黑树算法。有序。
![集合](http://img.blog.csdn.net/20160706172512559?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQv/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/Center)

+ fail-fast（快速失败）
  + 当你在迭代一个集合的时候，如果有另一个线程正在修改你正在访问的那个集合时，就会抛出一个 ConcurrentModification 异常；
  + 在 java.util 包下的都是快速失败。
+ fail-safe（安全失败）
  + 你在迭代的时候会去底层集合做一个拷贝，所以你在修改上层集合的时候是不会受影响的，不会抛出 ConcurrentModification 异常；
  + 在 java.util.concurrent 包下的全是安全失败的。

#### IO 与 NIO
+ 管道（Channel）：实际上就像传统IO中的流，到任何目的地(或来自任何地方)的所有数据都必须通过一个 Channel 对象。一个 Buffer 实质上是一个容器对象。
+ 选择器（Selector）：用于监听多个管道的事件，使用传统的阻塞IO时我们可以方便的知道什么时候可以进行读写，而使用非阻塞通道，我们需要一些方法来知道什么时候通道准备好了，选择器正是为这个需要而诞生的。

IO|NIO
---|---
面向流|面向缓冲
阻塞IO|非阻塞IO
无|选择器

+ 推荐 [🔘NIO](https://github.com/GeJinTaiHua/Learn-IO)
  + 大量的连接。
  + 连接每次发送少量的数据。
  + 聊天服务器。
+ 推荐 [🔘IO](https://github.com/GeJinTaiHua/Learn-IO)
  + 少量的连接。
  + 连接每次要发送大量的数据。
  + 流的分类
<table>
    <tr>
        <td >\</td> 
        <td >字节流</td> 
        <td >字符流</td> 
    </tr>
    <tr>
        <td >输入流</td> 
        <td >InputStream（字节输入流）</td> 
        <td >Reader（字符输入流）</td> 
    </tr>  
    <tr>
        <td >输出流</td> 
        <td >OutputStream（字节输出流）</td> 
        <td >Writer（字符输出流）</td> 
    </tr>
    <tr>
        <td rowspan=2>缓冲流</td> 
        <td >BufferedInputStream</td> 
        <td >BufferedReader</td> 
    </tr> 
    <tr>
        <td >BufferedOutputStream（字节缓冲流）	</td> 
        <td >BufferedWriter（字符缓冲流）</td> 
    </tr> 
    <tr>
        <td rowspan=2>转换流</td> 
        <td colspan=2>InputStreamReader（把字节输入流转换为字符输入流）</td> 
    </tr> 
    <tr>
        <td colspan=2>OutputStreamWriter（把字节输出流转换为字符输出流）</td>
    </tr> 
    <tr>
        <td rowspan=4>内存流</td> 
        <td >ByteArrayInputStream</td> 
        <td >CharArrayReader</td> 
    </tr>
    <tr>
        <td >ByteArrayOutputStream（字节内存流）</td> 
        <td >CharArrayWriter（字符内存流）</td> 
    </tr>
    <tr>
        <td rowspan=2></td> 
        <td >StringReader</td> 
    </tr>
    <tr>
        <td >StringWriter（字符串流）</td> 
    </tr>
    <tr>
        <td rowspan=2>对象流</td> 
        <td colspan=2>ObjectInputStream（反序列化）</td> 
    </tr>
    <tr>
        <td colspan=2>ObjectOutputStream（序列化）</td> 
    </tr>
    <tr>
        <td rowspan=2>数据流</td> 
        <td colspan=2>DataInput（从二进制流读取字节并从其中重建任何Java原语类型的数据）</td> 
    </tr>
    <tr>
        <td colspan=2>DataOutput（将数据从任何Java基本类型转换为一系列字节）</td> 
    </tr>
</table>

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







