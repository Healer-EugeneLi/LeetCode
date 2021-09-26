package DP;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: p650
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/9/19
 * @Time: 15:17
 */
public class p650 {

    public int minSteps(int n) {

      int dp[]=new int[n+1];
      dp[1]=0;

      for (int i=2;i<=n;i++){

          dp[i]=Integer.MAX_VALUE;
          for (int j=1;j*j<=i;j++){
              if (i%j==0){
                  dp[i]= Math.min(dp[i],dp[j]+i/j);
                  dp[i]=Math.min(dp[i],dp[i/j]+j);
              }
          }
      }

      return dp[n];
    }

    public static void main(String[] args) {
        
        p650 t=new p650();
        int i = t.minSteps(3);
    }
}
