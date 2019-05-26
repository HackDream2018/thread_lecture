package thread.producerandconsumermodel2;

/**
 * @version v1.0
 * @author: TianXiang
 * @description: 生产者
 * @date: 2019/5/26
 */
public class Producer implements Runnable{

    Warehouse warehouse;

    public Producer(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    @Override
    public void run() {
        while(true) {
            warehouse.put("咸鱼");
            try {
                Thread.sleep(200);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
