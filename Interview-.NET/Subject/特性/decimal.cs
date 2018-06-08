using System;

namespace Subject
{
    /// <summary>
    /// 计算类
    /// </summary>
    public class Test_Decimal
    {
        /// <summary>
        /// 具有更高的精度和更小的范围，这使它适合于财务和货币计算。
        /// </summary>
        public decimal price = 0.01m;

        /// <summary>
        /// 浮点型 0.01会被默认为double型
        /// </summary>
        public double d = 0.01;

        /// <summary>
        /// 浮点型
        /// </summary>
        public float f = 0.01f;

        /// <summary>
        /// 精度损失
        /// </summary>
        public void DoubleTest()
        {
            double de = 10000000000000000000000d;
            de++;     //10000000000000000000000d

            float ft = 10000000000000000000000f;
            ft++;    //10000000000000000000000f

            decimal dl = 10000000000000000000000000000m;
            dl += 0.1m;//10000000000000000000000000000m 精度损失依然存在
            dl++;      //10000000000000000000000000001m	
        }

        /// <summary>
        /// Math.Round 
        /// </summary>
        public void Round()
        {
            //四舍六入五取偶
            double result = 0.01;
            result = Math.Round(0.4);//0
            result = Math.Round(0.5);//0
            result = Math.Round(0.6);//1

            result = Math.Round(1.5);//2
            result = Math.Round(2.5);//2
            result = Math.Round(3.5);//4
            result = Math.Round(4.5);//4

            //四舍五入
            result = Math.Round(0.4, MidpointRounding.AwayFromZero);//0
            result = Math.Round(0.5, MidpointRounding.AwayFromZero);//1
            result = Math.Round(0.6, MidpointRounding.AwayFromZero);//1

            result = Math.Round(1.5, MidpointRounding.AwayFromZero);//2 
            result = Math.Round(2.5, MidpointRounding.AwayFromZero);//3
            result = Math.Round(3.5, MidpointRounding.AwayFromZero);//4
            result = Math.Round(4.5, MidpointRounding.AwayFromZero);//5
        }
    }
}
