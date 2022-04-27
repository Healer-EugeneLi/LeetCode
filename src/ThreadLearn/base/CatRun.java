package ThreadLearn.base;

/**
 * @ClassName: CatRun
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/4/15
 * @Time: 22:15
 */
public class CatRun {

    public static void main(String[] args) {

        Cat cat=new Cat();
        cat.start();//开启线程
    }
}


/**
 * 当一个类继承了Thread类，该类可以当做线程使用
 * 重写run方法 写上自己的业务代码
 * 线程的实现方式
 * 1.继承Thread类
 * 2.实现Runnable接口的run方法
 */
class Cat extends Thread{

    @Override
    public void run() {

        int time=0;

        while (true){

            System.out.println("I am cat:"+(++time));

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (time==8)
                break;
        }

    }
}