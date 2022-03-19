package DP;

/**
 * @ClassName: JZOffer2_088
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/2/24
 * @Time: 11:26
 */
public class JZOffer2_088 {


    public int minCostClimbingStairs(int[] cost) {


        int a = cost[0], b = cost[1], cur = 0;//设置初始为第1级楼梯 第2级楼梯
        int n = cost.length;
        for (int i = 2; i < n; i++) {

            cur = Math.min(a, b) + cost[i];//有两种情况可以到达 加上当前费用之后 就可以继续往下走了
            a = b;
            b = cur;
        }

        return Math.min(a, b);//最后两级台阶的费用

    }

    public static void main(String[] args) {

        int nums[] = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};

        JZOffer2_088 t = new JZOffer2_088();
        int res = t.minCostClimbingStairs(nums);
        System.out.println(res);
    }
}
