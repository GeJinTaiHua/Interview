package 进程线程;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;

/*
 * @desc CountDownLatch : 一个线程(或者多个)， 等待另外N个线程完成某个事情之后才能执行
 * @author wjl
 * @date 2018/7/24 0024
 */
public class CountDownLatchDemo {
    final static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(2);//两个工人的协作
        Worker worker1 = new Worker("甲乙丙丁", 8000, latch);
        Worker worker2 = new Worker("我就高兴", 5000, latch);
        worker1.start();
        worker2.start();
        latch.await();//等待所有工人完成工作
        System.out.println("all work done at " + sdf.format(new Date()));
    }

    static class Worker extends Thread {
        String workerName;
        int workTime;
        CountDownLatch latch;

        public Worker(String workerName, int workTime, CountDownLatch latch) {
            this.workerName = workerName;
            this.workTime = workTime;
            this.latch = latch;
        }

        public void run() {
            System.out.println("Worker " + workerName + " do work begin at " + sdf.format(new Date()));
            doWork();
            System.out.println("Worker " + workerName + " do work complete at " + sdf.format(new Date()));
            //工人完成工作，计数器减一
            latch.countDown();
        }

        private void doWork() {
            try {
                Thread.sleep(workTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
