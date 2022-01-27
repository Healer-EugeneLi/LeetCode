package DP;

import java.util.Scanner;

/**
 * @author ：EugeneLi
 * @date ：Created in 2021/10/24 11:36
 * @modified By：

 */
public class Knaspack01plus {



    //0-1背包问题 滚动数组 dp 优化版本
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
        // dp[j] 背包容量为j的时候 存放上1到i物品之后的最大价值
        // 每次都在更新该行就行 因为dp每一行只跟前一行有关系
        for (int i=1;i<=n;i++){
            //注意此时遍历要对背包重量使用倒序遍历 这样更新的时候后面的值才会使用到前一轮的值 更新成最新的值
            for (int j=bagSize;j>=1;j--){

                //因为背包重量不够的时候还是保留上一行的数据 所以不用更新
                if (j>=weight[i]){
                    //背包容量足够的时候 考虑两种情况 放与不放
                    dp[j]=Math.max(dp[j],dp[j-weight[i]]+value[i]);
                }

            }
            //此时可以输出查看一下dp数组的情况
            for (int k=0;k<=bagSize;k++){
                System.out.print(dp[k]+" ");
            }
            System.out.println();
        }

        System.out.println("最后的最大价值:");
        System.out.println(dp[bagSize]);

    }
    /**测试：
     3 3
     4 5
     7 9
     0 0 1 1 1 1 1 1 1 1 1
     0 0 1 3 3 4 4 4 4 4 4
     0 0 1 3 5 5 6 8 8 9 9
     0 0 1 3 5 5 6 9 9 10 12
     最后的最大价值:
     12
     */

}
