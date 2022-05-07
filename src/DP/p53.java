package DP;

/**
 * @ClassName: p53
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/5/1
 * @Time: 17:08
 */
public class p53 {

//    /**
//     * 最大子数组和 或者最大字段和
//     * @param nums
//     * @return
//     */
//    public int maxSubArray(int[] nums) {
//
//
//        int dp[]=new int[nums.length];
//        //dp[i]表示以nums[i]为结尾的最大子数组和
//        dp[0]=nums[0];
//        for (int i=1;i< nums.length;i++){
//            //转移方程 当前值或者i-1结尾的子数组最大和加上当前值 两者取最大
//            dp[i]=Math.max(nums[i],dp[i-1]+nums[i]);
//        }
//
//        int res=nums[0];
//        for (int value:dp){
//            if (value>res)
//                res=value;
//        }
//
//        return res;
//
//
//    }

    /**
     * 根据上面的dp写法可以知道 dp[i]只与前一个dp[i-1]有关 因此设置sum为遍历的时候更新的dp[i-1]的值
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {

        int ans=nums[0];
        int sum=0;
        for(int i=0;i<nums.length;i++){

            //此时sum 还是dp[i-1]
            //如果i-1结尾的最大子数组加上当前值比单独自己一个大 那么就更新以i结尾的最大子数组值
            if(sum+nums[i]>nums[i])
                sum+=nums[i];
            else
                sum=nums[i];//否则就是等于自己本身而已

            //更新最大值 这个时候更新完实质sum就等价于dp[i]
            if(sum>ans)
                ans=sum;

        }
        return ans;


    }

}
