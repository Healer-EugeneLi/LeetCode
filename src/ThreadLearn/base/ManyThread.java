package ThreadLearn.base;

/**
 * @ClassName: ManyThread
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/4/17
 * @Time: 11:19
 */
public class ManyThread {
    public static void main(String[] args) {

        Tiger tiger=new Tiger();
        Thread t1=new Thread(tiger);
        t1.setName("tiger 1");

        Thread t2=new Thread(tiger);
        t2.setName("tiger2");

        t1.start();
        t2.start();
    }
}




class Tiger implements Runnable{



    @Override
    public void run() {

        int time=0;

        while (true){

            try {
                System.out.println(Thread.currentThread().getName()+"--"+time++);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (time==10)
                break;

        }
    }
}