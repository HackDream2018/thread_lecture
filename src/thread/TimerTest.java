package thread;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 * @date: 2019/5/27
 */
public class TimerTest {

    public static void main(String[] args) throws Exception {
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println("执行了~~");
            }
        };
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmm");
        Date date = format.parse("201905271856");
        // 任务, 到某个时间点执行, 循环周期
        timer.schedule(task, date, 1000*5);
    }

}
