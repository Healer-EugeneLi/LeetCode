package DesignMode;

/**
 * @ClassName: Singleton
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/4/26
 * @Time: 21:40
 */
public class Singleton {

    /**
     * 为 uniqueInstance 分配内存空间
     * 初始化 uniqueInstance
     * 将 uniqueInstance 指向分配的内存地址
     */

   private volatile static Singleton uniqueInstance;

   public Singleton(){

   }

   public static Singleton getUniqueInstance(){

       //先判断对象是否实例过，没有实例过才可以进入加锁代码
       if (uniqueInstance==null){
           //类对象加锁
           synchronized (Singleton.class){
               if (uniqueInstance==null){
                   uniqueInstance=new Singleton();
               }
           }
       }
       return uniqueInstance;
   }
}
