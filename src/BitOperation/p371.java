package BitOperation;

/**
 * @ClassName: p371
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/9/26
 * @Time: 9:10
 */
public class p371 {
    public int getSum(int a, int b) {

        if (a == 0) return b;
        if (b == 0) return a;

        int add = 0;
        while (b != 0) {

            add = (a & b) << 1;//先计算两者位运算的结果 并且还有左移1位  来作为进位的结果
            a = a ^ b;//不进位相加
            b = add;//更新进位到b
        }
        return a;

    }
}
