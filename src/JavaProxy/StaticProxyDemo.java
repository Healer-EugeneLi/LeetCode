package JavaProxy;

import org.junit.Test;

/**
 * @ClassName: StaticProxyDemo
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/4/26
 * @Time: 9:55
 */

interface Person{
    public void doWork();
}

class Student implements Person{

    @Override
    public void doWork() {
        System.out.println("学习");
    }
}

class StaticProxy implements Person{


    private Person person;

    public StaticProxy(Person person){
        this.person=person;
    }

    @Override
    public void doWork() {

        System.out.println("执行前");
        person.doWork();
        System.out.println("执行后");
    }
}
public class StaticProxyDemo {

    @Test
    public void testStatic(){

        Person student=new Student();
        StaticProxy staticProxy=new StaticProxy(student);
        staticProxy.doWork();
    }
}
