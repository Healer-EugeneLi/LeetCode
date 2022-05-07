package JZOffer;

import java.util.Arrays;

/**
 * @ClassName: JZOffer60
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/2/22
 * @Time: 21:06
 */
public class JZOffer60 {

    public double[] dicesProbability(int n) {

        //设dp[i] 表示第i个骰子 值为j时的概率 采取了数组压缩
        //一开始 dp[6] 表示 当n=1只有一个骰子的时候 1~6的概率
        double[] dp = new double[6];
        //dp[0] 表示和为1的概率 dp[5] 表示和为6的概率 均为1/6
        Arrays.fill(dp, 1.0 / 6.0);

        //接下来就要往后推  比如n=2 两个骰子的时候 第2个骰子的值为1~6
        //那么假设上一轮和为1 这一轮这个1就会对下轮结果为2 3 4 5 6 7有贡献
        //对于每一轮i个骰子  其总的结果数有i*6-i*1+1=5i+1 比如i=1 1个骰子的时候有6个值 那么i=2 有11个 即 2 3 4... 12

        //总的有n个骰子要模拟
        for (int i = 2; i <= n; i++) {

            //存放当前这一轮i个骰子其对应求出来的和的概率 实际temp[0] 表示的是这5*i+1个值里面最小的值的概率 比如i=2 那么temp[0] 表示和为1+1=2的概率
            double[] temp = new double[5 * i + 1];
            //获取上一轮i-1个骰子的所有值的情况 对每一个值添加1-6 来构造下一个出现的值
            for (int j = 0; j < dp.length; j++) {

                //此时要加上的第i个骰子的值情况从1-6 所以对应下标从0~5 也就是循环的长度为6
                for (int k = 0; k < 6; k++) {

                    temp[j + k] += dp[j] * (1.0 / 6.0);//使用+= 而不是= 因为求的是所有值的概率和
                }

            }
            //更新新一轮求出来的结果 赋值给dp 将当前这一轮负值给dp这样下一轮才能使用
            dp = temp;


        }

        return dp;
    }

    public static void main(String[] args) {

        JZOffer60 t = new JZOffer60();
        double[] doubles = t.dicesProbability(2);
        for (double d : doubles)
            System.out.println(d);
    }
}
