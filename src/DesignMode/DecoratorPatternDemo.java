package DesignMode;

/**
 * @ClassName: DecoratorPatternDemo
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/5/13
 * @Time: 11:30
 */


//创建实现了 Shape 接口的抽象装饰类。
abstract class ShapeDecorator implements Shape{

    protected Shape decorateShape;//需要修饰的Shape

    public ShapeDecorator(Shape decorateShape){
        this.decorateShape=decorateShape;
    }

    public void draw(){
        decorateShape.draw();
    }

}

//创建扩展了 ShapeDecorator 类的实体装饰类。
class RedShapeDecorator extends ShapeDecorator{

    public RedShapeDecorator(Shape decorateShape){
        super(decorateShape);
    }

    @Override
    public void draw() {
        decorateShape.draw();
        setRedBorder(decorateShape);//装饰的方法
    }

    private void setRedBorder(Shape decorateShape){
        System.out.println("color red");
    }
}
//装饰器模式
public class DecoratorPatternDemo {


    public static void main(String[] args) {
        ShapeDecorator redCircle=new RedShapeDecorator(new Circle());
        redCircle.draw();
    }
}
