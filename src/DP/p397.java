package DP;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: p397
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/11/20
 * @Time: 21:07
 * 整数替换
 *
 */
public class p397 {

    //数组会溢出
//    public int integerReplacement(int n) {
//
//        int dp[]=new int[n+1];
//        dp[1]=0;
//        for (int i=2;i<=n;i++){
//
//            if (i%2==0){
//                //如果是偶数 直接就是dp[i]=dp[i/2]+1
//                dp[i]=dp[i/2]+1;
//            }else {
//                //如果是奇数的话 n可以有n+1 或者n-1替换n
//                //如果是n-1 那么dp[i]=dp[i-1]+1
//                //如果是n+1 那么n+1会由(n+1)/2变换过来 dp[(i+1)/2]+2
//                dp[i]=Math.min(dp[i-1]+1,dp[(i+1)/2]+2);
//            }
//        }
//
//        return dp[n];
//    }

    public int integerReplacement(int n) {

        Map<Integer,Integer> map=new HashMap<>();
        return dfs(n,map);
    }

    public int dfs(int n,Map<Integer,Integer> map){

        if (n==1) return 0;
        int ans=0;

        if (map.containsKey(n)) return map.get(n);
        //如果是偶数
        if (n%2==0){
            ans=dfs(n/2,map)+1;
        }

        if (n%2==1){
            ans=Math.min(dfs(n+1,map),dfs(n-1,map))+1;
        }
        map.put(n,ans);
        return ans;

    }

    public static void main(String[] args) {
        int n=100000000;
        p397 t=new p397();
        int res = t.integerReplacement(n);
        System.out.println(res);

    }


}
