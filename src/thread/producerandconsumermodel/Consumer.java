package thread.producerandconsumermodel;

/**
 * @version v1.0
 * @author: TianXiang
 * @description: 消费者
 * @date: 2019/5/26
 */
public class Consumer implements Runnable{

    @Override
    public void run() {
        while (true) {
            Warehouse.get();
            try {
                Thread.sleep(300);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
