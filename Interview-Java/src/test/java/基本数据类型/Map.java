package 基本数据类型;

import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.SortedMap;
import java.util.TreeMap;

/*
 * @desc 键值：Map
 *
 * HashMap
 * Hashtable
 * SortedMap（TreeMap）
 *
 * @author wjl
 * @date 2018/6/14 0014
 */
@SpringBootTest
public class Map {
    public void T() {
        HashMap<String, String> hashMap = new HashMap<>();

        Hashtable<String, String> hashtable = new Hashtable<>();

        SortedMap<String, String> sortedMap = new TreeMap<>();
    }
}
