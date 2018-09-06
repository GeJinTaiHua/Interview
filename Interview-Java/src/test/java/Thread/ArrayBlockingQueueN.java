package Thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
 * @desc ArrayBlockingQueue 源码简写
 * 用Lock和Condition实现一个阻塞队列
 * @author wjl
 * @date 2018/9/6 0006
 */
public class ArrayBlockingQueueN {
    // 锁对象
    final Lock lock = new ReentrantLock();
    // 写线程条件
    final Condition notFull = lock.newCondition();
    // 读线程条件
    final Condition notEmpty = lock.newCondition();

    // 缓存队列
    final Object[] items = new Object[100];

    // 写索引
    int putptr;
    // 读索引
    int takeptr;
    // 队列中存在的数据个数
    int count;

    public void put(Object x) throws InterruptedException {
        //可中断锁
        lock.lockInterruptibly();

        try {
            // 如果队列满了
            while (count == items.length) {
                // 阻塞写线程
                notFull.wait();
            }

            items[putptr] = x;

            // 如果写索引写到队列的最后一个位置了，那么置为0
            if (++putptr == items.length) {
                putptr = 0;
            }

            ++count;
            // 唤醒读线程
            notEmpty.signal();

        } finally {
            lock.unlock();
        }
    }

    public Object take() throws InterruptedException {
        lock.lockInterruptibly();

        try {
            while (count == 0) {
                notEmpty.await();
            }

            Object x = items[takeptr];

            if (++takeptr == items.length) {
                takeptr = 0;
            }

            --count;
            notFull.signal();
            return x;
        } finally {
            lock.unlock();
        }
    }
}
