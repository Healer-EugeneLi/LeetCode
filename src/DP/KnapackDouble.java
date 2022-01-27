package DP;

import java.util.Scanner;

/**
 * @ClassName: KnapackDouble
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/10/28
 * @Time: 17:01
 * 二维费用背包
 */
public class KnapackDouble {



    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        int cost1,cost2;//两个代价
        int n;//物品数量

        cost1=scanner.nextInt();
        cost2=scanner.nextInt();
        n=scanner.nextInt();

        int w[];//物品的代价1 数组
        int v[];//物品的代价2 数组
        int weight[];//重量

        w=new int[n+1];
        v=new int[n+1];
        weight=new int[n+1];
        for (int i=1;i<=n;i++){
            w[i]=scanner.nextInt();
            v[i]=scanner.nextInt();
            weight[i]=scanner.nextInt();

        }

        int dp[][]=new int[cost1+1][cost2+1];
        for (int i=0;i<cost1+1;i++){
            for (int j=0;j<cost2+1;j++){
                dp[i][j]=1000000;
            }
        }
        dp[0][0]=0;
        //n个物品
        for (int i=1;i<=n;i++){

            //代价1 遍历
            for (int j=cost1;j>=0;j--){

                //代价2 遍历
                for (int k=cost2;k>=0;k--){

                    //足够满足你这个要求的代价的时候
                    if (j<=w[i]&&k<=v[i]){
                        dp[j][k]=Math.min(dp[j][k],weight[i]);
                    }else {
                        //当两个条件不一定全部满足的时候

                        int x,y;
                        if (j-w[i]<0) x=0;else x=j-w[i];
                        if (k-v[i]<0) y=0;else y=k-v[i];

                        dp[j][k]=Math.min(dp[j][k],dp[x][y]+weight[i]);
                    }

                }
            }
        }

        System.out.println(dp[cost1][cost2]);

    }
}
