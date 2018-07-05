## 💾数据库

### 范式
+ 第一范式（1NF）：
确保每一列的原子性。
+ 第二范式：
非键字段必须依赖于键字段。
+ 第三范式：
在1NF基础上，除了主键以外的其它列都不传递依赖于主键列，或者说任何非主属性不依赖于其它非主属性（在2NF基础上消除传递依赖）。

### 事务
+ 原子性（atomicity）：
一个事务是一个不可分割的工作单位，事务中包括的诸操作要么都做，要么都不做。
+ 一致性（consistency）：
事务必须是使数据库从一个一致性状态变到另一个一致性状态。一致性与原子性是密切相关的。
+ 隔离性（isolation）：
一个事务的执行不能被其他事务干扰。即一个事务内部的操作及使用的数据对并发的其他事务是隔离的，并发执行的各个事务之间不能互相干扰。
+ 持久性（durability）：
也称永久性（permanence），指一个事务一旦提交，它对数据库中数据的改变就应该是永久性的。接下来的其他操作或故障不应该对其有任何影响。

### 切分
+ 垂直拆分：
把表按模块划分到不同数据库表中。
+ 水平拆分：
把一个表按照某种规则（时间、用户...）把数据划分到不同表或数据库里。

### SQL 一些小技巧
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

### count(1) count(主键) count(\*)
+ count(1) 和 count(主键) 这两个只**扫描主键**Index就可以得到数据
+ count(\*) 是**扫描表**的
+ count(1) 和 count(主键) 这两个效率高
+ count(ROWID) 这也是只扫描Index的，效率高
