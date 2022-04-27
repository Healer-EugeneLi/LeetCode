package ThreadLearn.Proplem;

/**
 * @ClassName: p1114
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/4/27
 * @Time: 11:03
 */
public class p1114 {

    class Foo {

        public boolean firstDone=false;//判断第一个线程是否执行完毕
        public boolean secondDone=false;//判断第二个线程是否执行完毕
        public Object object=new Object();//用来控制信号量 相当于锁住这个对象 来实现独占这个锁
        public Foo() {

        }

        public void first(Runnable printFirst) throws InterruptedException {

            synchronized (object){
                // printFirst.run() outputs "first". Do not change or remove this line.
                printFirst.run();
                firstDone=true;//设置第一个线程执行完成
                object.notifyAll();//唤醒等待这个object对象的线程
            }

        }

        public void second(Runnable printSecond) throws InterruptedException {

            synchronized (object){
                while (firstDone==false){
                    object.wait();//如果第一个线程还未执行完毕 那么就等待
                }
                //如果第一个线程执行完了 那么就可以执行第2个线程
                // printSecond.run() outputs "second". Do not change or remove this line.
                printSecond.run();
                secondDone=true;//此时设置第二个线程执行完毕
                object.notifyAll();//同样释放锁 唤醒其他等待这个对象锁的线程

            }

        }

        public void third(Runnable printThird) throws InterruptedException {

            synchronized (object){
                while (secondDone==false){
                    object.wait();//第二个线程还未执行完毕 等待
                }
                //第二个线程执行完 那么第第三个线程可以执行
                // printThird.run() outputs "third". Do not change or remove this line.
                printThird.run();
                object.notifyAll();
            }

        }
    }
}
