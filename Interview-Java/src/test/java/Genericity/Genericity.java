package Genericity;

import www.wjl.com.Interview.entity.Genericity.Apple;
import www.wjl.com.Interview.entity.Genericity.Fruit;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * 一维泛型数组
 *
 * @author wjl
 * @date 2021/5/14 14:41
 */
public class Genericity<T> {
    private T[] oneArray;
    private T[][] twoArray;

    public Genericity(Class<T> c, int size) {
        oneArray = (T[]) Array.newInstance(c, size);
//        oneArray = (T[]) new Object[size];
    }

    public Genericity(Class<T> c, int row, int column) {
        twoArray = (T[][]) Array.newInstance(c, row, column);
    }

    public T[] getOneArray() {
        return oneArray;
    }

    public T[][] getTwoArray() {
        return twoArray;
    }

    public static void main(String[] args) {
        Apple[] apple = new Genericity<Apple>(Apple.class, 10).getOneArray();
        apple[0] = new Apple("1");
        apple[2] = new Apple("2");
        System.out.println(apple[0]);

        Fruit[][] fruit = new Genericity<Fruit>(Fruit.class, 10, 5).getTwoArray();
        fruit[0][1] = new Fruit("01");
        fruit[1][1] = new Fruit("11");
        System.out.println(fruit[0][1]);

        List<?>[] lsa = new List<?>[10];
        lsa[0] = new ArrayList<>(1);
    }
}
