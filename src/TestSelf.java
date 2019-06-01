import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestSelf {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        List<Object> objects = new ArrayList<>();
        for (int i=0;i<10;i++){


            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    if(!objects.contains(Thread.currentThread())){
                        objects.add(Thread.currentThread());
                    }

                    for (int i=0;i<10;i++){
                        try{
                            Thread.currentThread().sleep(1);
                        }
                        catch (Exception e){
                            System.out.println("异常异常异常异常异常异常异常异常异常");

                        }
                        System.out.println(Thread.currentThread().getName()+"线程名字"+i);

                        System.out.println("第"+i+"执行一条线程");
                    }
                }
            };

            executorService.execute(runnable);


        }
        try{
            Thread.currentThread().sleep(50);
            System.out.println("name: "+Thread.currentThread().getName());

        }catch (Exception e){

        }
        for (int i = 0; i < objects.size(); i++) {
            System.out.println(objects.get(i)+"-------------size: ");
        }
        System.out.println("size: "+objects.size()+"----------------------------------------");
        executorService.shutdown();
        for (int i = 0; i < objects.size(); i++) {
            System.out.println("-------------size: "+objects.get(i));
        }
    }
}
