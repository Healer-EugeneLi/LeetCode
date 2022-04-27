package ThreadLearn.base;

/**
 * @ClassName: DogRun
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/4/17
 * @Time: 10:58
 */
public class DogRun {


    public static void main(String[] args) {
        Dog dog=new Dog();


        Thread thread=new Thread(dog);

        thread.start();
        for (int i=0;i<10;i++){

            try {
                System.out.println("main ---"+i);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


class Dog implements Runnable{


    @Override
    public void run() {

        int time=0;
        while (true){


            try {
                System.out.println("dog run:"+time++);
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (time==10)
                break;

        }
    }
}