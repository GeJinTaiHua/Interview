## ✏️算法
 
  * [排序算法](#%E6%8E%92%E5%BA%8F%E7%AE%97%E6%B3%95)
    * [插入排序](#%E6%8F%92%E5%85%A5%E6%8E%92%E5%BA%8F)
    * [选择排序](#%E9%80%89%E6%8B%A9%E6%8E%92%E5%BA%8F)
    * [交换排序](#%E4%BA%A4%E6%8D%A2%E6%8E%92%E5%BA%8F)
    * [其他排序](#%E5%85%B6%E4%BB%96%E6%8E%92%E5%BA%8F)
  * [Hash](#hash)
    * [哈希函数](#%E5%93%88%E5%B8%8C%E5%87%BD%E6%95%B0)
    * [哈希冲突处理](#%E5%93%88%E5%B8%8C%E5%86%B2%E7%AA%81%E5%A4%84%E7%90%86)
    * [hash一致性算法](#hash一致性算法)
  * [其他](#其他)
    * [数字频率](#数字频率)
    * [随机数](#%E9%9A%8F%E6%9C%BA%E6%95%B0)
    * [频率](#%E9%A2%91%E7%8E%87)
    * [雪花算法](#雪花算法)

### 排序算法  
#### 插入排序
+ [直接插入排序](/Interview-Java/src/test/java/Algorithm/Sort/InsertionSort.java)
  + 基本思想：将一个记录插入到已排序好的有序表中，从而得到一个新的记录数增1的有序表。
  + 时间复杂度：O(n^2) 
  + 空间复杂度：O(1) 
  + 稳定
  + 改进：设立哨兵，作为临时存储和判断数组边界之用。  

+ [二分插入排序](/Interview-Java/src/test/java/Algorithm/Sort/BinaryInsertSort.java)
  + 基本思想：在插入第i个元素时，对前面的0～i-1元素进行折半，先跟他们中间的那个元素比，如果小，则对前半再进行折半，否则对后半进行折半，直到left<right，然后再把第i个元素前1位与目标位置之间的所有元素后移，再把第i个元素放在目标位置上。
  + 时间复杂度：O(n^2)
  + 空间复杂度：O(1)
  + 稳定

+ [希尔排序](/Interview-Java/src/test/java/Algorithm/Sort/ShellSort.java)（缩小增量排序）
  + 基本思想：先将整个待排序的记录序列分割成为若干子序列分别进行直接插入排序，待整个序列中的记录“基本有序”时，再对全体记录进行依次直接插入排序。  
  + 时间复杂度：O(n^（1.3—2）) 
  + 空间复杂度：O(1)
  + 不稳定

#### 选择排序
+ [直接选择排序](/Interview-Java/src/test/java/Algorithm/Sort/StraightSelectionSort.java)
  + 基本思想：在要排序的一组数中，选出最小（或者最大）的一个数与第1个位置的数交换；然后在剩下的数当中再找最小（或者最大）的与第2个位置的数交换，依次类推，直到第n-1个元素（倒数第二个数）和第n个元素（最后一个数）比较为止。  
  + 时间复杂度：O(n^2)
  + 空间复杂度：O(1)
  + 不稳定

+ [树形选择排序](/Interview-Java/src/test/java/Algorithm/Sort/TreeSelectionSort.java)（锦标赛排序 ）
  + 基本思想：一种按照锦标赛的思想进行选择排序的方法。首先对n个记录的关键字进行两两比较，然后在n/2个较小者之间再进行两两比较，如此重复，直至选出最小的记录为止。
  + 时间复杂度为：O(nlogn)
  + 空间复杂度：O(n)
  
+ [堆排序](/Interview-Java/src/test/java/Algorithm/Sort/Heapsort.java)
  + 基本思想：是一种树形选择排序，是对直接选择排序的有效改进。
  + 时间复杂度：O(nlogn)
  + 空间复杂度：最坏：O(n)

#### 交换排序
+ [冒泡排序](/Interview-Java/src/test/java/Algorithm/Sort/BubbleSort.java)
  + 基本思想：在要排序的一组数中，对当前还未排好序的范围内的全部数，自上而下对相邻的两个数依次进行比较和调整，让较大的数往下沉，较小的往上冒。
  + 时间复杂度：O(n²)
  + 空间复杂度：O(1)
  + 改进：
    1) 加入标志性变量exchange，用于标志某一趟排序过程中是否有数据交换。
    2) 设置一标志性变量pos，用于记录每趟排序中最后一次进行交换的位置。由于pos位置之后的记录均已交换到位，故在进行下一趟排序时只要扫描到pos位置即可。
    3) 传统冒泡排序中每一趟排序操作只能找到一个最大值或最小值，我们考虑利用在每趟排序中进行正向和反向两遍冒泡的方法一次可以得到两个最终值(最大者和最小者) ，从而使排序趟数几乎减少了一半。  

+ [快速排序](/Interview-Java/src/test/java/Algorithm/Sort/QuickSort.java)（划分交换排序）
  + 基本思想：
    1) 选择一个基准元素，通常选择第一个元素或者最后一个元素；
    2) 通过一趟排序讲待排序的记录分割成独立的两部分，其中一部分记录的元素值均比基准元素值小，另一部分记录的元素值比基准值大；
    3) 此时基准元素在其排好序后的正确位置；
    4) 然后分别对这两部分记录用同样的方法继续进行排序，直到整个序列有序。
  + 时间复杂度：最优：O(nlgn)提升到O(n)
  + 空间复杂度：根据具体实现情况
  + 改进：
    1) 三者取中法：排序区间的两个端点与中点三个记录关键码居中的调整为支点记录。  

#### 其他排序
+ [归并排序](/Interview-Java/src/test/java/Algorithm/Sort/MergeSort.java)
  + 基本思想：归并（Merge）排序法是将两个（或两个以上）有序表合并成一个新的有序表，即把待排序序列分为若干个子序列，每个子序列是有序的。然后再把有序子序列合并为整体有序序列。  
  + 时间复杂度为：O(nlogn)
  + 空间复杂度：O(n)
  + 稳定

+ [桶排序](/Interview-Java/src/test/java/Algorithm/Sort/BucketSort.java)
  + 基本思想：就是把数据分组，放在一个个的桶中，然后对每个桶里面的在进行排序。  
  + 时间复杂度为：O(N+C)，其中C=N*(logN-logM)
  + 空间复杂度：O(N+M)
  + 稳定

+ [基数排序](/Interview-Java/src/test/java/Algorithm/Sort/RadixSort.java)（桶子法）
  + 基本思想：透过键值的部份资讯，将要排序的元素分配至某些“桶”中，藉以达到排序的作用。
  + 时间复杂度为：O (nlog(r)m)
  + 空间复杂度：
  + 稳定

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

#### hash一致性算法
考虑到分布式系统每个节点都有可能失效，并且新的节点很可能动态的增加进来的情况。

+ 环形Hash空间
  + 对2^32取模  
  ![2^32取模](/Interview-DSAndA/A_Pic/2mod.png)
  + 对象与机器处于同一个哈希空间中，这样按顺时针转动object1（对象）存储到了NODE1（机器）中,object3（对象）存储到了NODE2（机器）中,object2、object4（对象）存储到了NODE3（机器）中。
  ![映射到环上](/Interview-DSAndA/A_Pic/Huan.png)

+ 缺点：服务节点太少时，容易因为节点分部不均匀而造成数据倾斜（被缓存的对象大部分集中缓存在某一台服务器上）
  + 虚拟节点：是实际节点（机器）在hash空间的复制品，一个实际节点对应了若干个“虚拟节点”，这个对应个数也称为“复制个数”，“虚拟节点”在hash空间中以hash值排列。      
  ![虚拟节点映射](/Interview-DSAndA/A_Pic/XLNode.png)

### 其他
#### 数字游戏
+ [水仙花数](/Interview-NET/Subject/算法/Narcissus.cs)
+ [约瑟夫问题](/Interview-NET/Subject/算法/Josephus.cs)
+ [斐波那契数列](/Interview-NET/Subject/算法/Fibonacci.cs)
+ [交换ab的值](/Interview-NET/Subject/算法/Swap.cs)
+ [在字符串中找出连续最长的数字串](/Interview-Java/src/test/java/Algorithm/FindMaxNum.java)

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

#### 雪花算法
Twitter 的分布式自增ID SnowFlake算法
+ [SnowFlake](/Interview-Java/src/main/java/www/wjl/com/Interview/SnowFlake.java)
  + 组合：1位 + 41位毫秒级时间 + 5位数据中心datacenterId + 5位机器标识workerId + 12位的计数顺序号 = 64位Long型(转换成字符串长度为18)；
  + 算法核心：把时间戳，工作机器id，序列号组合在一起。
  ![](/Interview-DSAndA/A_Pic/Snowflake.png)


