## ✒️算法
 
 
  * [Hash](#hash)
    * [哈希函数](#%E5%93%88%E5%B8%8C%E5%87%BD%E6%95%B0)
    * [哈希冲突处理](#%E5%93%88%E5%B8%8C%E5%86%B2%E7%AA%81%E5%A4%84%E7%90%86)
  * [数字游戏](#%E6%95%B0%E5%AD%97%E6%B8%B8%E6%88%8F)
    * [随机数](#%E9%9A%8F%E6%9C%BA%E6%95%B0)
    * [频率](#%E9%A2%91%E7%8E%87)
  * [排序算法](#%E6%8E%92%E5%BA%8F%E7%AE%97%E6%B3%95)
    * [插入排序](#%E6%8F%92%E5%85%A5%E6%8E%92%E5%BA%8F)
    * [交换排序](#%E4%BA%A4%E6%8D%A2%E6%8E%92%E5%BA%8F)
    * [选择排序](#%E9%80%89%E6%8B%A9%E6%8E%92%E5%BA%8F)
    * [归并排序](#%E5%BD%92%E5%B9%B6%E6%8E%92%E5%BA%8F)
    * [分配排序](#%E5%88%86%E9%85%8D%E6%8E%92%E5%BA%8F)

 
### Hash 
#### 哈希函数
+ 直接取余法：f(x):= x mod maxM ; maxM一般是不太接近 2^t 的一个质数。
+ 乘法取整法：f(x):=trunc((x/maxX)\*maxlongit) mod maxM，主要用于实数。
+ 平方取中法：f(x):=(x*x div 1000 ) mod 1000000); 平方后取中间的，每位包含信息比较多。

#### 哈希冲突处理
+ 开放寻址法：把所有的元素都存放在散列表中，也就是每个表项包含动态集合的一个元素，或者包含NIL。
+ 再散列法：即在同义词产生地址冲突时计算另一个散列函数地址，直到冲突不再发生。
  + 不易产生“聚集”；
  + 增加了计算时间。
+ 链地址法（拉链法）
+ 公共溢出区 

### 数字游戏
+ [水仙花数](/Interview-.NET/Subject/算法/Narcissus.cs)
+ [约瑟夫问题](/Interview-.NET/Subject/算法/Josephus.cs)
+ [斐波那契数列](/Interview-.NET/Subject/算法/Fibonacci.cs)
+ [交换 a b 的值](/Interview-.NET/Subject/算法/Swap.cs)

#### 随机数
+ [1-100的随机数](/Interview-Java/src/test/java/Algorithm/RandomNum.java#L16)
```
// Java：randNumber 将被赋值为一个 MIN 和 MAX 范围内的随机数
int randNumber = new Random().nextInt(MAX - MIN + 1) + MIN;
```
```
// C#：randNumber 将被赋值为一个 MIN 和 MAX 范围内的随机数
int randNumber = new Random().Next(MIN, MAX + 1); 
```
+ [随机数字和字母](/Interview-Java/src/test/java/Algorithm/RandomNum.java#L37)

#### 频率
+ [100个URL如何找到出现频率最高的前10个](/Interview-Java/src/test/java/Algorithm/MaxUrl.java)
+ [获取一个字符串在另一个字符串中出现的次数](/Interview-Java/src/test/java/Algorithm/Stringsub.java)
 
### 排序算法
![排序算法](http://img.my.csdn.net/uploads/201207/17/1342514529_5795.jpg)
#### 插入排序
+ 直接插入排序
+ 希尔排序

#### 交换排序
+ 冒泡排序
+ 快速排序

#### 选择排序
+ 直接选择排序
+ 堆排序

#### 归并排序

#### 分配排序
+ 箱排序
+ 基数排序




