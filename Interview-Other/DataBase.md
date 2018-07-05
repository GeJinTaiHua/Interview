## 💾数据库

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
+ count(1) 和 count(主键) 这两个只扫描主键Index就可以得到数据
+ count(\*) 是扫描表的
+ count(1) 和 count(主键) 这两个效率高
+ count(ROWID) 这也是只扫描Index的，效率高

### 三大范式
+ 第一范式（1NF）：
每一列都是不可分割的原子数据项；
+ 第二范式：
满足1NF后，要求表中的所有列，都必须依赖于主键，而不能有任何一列与主键没有关系（一个表只描述一件事情）；
+ 第三范式：
在2NF基础上，表中的每一列只能依赖于主键（在2NF基础上消除传递依赖）。

### 五大约束
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

