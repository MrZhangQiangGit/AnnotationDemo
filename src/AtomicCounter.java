
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicCounter {

    private AtomicInteger count = new AtomicInteger(0);

    // 使用AtomicInteger之后，不需要加锁，也可以实现线程安全。
    public void increment() {
        //获取当前的值并自增
        count.incrementAndGet();
    }
    /**
     * 获取当前的值
     * @return
     */
    public int getCount() {
        return count.get();
    }
    //递减
    public void deIncrement(){
        count.decrementAndGet();
    }


    /**
     * 这里模拟一个递增的任务，递增目标为50000
     */
    public static void main(String[] args) throws InterruptedException {
        final AtomicCounter counter = new AtomicCounter();
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