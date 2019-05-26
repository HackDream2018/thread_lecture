package thread.producerandconsumermodel;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 * @date: 2019/5/26
 */
public class Main {

    public static void main(String[] args) {
        Thread producer = new Thread(new Producer());
        Thread consumer1 = new Thread(new Consumer());
        Thread consumer2 = new Thread(new Consumer());

        producer.setName("生产者线程1");
        consumer1.setName("消费者线程1");
        consumer2.setName("消费者线程2");

        producer.start();
        consumer1.start();
        consumer2.start();
    }

}
