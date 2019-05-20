package Thread;

import org.junit.Test;

/*
 * @desc 基础知识
 * @author wjl
 * @date 2018/6/28 0028
 */
public class ThreadT {
    /* Thread类构造方法：
    1.ThreadT（）
    2.ThreadT（String name）
    3.ThreadT（Runable r）
    4.ThreadT（Runable r, String name）
    */

    /* thread类常用方法：
    start(); // 启动线程
    getId(); // 获得线程ID
    getName(); // 获得线程名字
    getPriority(); // 获得优先权
    isAlive(); // 判断线程是否活动
    isDaemon(); // 判断是否守护线程
    getState(); // 获得线程状态
    sleep(long mill);// 休眠线程
    join(); // 等待线程结束
    yield(); // 放弃cpu使用权利
    interrupt(); // 中断线程
    currentThread(); // 获得正在执行的线程对象
    */

    class Thread1 extends Thread {
        @Override
        public void run() {
            System.out.println("extend thread");
        }
    }

    class Thread2 implements Runnable {
        public void run() {
            System.out.println("runbale interfance");
        }
    }

    @Test
    public void test() {
        new Thread1().start();
        new Thread1().start();

        Thread2 thread2 = new Thread2();
        new Thread(thread2).start();
        new Thread(thread2).start();
    }
}
