## 📐数据结构 
 
 
  * [栈](#%E6%A0%88)
  * [队列](#%E9%98%9F%E5%88%97)
    * [Java中的队列](#java%E4%B8%AD%E7%9A%84%E9%98%9F%E5%88%97)
  * [链表](#%E9%93%BE%E8%A1%A8)
  * [树](#%E6%A0%91)
  * [图](#%E5%9B%BE)
  * [堆](#%E5%A0%86)
  * [散列表](#%E6%95%A3%E5%88%97%E8%A1%A8)
 
 
### 栈
![栈](http://i2.51cto.com/images/blog/201801/21/796da6488c298dcd907ee5e204d1215b.png?x-oss-process=image/watermark,size_16,text_QDUxQ1RP5Y2a5a6i,color_FFFFFF,t_100,g_se,x_10,y_10,shadow_90,type_ZmFuZ3poZW5naGVpdGk=)
 
### 队列
+ 顺序队列（先进先出） 
![顺序队列](https://sfault-image.b0.upaiyun.com/124/395/1243953170-57245f3329084_articlex)
+ 循环队列   
![循环队列](https://gss1.bdstatic.com/-vo3dSag_xI4khGkpoWK1HF6hhy/baike/c0%3Dbaike80%2C5%2C5%2C80%2C26/sign=2d7e279f259759ee5e5d6899d3922873/5d6034a85edf8db1ee973ff60a23dd54574e74e2.jpg)

#### Java中的队列
+ 普通队列
  + ArrayDeque（数组双端队列） 
  + PriorityQueue（优先级队列） 
  + ConcurrentLinkedQueue（基于链表的并发队列） 
+ 阻塞队列：当队列是空的时，从队列中获取元素的操作将会被阻塞，或者当队列是满时，往队列里添加元素的操作会被阻塞。
  + DelayQueue（延期阻塞队列）（阻塞队列实现了BlockingQueue接口） 
  + ArrayBlockingQueue（基于数组的并发阻塞队列阻塞队列） 
  + LinkedBlockingQueue（基于链表的FIFO阻塞队列） 
  + LinkedBlockingDeque（基于链表的FIFO双端阻塞队列） 
  + PriorityBlockingQueue（带优先级的无界阻塞队列） 
  + ynchronousQueue（并发同步阻塞队列）
  + 生产者-消费者模式
+ 非阻塞算法（nonblocking）：一个线程的失败或挂起不应该影响其他线程的失败或挂起。
+ 锁自由（lock-free）算法：如果算法的每一个步骤中都有一些线程能够继续执行。
 
### 链表
+ [单向链表](/Interview-.NET/Entity/Node.cs#L6)
  + [反转单向链表](/Interview-.NET/Subject/数据结构/LinkReverse.cs)
+ [双向链表](/Interview-.NET/Entity/Node.cs#L19)

### 树
+ 完全二叉树
+ 满二叉树  
![完全二叉树 和 满二叉树](http://jbcdn2.b0.upaiyun.com/2017/07/a5952ec741b60202c7b377bfb8e8f368.png)
+ 二叉查找树（二叉排序树）（二叉搜索树）：O(logn)
  1) 若左子树不空，则左子树上所有结点的值均小于它的根结点的值；
  2) 若右子树不空，则右子树上所有结点的值均大于或等于它的根结点的值；
  3) 左、右子树也分别为二叉排序树；
  4) 没有键值相等的节点。
  + 平衡二叉树：一 棵空树或它的左右两个子树的高度差的绝对值不超过1，并且左右两个子树都是一棵平衡二叉树。
    + AVL树
    + 红黑树  
    ![红黑树](http://jbcdn2.b0.upaiyun.com/2017/07/9fd5e683147961431e0ecfcffbe5805b.png)  
+ B树：一种树状数据结构，能够用来存储排序后的数据。  
![B树](http://jbcdn2.b0.upaiyun.com/2017/07/0178191b698ab75a98fa1d0bb03cc51f.jpg)
  + B+树：B+树只有达到叶子结点才命中（B树可以在非叶子结点命中）。  
  ![B+树](http://jbcdn2.b0.upaiyun.com/2017/07/0972ef809f286cc29cd2d94687b2ef2d.jpg)
    + B\*树：在B+树的非根和非叶子结点再增加指向兄弟的指针，将结点的最低利用率从1/2提高到2/3。
    ![B\*树](http://jbcdn2.b0.upaiyun.com/2017/07/eb5835f421e029240105ccb8e80279ee.jpg)
+ Trie树（字典树）（单词查找树）：利用字符串的公共前缀来减少查询时间，最大限度地减少无谓的字符串比较，查询效率比哈希树高。

### 图
+ 存储结构—-邻接矩阵。   
![邻接矩阵](https://gss1.bdstatic.com/-vo3dSag_xI4khGkpoWK1HF6hhy/baike/c0%3Dbaike80%2C5%2C5%2C80%2C26/sign=77989746352ac65c73086e219a9bd974/b812c8fcc3cec3fdb11cec53d688d43f879427f1.jpg)
+ 存储结构—-邻接表  
```
typedef char Vertextype;
//表结点结构
struct ArcNode {
    int adjvex;   //某条边指向的那个顶点的位置（一般是数组的下标）。
    ArcNode * nextarc; //指向下一个表结点
    int weight;   //这个只有网图才需要使用。普通的图可以直接忽略
};
//头结点
struct Vnode
{
    Vertextype data;  //这个是记录每个顶点的信息（现在一般都不需要怎么使用）
    ArcNode * firstarc; //指向第一条依附在该顶点边的信息（表结点）
};
```
![邻接表](https://gss3.bdstatic.com/7Po3dSag_xI4khGkpoWK1HF6hhy/baike/c0%3Dbaike80%2C5%2C5%2C80%2C26/sign=f912d7d98d94a4c21e2eef796f9d70b0/4e4a20a4462309f7bfc89bc4780e0cf3d6cad644.jpg)
+ 存储结构—-十字链表   
![十字链表](https://images2015.cnblogs.com/blog/705949/201605/705949-20160505160739841-1219722707.png)
+ 存储结构—-邻接多重表  

### 堆

### 散列表










