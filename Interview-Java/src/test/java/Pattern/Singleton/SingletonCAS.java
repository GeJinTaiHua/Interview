package Pattern.Singleton;

/*
 * @desc 乐观锁技术
 * @date 2019/4/22 0024
 */
public class SingletonCAS {
    private static final AtomicReference<Singleton> INSTANCE = new AtomicReference<Singleton>();

    private Singleton() {}

    public static Singleton getInstance() {
        for (;;) {
            Singleton singleton = INSTANCE.get();
            if (null != singleton) {
                return singleton;
            }

            singleton = new Singleton();
            if (INSTANCE.compareAndSet(null, singleton)) {
                return singleton;
            }
        }
    }
}
