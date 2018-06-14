package 基本数据类型;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.SortedMap;
import java.util.TreeMap;

/*
 * @desc 键值：Map
 * HashMap
 * Hashtable
 * SortedMap（TreeMap）
 * @author wjl
 * @date 2018/6/14 0014
 */
@SpringBootTest
public class Map {
    @Test
    public void T() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("1", "A");
        hashMap.put("1", "B");
        hashMap.put("2", "C");

        Hashtable<String, String> hashtable = new Hashtable<>();

        SortedMap<String, String> sortedMap = new TreeMap<>();
    }
}
