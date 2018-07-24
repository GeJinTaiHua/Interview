package 进程线程;

import www.wjl.com.Interview.entity.ThreadCount;

import java.util.concurrent.*;

/*
 * @desc 假如有 Thread1、Thread2、ThreaD3、Thread4 四条线程分别统计 C、D、E、F 四个盘的大小，
 *  所有线程都统计完毕交给 Thread5 线程去做汇总，应当如何实现？
 * @author wjl
 * @date 2018/7/23 0023
 */
public class TestThread {
    public static void main(String[] args) {
        ThreadCount tc = null;
        ExecutorService es = Executors.newCachedThreadPool();//线程池
        CompletionService<Integer> cs = new ExecutorCompletionService<Integer>(es);
        for (int i = 0; i < 4; i++) {
            tc = new ThreadCount(i + 1);
            cs.submit(tc);
        }

        // 添加结束，及时shutdown，不然主线程不会结束
        es.shutdown();

        int total = 0;
        for (int i = 0; i < 4; i++) {
            try {
                total += cs.take().get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

        System.out.println(total);
    }
}