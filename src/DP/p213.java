package DP;

/**
 * @ClassName: p213
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/4/7
 * @Time: 23:39
 * 打家劫舍2
 * 输入：nums = [2,3,2]
 * 输出：3
 * 解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
 * 这些房屋会构成一个圈  因此需要考虑两种情况
 * 情况1：不考虑尾部 也就是说此时选择偷首部
 * 情况2：不考虑首部 也就是此时偷尾部
 */
public class p213 {
    /**
     * 打家劫舍2
     * 输入：nums = [2,3,2]
     * 输出：3
     * 解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
     * 这些房屋会构成一个圈  因此需要考虑两种情况
     * 情况1：不考虑尾部 也就是说此时选择偷首部
     *  情况2：不考虑首部 也就是此时偷尾部
     * @param nums
     * @return
     */
    public int rob(int[] nums) {

        if (nums.length==0) return 0;
        if (nums.length==1) return nums[0];

        //情况1 不考虑尾部
        int res1=func(0,nums.length-2,nums);
        //情况2 不考虑首部
        int res2=func(1,nums.length-1,nums);
        return Math.max(res1,res2);
    }

    /**
     *注意是闭区间[start,end]
     * @param start 数组的第一个元素下标
     * @param end  数组的最后一个元素下标
     * @param nums
     * @return
     */
    public int func(int start,int end,int nums[]){

        //dp[i]表示从start开始到i用户 所能偷到的最大值
        if (start==end) return nums[start];

        int dp[]=new int[nums.length];//这边新建的长度不能写成end-start+1 在情况2的时候会报错 直接新建一个与原数组一样大小的准没错
        dp[start]=nums[start];//偷第一个时的值
        dp[start+1]=Math.max(nums[start],nums[start+1]);//偷前两个时的dp值
        //开始从第3户人家开始
        for (int i=start+2;i<=end;i++){
            dp[i]=Math.max(dp[i-2]+nums[i],dp[i-1]);
        }
        return dp[end];//注意此时返回的是dp[end] 比写错写成dp[n.length-1]
    }
}
