package BaseData;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/*
 * @desc 键值：Map
 * HashMap（LinkedHashMap）
 * Hashtable
 * SortedMap（TreeMap）
 * @author wjl
 * @date 2018/6/14 0014
 */
@SpringBootTest
public class Map {
    @Test
    public void Run() {
        // 非线程安全，允许空的value
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("1", "A");
        hashMap.put("1", "B");
        hashMap.put("2", "C");
        hashMap.get("1");
        hashMap.remove("1");
        //相对于HashMap保证了元素迭代的顺序
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();

        // 线程安全，不允许空的value
        Hashtable<String, String> hashtable = new Hashtable<>();

        SortedMap<String, String> sortedMap = new TreeMap<>();

        //JDK1.7 锁分离技术：将一个大的table分割成多个小的table来进行加锁
        //JDK1.8 Node数组+链表+红黑树
        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();
    }
}
