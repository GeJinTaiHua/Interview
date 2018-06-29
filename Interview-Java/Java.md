### 一、代码目录
+ /Interview-Java/src/test/java 
+ /Interview-Java/src/main/java/www/wjl/com/Interview

### 二、知识点
[10 个有关 String 的面试问题](https://mp.weixin.qq.com/s/uaytl6QKKTqLitvXxlcU2g)  
[面试的角度诠释 Java工程师（1）](https://mp.weixin.qq.com/s?__biz=MjM5NzMyMjAwMA==&mid=2651479600&idx=1&sn=7f310d3fe836232e72491e595ffbaa1f&chksm=bd25324f8a52bb59863fa0c133e6d381def118bed4d820ef523afb12ec62bac8d508202da214&mpshare=1&scene=1&srcid=061265cmoVaAepudXykwsdN6#rd)  
[面试的角度诠释 Java工程师（2）](https://mp.weixin.qq.com/s?__biz=MjM5NzMyMjAwMA==&mid=2651479604&idx=1&sn=2a4d352795d60297e236dc4d06b59a04&chksm=bd25324b8a52bb5d87856ceb2dc0e5338ab37c24da9f30297435f001ef43f1c49efc570e8606&mpshare=1&scene=1&srcid=0612FgwBictVHwxAhjHOc4ec#rd)  
[2017秋，阿里、京东、美团、滴滴面试案](https://mp.weixin.qq.com/s/BGo3RY6JLFeg87hH3Y60KA)

### 三、基础问题
#### 3.1 集合
![集合](http://img.blog.csdn.net/20160706172512559?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQv/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/Center)

[30个Java集合面试问题及答案](https://mp.weixin.qq.com/s?__biz=MzAwNDE2NTgzNQ==&mid=2247484485&idx=1&sn=e25d097893b232403d74b2110e5b1fab&chksm=9b315de1ac46d4f72b703b2c85e57019b481bdcc59dc53447a27909d7b8f70f0ed1ee4854159&mpshare=1&scene=23&srcid=0608pXE8NxhkbmuVbGvu5Qpd#rd)  
[Java 集合框架面试问题集锦](https://mp.weixin.qq.com/s?__biz=MjM5NzMyMjAwMA==&mid=2651480544&idx=1&sn=7b853579f783bf6d4ade4a79ca2dee6c&chksm=bd250d9f8a5284898ba1ba298e4367956ba6c7a15c01597ae70c56f30b1e72982d7a7d764c73&mpshare=1&scene=1&srcid=0612q9YIyiWAjSrjP6mEZ2A9#rd)

### 四、JVM 
#### 4.1 JVM 类加载机制
![类加载](http://incdn1.b0.upaiyun.com/2017/06/2fb054008ca2898e0a17f7d79ce525a1.png)
+ 1）加载：在加载阶段，虚拟机主要完成以下3件事：
   - 通过一个类的全限定名来获取定义此类的二进制字节流；
   - 将这个字节流所代表的静态存储结构转化为方法区的运行时数据结构；
   - 在内存中生成一个代表这个类的java.lang.Class对象，作为方法区这个类的各种数据访问入口。
+ 2）验证  
   - 文件格式验证：验证字节流是否符合Class文件格式的规范，并且能被当前版本的虚拟机处理；
   - 元数据验证：对字节码描述的信息进行语义分析，以保证其描述的信息符合Java语言的规范的要求；
   - 字节码验证：通过数据流和控制流分析，确定程序语法是否是合法的，符合逻辑的；
  + 符号引用验证：对类自身以外的信息进行匹配性校验。
+ 3）准备：正式为[类变量]分配内存并设置变量初始值的阶段，这些变量所使用的内存都将在方法区中进行分配，记住，只为类变量分配内存，不包括实例变量，实例变量将会在对象实例化时随对象一起分配在java堆中。如果类字段的字段属性表中存在ConstantValue属性，那么在准备阶段变量value就会被初始化为ConstantValue属性所指定的值。
+ 4）解析：虚拟机将常量池内的符号引用替换为直接引用的过程。
+ 5）初始化
+ 类加载器
  - 启动类加载器（Bootstrap ClassLoader）
  - 扩展类加载器（Extension ClassLoader）
  - 应用程序类加载器（Application ClassLoader）：一般情况下这个是程序默认的类加载器

#### 4.2 JVM 内存模型
![JVM 内存模型](http://img.blog.csdn.net/20150720152805765?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQv/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/Center)
+ 方法区：用于存储已被虚拟机加载的类信息、常量、静态变量、即时编译器编译后的代码等数据。（JDK1.8 元数据区取代了永久代）
  - 运行时常量池：存放编译期生成的各种字面量和符号引用。
+ 虚拟机栈：为虚拟机执行Java方法（也就是字节码）服务。
+ 本地方法栈：为虚拟机使用到的Native 方法服务。
+ 堆：用来存放对象实例。
+ 程序计数器：这里记录了线程执行的字节码的行号，在分支、循环、跳转、异常、线程恢复等都依赖这个计数器。
