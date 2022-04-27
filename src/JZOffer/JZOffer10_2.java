package JZOffer;

/**
 * @ClassName: JZOffer10_2
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/4/19
 * @Time: 10:19
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n级的台阶总共有多少种跳法。
 *
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 * 输入：n = 2
 * 输出：2
输入：n = 7
输出：21


 */
public class JZOffer10_2 {

    //1 2 3 5 8 13 21
    //比如21 可以由13 跳1个台阶得到 也可以由8跳两个台阶得到 因此采用将两个相加的思想
    public int numWays(int n) {

        //注意题目中n=0的时候也为1
        if (n==0||n==1) return 1;
        if (n==2) return 2;
        int a=1,b=2,sum=0;
        for (int i=3;i<=n;i++){
            sum=(a+b)%1000000007;
            a=b;
            b=sum;
        }
        return sum;

    }
}
