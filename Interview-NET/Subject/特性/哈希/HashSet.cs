using Entity;
using System.Collections.Generic;

namespace Subject
{
    /* * * * * * * * * * * * ** * * * * * * * * * * * * * * * * * * * * * * * ** * * * * * * * * * * * * * * * * * * * * * * * *
     * HashSet<T>类主要是设计用来做高性能集运算的，例如对两个集合求交集、并集、差集等。
     * 1、集合中包含一组不重复出现且无特性顺序的元素，HashSet拒绝接受重复的对象。
     * 2、容量会按需自动添加。
     * * * * * * * * * * * * ** * * * * * * * * * * * * * * * * * * * * * * * ** * * * * * * * * * * * * * * * * * * * * * * * */

    public class Test_HashSet
    {
        HashSet<Node> hashSet = new HashSet<Node>();
    }
}
