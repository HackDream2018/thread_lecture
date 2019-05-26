package thread.producerandconsumermodel;

/**
 * @version v1.0
 * @author: TianXiang
 * @description: 生产者
 * @date: 2019/5/26
 */
public class Producer implements Runnable{

    @Override
    public void run() {
        while(true) {
            Warehouse.put("咸鱼");
            try {
                Thread.sleep(200);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
