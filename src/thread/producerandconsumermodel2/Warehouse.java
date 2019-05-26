package thread.producerandconsumermodel2;

import java.util.LinkedList;

/**
 * @version v1.0
 * @author: TianXiang
 * @description: 仓库
 * @date: 2019/5/26
 */
public class Warehouse {

    // 规定存取容器(添加和删除用链表会更快)
    private LinkedList<String> linkedList = new LinkedList();
    public synchronized void put(String goods) {
        if(20 > linkedList.size()) {
            System.out.println(String.format("%s 放入了商品: %s", Thread.currentThread().getName(), goods));
            linkedList.add(goods);
        }else {
            try{
                this.notifyAll();
                // 调用当前类对象的线程等待(生产者线程等待)
                this.wait();
            }catch (Exception e) {
                System.out.println(e);
            }
        }
    }
    public synchronized void get() {
        if(0 < linkedList.size()) {
            System.out.println(String.format("%s 取出了商品: %s", Thread.currentThread().getName(), linkedList.get(0)));
            linkedList.remove(0);
        }else {
            try{
                this.notifyAll();
                // 调用当前类对象的线程等待(消费者线程等待)
                this.wait();
            }catch (Exception e) {
                System.out.println(e);
            }
        }
    }

}
