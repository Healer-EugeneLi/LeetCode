package JZOffer;

/**
 * @ClassName: JZOffer63
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/2/14
 * @Time: 10:36
 */
public class JZOffer63 {


    /**
     * 使用动态规划
     * dp[i]表示第i天获得的最大利润 dp[i]=max(dp[i-1],prices[i]-min(pricess[0:i-1))
     * 也就是说 当前第i天的最大利润=前i-1天获得的最大利润与当前股票价格减去前i-1天的最低价格的最大值
     * 优化 维护一个最小值cost 然后更新利润profit
     * profit=max(profit,min(prices[i]-cost))
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {


        int cost=Integer.MAX_VALUE;
        int profit=0;

        for (int price:prices){
            cost=Math.min(price,cost);
            profit=Math.max(profit,price-cost);
        }
        return profit;
    }

    /**
     * 维护一个最小值 一开始初值为第0个元素
     * 当遍历的时候如果遍历的值比min大 那么更新res
     * 如果比min小 则更新min
     * @param prices
     * @return
     */
//    public int maxProfit(int[] prices) {
//
//        if (prices.length==0) return 0;
//        int min=prices[0];
//        int res=0;
//        for (int p:prices){
//
//            if (p>=min)
//                res=Math.max(res,p-min);//更新利润
//            else
//                min=p;//更新最小值
//        }
//        return res;
//    }






}
