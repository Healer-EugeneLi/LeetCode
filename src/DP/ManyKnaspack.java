package DP;

import java.util.Scanner;

/**
 * @ClassName: ManyKnaspack
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/10/28
 * @Time: 14:58
 * 多重背包问题
 * 有限给物品 给定大小的背包 求最大存放的价值
 */
public class ManyKnaspack {


    public static void main(String[] args) {
        int bagSize;//背包重量
        int n;//物品数量
        int weight[];//物品重量
        int value[];//物品价值
        int num[];//物品的数量
        Scanner scanner = new Scanner(System.in);
        bagSize = scanner.nextInt();
        n = scanner.nextInt();

        weight = new int[n + 1];
        value = new int[n + 1];
        num = new int[n + 1];

        //从i=1开始存放n个物品
        for (int i = 1; i <= n; i++) {
            weight[i] = scanner.nextInt();
            value[i] = scanner.nextInt();
            num[i] = scanner.nextInt();
        }

        int dp[] = new int[bagSize + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = bagSize; j >= 1; j--) {
                //多一重循环k 来表示可以放几个物品i
                for (int k = 0; k <= num[i] && j >= k * weight[i]; k++) {
                    //k的数量小于物品i的总数量
                    // j背包的重量要能够放得下k个 所以j>=k*weight[i]
                    dp[j] = Math.max(dp[j], dp[j - k * weight[i]] + k * value[i]);
                }
            }
        }

        System.out.println("多重背包的最大价值");
        System.out.println(dp[bagSize]);
    }
}
/**
 * 1000 5
 * 80 20 4
 * 40 50 9
 * 30 50 7
 * 40 30 6
 * 20 20 1
 * 多重背包的最大价值
 * 1040
 */