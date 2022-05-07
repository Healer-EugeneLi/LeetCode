package DP;

/**
 * @InterfaceName: p121
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/5/2
 * @Time: 22:49
 */
public class p121 {
    /**
     * 使用动态规划
     * dp[i]表示第i天获得的最大利润 dp[i]=max(dp[i-1],prices[i]-min(pricess[0:i-1])
     * 也就是说 当前第i天的最大利润=前i-1天获得的最大利润与当前股票价格减去前i-1天的最低价格 二者选最大值
     * 优化 维护一个最小值cost 然后更新利润profit
     * profit=max(profit,min(prices[i]-cost))
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {


        int cost = Integer.MAX_VALUE;
        int profit = 0;

        for (int price : prices) {
            cost = Math.min(price, cost);//维护一个最小值
            profit = Math.max(profit, price - cost);//更新最大收益 当前的卖出价格 减去之前的最小的
        }
        return profit;
    }
}
