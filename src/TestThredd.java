
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TestThredd {

    private volatile int count = 0;

    public synchronized void increment() {
        count++;
    }

    private int getCount() {
        return count;
    }

    /**
     * 这里模拟一个递增的任务，递增目标为50000 
     */
    public static void main(String[] args) throws InterruptedException {
        final TestThredd counter = new TestThredd();
        int workCount = 50000;
        ExecutorService executor = Executors.newFixedThreadPool(10);
        long start = System.currentTimeMillis();
        for (int i = 0; i < workCount; i++) {
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    counter.increment();
                }
            };
            executor.execute(runnable);
        }
        // 关闭启动线程，执行未完成的任务  
        executor.shutdown();
        // 等待所有线程完成任务，完成后才继续执行下一步  
        executor.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);
        System.out.println("耗时：" + (System.currentTimeMillis() - start) + "ms");
        System.out.println("执行结果：count=" + counter.getCount());
    }
}