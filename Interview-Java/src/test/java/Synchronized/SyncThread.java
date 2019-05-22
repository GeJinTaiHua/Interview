package Synchronized;

/**
 * synchronized
 *
 * @author xiaolong
 * @date 2019/5/22 16:25
 */
public class SyncThread implements Runnable {
    private static int count;

    public void run() {
        // 同步语句块
        synchronized (this) {
            for (int i = 0; i < 5; i++) {
                // todo
            }
        }
    }

    // 同步方法
    public synchronized void method() {
        // todo
    }

    /**
     * 静态方法是属于类的而不属于对象的。同样的，synchronized修饰的静态方法锁定的是这个类的所有对象。
     */
    public synchronized static void method2() {
        // todo
    }

    /**
     * synchronized作用于一个类T时，是给这个类T加锁，T的所有对象用的是同一把锁。
     */
    public void method3() {
        synchronized (SyncThread.class) {
            // todo
        }
    }
}
