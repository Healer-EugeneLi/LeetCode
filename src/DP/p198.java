package DP;

/**
 * @ClassName: p198
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/4/7
 * @Time: 23:30
 * 输入：[1,2,3,1]
 * 输出：4
 * 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 *     偷窃到的最高金额 = 1 + 3 = 4 。

 */
public class p198 {

    public int rob(int[] nums) {


        if (nums.length==1) return nums[0];
        //设dp[i]表示 考虑下标i（包括i）以内的房屋，最多可以偷到的金额为dp[i]

        int dp[]=new int[nums.length];
        dp[0]=nums[0];//最大的肯定是偷第一间房屋
        dp[1]=Math.max(nums[0],nums[1]);//前两间取最大

        for (int i=2;i<nums.length;i++){

            dp[i]=Math.max(dp[i-2]+nums[i],dp[i-1]);//偷当前的房屋 以及 如果不偷 进行比较 取最大
        }

        return dp[nums.length-1];

    }
}
