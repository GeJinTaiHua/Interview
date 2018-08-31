package BaseData;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/*
 * @desc 函数式接口
 * @author wjl
 * @date 2018/8/31 0031
 */
@SpringBootTest
public class FunctionInterfaceDemo {
    // 1. 消费型接口
    private static void donation(Integer money, Consumer<Integer> consumer) {
        consumer.accept(money);
    }

    @Test
    public void ConsumerTest() {
        donation(1000, money -> System.out.println("我消费了" + money + "元"));
    }

    // 2. 供给型接口
    private static List<Integer> supply(Integer num, Supplier<Integer> supply) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            result.add(supply.get());
        }

        return result;
    }

    @Test
    public void SupplyTest() {
        List<Integer> list = supply(10, () -> (int) (Math.random() * 100));
        list.forEach(System.out::println);
    }

    // 3. 函数型接口
    private static Integer convert(String str, Function<String, Integer> function) {
        return function.apply(str);
    }

    @Test
    public void FunctionTest() {
        Integer value = convert("10", x -> Integer.parseInt(x));
    }

    // 4. 断言型接口
    public static List<String> filter(List<String> fruit, Predicate<String> predicate) {
        List<String> f = new ArrayList<>();
        for (String s : fruit) {
            if (predicate.test(s)) {
                f.add(s);
            }
        }
        return f;
    }

    @Test
    public void PredicateTest() {
        List<String> fruit = Arrays.asList("香蕉", "哈密瓜", "榴莲", "火龙果", "水蜜桃");
        List<String> newFruit = filter(fruit, (f) -> f.contains("果") || f.contains("瓜"));
        newFruit.forEach(item -> {
            System.out.println("瓜果有" + item);
        });

        List<String> f2 = fruit.stream().filter(f -> f.contains("果") || f.contains("瓜")).collect(Collectors.toList());

        fruit.stream().filter(f -> f.contains("果") || f.contains("瓜")).forEach(item -> {
            System.out.println("瓜果有" + item);
        });
    }
}
