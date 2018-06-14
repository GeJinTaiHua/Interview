package 基本数据类型;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/*
 * @desc 集合：Collection
 * List（ArrayList，LinkedList，Vector（Stack））
 * Set（HashSet，SortedSet（TreeSet））
 * @author wjl
 * @date 2018/6/14 0014
 */
@SpringBootTest
public class Collection {
    @Test
    public void List() {
        // 以数组形式实现，顺序插入、查找快，插入、删除较慢
        List<String> arrayList = new ArrayList<>();
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");
        arrayList.get(0);
        arrayList.remove("C");

        // 以链表形式实现，顺序插入、查找较慢，插入、删除方便
        List<String> linkedList = new LinkedList<>();

        List<String> vector = new Stack<>();

        //读写分离+最终一致
        List<String> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
    }

    @Test
    public void Set() {
        HashSet<String> hashSet = new HashSet<>();

        SortedSet<String> sortedSet = new TreeSet<>();
    }
}
