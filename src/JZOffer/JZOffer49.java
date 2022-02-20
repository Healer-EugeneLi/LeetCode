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
     * 对于每一个数都来乘以2 3 5 因为要排序 所以使用三个指针来记录当前是哪个数乘以2 3 5
     * 自增之后 就知道下一个要计算的是哪一个数了
     * @param n
     * @return
     */
    public int nthUglyNumber(int n) {

        int dp[]=new int[n];

        dp[0]=1;
        int p2=0,p3=0,p5=0;
        for (int i=1;i<n;i++){

            dp[i]=Math.min(Math.min(dp[p2]*2,dp[p3]*3),dp[p5]*5);

            if (dp[i]==dp[p2]*2) p2++;//记录下一个丑数来乘以2

            if (dp[i]==dp[p3]*3) p3++;

            if (dp[i]==dp[p5]*5) p5++;
        }

        return dp[n-1];

    }
}
