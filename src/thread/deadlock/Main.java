package thread.deadlock;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 * @date: 2019/5/27
 */
public class Main {
    
    public static void main(String[] args) {
        // 4根筷子
        Chopstick c1 = new Chopstick(1);
        Chopstick c2 = new Chopstick(2);
        Chopstick c3 = new Chopstick(3);
        Chopstick c4 = new Chopstick(4);

        new Thread(new Person("a", c2, c1, 0L)).start();
        new Thread(new Person("b", c3, c2, 1000L)).start();
        new Thread(new Person("c", c4, c3, 0L)).start();
        new Thread(new Person("d", c1, c4, 1000L)).start();
    }
    
}
