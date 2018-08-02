package Pattern.Singleton;

/*
 * @desc 饿汉模式
 * @author wjl
 * @date 2018/7/27 0027
 */
public class SingletonHungry {
    private static SingletonHungry instance = null;

    static {
        instance = new SingletonHungry();
    }

    private SingletonHungry() {
        // 避免反射破坏单例
//        if (instance != null) {
//            throw new UnsupportedOperationException("实例已经初始化过！");
//        }
    }

    public static SingletonHungry getInstance() {
        return instance;
    }
}
