package Pattern.Singleton;

/*
 * @desc 静态内部类
 * @author wjl
 * @date 2018/7/24 0024
 */
public class SingletonIODH {
    private static class SingletonHolder {
        private static final SingletonIODH instance = new SingletonIODH();
    }

    private SingletonIODH() {
    }

    public static final SingletonIODH getInstance() {
        return SingletonHolder.instance;
    }
}
