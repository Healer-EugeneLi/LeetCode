package JZOffer;

/**
 * @ClassName: JZOffer16
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/2/20
 * @Time: 21:14
 */
public class JZOffer16 {

    /**
     * 快速幂
     *
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {

        if (x == 0) return 0;

        //当幂为负数时 x=1/x n=-n
        if (n < 0) {
            n = -n;
            x = 1 / x;
        }
        long N = n;
        //当N为偶数时 x^N=x^(2*N//2)
        //当N为奇数时 x^N=x^(2*N//2)*x
        //所以不断的让x^N转换为x的2次方 乘N//2次
        double res = 1;
        while (N > 0) {

            //判断N的奇偶数 一般采用N%2==0 等价于 N&1==1 如果等于1 说明是奇数
            if ((N & 1) == 1)
                res *= x;
            x *= x;//此时x转换成x的平方
            N >>= 1;//同时N//2 即右移一位

        }
        //当最后N==0的时候 结果即为x^n=x^0 * res
        return res;

    }

    public static void main(String[] args) {
        double x=3;
        int N=5;

        JZOffer16 t=new JZOffer16();
        double res = t.myPow(x, N);
        System.out.println(res);

    }
}
