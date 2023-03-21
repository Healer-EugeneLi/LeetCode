package DP;

/**
 * @ClassName: p152
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/5/12
 * @Time: 22:09
 */
public class p152 {


    /**
     * 乘积最大的子数组
     * 输入: nums = [2,3,-2,4]
     * 输出: 6
     * 解释: 子数组 [2,3] 有最大乘积 6。
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {

        int n=nums.length;
        if (n==1) return nums[0];
        //因为数组中可能存在负数 如果直接按照一般的转移肯定不行
        //dp[i][0] 表示以nums[i]结尾的子序列的最小乘积和
        //dp[i][1] 表示以nums[i]结尾的子序列的最大乘积和
        int dp[][]=new int[n][2];

        dp[0][0]=nums[0];
        dp[0][1]=nums[0];

        for (int i=1;i<n;i++){

            //如果当前这个数>=0 是正数
            if (nums[i]>=0){

                dp[i][0]=Math.min(nums[i],nums[i]*dp[i-1][0]);//也就是让当前值乘上前一个数字结尾的子序列最小乘积和 希望能拿到更小的
                dp[i][1]=Math.max(nums[i],nums[i]*dp[i-1][1]);//当前值乘上前一个数字结尾的子序列最大乘积和 希望拿到更大的和
            }else {

                //如果当前这个数是负数的话
                dp[i][0]=Math.min(nums[i],nums[i]*dp[i-1][1]);//当前是负数 那肯定乘以前一个数字结尾的子序列的最大乘积和 这样才能拿到更小的
                dp[i][1]=Math.max(nums[i],nums[i]*dp[i-1][0]);//负数 乘上前一个数字结尾的子序列的最小乘积和 有可能会出现负负得正 得到更大的和
            }
        }

        //最后遍历每一个数字 取以他们结尾的子序列的最大乘积和
        int res=dp[0][1];
        for (int i=1;i<n;i++){
            res=Math.max(res,dp[i][1]);
        }
        return res;
    }
}
