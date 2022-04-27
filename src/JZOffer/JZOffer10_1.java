package JZOffer;

/**
 * @ClassName: JZOffer10_1
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/4/19
 * @Time: 9:37
 * 斐波那契数列
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 *
 * 输入：n = 2
 * 输出：1
 *
 * 0 1 1 2
 */
public class JZOffer10_1 {


    public int fib(int n) {

        if (n==0) return 0;
        if (n==1) return 1;

        int a=0,b=1,sum=0;
        for (int i=2;i<=n;i++){
            sum=(a+b)%1000000007;
            a=b;
            b=sum;
        }
        return sum;
    }
}
