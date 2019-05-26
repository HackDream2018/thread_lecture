package thread.producerandconsumermodel;

import java.util.LinkedList;

/**
 * @version v1.0
 * @author: TianXiang
 * @description: 仓库
 * @date: 2019/5/26
 */
public class Warehouse {

    // 规定存取容器(添加和删除用链表会更快)
    private static LinkedList<String> linkedList = new LinkedList();

    private Warehouse() {}

    // 锁的是当前类的字节码
    public synchronized static void put(String goods) {
        if(20 > linkedList.size()) {
            System.out.println(String.format("%s 放入了商品: %s", Thread.currentThread().getName(), goods));
            linkedList.add(goods);
        }else {
            try{
                linkedList.notifyAll();
                // 调用类对象的线程进入等待(对象锁), 而不是调用类成员变量的线程进入等待(变量可能有生产者和消费者) 所以有问题
                linkedList.wait();
            }catch (Exception e) {
                 System.out.println(e);
            }
        }
    }

    // 锁的是当前类的字节码
    public synchronized static void get() {
        if(0 < linkedList.size()) {
            System.out.println(String.format("%s 取出了商品: %s", Thread.currentThread().getName(), linkedList.get(0)));
            linkedList.remove(0);
        }else {
            try{
                linkedList.notifyAll();
                // 调用类对象的线程进入等待(对象锁), 而不是调用类成员变量的线程进入等待(变量可能有生产者和消费者) 所以有问题
                linkedList.wait();
            }catch (Exception e) {
                System.out.println(e);
            }
        }
    }

}
