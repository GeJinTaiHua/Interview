using System;

namespace Subject
{
    /// <summary>
    /// 斐波那契数列 O(n2)
    /// 1、1、2、3、5、8、13、21、34、…
    /// </summary>
    public class Fibonacci
    {
        /// <summary>
        /// 递归
        /// </summary>
        /// <param name="n"></param>
        /// <returns></returns>
        public int GetFibonacci(int n)
        {
            if (n <= 0)
            {
                throw new ArgumentOutOfRangeException("输入不能小于0！");
            }

            if (n == 1 || n == 2)
            {
                return 1;
            }

            return GetFibonacci(n - 1) + GetFibonacci(n - 2);
        }

        public int GetFibonacci2(int n)
        {
            if (n <= 0)
            {
                throw new ArgumentOutOfRangeException("输入不能小于0！");
            }

            int a = 1;
            int b = 1;
            int c = 1;

            for (int i = 3; i <= n; i++)
            {
                c = a + b;
                a = b;
                b = c;
            }

            return c;
        }
    }
}
