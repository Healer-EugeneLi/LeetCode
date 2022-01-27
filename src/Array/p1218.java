package Array;

import java.util.HashMap;

/**
 * @ClassName: p1218
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/11/22
 * @Time: 20:27
 */
public class p1218 {

    //暴力解法
//    public int longestSubsequence(int[] arr, int difference) {
//
//        if (arr==null) return 0;
//        int max=1;
//        int ans=1;
//        for (int i=0;i<arr.length-1;i++){
//            ans=1;
//           int start=arr[i];
//           for (int j=i+1;j<arr.length;j++){
//
//               if (start+difference==arr[j]){
//                   //如果当前这个数与前一个数 相差一个difference
//                   ans++;
//                   start=arr[j];//start被设置为当前数
//               }
//           }
//           max=Math.max(max,ans);
//
//       }
//
//        if (max==1&&difference!=1)
//            return 0;
//
//       return max;
//    }

    /**
     * 动态规划解法
     * dp[i]=dp[j]+1
     *
     * dp[v]=dp[v-d]+1
     * @param arr
     * @param difference
     * @return
     */
    public int longestSubsequence(int[] arr, int difference) {

        HashMap<Integer,Integer> dp=new HashMap<>();
        int max=0;
        for (int i=0;i<arr.length;i++){

            int v=arr[i];//当前值
            int pre=v-difference;//离他最近的左侧的值
            int currentDp=dp.getOrDefault(pre,0)+1;
            dp.put(v,currentDp);
            max=Math.max(max,currentDp);

        }
        return max;

    }

    public static void main(String[] args) {

        int arr[]={1,5,7,8,5,3,4,2,1};

        p1218 t=new p1218();
        int res= t.longestSubsequence(arr,-2);
        System.out.println(res);

    }
}
