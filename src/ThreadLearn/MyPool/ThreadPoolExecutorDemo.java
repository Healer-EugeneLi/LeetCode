package ThreadLearn.MyPool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName: ThreadPoolExecutorDemo
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/4/27
 * @Time: 20:20
 */
public class ThreadPoolExecutorDemo {

    private static final int CORE_POOL_SIZE = 5;//核心线程数为 5。
    private static final int MAX_POOL_SIZE = 10;//最大线程数 10
    private static final int QUEUE_CAPACITY = 100;//任务队列为 ArrayBlockingQueue，并且容量为 100;
    private static final Long KEEP_ALIVE_TIME = 1L;//等待时间为 1L

    public static void main(String[] args) {
        ThreadPoolExecutor executor=new ThreadPoolExecutor(CORE_POOL_SIZE,MAX_POOL_SIZE,KEEP_ALIVE_TIME,
                TimeUnit.SECONDS,new ArrayBlockingQueue<>(QUEUE_CAPACITY),
                new ThreadPoolExecutor.CallerRunsPolicy());

        for (int i=0;i<10;i++){
            //创建线程对象
            Runnable worker=new MyRunnable(""+i);
            //执行Runnable
            executor.execute(worker);
        }

        //终止线程池
        executor.shutdown();

        while (!executor.isTerminated()){

        }
        System.out.println("finish all threads");
    }


}
