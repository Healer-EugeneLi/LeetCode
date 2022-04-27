package JavaProxy;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: DynamicProxyDemo
 * @Description: 动态代理
 * @Author EugeneLi
 * @Date: 2022/4/26
 * @Time: 9:41
 */



class  DynamicProxy implements InvocationHandler{

    Object target;

    /**
     * 生产代理对象实例
     * @param target
     * @return
     */
    public Object getInstance(Object target){
        this.target=target;
        //生成动态代理类以及访问它的实例
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }

    /**
     * 实现这个方法来 进行对目标类调用的时候进行预处理后处理
     * 当你使用代理对象调用方法的时候实际会调用到这个方法
     * @param proxy 动态生成的代理类
     * @param method 与代理类对象调用的方法相对应
     * @param args 当前 method 方法的参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("开始执行");
        Object invoke = method.invoke(target, args);
        System.out.println("执行完毕");
        return invoke;
    }
}
public class DynamicProxyDemo {

    @Test
    public void testDynamicProxy(){

        List<String> dynamicProxyList= (List) new DynamicProxy().getInstance(new ArrayList<>());
        dynamicProxyList.add("hello world");
        System.out.println(dynamicProxyList.toString());

    }
}
