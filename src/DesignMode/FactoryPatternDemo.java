package DesignMode;

/**
 * @ClassName: FactoryPatternDemo
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/5/13
 * @Time: 10:44
 *
 */

//形状的共同接口
interface Shape{

    void draw();
}

//不同的类进行不同形状的实现
class Rectangle implements Shape{

    @Override
    public void draw() {
        System.out.println("shape rectangle");
    }
}

class Square implements Shape{

    @Override
    public void draw() {
        System.out.println("shape square");
    }
}


class Circle implements Shape{

    @Override
    public void draw() {
        System.out.println("shape circle");
    }
}


//创建一个工厂 生成基于给定信息的实体类对象
class ShapeFactory{

    //获取shapeType字符串对应的Shape
    public Shape getShape(String shapeType){

        if (shapeType==null) return null;

        if (shapeType.equals("CIRCLE")){
            return new Circle();
        }else if (shapeType.equals("RECTANGLE")){
            return new Rectangle();
        }else if (shapeType.equals("SQUARE")){
            return new Square();
        }
        return null;//其他形状返回null
    }
}

public class FactoryPatternDemo {

    public static void main(String[] args) {
        //使用该工厂，通过传递类型信息来获取实体类的对象。
        ShapeFactory shapeFactory=new ShapeFactory();

        //获取Circle对象 调用它的draw方法
        Shape circle = shapeFactory.getShape("CIRCLE");

        //draw
        circle.draw();
        //其他以此类推
    }
}
