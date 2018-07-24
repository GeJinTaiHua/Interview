package Pattern.Singleton;

/*
 * @desc double check
 * @author wjl
 * @date 2018/7/24 0024
 */
public class SingletonDC {
    private volatile static SingletonDC instance;

    public static SingletonDC getInstance() {
        if (instance == null) {
            synchronized (SingletonDC.class) {
                if (instance == null) {
                    instance = new SingletonDC();
                }
            }
        }
        return instance;
    }
}

