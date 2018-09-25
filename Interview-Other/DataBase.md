## 💾数据库


  * [常用数据库](#%E5%B8%B8%E7%94%A8%E6%95%B0%E6%8D%AE%E5%BA%93)
    * [Redis](#redis)
  * [关键字](#%E5%85%B3%E9%94%AE%E5%AD%97)
    * [count(1) count(主键) count(\*)](#count1-count%E4%B8%BB%E9%94%AE-count)
    * [Limit](#limit)
  * [基础知识](#%E5%9F%BA%E7%A1%80%E7%9F%A5%E8%AF%86)
    * [三大范式](#%E4%B8%89%E5%A4%A7%E8%8C%83%E5%BC%8F)
    * [五大约束](#%E4%BA%94%E5%A4%A7%E7%BA%A6%E6%9D%9F)
  * [事务](#%E4%BA%8B%E5%8A%A1)
    * [不考虑隔离性的安全性问题](#%E4%B8%8D%E8%80%83%E8%99%91%E9%9A%94%E7%A6%BB%E6%80%A7%E7%9A%84%E5%AE%89%E5%85%A8%E6%80%A7%E9%97%AE%E9%A2%98)
    * [4大特性（ACID）](#4%E5%A4%A7%E7%89%B9%E6%80%A7acid)
    * [5种事务隔离级别](#5%E7%A7%8D%E4%BA%8B%E5%8A%A1%E9%9A%94%E7%A6%BB%E7%BA%A7%E5%88%AB)
  * [优化](#%E4%BC%98%E5%8C%96)
    * [切分技巧](#%E5%88%87%E5%88%86%E6%8A%80%E5%B7%A7)
    * [SQL 一些小技巧](#sql-%E4%B8%80%E4%BA%9B%E5%B0%8F%E6%8A%80%E5%B7%A7)
    * [索引](#%E7%B4%A2%E5%BC%95)
  * [缓存](#%E7%BC%93%E5%AD%98)


### 常用数据库
+ MySQL 
+ Microsoft SQL Server
+ MongoDB 
+ Redis
+ Oracle
+ Microsoft Access

#### Redis
基于内存的采用的【单进程单线程】模型的KV数据库，由C语言编写。
+ 为什么快
  + 完全基于内存；
  + 数据结构简单，对数据操作也简单；
  + 采用单线程；
  + 使用多路 I/O 复用模型，非阻塞IO；
  + 底层模型：Redis直接自己构建了VM 机制；
+ 数据结构
  + String
  + Hash
  + List
  + Set
  + Zset

### 关键字
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

### 事务
#### 不考虑隔离性的安全性问题
+ 脏读：一个事务读到了另一个事务的未提交的数据；
+ 不可重复读：一个事务读到了另一个事务已经提交的 update 的数据导致多次查询结果不一致；
+ 虚幻读：一个事务读到了另一个事务已经提交的 insert 的数据导致多次查询结果不一致。

#### 4大特性（ACID）
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
![隔离级别](https://images2015.cnblogs.com/blog/1053956/201703/1053956-20170313102548791-1506111244.png)

### 优化
#### 切分技巧
+ 垂直拆分：把表按模块划分到不同数据库表中。
+ 水平拆分：把一个表按照某种规则（时间、用户...）把数据划分到不同表或数据库里。

#### SQL 一些小技巧
+ 根据已有的表创建新表
```
create table tab_new like tab_old 
```
```
create table tab_new as select col1,col2… from tab_old definition only
```
+ 复制表（只复制结构）
```
select * into tab_new from tab_old where 1<>1（仅用于SQlServer）
```
```
select top 0 * into tab_new from tab_old
```
+ 删除重复记录
```
delete from tablename where id not in (select max(id) from tablename group by col1,col2,...)（推荐）
```
```
select distinct * into temp from tablename
delete from tablename
insert into tablename select * from temp
```
+ 随机取出10条数据
```
select top 10 * from tablename order by newid()
```
+ 分组查询每组前三
```
select t3.id,t3.country,t3.score 
from (select t1.*, (select count(*) 
                    from tb_score t2 
                    where t1.score<=t2.score and t1.country=t2.country) as rownum 
      from tb_score t1) t3 
where rownum <=3 order by country,score DESC;
```
```
select a.id,a.country,a.name,a.score 
from tb_score a 
where exists 
      (select count(*) 
       from tb_score 
       where country = a.country and score > a.score having Count(*) < 3)
order by a.country,score DESC;
```
```
 select a.id,a.country,a.name,a.score 
 from tb_score a 
 where 
      (select count(*) 
       from tb_score 
       where country = a.country and score > a.score )<3
 order by a.country,score DESC;
```

#### 索引
+ 使用时机
  + 经常出现在 group by,order by 和 distinc 关键字后面的字段；
  + 经常与其他表进行连接的表，在连接字段上应该建立索引；
  + 经常出现在 Where 子句中的字段；
  + 经常出现用作查询选择的字段。
  
### 缓存
+ 缓存穿透
  + 查询一个一定不存在的数据，由于缓存是不命中时需要从数据库查询，查不到数据则不写入缓存，这将导致这个不存在的数据每次请求都要到数据库去查询；
  + 解决办法：
    1) 布隆过滤器，对所有可能查询的参数以hash形式存储，在控制层先进行校验，不符合则丢弃；
    2) 如果一个查询返回的数据为空，我们仍然把这个空结果进行缓存，但它的过期时间会很短，最长不超过五分钟。
+ 缓存雪崩
  + 如果缓存集中在一段时间内失效，发生大量的缓存穿透，所有的查询都落在数据库上，造成了缓存雪崩;
  + 解决方法：
    1) 在缓存失效后，通过加锁或者队列来控制读数据库写缓存的线程数量；
    2) 通过缓存reload机制，预先去更新缓存，在即将发生大并发访问前手动触发加载缓存；
    3) 不同的key，设置不同的过期时间，让缓存失效的时间点尽量均匀；
    4) 做二级缓存，或者双缓存策略。


