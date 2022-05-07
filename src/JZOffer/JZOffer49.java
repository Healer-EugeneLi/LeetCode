package JZOffer;

/**
 * @ClassName: JZOffer49
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/2/14
 * @Time: 22:11
 * 我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。
 * 求按从小到大的顺序的第 n 个丑数。
 */
public class JZOffer49 {
    /**
     * 所有的丑数都是前面的丑数乘以2 3 5 并选择其中最小值来得到的 最后构成有序的序列
     * 使用三个指针可以根据合并3个数组来理解
     * 对于每一个数都来乘以2 3 5 所以使用三个指针来记录当前是哪个数乘以2 3 5 然后当计算出来的dp[i]判断是乘哪个数得来的 就将代表该数的指针++
     * 自增之后 就知道下一个要计算的是哪一个数了
     *
     * @param n
     * @return
     */
    public int nthUglyNumber(int n) {

        //dp[i]表示第i+1个丑数 dp[0]=1 即第一个丑数为1
        int dp[] = new int[n];
        dp[0] = 1;
        int p2 = 0, p3 = 0, p5 = 0;
        for (int i = 1; i < n; i++) {

            dp[i] = Math.min(Math.min(dp[p2] * 2, dp[p3] * 3), dp[p5] * 5);

            if (dp[i] == dp[p2] * 2) p2++;//也就是dp[i]这个值是通过p2这个位置的值乘以2得到的 那么下一个需要乘2的肯定是p2的下一个位置了 所以p2++

            if (dp[i] == dp[p3] * 3) p3++;

            if (dp[i] == dp[p5] * 5) p5++;
        }

        return dp[n - 1];

    }

    public static void main(String[] args) {

        int n=12;
        JZOffer49 t=new JZOffer49();
        int res = t.nthUglyNumber(n);
        System.out.println(res);
    }
}
