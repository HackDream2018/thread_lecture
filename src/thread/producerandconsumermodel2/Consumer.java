package thread.producerandconsumermodel2;

/**
 * @version v1.0
 * @author: TianXiang
 * @description: 消费者
 * @date: 2019/5/26
 */
public class Consumer implements Runnable{

    Warehouse warehouse;

    public Consumer(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    @Override
    public void run() {
        while (true) {
            warehouse.get();
            try {
                Thread.sleep(300);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
