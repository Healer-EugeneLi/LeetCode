package MoveWindow;

/**
 * @ClassName: p1423
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/4/10
 * @Time: 21:12
 * 卡牌的最大点数之和
 * 几张卡牌 排成一行，每张卡牌都有一个对应的点数。点数由整数数组 cardPoints 给出。
 *
 * 每次行动，你可以从行的开头或者末尾拿一张卡牌，最终你必须正好拿 k 张卡牌。
 *
 * 你的点数就是你拿到手中的所有卡牌的点数之和。
 *
 * 给你一个整数数组 cardPoints 和整数 k，请你返回可以获得的最大点数。
输入：cardPoints = [1,2,3,4,5,6,1], k = 3
输出：12
解释：第一次行动，不管拿哪张牌，你的点数总是 1 。但是，先拿最右边的卡牌将会最大化你的可获得点数。最优策略是拿右边的三张牌，最终点数为 1 + 6 + 5 = 12 。

 */
public class p1423 {

    /**
     * 假设这个数组围绕成一个环 最终取到的k个数肯定是连续的
     * 因此最后的k个值肯定从头结点出发 或者尾结点出发 往前或者往后围绕在一起的k个数构成的最大值
     * 因此从前面k个数开始构成一个滑动窗口 然后再移动窗口，并且是考虑从尾部进入一个新的数
     * 最后找到这个窗口的最大值 并且最终这个窗口停在了最后倒数k个数的位置
     * @param cardPoints
     * @param k
     * @return
     */
    public int maxScore(int[] cardPoints, int k) {

        int maxSum=0;
        int curWindow=0;
        //先遍历前面k个数 构成一开始的滑动窗口的大小
        for (int i=0;i<k;i++)
            curWindow+=cardPoints[i];
        maxSum=curWindow;
        int left=k;//用来控制滑动窗口中移除出去的数
        for (int j=cardPoints.length-1;j>= cardPoints.length-k;j--){
            curWindow-=cardPoints[left-1];//移除滑动窗口的一个数据
            left--;
            curWindow+=cardPoints[j];//数据进入滑动窗口
            maxSum=Math.max(maxSum,curWindow);
        }
        return maxSum;
    }
}
