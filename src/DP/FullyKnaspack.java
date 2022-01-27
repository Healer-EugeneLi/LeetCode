package DP;

import java.util.Scanner;

/**
 * @ClassName: FullyKnaspack01
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/10/27
 * @Time: 11:17
 * 朴素版完全背包解法
 * 从0-1背包问题修改而来。在0-1背包问题的第2层循环的时候，
 * 考虑这样一件事情，因为对于每种物品可以有很多个，所以当此时背包容量有j的时候，
 * 对于i物品，其重量为weight[ i ]，那么最多就可以装入j/weight[i] 个，所以添加一层循环
 * 10 4
 * 2 1
 * 3 3
 * 4 5
 * 7 9
 * 最后的最大价值
 * 12
 */
public class FullyKnaspack {


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

            for (int j=bagSize;j>=1;j--){

                for (int k=0;k<=j/weight[i];k++){
                    //不断进行放入第i个物品 最多可以放入j/weight[i]个
                    //要放入k个这个物品i 就需要腾出k*weight[i]的重量 并且加入这k个的价值
                    dp[j]=Math.max(dp[j],dp[j-k*weight[i]]+value[i]*k);
                }
            }
        }

        System.out.println("最后的最大价值");
        System.out.println(dp[bagSize]);

    }
}
