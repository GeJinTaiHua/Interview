using System.Collections.Generic;
using System.Linq;

namespace Subject
{
    /* * * * * * * * * * * * ** * * * * * * * * * * * * * * * * * * * * * * * ** * * * * * * * * * * * * * * * * * * * * * * * *
     * Dictionary是Hashtable的一种泛型实现（也是一种哈希表），任何非 null 对象都可以用作键。
     * 1、使用的哈希函数是除留余数法：h = F(k) % m; m 为哈希表长度（这个长度一般为素数）。
     * 2、解决冲突方法是拉链法，又称链地址法。
     * 3、内部实现结构比Hashtable复杂，因为具有单链表的特性，效率也比Hashtable高。
     * 4、非线程安全，必须人为使用lock语句进行保护, 效率大减。
     * * * * * * * * * * * * ** * * * * * * * * * * * * * * * * * * * * * * * ** * * * * * * * * * * * * * * * * * * * * * * * */

    public class Test_Dictionary
    {
        public Dictionary<int, string> dictionary = new Dictionary<int, string>();

        /// <summary>
        /// 排序
        /// </summary>
        public void Sort()
        {
            Dictionary<int, string> dic = new Dictionary<int, string>();
            dic.Add(2, "two");
            dic.Add(1, "one");
            dic.Add(4, "four");
            dic.Add(3, "three");

            var sort1 = from item in dic orderby item.Key select item;
            var sort2 = dic.OrderByDescending(p => p.Key).ToDictionary(p => p.Key, o => o.Value);
        }
    }
}
