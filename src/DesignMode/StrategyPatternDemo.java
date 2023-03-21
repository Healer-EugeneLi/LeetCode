package DesignMode;

/**
 * @ClassName: StrategyPatternDemo
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/5/13
 * @Time: 10:28
 * 策略模式demo
 */

/**
 * 为两个参数进行操作的一个接口
 */
interface Strategy{
    public int doOperation(int num1,int num2);
}

/**
 * 具体的不同的操作对接口进行不同的实现
 */
class OperationAdd implements Strategy{

    @Override
    public int doOperation(int num1, int num2) {
        return num1+num2;
    }
}

class OperationSubtract implements Strategy{


    @Override
    public int doOperation(int num1, int num2) {
        return num1-num2;
    }
}

class OperationMultiply implements Strategy{

    @Override
    public int doOperation(int num1, int num2) {
        return num1*num2;
    }
}

/**
 * 是一个使用了某种策略的类
 * 使用 Context 来查看当它改变策略 Strategy 时的行为变化。
 */
class Context{

    private Strategy strategy;

    //使用时传入的是该接口的实现类的对象实例 表明此次操作是具体什么样的操作
    public Context(Strategy strategy){
        this.strategy=strategy;
    }

    //调用该对象具体来实现操作运算符
    public int executeStrategy(int num1,int num2){
        return strategy.doOperation(num1,num2);
    }
}
public class StrategyPatternDemo {

    public static void main(String[] args) {

        //传入一个要进行+操作的对象实例
        Context context=new Context(new OperationAdd());
        System.out.println("5+10="+context.executeStrategy(5,10));

        //传入一个要进行*操作的对象实例
        context=new Context(new OperationMultiply());
        System.out.println("5x10="+context.executeStrategy(5,10));

        //传入一个要进行-操作的对象实例
        context=new Context(new OperationSubtract());
        System.out.println("5-10="+context.executeStrategy(5,10));
    }
}
