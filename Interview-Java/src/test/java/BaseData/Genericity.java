package BaseData;

import www.wjl.com.Interview.entity.Genericity.Apple;
import www.wjl.com.Interview.entity.Genericity.Fruit;
import www.wjl.com.Interview.entity.Genericity.GenericHolder;

/*
 * @desc 泛型
 * @author wjl
 * @date 2018/8/31 0031
 */
public class Genericity {
    private static void eatFruit(GenericHolder<? extends Fruit> fruitGenericHolder) {
        System.out.println("我正在吃 " + fruitGenericHolder.getObj().getName());
    }

    public static void main(String args[]) {
        GenericHolder<Fruit> fruitGenericHolder = new GenericHolder<>();
        GenericHolder<Apple> appleGenericHolder = new GenericHolder<>();

        Fruit fruit = new Fruit("一堆水果"); 
        Apple apple = new Apple("一筐水果");

        fruitGenericHolder.setObj(fruit);
        eatFruit(fruitGenericHolder);

        appleGenericHolder.setObj(apple);
        eatFruit(appleGenericHolder);
    }
}
