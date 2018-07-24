package Pattern.Singleton;

/*
 * @desc 懒加载
 * @author wjl
 * @date 2018/7/24 0024
 */
public class SingletonIODH {
    static class SingletonHolder {
        static SingletonIODH instance = new SingletonIODH();
    }

    public static SingletonIODH getInstance() {
        return SingletonHolder.instance;
    }
}
