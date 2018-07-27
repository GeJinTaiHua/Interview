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
    }

    public static SingletonHungry getInstance() {
        return instance;
    }
}
