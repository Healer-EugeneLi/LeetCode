package DP;

/**
 * @ClassName: p122
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/5/2
 * @Time: 22:54
 */
public class p122 {

    /**
     * 输入：prices = [7,1,5,3,6,4]
     * 输出：7
     * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5 - 1 = 4 。
        随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6 - 3 = 3 。
     *      总利润为 4 + 3 = 7 。
     */

    public int maxProfit(int[] prices) {

        //等价于让那些卖出去可以赚钱的股票进行出售 而那些会亏损的不卖  每天都进行判断 与前一天进行比较

        int profit=0;
        for (int i=1;i<prices.length;i++){

            if (prices[i]-prices[i-1]>0)
                profit+=prices[i]-prices[i-1];
        }
        return profit;
    }
}
