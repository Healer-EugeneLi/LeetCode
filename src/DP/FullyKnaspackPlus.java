package DP;

import java.util.Scanner;

/**
 * @ClassName: FullyKnaspackPlus
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/10/28
 * @Time: 10:37
 */
public class FullyKnaspackPlus {


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

        int dp[]=new int[bagSize+1];

        for (int i=1;i<=n;i++){
            for (int j=weight[i];j<=bagSize;j++){
                //直接优化 从放得下的那个重量开始计算 j>=weight[i] 表明才放得下这个i

                dp[j]=Math.max(dp[j],dp[j-weight[i]]+value[i]);
            }

            //此时可以输出查看一下dp数组的情况
            for (int k=0;k<=bagSize;k++){
                System.out.print(dp[k]+" ");
            }
            System.out.println();
        }

        System.out.println("最后的最大价值");
        System.out.println(dp[bagSize]);
    }
}
