package 基本数据类型;

import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

/*
 * @desc 集合：Collection
 *
 * List（ArrayList，LinkedList，Vector（Stack））
 * Set（HashSet，SortedSet（TreeSet））
 *
 * @author wjl
 * @date 2018/6/14 0014
 */
@SpringBootTest
public class Collection {
    public void List() {
        List<String> arrayList = new ArrayList<>();

        List<String> linkedList = new LinkedList<>();

        List<String> vector = new Stack<>();
    }

    public void Set() {
        HashSet<String> hashSet = new HashSet<>();

        SortedSet<String> sortedSet = new TreeSet<>();
    }
}
