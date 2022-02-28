package DP;

/**
 * @ClassName: p416
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/2/24
 * @Time: 21:01
 * 0-1背包问题的实际运用 划分两个集合
 */
public class p416 {


//    public boolean canPartition(int[] nums) {
//
//        //物体个数
//        int n=nums.length;
//        //背包重量
//        int weight=0;
//        for (int num:nums)
//            weight+=num;
//        if (weight%2!=0) return false;//不是偶数肯定不行
//        weight/=2;//分割成两个子集  那么背包的重量就是和的一半
//
//        //dp[i][j] 放入i个数 重量（和）为j的价值为多少
//        int dp[][]=new int[n+1][weight+1];
//
//        //遍历物品 也就是遍历数据 dp[0][j] 放入0个数 那么价值肯定为0
//        for (int i=1;i<=n;i++){
//            for (int j=0;j<=weight;j++){
//
//                if (j<nums[i-1])//因为数组下标从0开始 所以i-1表示第i个物品
//                    dp[i][j]=dp[i-1][j];
//                else
//                    dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-nums[i-1]]+nums[i-1]);
//                if (dp[i][j]==weight) return true;
//            }
//        }
//
//        return false;
//
//    }

    public boolean canPartition(int[] nums) {

        int n=nums.length;
        int weight=0;
        for (int num:nums)
            weight+=num;
        if (weight%2!=0) return false;
        weight/=2;
        int dp[]=new int[weight+1];

        //遍历n个物品
        for (int i=1;i<=n;i++){

            //对背包容量从后往前遍历 要放得下当前这个物品才放入 否则保持的是原先的值
            for (int j=weight;j>=nums[i-1];j--){

                dp[j]=Math.max(dp[j],dp[j-nums[i-1]]+nums[i-1]);

                if (dp[j]==weight) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        int nums[]={1,5,11,5};

        p416 t=new p416();
        boolean res = t.canPartition(nums);
        System.out.println(res);


    }
}
