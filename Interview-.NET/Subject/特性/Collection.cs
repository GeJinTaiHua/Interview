using Entity;
using System;
using System.Collections;
using System.Collections.Generic;

namespace Subject
{
    /// <summary>
    /// 集合类 ArrayList、Hashtable、SortedList、Stack、Queue、BitArray
    /// </summary>
    public class Test_Collection
    {
        /// <summary>
        /// 数组 System
        /// 1、两个数据间插入数据很麻烦。
        /// 2、容量固定。
        /// 3、可以多个维度。
        /// </summary>
        public Array array = new Array[10];

        /// <summary>
        /// 动态数组 System.Collections
        /// 1、继承了IList接口，提供了数据存储和检索。
        /// 2、动态扩充与收缩的容量。
        /// 3、允许插入不同类型的数据，不是类型安全。在存储或检索值类型时通常发生装箱和取消装箱操作，带来很大的性能耗损。
        /// </summary>
        public ArrayList arrayList = new ArrayList();

        public void ArrayListOperation()
        {
            arrayList.Add(7);
            arrayList.Add("002");
            arrayList.Add(new Node(3));

            arrayList.Clear();
        }

        /// <summary>
        /// 泛型 System.Collections.Generi
        /// 1、类型安全。
        /// </summary>
        public List<int> list = new List<int>();

        /// <summary>
        /// 哈希表
        /// </summary>
        public Hashtable hashtable = new Hashtable();

        /// <summary>
        /// 排序列表
        /// 1、是数组和哈希表的组合
        /// </summary>
        public SortedList sortedList = new SortedList();

        /// <summary>
        /// 堆栈
        /// 1、后进先出
        /// </summary>
        public Stack stack = new Stack();

        public void StackOperation()
        {
            stack.Push('A');
            stack.Push(2);
            stack.Push("CC");

            stack.Pop();
        }

        /// <summary>
        /// 队列
        /// 1、先进先出
        /// </summary>
        public Queue queue = new Queue();

        public void QueueOperation()
        {
            queue.Enqueue('A');
            queue.Enqueue(2);
            queue.Enqueue("CCC");
            queue.Enqueue(new Node(4));

            queue.Dequeue();
        }

        /// <summary>
        /// 点阵列
        /// 1、一个使用值 1 和 0 来表示的二进制数组
        /// </summary>
        public BitArray bitArray = new BitArray(1024);
    }
}
