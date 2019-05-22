package www.wjl.com.Interview.service;

import www.wjl.com.Interview.entity.Genericity.Apple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

/**
 * stream
 *
 * @author xiaolong
 * @date 2019/5/22 17:09
 */
public class StreamService {
    /**
     * 构造
     */
    public void initStream() {
        // 1. Individual values
        Stream stream = Stream.of("a", "b", "c");

        // 2. Arrays
        String[] strArray = new String[]{"a", "b", "c"};
        stream = Stream.of(strArray);
        stream = Arrays.stream(strArray);

        // 3. Collections
        List<String> list = Arrays.asList(strArray);
        stream = list.stream();
    }

    /**
     * 方法引用
     */
    public void use() {
        List<Apple> apples = new ArrayList<>();

        apples.sort((Apple p, Apple q)
                -> p.getWeight().compareTo(q.getWeight()));
        apples.sort(Comparator.comparing(Apple::getWeight));
    }
}
