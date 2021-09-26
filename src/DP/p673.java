package DP;

/**
 * @ClassName: p673
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/9/20
 * @Time: 9:28
 */
public class p673 {

    public int findNumberOfLIS(int[] nums) {

        int maxLen=0,ans=0;

        int dp[]=new int[nums.length];//表示以i结尾的最长子序列长度
        int count[]=new int[2001];//表示以j结尾的最长子序列个数

        for (int i=0;i<nums.length;i++){

            dp[i]=1;
            count[i]=1;
            for (int j=0;j<i;j++){

                if (nums[j]<nums[i]){
                    if (dp[j]+1>dp[i]){
                        //更新最长子序列长度
                        dp[i]=dp[j]+1;
                        count[i]=count[j];//比如原本是有3个最长 然后加上一个比他们都大的数 那还是有3个最长
                    }else if (dp[j]+1==dp[i]){
                        count[i]+=count[j];//原本有3个最长 现在使用前一个数之后还有最长 那就是加上原先最长的个数
                    }

                }
            }

            if (dp[i]>maxLen){
                maxLen=dp[i];
                ans=count[i];
            }else if (dp[i]==maxLen){
                ans+=count[i];
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        int arr[]={1,3,5,4,7};

        p673 t=new p673();
        int numberOfLIS = t.findNumberOfLIS(arr);
        System.out.println();
    }
}
