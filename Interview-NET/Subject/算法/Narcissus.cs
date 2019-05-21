using System;
using System.Collections.Generic;

namespace Subject
{
    /// <summary>
    /// 水仙花数
    /// 一个 n 位数（n≥3），它的每个位上的数字的 n 次幂之和等于它本身（例如：1^3 + 5^3+ 3^3 = 153）。
    /// </summary>
    public class Narcissus
    {
        /// <summary>
        /// 获取n位数的水仙花数
        /// </summary>
        /// <param name="n">n位数</param>
        /// <returns></returns>
        public List<int> GetN(int n)
        {
            List<int> result = new List<int>();
            if (n < 1)
            {
                return result;
            }

            int num = (int)Math.Pow(10, n - 1);
            int max = (int)Math.Pow(10, n);
            while (num < max)
            {
                int[] a = new int[n];
                int sum = 0;
                for (int i = 0; i < n; i++)
                {
                    //第i+1位数
                    a[i] = (int)(num / Math.Pow(10, i) % 10);
                    sum += (int)Math.Pow(a[i], n);
                }

                if (sum == num)
                {
                    result.Add(num);
                }

                num++;
            }

            return result;
        }

        /// <summary>
        /// 获取100至999内的水仙花数
        /// </summary>
        /// <returns></returns>
        public List<int> Get100to999()
        {
            List<int> result = new List<int>();

            int num = 100;
            while (num <= 999)
            {
                //百位
                int a = num / 100;
                //十位
                int b = num / 10 % 10;
                //个位
                int c = num % 10;

                if (a * a * a + b * b * b + c * c * c == num)
                {
                    result.Add(num);
                }

                num++;
            }
            return result;
        }
    }
}
