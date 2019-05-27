package thread.deadlock;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 * @date: 2019/5/27
 */
public class Person implements Runnable{
    private String name;
    private Chopstick left;
    private Chopstick right;
    private Long time;

    public Person(String name, Chopstick left, Chopstick right, Long time) {
        this.name = name;
        this.left = left;
        this.right = right;
        this.time = time;
    }

    @Override
    public void run() {
        synchronized (left) {
            System.out.println(String.format("%s 拿起了左手边的%s号筷子", this.name, this.left.getNum()));
        }
        synchronized (right) {
            System.out.println(String.format("%s 拿起了右手边的%s号筷子", this.name, this.right.getNum()));
            System.out.println(this.name + "狼吞虎咽的开始吃饭!!!");
        }
    }
}
