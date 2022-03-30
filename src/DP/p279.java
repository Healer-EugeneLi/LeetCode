package DP;

/**
 * @ClassName: p279
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/3/30
 * @Time: 21:45
 * 给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。
 *
 * 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。
 * 例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
 *
 */
public class p279 {

    //令dp[i]表示 构成i这个数字的完全平方数的最少数量
    //比如dp[12]=dp[8]+1 因为8可以加上1个4 就能得到结果了 dp[8]=dp[4]+1  此时dp[4] 因为可以由4=2*2得到 所以其值=dp[4-2*2]+1
    //所以dp[0]=0
    public int numSquares(int n) {


        int dp[]=new int[n+1];

        for (int i=1;i<=n;i++){

            dp[i]=i;//表示i这个数 最多情况下就是全部由1来组成 那么就是有i个完全平方数得到 后面通过遍历来更新
            for (int j=1;i-j*j>=0;j++){

                dp[i]=Math.min(dp[i],dp[i-j*j]+1);//如果有更少的方案数来得到的话 就进行更新
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n=12;

        p279 t=new p279();
        int res = t.numSquares(n);
        System.out.println(res);
    }
}
