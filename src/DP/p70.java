package DP;

/**
 * @ClassName: p70
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/4/20
 * @Time: 22:13
 */
public class p70 {

    /**假设你正在爬楼梯。需要 n 阶你才能到达楼顶。

     每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
     * 怕楼梯
     * n=1 1种方式
     * n=2 2种方式
     * n=3 3种方式
     * n=4 5种方式 由n=2的时候跳两阶 由n=3跳一阶
     * @param n
     * @return
     */
    public int climbStairs(int n) {

        if(n==1) return 1;
        if (n==2) return 2;
        int a=1,b=2,sum=0;
        for (int i=3;i<=n;i++){

            sum=a+b;
            a=b;
            b=sum;
        }
        return sum;
    }
}
