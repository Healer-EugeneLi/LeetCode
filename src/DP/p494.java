package DP;

/**
 * @ClassName: p494
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/2/24
 * @Time: 22:43
 *
 * 得到目标和的方法数
 * 输入：nums = [1,1,1,1,1], target = 3
 * 输出：5
 * 解释：一共有 5 种方法让最终目标和为 3 。
 * -1 + 1 + 1 + 1 + 1 = 3
 * +1 - 1 + 1 + 1 + 1 = 3
 * +1 + 1 - 1 + 1 + 1 = 3
 * +1 + 1 + 1 - 1 + 1 = 3
 * +1 + 1 + 1 + 1 - 1 = 3

 这些数有加有减  那么可以理解为一堆正-另外一堆正数=target
 而这些正数的和为target   正1+正2=sum

 因此正1=（target+sum）/2

 将题目转化为这些数中找到部分数 使得和为weight=(target+sum)/2
 */
public class p494 {


    public int findTargetSumWays(int[] nums, int target) {

        int n=nums.length;
        int sum=0,weight=0;
        for (int num:nums)
            sum+=num;
        if (target>sum) return 0;//所有的数加起来也无法的话 无方案数
        if ((sum+target)%2==1) return 0;//即无法让2整除 也就是weight无法为整数
        weight=(sum+target)/2;

        if (weight<0) return 0;//此时求出来背包容量为负数 不符合 肯定是无法的是 所以方案数为0 eg.[200] -100
        int dp[]=new int[weight+1];//dp[j] 表示在索引为0~i的这些数构成和为j的方案数
        //因为后面求组合的情况时  假设 背包重量为5  那么当背包重量为3的方案数为k时
        // 此时再来一个5-3=2 这个数即同样有k个方案可以组成j  所以使用dp[j]+=dp[j-nums[i]] 如果dp[0]=0 那么递推的结果一直是0
        //让结果为0的情况数就是啥都没有放这1种方案
        dp[0]=1;

        for (int i=0;i<n;i++){

            for (int j=weight;j>=nums[i];j--){

                dp[j]+=dp[j-nums[i]];
            }
        }

        return dp[weight];//最后返回背包重量为weight的时候 从0~i个物品中放入的可以组合的方案数

    }
}
