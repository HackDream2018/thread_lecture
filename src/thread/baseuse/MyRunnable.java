package thread.baseuse;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 * @date: 2019/5/26
 */
public class MyRunnable {
    public static void main(String[] args) {
        Thread task1 = new Thread(new MyRunnableTask());
        Thread task2 = new Thread(new MyRunnableTask());

        task1.setName("线程1");
        task2.setName("线程2");

        task1.start();
        task2.start();

        /*加入线程池
        ExecutorService pool = Executors.newFixedThreadPool(10);
        pool.submit(new MyRunnableTask());
        pool.submit(new MyRunnableTask());
        // 关闭线程池, 否则会一直等待新线程加入
        pool.shutdown();*/
    }
}


class MyRunnableTask implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "执行");
    }
}