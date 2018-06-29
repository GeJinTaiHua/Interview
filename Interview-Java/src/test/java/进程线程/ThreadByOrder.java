package 进程线程;

/*
 * @desc
 *  有三个线程T1 T2 T3，如何保证他们按顺序执行
 *  在T2的run中，调用t1.join，让t1执行完成后再让T2执行
 *  在T3的run中，调用t2.join，让t2执行完成后再让T3执行
 * @author wjl
 * @date 2018/6/28 0028
 */
public class ThreadByOrder {
    static Thread T1 = new Thread(new Runnable() { 
        @Override
        public void run() {
            System.out.println("T1 RUN");
        }
    });

    static Thread T2 = new Thread(new Runnable() {
        @Override
        public void run() {
            try {
                T1.join();
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }

            System.out.println("T2 RUN");
        }
    });

    static Thread T3 = new Thread(new Runnable() {
        @Override
        public void run() {
            try {
                T2.join();
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("T3 RUN");
        }
    });

    public static void main(String[] args) {
        T1.start();
        T2.start();
        T3.start();
    }
}
