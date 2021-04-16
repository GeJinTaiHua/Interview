## 📏数据结构 
 
  * [栈](#%E6%A0%88)
  * [队列](#%E9%98%9F%E5%88%97)
    * [顺序队列](#%E9%A1%BA%E5%BA%8F%E9%98%9F%E5%88%97)
    * [循环队列](#%E5%BE%AA%E7%8E%AF%E9%98%9F%E5%88%97)
  * [链表](#%E9%93%BE%E8%A1%A8)
    * [单向链表](#%E5%8D%95%E5%90%91%E9%93%BE%E8%A1%A8)
    * [双向链表](#%E5%8F%8C%E5%90%91%E9%93%BE%E8%A1%A8)
  * [树](#%E6%A0%91)
    * [二叉树](#%E4%BA%8C%E5%8F%89%E6%A0%91)
    * [B树](#b%E6%A0%91)
    * [Trie树（字典树）（单词查找树）](#trie%E6%A0%91%E5%AD%97%E5%85%B8%E6%A0%91%E5%8D%95%E8%AF%8D%E6%9F%A5%E6%89%BE%E6%A0%91)
  * [图](#%E5%9B%BE)
    * [存储结构](#%E5%AD%98%E5%82%A8%E7%BB%93%E6%9E%84)
  * [堆](#%E5%A0%86)
  * [散列表](#%E6%95%A3%E5%88%97%E8%A1%A8)
 
### 栈

### 队列
#### 顺序队列
先进先出

#### 循环队列   
 
### 链表
#### 单向链表
+ [反转单向链表](/Interview-NET/Subject/数据结构/LinkReverse.cs)
 
#### 双向链表 

### 树
#### 二叉树  
![二叉树](/Interview-DSAndA/DS_Pic/2XTree.png)
+ 遍历
  + [前序遍历](/Interview-Java/src/test/java/DataStructure/BinaryTree.java#L17)：ABDECF
  + [中序遍历](/Interview-Java/src/test/java/DataStructure/BinaryTree.java#L57)：DBEAFC
  + [后序遍历](/Interview-Java/src/test/java/DataStructure/BinaryTree.java#L95)：DEBFCA
  + [层序遍历](/Interview-Java/src/test/java/DataStructure/BinaryTree.java#L108)：ABCDEF
  
+ 完全二叉树

+ 满二叉树   
![完全二叉树 和 满二叉树](/Interview-DSAndA/DS_Pic/WQ2XTree.png)

+ 二叉查找树（二叉排序树）（二叉搜索树）：O(logn)
  1) 若左子树不空，则左子树上所有结点的值均小于它的根结点的值；
  2) 若右子树不空，则右子树上所有结点的值均大于或等于它的根结点的值；
  3) 左、右子树也分别为二叉排序树；
  4) 没有键值相等的节点。
  + 平衡二叉树：一棵空树或它的左右两个子树的高度差的绝对值不超过1，并且左右两个子树都是一棵平衡二叉树。
    + AVL树
    + 红黑树  
    ![红黑树](/Interview-DSAndA/DS_Pic/RedBlackTree.png)  

#### B树
+ B树：一种树状数据结构，能够用来存储排序后的数据。      
![B树](/Interview-DSAndA/DS_Pic/B-Tree.png)

+ B+树：只有达到叶子结点才命中（B树可以在非叶子结点命中）。   
  + 非叶子节点只存储键值信息；
  + 所有叶子节点之间都有一个链指针；
  + 数据记录都存放在叶子节点中。  
![B+树](/Interview-DSAndA/DS_Pic/B+Tree.png)

+ B\*树：在B+树的非根和非叶子结点再增加指向兄弟的指针，将结点的最低利用率从1/2提高到2/3。  
![B\*树](/Interview-DSAndA/DS_Pic/BXTree.jpg)
    
#### Trie树（字典树）（单词查找树）
利用字符串的公共前缀来减少查询时间，最大限度地减少无谓的字符串比较，查询效率比哈希树高。

### 图
#### 存储结构
+ 存储结构—-邻接矩阵。   
![邻接矩阵](/Interview-DSAndA/DS_Pic/AdjacencyMatrix.jpg)

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
![邻接表](/Interview-DSAndA/DS_Pic/AdjacencyList.jpg)

+ 存储结构—-十字链表   
![十字链表](/Interview-DSAndA/DS_Pic/OrthogonalList.png)

+ 存储结构—-邻接多重表  

### 堆

### 散列表










