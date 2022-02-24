package DP;

/**
 * @ClassName: p343
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/2/24
 * @Time: 15:51
 *
 * 整数拆分
 * 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
 */
public class p343 {

    public int integerBreak(int n) {

        //初始值设置dp[2]=1 表示2这个数可以得到的最大乘积为1x1=1
        //遍历从3到n 对当前数字i进行1~i的遍历 值为j 也就是可以由j这个数和i-j这个数来得到一个乘积
        // 设置 dp[i]=max(dp[i],max(dp[i-j]*j,(i-j)*j))
        int dp[]=new int[n+1];
        dp[2]=1;

        //遍历n范围内的每个数
        for (int i=3;i<=n;i++){

            //进行拆分 求出i这个数可以得到的最大乘积 dp[i]
            for (int j=1;j<i;j++){

                dp[i]=Math.max(dp[i],Math.max(dp[i-j]*j,(i-j)*j));
            }

        }

        return dp[n];
    }

    public static void main(String[] args) {

        int n=10;
        p343 t=new p343();
        int res = t.integerBreak(n);
        System.out.println(res);
    }
}
