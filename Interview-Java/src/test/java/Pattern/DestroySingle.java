package Pattern;

import Pattern.Singleton.SingletonHungry;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
     * 通过反射把单例的构造函数设置为可访问，然后去生成一个新的对象。
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

    /*
     * @desc 利用反序列化破坏
     * 序列化会通过反射调用无参数的构造方法创建一个新的对象。
     * @author wjl
     * @date 2018/8/2 0002
     */
    @Test
    public void testSerialize() throws Exception {
        SingletonHungry A = SingletonHungry.getInstance();
        FileOutputStream fos = new FileOutputStream("test.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(A);
        oos.flush();
        oos.close();

        SingletonHungry B = null;
        FileInputStream fls = new FileInputStream("test.txt");
        ObjectInputStream ols = new ObjectInputStream(fls);
        B = (SingletonHungry) ols.readObject();

        System.out.println("A=B:" + (A == B)); //A=B:false
    }
}
