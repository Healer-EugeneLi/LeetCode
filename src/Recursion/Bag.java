package Recursion;

/**
 * @ClassName: Bag
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/10/3
 * @Time: 21:41
 * 0-1背包问题的递归解法
 */
public class Bag {

    //i...的货物自由选择 形成最大的价值返回
    //重量永远不要超过bag
    //之前做的决定  所达到的重量 alreadyWeight

    /**
     * @param weights       重量数组
     * @param values        价值数组
     * @param i             i...开始往后选
     * @param alreadyWeight 已经有的重量
     * @param bag           背包重量最大限制
     * @return
     */
    public static int process1(int[] weights, int[] values,
                               int i, int alreadyWeight, int bag) {

        if (alreadyWeight > bag) return 0;//背包上的重量已经超过 bag最大限制

        if (i == weights.length) return 0;//已经判断完了  没有东西可以选了

        //如果当前i这个物品不妨进去 那么只能是i+1后面的物品来放了
        int noChooseI = process1(weights, values, i + 1, alreadyWeight, bag);

        //如果当前i放进去 那么alreadyWeight更新 继续从i+1往后判断
        int chooseI = values[i] + process1(weights, values, i + 1, alreadyWeight + weights[i], bag);

        return Math.max(noChooseI, chooseI);
    }
}
