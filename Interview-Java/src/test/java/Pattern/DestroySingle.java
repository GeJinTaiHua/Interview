package Pattern;

import Pattern.Singleton.SingletonHungry;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Constructor;


/*
 * @desc 破坏单例
 * @author wjl
 * @date 2018/8/2 0002
 */
@SpringBootTest
public class DestroySingle {
    /*
     * @desc 利用反射破坏
     * @author wjl
     * @date 2018/8/2 0002
     */
    @Test
    public void testReverberation() throws Exception {
        SingletonHungry A = SingletonHungry.getInstance();
        SingletonHungry B = SingletonHungry.getInstance();
        System.out.println("A=B:" + (A == B)); //A=B:true

        // 反射调用方法
        Class clazz = SingletonHungry.class;
        Constructor cons = clazz.getDeclaredConstructor(null);
        cons.setAccessible(true);
        SingletonHungry C = (SingletonHungry) cons.newInstance(null);
        System.out.println("A=C:" + (A == C)); //A=C:false
    }
}
