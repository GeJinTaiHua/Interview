package Thread;

import org.junit.Test;

/*
 * @desc 多线程实现i++??????????????
 * @author wjl
 * @date 2018/9/6 0006
 */
public class CountAdd implements Runnable {
    private volatile static int count = 0;
    private Object object = new Object();

    @Test
    public void Test1() throws Exception {
        CountAdd i = new CountAdd();
        Thread thread_iCountAdd1 = new Thread(i);
        Thread thread_iCountAdd2 = new Thread(i);
        thread_iCountAdd1.start();
        thread_iCountAdd2.start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            synchronized (object) {
                count++;
            }
        }
    }
}
