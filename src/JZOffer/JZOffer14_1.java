package JZOffer;

/**
 * @ClassName: JZOffer14_1
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/1/28
 * @Time: 10:02
 * <p>
 * 剪绳子-1
 * 将n剪成大于1段数目的绳子
 * 使得绳子长度乘积最大
 */
public class JZOffer14_1 {

    //动态规划
//    public int cuttingRope(int n) {
//
//        int dp[]=new int[n+1];//dp[i]表示的是长度为i的绳子 可以得到的最大乘积
//        dp[1]=1;
//        dp[2]=1;
//        for (int i=3;i<=n;i++){
//            //遍历绳子长度直到最后目标长度
//
//            for (int j=2;j<i;j++){
//                // 此循环表示剪掉其中一个长度为j的 然后剩下的j-i 可以继续剪也有选择不剪
//                //因为绳子数目必须是大于1段的 所以j不能取到i
//                int notCut=j*(i-j);//剪掉长度j 剩下i-j 不继续剪
//                int cut=j*dp[i-j];//剪掉长度j 剩下i-j继续剪
//                dp[i]=Math.max(dp[i],Math.max(notCut,cut));
//
//            }
//        }
//        return dp[n];
//    }

    /**
     * 贪心思路 尽可能剪出长度为3的绳子
     *
     * @param n
     * @return
     */
    public int cuttingRope(int n) {

        //长度为2时 结果1
        //     3      2

        if (n < 4) return n - 1;

        int res = 1;

        while (n > 4) {
            res *= 3;
            n -= 3;
        }

        return res * n;

    }
}
