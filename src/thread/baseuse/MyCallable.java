package thread.baseuse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 * @date: 2019/5/26
 */
public class MyCallable {

    public static void main(String[] args) {
        // 任务容器集
        List<FutureTask<String>> futureTasks = new ArrayList<>(2);
        for(int i = 0;i < 2; i++) {
            FutureTask<String> task = new FutureTask<>(new MyCallableTask());
            futureTasks.add(task);
            Thread thread = new Thread(task);
            thread.start();
           /*  加入线程池
            ExecutorService executor = Executors.newFixedThreadPool(10);
            FutureTask<String> task = new FutureTask<>(new MyCallableTask());
            futureTasks.add(task);
            executor.submit(task);
            // 关闭线程池, 否则会一直等待新线程加入
            executor.shutdown();*/
        }
        // 从任务容器中取返回值
        futureTasks.forEach(item -> {
            try {
                // FutureTask里的get()会一直阻塞直到收到线程的返回值将FutureTask里的status -> 2
                String result = item.get();
                System.out.println(result);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

}

class MyCallableTask implements Callable<String> {

    @Override
    public String call() throws Exception {
        return "我是结果";
    }
}
