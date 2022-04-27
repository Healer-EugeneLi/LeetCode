package DP;

/**
 * @ClassName: p300
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/4/17
 * @Time: 22:10
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 *
 * 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 *
 *
 */
public class p300 {

    public int lengthOfLIS(int[] nums) {

        //令dp[i]表示nums[i]结尾的最长严格递增子序列的长度
        //如果nums[i]>nums[j] j 属于[0,i) dp[i]=max(dp[i],dp[j]+1)

        int dp[]=new int[nums.length];
        //每个元素都可以单独成为一个最长严格递增子序列 所以初始长度为1
        for (int i=0;i<nums.length;i++)
            dp[i]=1;

        int max=0;
        //外层表示遍历每一个元素作为结尾
        for (int i=0;i<nums.length;i++){

            for (int j=0;j<i;j++){
                if (nums[i]>nums[j])
                    dp[i]=Math.max(dp[i],dp[j]+1);
                max=Math.max(max,dp[i]);
            }

        }

        return max;

    }

    public static void main(String[] args) {

        int arr[]={1,3,6,7,9,4,10,5,6};

        p300 t=new p300();
        int res = t.lengthOfLIS(arr);
        System.out.println(res);
    }
}
