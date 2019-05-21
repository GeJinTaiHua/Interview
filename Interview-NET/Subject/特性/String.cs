using System;
using System.Text;

namespace Subject
{
    /// <summary>
    /// String、StringBuilder
    /// </summary>
    public class Test_String
    {
        /// <summary>
        /// 字符串常量
        /// 1、不可改变对象，进行运算时（如赋值、拼接等）会产生一个新的实例。
        /// 2、引用类型，创建很多个相同值的字符串对象，它在内存中的指向地址应该是一样的。
        /// </summary>
        public String str = string.Empty;

        /// <summary>
        /// 字符串变量
        /// </summary>
        public StringBuilder stringBuilder = new StringBuilder();

        //c#没有StringBuffer类，java有

        public void Test1()
        {
            String str = "abc";  //分配固定的内存大小
            str += "def";  //创建新的内存分配a1，代价比较昂贵

            StringBuilder sb = new StringBuilder(20);  //指定分配大小
            sb.Append("abc");  //分配到堆区
            sb.Append("def");  //不会被销毁，而是直接追加到后面。
        }

        public void Test2()
        {
            string s = "1234";
            Change(s);//s="1234";

            string t = "1234";
            Change(ref t);//t="5678";
        }

        private void Change(string str)
        {
            str = "5678";
        }

        private void Change(ref string str)
        {
            str = "5678";
        }
    }
}
