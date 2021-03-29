package concurrent;

import model.Data;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ConcurrentTest {
    public static void main(String[] args) {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(0);
        executorService.scheduleAtFixedRate(new ThreatTest(),0,5, TimeUnit.SECONDS);
        executorService.shutdownNow();
        executorService.scheduleAtFixedRate(new ThreatTest(),0,5, TimeUnit.SECONDS);
    }
    public static class ThreatTest extends Thread{
        @Override
        public void run() {
            super.run();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
            System.out.println("当前线程："+df.format(new Date()));
        }
    }
}
