package ThreadLearn.TL;

/**
 * @ClassName: ThreadLocalDemo1
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/4/27
 * @Time: 11:24
 */
public class ThreadLocalDemo1 {

    private static ThreadLocal<String> localVar=new ThreadLocal<String>();

    static void print(String str){
        System.out.println(str+":"+localVar.get());
        localVar.remove();//消除本地内存中的本地变量
    }

    public static void main(String[] args) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                ThreadLocalDemo1.localVar.set("local_A");
                print("A");
                //打印本地变量
                System.out.println("after remove:"+localVar.get());
            }
        },"A").start();
        try {
            Thread.sleep(2000);

            new Thread(new Runnable() {
                @Override
                public void run() {
                    ThreadLocalDemo1.localVar.set("local_B");
                    print("B");
                    System.out.println("after remove:"+localVar.get());
                }
            },"B").start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
