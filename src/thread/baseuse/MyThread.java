package thread.baseuse;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 * @date: 2019/5/26
 */
public class MyThread {

    public static void main(String[] args) {
        MyThreadTask task1 = new MyThreadTask();
        MyThreadTask task2 = new MyThreadTask();

        task1.setName("线程1");
        task2.setName("线程2");

        task1.start();
        task2.start();
    }

}

class MyThreadTask extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "执行");
    }
}
