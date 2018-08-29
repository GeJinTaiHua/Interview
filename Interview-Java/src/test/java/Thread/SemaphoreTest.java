package Thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/*
 * @desc 流量控制
 * 30个线程只允许10个同时存在
 * Semaphore的构造方法Semaphore(int permits) 接受一个整型的数字，表示可用的许可证数量。
 * @author wjl
 * @date 2018/8/29 0029
 */
public class SemaphoreTest {
    private static final int THREAD_COUNT = 30;

    private static ExecutorService threadPool = Executors.newFixedThreadPool(THREAD_COUNT);

    private static Semaphore s = new Semaphore(10);

    public static void main(String[] args) {
        for (int i = 0; i < THREAD_COUNT; i++) {
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        s.acquire();// 获取一个许可证
                        System.out.println("ToDo");
                        s.release();// 归还许可证
                    } catch (InterruptedException e) {
                    }
                }
            });
        }

        threadPool.shutdown();
    }
}
