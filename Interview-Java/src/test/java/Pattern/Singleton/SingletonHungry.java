package Pattern.Singleton;

import java.io.Serializable;

/*
 * @desc 饿汉模式
 * @author wjl
 * @date 2018/7/27 0027
 */
public class SingletonHungry implements Serializable {
    private static SingletonHungry instance = null;

    static {
        instance = new SingletonHungry();
    }

    private SingletonHungry() {
//        // 1.避免反射破坏单例
//        if (instance != null) {
//            throw new UnsupportedOperationException("实例已经初始化过！");
//        }
    }

    public static SingletonHungry getInstance() {
        return instance;
    }

//    // 2.避免反系列化破坏单例
//    private Object readResolve() {
//        return instance;
//    }
}
