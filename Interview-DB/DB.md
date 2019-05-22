## 💾数据库

  * [数据库](#数据库)
    * [常用数据库](#常用数据库)
    * [Redis](#redis)
    * [MongoDB](#mongodb)
  * [事务](#%E4%BA%8B%E5%8A%A1)
    * [3种并发问题](#3种并发问题)
    * [四大特性](#四大特性)
    * [5种事务隔离级别](#5%E7%A7%8D%E4%BA%8B%E5%8A%A1%E9%9A%94%E7%A6%BB%E7%BA%A7%E5%88%AB)
    * [加锁协议](#加锁协议)
    * [两/三阶段提交](#%E4%B8%A4%E4%B8%89%E9%98%B6%E6%AE%B5%E6%8F%90%E4%BA%A4)
  * [缓存](#%E7%BC%93%E5%AD%98)
    * [缓存穿透](#%E7%BC%93%E5%AD%98%E7%A9%BF%E9%80%8F)
    * [缓存雪崩](#%E7%BC%93%E5%AD%98%E9%9B%AA%E5%B4%A9)
  * [优化](#%E4%BC%98%E5%8C%96)
    * [数据库优化](#%E6%95%B0%E6%8D%AE%E5%BA%93%E4%BC%98%E5%8C%96)
    * [数据库切分](#数据库切分)
    * [计数器表](#%E8%AE%A1%E6%95%B0%E5%99%A8%E8%A1%A8)
    * [SQL技巧](#SQL技巧)
  * [基础知识](#%E5%9F%BA%E7%A1%80%E7%9F%A5%E8%AF%86)
    * [三大范式](#%E4%B8%89%E5%A4%A7%E8%8C%83%E5%BC%8F)
    * [五大约束](#%E4%BA%94%E5%A4%A7%E7%BA%A6%E6%9D%9F)
    * [索引](#%E7%B4%A2%E5%BC%95)
    * [count(1) count(主键) count(\*)](#count1-count%E4%B8%BB%E9%94%AE-count)
    * [Limit](#limit)
    * [Select For update](#select-for-update)

### 数据库
#### 常用数据库
+ [Oracle](https://www.oracle.com/cn/index.html)
+ [MySQL](https://www.mysql.com/)
+ [Microsoft SQL Server]()
+ [PostgreSQL](https://www.postgresql.org/)
+ [MongoDB](https://www.mongodb.com/)
+ [Redis](https://redis.io/)
+ Microsoft Access

#### Redis
基于内存的采用的【单进程单线程】模型的KV数据库，由C语言编写。
+ 为什么快
  + 完全基于内存；
  + 单线程避免了多线程的频繁上下文切换问题；
  + 基于非阻塞的IO多路复用机制；
  + 数据结构简单，对数据操作也简单；
  + 底层模型：Redis直接自己构建了VM机制；
+ 数据结构
  + String：缓存、限流、计数器、分布式锁、分布式Session
    + 底层实现：int、raw、embstr
    + embstr：<=39字节的字符串时使用；
    + int：8个字节的长整型时使用；
    + raw：<39个字节的字符串时使用。
  + Hash：存储用户信息、用户主页访问量、组合查询
    + 底层实现：ziplist（压缩列表）或者hashtable（字典或者也叫哈希表）
  + List：微博关注人时间轴列表、简单队列
    + 底层实现：quicklist（快速列表，是ziplist 压缩列表 和linkedlist 双端链表 的组合）
    + linkedlist（双端链表）
    + ziplist（压缩列表）:当一个列表键只包含少量列表项，且是小整数值或长度比较短的字符串时使用；
  + Set：赞、踩、标签、好友关系
    + 底层实现：intset（整数集合）或者hashtable（字典或者也叫哈希表）
  + Zset：排行榜
    + 底层实现：ziplist（压缩列表）或者skiplist（跳跃表）
  
![](https://mmbiz.qpic.cn/mmbiz_png/eZzl4LXykQy8y3RicnZarvIuaS7K29Yh9gN6bpoI2kslO06oXCTP23Iv9RqvX5trhu8L1hpaz1UVAmibtNj1r0Ag/640?wx_fmt=png&tp=webp&wxfrom=5&wx_lazy=1&wx_co=1)
![数据建模](https://mmbiz.qpic.cn/mmbiz_png/eZzl4LXykQy8y3RicnZarvIuaS7K29Yh9SdNiaqQLhXqicly18gTw8yITomaeUr3kib3rCV1As2c5sjnqOvhLSrE2Q/640?wx_fmt=png&tp=webp&wxfrom=5&wx_lazy=1&wx_co=1)
  
#### MongoDB
+ 数据库（database）
+ 集合（collection）
+ 文档对象（document）

![优势](https://img-blog.csdn.net/20170209135023925?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvbGluZmVubGlhbmc=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)
![劣势](https://img-blog.csdn.net/20170209135035046?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvbGluZmVubGlhbmc=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

### 事务
#### 3种并发问题
+ 脏读：一个事务读到了另一个事务的未提交的数据；
+ 不可重复读：一个事务读到了另一个事务已经提交的 update 的数据导致多次查询结果不一致；
+ 虚幻读：一个事务读到了另一个事务已经提交的 insert 的数据导致多次查询结果不一致。

#### 四大特性
+ 原子性（Atomicity）：一个事务是一个不可分割的工作单位，事务中的所有操作，要么全部完成，要么全部不完成；
+ 一致性（Consistency）：对数据完整性约束的遵循；
+ 隔离性（Isolation）：一个事务的执行不能被其他事务干扰；
+ 持久性（Durability）：一个事务一旦提交，它对数据库中数据的改变就应该是永久性的，即便是在数据库系统遇到故障的情况下也不会丢失提交事务的操作。

#### 5种事务隔离级别
+ DEFAULT 这是一个PlatfromTransactionManager默认的隔离级别，使用数据库默认的事务隔离级别；
  + MySQL默认：可重复读
  + Oracle默认：已提交读
  + SQL Server默认：已提交读
+ 未提交读（read uncommited）：脏读，不可重复读，虚读都有可能发生；
+ 已提交读（read commited）：避免脏读。但是不可重复读和虚读有可能发生；
+ 可重复读（repeatable read）：避免脏读和不可重复读.但是虚读有可能发生；
+ 串行化的（serializable）：避免以上所有读问题。  

---|脏读|不可重复读|幻读|加锁协议|
---|---|---|---|---|
未提交读|✔️ |✔️ |✔️ |一级加锁协议|
已提交读|✖️ |✔️ |✔️ |二级加锁协议|
可重复读|✖️ |✖️ |✔️ |三级加锁协议|
串行化的|✖️ |✖️ |✖️ |两段锁协议|

#### 加锁协议
1) 一级加锁协议：
   + 事务在修改数据前必须加X锁，直到事务结束（事务结束包括正常结束(COMMIT)和非正常结束(ROLLBACK)）才可释放；如果仅仅是读数据，不需要加锁。
   + 一级封锁协议可以防止丢失修改，并保证事务T是可恢复的。使用一级封锁协议可以解决丢失修改问题。
   + 在一级封锁协议中，如果仅仅是读数据不对其进行修改，是不需要加锁的，它不能保证可重复读和不读“脏”数据。
```
SELECT xxx FOR UPDATE;
UPDATE xxx;
```
 
2) 二级加锁协议：
   + 满足一级加锁协议，且事务在读取数据之前必须先加S锁，读完后即可释放S锁。
   + 二级封锁协议除防止了丢失修改，还可以进一步防止读“脏”数据。但在二级封锁协议中，由于读完数据后即可释放S锁，所以它不能保证可重复读。

3) 三级加锁协议：
   + 满足一级加锁协议，且事务在读取数据之前必须先加S锁，直到事务结束才释放。
   + 三级封锁协议除防止了丢失修改和不读“脏”数据外，还进一步防止了不可重复读。
   
+ 两段锁协议（2-phase locking）
  + 两段锁协议是指每个事务的执行可以分为两个阶段：生长阶段（加锁阶段）和衰退阶段（解锁阶段）。
    + 加锁阶段：在该阶段可以进行加锁操作。在对任何数据进行读操作之前要申请并获得S锁，在进行写操作之前要申请并获得X锁。加锁不成功，则事务进入等待状态，直到加锁成功才继续执行。
    + 解锁阶段：当事务释放了一个封锁以后，事务进入解锁阶段，在该阶段只能进行解锁操作不能再进行加锁操作。
  + 若并发执行的所有事务均遵守两段锁协议，则对这些事务的任何并发调度策略都是可串行化的；遵循两段锁协议的事务调度处理的结果是可串行化的充分条件，但是可串行化并不一定遵循两段锁协议。
  + 与防止死锁的一次封锁法的异同之处：一次封锁法要求每个事务必须一次将所有要使用的数据全部加锁，否则就不能继续执行，因此一次封锁法遵守两段锁协议；但是两段锁协议并不要求事务必须一次将所有要使用的数据全部加锁，因此遵守两段锁协议的事务可能发生死锁。
  
#### 两/三阶段提交
+ 2PC（two-phase commit protocol）：强一致、中心化的原子提交协议。中心化协调者节点（coordinator）和N个参与者节点（partcipant）。
  + 第一阶段：请求/表决阶段；
  + 第二阶段：提交/执行阶段。
+ 3PC：增加了CanCommit阶段，并引入了超时机制。
  + 第一阶段：CanCommit阶段；
  + 第二阶段：PreCommit阶段；
  + 第三阶段：DoCommit阶段。
+ TCC（Try-Confirm-Cancel）：补偿事务
  + Try阶段：主要是对业务系统做检测及资源预留；
  + Confirm阶段：确认执行业务操作；
  + Cancel阶段：取消执行业务操作。

### 缓存
#### 缓存穿透
+ 查询一个一定不存在的数据，由于缓存是不命中时需要从数据库查询，查不到数据则不写入缓存，这将导致这个不存在的数据每次请求都要到数据库去查询；
+ 解决办法：
  1) 布隆过滤器，对所有可能查询的参数以hash形式存储，在控制层先进行校验，不符合则丢弃；
  2) 如果一个查询返回的数据为空，我们仍然把这个空结果进行缓存，但它的过期时间会很短，最长不超过五分钟。
  
#### 缓存雪崩
+ 如果缓存集中在一段时间内失效，发生大量的缓存穿透，所有的查询都落在数据库上，造成了缓存雪崩;
+ 解决方法：
  1) 事前：redis 高可用，主从+哨兵，redis cluster，避免全盘崩溃。
  2) 事中：本地 ehcache 缓存 + hystrix 限流&降级，避免 MySQL 被打死。
  3) 事后：redis 持久化，一旦重启，自动从磁盘上加载数据，快速恢复缓存数据。

### 优化
#### 数据库优化
+ 选择合适的字段；尽量吧字段设置为not null，这样查询时不需要比较null；
+ 使用关联查询（left join on）代替子查询；
+ 使用联合查询（union）手动创建临时表；
+ 开启事务；
+ 使用外键保证数据的关联性；
+ 使用索引提高检索特定行的速度；

#### 数据库切分
+ 垂直拆分：把表按模块划分到不同数据库表中。
![垂直拆分](https://mmbiz.qpic.cn/mmbiz_jpg/4MXV7svuTWL5r9fPIGouhodOCQDdD6g8pSOgLOOgraTXACO6u3Mu5ItUMgZBHCr18kiaIw88HxXFk6Cykoj8QDA/640?wx_fmt=jpeg&tp=webp&wxfrom=5&wx_lazy=1&wx_co=1)

+ 水平拆分：把一个表按照某种规则（时间、用户...）把数据划分到不同表或数据库里。
  + 会将一段时间以前的数据归档，存放到类似HBase这种非关系型数据库中。
  + 非每个查询都能携带分库分表键：建立“异构索引表”，即采用异步机制将原表内的每次一创建或更新，都换一个维度保存一份完整的数据表或索引表，拿空间换时间。
![水平拆分](https://mmbiz.qpic.cn/mmbiz_jpg/4MXV7svuTWL5r9fPIGouhodOCQDdD6g8wbgYho10FyQRibfe08XUyicu8gsy3pfBsz7bvohx8yKC0S5VAFdNoVJw/640?wx_fmt=jpeg&tp=webp&wxfrom=5&wx_lazy=1&wx_co=1)

#### 计数器表
+ 只有一行，更新会串行执行
```
update table set cnt=cnt+1 limit 1;
```
+ 优化：可以加入100行，随机更新
```
update table set cnt=cnt+1 where id=RAND()*100 limit 1;
```
查询计数：
```
select sun(cnt) from table;
```

#### SQL技巧
+ [根据已有的表创建新表](/Interview-DB/SQL/skill.sql#L1)
+ [复制表（只复制结构）](/Interview-DB/SQL/skill.sql#L9)
+ [删除重复记录](/Interview-DB/SQL/skill.sql#L19)
+ [随机取出10条数据](/Interview-DB/SQL/skill.sql#L28)
+ [分组查询每组前三](/Interview-DB/SQL/skill.sql#L32)
+ [按数字大小排序String字段 str](/Interview-DB/SQL/skill.sql#L59)
  
### 基础知识
#### 三大范式
+ 第一范式（1NF）：
每一列都是不可分割的原子数据项；
+ 第二范式：
满足1NF后，要求表中的所有列，都必须依赖于主键，而不能有任何一列与主键没有关系（一个表只描述一件事情）；
+ 第三范式：
在2NF基础上，表中的每一列只能依赖于主键（在2NF基础上消除传递依赖）。

#### 五大约束
+ 主键约束（Primay Key Coustraint）：唯一性，非空性；  
```
alter table stuInfo
add constraint PK_stuNo primary key (stuNo)
```
+ 唯一约束（Unique Counstraint）：唯一性，可以空，但只能有一个；  
```
alter table stuInfo
add constraint UQ_stuID unique(stuID)
```
+ 检查约束 (Check Counstraint) ：对该列数据的范围、格式的限制（如：年龄、性别等）；  
```
alter table stuInfo
add constraint CK_stuAge check (stuAge between 15 and 40)
```
+ 默认约束 (Default Counstraint) ：该数据的默认值；  
```
alter table stuInfo
add constraint DF_stuAddress default (‘地址不详’) for stuAddress
```
+ 外键约束 (Foreign Key Counstraint) ：需要建立两表间的关系并引用主表的列。  
```
alter table stuInfo
add constraint FK_stuNo foreign key(stuNo)references stuinfo(stuNo)
```

#### 索引
+ 使用时机
  + 经常出现在 group by,order by 和 distinc 关键字后面的字段；
  + 经常与其他表进行连接的表，在连接字段上应该建立索引；
  + 经常出现在 Where 子句中的字段；
  + 经常出现用作查询选择的字段。
+ 单列索引
  + 多个单列索引在多条件查询时只会生效第一个索引；
+ 联合索引
  + 最左前缀原则：以最左边的为起点任何连续的索引都能匹配上；
  + 当创建(a,b,c)联合索引时，相当于创建了(a)单列索引，(a,b)联合索引以及(a,b,c)联合索引（a,c组合也可以，但实际上只用到了a的索引，c并没有用到！）。
+ 索引失效
  + where 子句中使用 != 、or 、<> 、函数操作，引擎将放弃使用索引而进行全表扫描；
  + 多列索引，不使用的第一部分，则不会使用索引；
  + 列类型是字符串，那一定要在条件中将数据使用引号引用起来，否则不会使用索引；
  + like的模糊查询以 % 开头，索引失效；
  + 如果MySQL估计使用全表扫描要比使用索引快，则不使用索引。

#### count(1) count(主键) count(\*)
+ count(1) 和 count(主键) 这两个只扫描主键Index就可以得到数据
+ count(\*) 是扫描表的
+ count(主键)>count(1)= count(\*)
+ count(ROWID) 这也是只扫描Index的，效率高

#### Limit 
+ LIMIT N,M：LIMIT首先要找查 N+M 行，然后从N行处，取M行。
+ 优化：让N变的尽可能的小或是不用
```
原查询：SELECT * FROM pw_gbook WHERE uid='48' ORDER BY postdate DESC LIMIT 1275480,20;
转换成：SELECT * FROM pw_gbook WHERE id>1275480 and uid='48' ORDER BY postdate DESC LIMIT 20;
```

#### Select For update
+ InnoDB 使用行锁定，BDB 使用页锁定，MyISAM 使用表锁；