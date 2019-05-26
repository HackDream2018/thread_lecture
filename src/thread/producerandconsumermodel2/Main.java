package thread.producerandconsumermodel2;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 * @date: 2019/5/26
 */
public class Main {

    public static void main(String[] args) {
        Warehouse warehouse = new Warehouse();

        Thread producer = new Thread(new Producer(warehouse));
        Thread consumer1 = new Thread(new Consumer(warehouse));
        Thread consumer2 = new Thread(new Consumer(warehouse));

        producer.setName("生产者线程1");
        consumer1.setName("消费者线程1");
        consumer2.setName("消费者线程2");

        // 生产者只有一个所以提高生产者的线程等级, 提高生产者线程获取CPU的时间片的几率
        producer.setPriority(10);

        producer.start();
        consumer1.start();
        consumer2.start();
    }

}
