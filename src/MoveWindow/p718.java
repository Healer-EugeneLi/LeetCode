package MoveWindow;

/**
 * @ClassName: p718
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/3/11
 * @Time: 22:07
 *
 * 最长重复子数组
 */
public class p718 {


//    public int findLength(int[] nums1, int[] nums2) {
//
//        int len1=nums1.length;
//        int len2=nums2.length;
//        int dp[][]=new int[len1+1][len2+1];
//        int res=0;
//        //dp[i][j]表示nums1中以nums1[i-1]结尾的子数组 和nums2中以nums2[j-1]结尾的子数组最大公共子数组长度
//        for (int i=1;i<=len1;i++){
//            for (int j=1;j<=len2;j++){
//
//                // 需要明确是最大重复子数组的话 最后一个数字肯定是一样的 然后具体可以有多长需要由前一个数结尾的最大子数组决定
//                if (nums1[i-1]==nums2[j-1]){
//
//                    dp[i][j]=dp[i-1][j-1]+1;
//                }
//
//                res=Math.max(res,dp[i][j]);//每次都更新一遍
//
//
//            }
//        }
//        return res;
//    }

    public int findLength(int[] nums1, int[] nums2) {

        int len1=nums1.length;
        int len2=nums2.length;

        int dp[]=new int[len2+1];
        int ans=0;
        for (int i=1;i<=len1;i++){

            for (int j=len2;j>=1;j--){

                if (nums1[i-1]==nums2[j-1]){
                    dp[j]=dp[j-1]+1;
                }else
                    dp[j]=0;

                ans=Math.max(ans,dp[j]);
            }
        }

        return ans;
    }
}
