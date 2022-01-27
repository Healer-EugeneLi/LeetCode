package JZOffer;

/**
 * @ClassName: JZOffer65
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/1/18
 * @Time: 17:37
 *
 * 位运算加法
 */
public class JZOffer65 {
    public int add(int a, int b) {

        while (b!=0){//当进位不等于0才需要往下走  如果是0 那么无需往下走了

            //a用来保留原味 b用来存储进位

            int next=a&b;
            a=a^b;//本位
            b=next<<1;//进位
        }
        return a;
    }

    public static void main(String[] args) {

        int a=6,b=3;

        JZOffer65 t=new JZOffer65();
        int add = t.add(a, b);
        System.out.println(add);
    }
}
