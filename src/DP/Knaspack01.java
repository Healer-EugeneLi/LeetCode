package DP;

import java.util.Scanner;

/**
 * @author ：EugeneLi
 * @date ：Created in 2021/10/24 11:36
 * @modified By：
 * 10 4
 * 2 1
 * 3 3
 * 4 5
 * 7 9
 * dp表情况输出：
 * 0  0  0  0  0  0  0  0  0  0  0
 * 0  0  1  1  1  1  1  1  1  1  1
 * 0  0  1  3  3  4  4  4  4  4  4
 * 0  0  1  3  5  5  6  8  8  9  9
 * 0  0  1  3  5  5  6  9  9  10  12
 * 最后的最大价值:
 * 12
 */
public class Knaspack01 {



    //0-1背包问题 二维dp 无优化版本
    public static void main(String[] args) {

        int bagSize;//背包重量
        int n;//物品数量
        int weight[];//物品重量
        int value[];//物品价值
        Scanner scanner=new Scanner(System.in);
        bagSize=scanner.nextInt();
        n=scanner.nextInt();

        //初始化数组
        weight=new int[n+1];
        value=new int[n+1];
        //从i=1开始存放n个物品
        for (int i=1;i<=n;i++){
            weight[i]=scanner.nextInt();
            value[i]=scanner.nextInt();
        }

        int dp[][]=new int[n+1][bagSize+1];
        //使用二维数组 dp[i][j] 背包容量为j的时候 存放上1到i物品之后的最大价值
        for (int i=1;i<=n;i++){
            for (int j=1;j<=bagSize;j++){

                if (j<weight[i]){
                    //背包重量不足以放下第i个物品 此时价值等于不放入第i个物品的价值
                    dp[i][j]=dp[i-1][j];
                }else {
                    //背包容量足够的时候 考虑两种情况 放与不放
                    dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-weight[i]]+value[i]);
                }
            }
        }
        //输出dp表的情况
        System.out.println("dp表情况输出：");
        for(int i=0;i<=n;i++){
            for (int j=0;j<=bagSize;j++){
                System.out.print(dp[i][j]+"  ");
            }
            System.out.println();
        }

        System.out.println("最后的最大价值:");
        System.out.println(dp[n][bagSize]);

    }

}
