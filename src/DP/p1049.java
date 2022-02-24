package DP;

/**
 * @ClassName: p1049
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/2/24
 * @Time: 22:04
 *
 * 最后一块石头的重量：
 * 尽量让石头分成重量相同的两堆 最后让这两堆石头的重量相减 得到的就是最后的结果
 * 比如两堆一样 那么这两堆区碰撞 得到的结果肯定是0
 */
public class p1049 {

    public int lastStoneWeightII(int[] stones) {

        int n=stones.length;
        int weight=0,sum=0;
        for (int stone:stones){
            sum+=stone;
        }

        weight=sum/2;//向下取整

        int dp[]=new int[weight+1];

        for (int i=0;i<n;i++){

            for (int j=weight;j>=stones[i];j--){

                dp[j]=Math.max(dp[j],dp[j-stones[i]]+stones[i]);
            }
        }

        //最后weight背包下放的最大重量为dp[weight]  那么另外一堆就是weight-dp[weights] 因为向下取整的 所以weight肯定大于dp[weight]

        return (sum-dp[weight])-dp[weight];

    }
}
