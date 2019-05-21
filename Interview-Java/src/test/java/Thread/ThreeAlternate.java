package Thread;

import static java.lang.System.out;

/**
 * 3个线程交替输出 1-100
 *
 * @author xiaolong
 * @date 2019/5/21 14:39
 */
public class ThreeAlternate {
    int i = 1;

    /**
     * 示例来源：https://github.com/maronghe/ODOP/blob/master/src/com/ibm/thread/ThreadPrintTest.java
     */
    public static void main(String[] args) {
        // 创建该类的对象
        ThreeAlternate obj = new ThreeAlternate();
        // 使用匿名内部类的形式，没创建runnable对象
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                while (obj.i < 100) {
                    // 上锁当前对象
                    synchronized (this) {
                        // 唤醒另一个线程
                        notify();
                        out.println("Thread " + Thread.currentThread().getName() + " " + obj.i++);
                        try {
                            Thread.currentThread();
                            // 使其休眠100毫秒，放大线程差异
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        try {
                            // 释放掉锁
                            wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        };

        // 启动多个线程（想创建几个就创建几个）
        new Thread(runnable).start();
        new Thread(runnable).start();
        new Thread(runnable).start();
    }
}
