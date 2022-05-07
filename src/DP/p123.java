package DP;

/**
 * @ClassName: p123
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/5/3
 * @Time: 9:46
 */
public class p123 {


    /**
     * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
     * 设计一个算法来计算你所能获取的最大利润。你最多可以完成两笔交易。
     * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）
     * 输入：prices = [3,3,5,0,0,3,1,4]
     * 输出：6
     * 解释：在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。
     * 随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3 。
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        /***
         * 最多完成两笔交易 在任意一天结束之后，我们会处于以下5个状态中的一种
         * 1.未进行任何操作                                   最大利润 0
         * 2.只进行过1次买操作                                最大利润buy1
         * 3.进行了1次买操作和1次卖操作，即完成了一笔交易         最大利润sell1
         * 4.在完成了一笔交易的前提下，进行了第2次买操作          最大利润buy2
         * 5.完成了全部两笔交易                               最大利润sell2
         *
         * 对于buy1 第i天可以不进行任何操作 也可以以prices[i]买入
         *          buy1=max(buy1',-prices[i])  buy1'表示前一天的状态
         * 对于sell1  第i天可以不进行任何操作  也可以在只进行过一次买操作的前提下以prices[i] 的价格卖出股票
         *          sell1=max(sell1',buy1'+prices[i])
         * 对于buy2
         *          buy2=max(buy2',sell1'-prices[i]
         * 对于sell2
         *          sell2=max(sell2',buy2'+prices[i])
         * 无论题目中是否允许「在同一天买入并且卖出」这一操作，最终的答案都不会受到影响，这是因为这一操作带来的收益为零。
         */

        int n=prices.length;
        int buy1=-prices[0];//第1天 进行1次买操作 那就是花费了prices[0] 收益-prices[0]
        int sell1=0;//第1天 买入又卖出 收益0
        int buy2=-prices[0];//完成1次交易之后 进行第2次买操作
        int sell2=0;//完成两次交易 两次买入又卖出  收益0

        for (int i=1;i<n;i++){
            buy1=Math.max(buy1,-prices[i]);//什么都没干 或则就是未进行其他操作的时候 然后买入今天的股票
            sell1=Math.max(sell1,buy1+prices[i]);
            buy2=Math.max(buy2,sell1-prices[i]);
            sell2=Math.max(sell2,buy2+prices[i]);
        }
        return sell2;
    }

    public static void main(String[] args) {

        int arr[]={3,5,0,0,3,1,4};
        p123 t=new p123();
        int res = t.maxProfit(arr);
        System.out.println(res);
    }
}
