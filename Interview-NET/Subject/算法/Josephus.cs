using Entity;
using System.Collections.Generic;

namespace Subject
{
    /// <summary>
    /// 约瑟夫问题 
    /// 已知n个人（以编号1，2，3...n分别表示）围坐在一张圆桌周围。
    /// 从编号为k的人开始报数（从1开始报数)，数到m的那个人出列；
    /// 他的下一个人又从1开始报数，数到m的那个人又出列；
    /// 依此规律重复下去，直到圆桌周围的人全部出列。 
    /// 例如N=6，M=5，[1，2，3，4，5，6]被杀掉的顺序是：5，4，6，2，3，1。
    /// </summary>
    public class Josephus
    {
        /// <summary>
        /// 队列
        /// </summary>
        /// <param name="n">n个人</param>
        /// <param name="k">第k个开始</param>
        /// <param name="m"></param>
        public List<int> GetRemoveList(int n, int k, int m)
        {
            List<int> resut = new List<int>();

            //第k个元素即队列的队头，也即从第k个元素开始报数
            Queue<int> numbersQueue = new Queue<int>();
            for (int i = k; i <= n; i++)
            {
                numbersQueue.Enqueue(i);
            }
            for (int i = 1; i < k; i++)
            {
                numbersQueue.Enqueue(i);
            }

            //开始循环
            int flag = 0;
            while (numbersQueue.Count > 0)
            {
                flag++;

                if (flag != m)
                {
                    //将列头的数据放到列尾
                    numbersQueue.Enqueue(numbersQueue.Dequeue());
                }
                else
                {
                    //输出出列项的编号，下标从1开始
                    resut.Add(numbersQueue.Dequeue());
                    flag = 0;
                }
            }

            return resut;
        }

        /// <summary>
        /// 数组
        /// </summary>
        /// <param name="n"></param>
        /// <param name="m"></param>
        /// <returns></returns>
        public int GetLastOne1(int n, int m)
        {
            int result = 0;

            int[] a = new int[n];
            for (int i = 0; i < n; i++)
            {
                a[i] = i + 1;
            }

            for (int i = 0, num = 0, dead = 0; ; i++)
            {
                //大于总人数，我们就从头开始
                if (i >= n)
                {
                    i = 0;
                }

                //如果当前这个人没有死，就报数  
                if (a[i] > 0)
                {
                    num++;
                }

                if (num == m && dead != n - 1)
                {
                    //如果当前这个人报的数等于m 并且没有已经死亡n-1个人  
                    num = 0;
                    a[i] = 0;
                    dead++;
                }
                else if (num == m && dead == n - 1)
                {
                    //如果这个人报数等于m，并且已经死了n-1个人，说明当前这个人就是最后的一个活着的了。。  
                    result = a[i];
                    break;
                }
            }

            return result;
        }

        /// <summary>
        /// 递归-根据推导的公式 O(n)
        /// </summary>
        /// <param name="n"></param>
        /// <param name="k">第k个开始</param>
        /// <param name="m"></param>
        /// <returns></returns>
        public int GetLastOne2(int n, int k, int m)
        {
            int result = 0;

            int[] numbers = new int[n];
            for (int i = 0; i < n; i++)
            {
                numbers[i] = i + 1;
            }

            int winnerIndex = GetIndex(numbers.Length, m);

            //输出最后一个出列项的编号，下标从1开始
            result = numbers[(winnerIndex + k - 1) % numbers.Length];
            return result;
        }

        /// <summary>
        /// 假设有x个元素时，最后退出的元素为f(x)
        /// f(x+1) = (m+f(x))%(x+1) 
        /// </summary>
        /// <param name="itemCount"></param>
        /// <param name="m"></param>
        /// <returns></returns>
        private int GetIndex(int itemCount, int m)
        {
            if (itemCount == 0)
            {
                return 0;
            }
            else
            {
                return (GetIndex(itemCount - 1, m) + m) % itemCount;
            }
        }

        /// <summary>
        /// 链表 O(n*m)
        /// </summary>
        /// <param name="head">循环链表</param>
        /// <param name="m"></param>
        /// <returns></returns>
        public Node PushLastNode(Node head, int m)
        {
            if (head == null || head.next == null || m < 1)
            {
                return head;
            }

            Node last = head;  //  ...-->last-->head-->...
            while (last.next != head)
            {
                last = last.next;
            }

            int count = 0;
            while (head != last)
            {
                if (++count == m)
                {
                    //删除head所在节点
                    last.next = head.next;
                    count = 0;
                }
                else
                {
                    last = last.next;
                }
                head = last.next;
            }
            return head;
        }
    }
}
