package ThreadLearn.MyPool;

import java.util.Date;

/**
 * @ClassName: MyRunnableDemo
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/4/27
 * @Time: 20:17
 */
public class MyRunnable implements Runnable{

    private String command;

    public MyRunnable(String s){
        this.command=s;
    }
    @Override
    public void run() {


        System.out.println(Thread.currentThread().getName()+"start time:"+new Date());
        processCommand();
        System.out.println(Thread.currentThread().getName()+"end time:"+new Date());
    }

    private void processCommand() {

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "MyRunnableDemo{" +
                "command='" + command + '\'' +
                '}';
    }
}
