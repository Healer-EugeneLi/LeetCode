package Code2019;

import java.util.Scanner;

/**
 * @ClassName: QPa
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/10/8
 * @Time: 10:13
 * 小Q爬塔
 */
public class QPa {

    public static int n;
    public static int[] high;
    public static final int MAXN = 10002;//最大层数
    public static int pa[];//到达该层使用的是爬的最少时间
    public static int jump[];//存放到达该层 使用的是跳的最少时间

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        high = new int[MAXN];
        pa = new int[MAXN];
        jump = new int[MAXN];
        int x = 0;

        /**
         * 到达第i层如果是用爬的 那么到达第i-1层可以是用爬的 也可以用跳的 取最小的
         *
         * 到达第i层如果是用跳的 可以从i-1层开始跳  或者i-2层开始跳  而且到达第i-1层 i-2层必须是使用爬的
         */
        for (int i = 1; i <= n; i++) {

            x = scanner.nextInt();
            pa[i] = Math.min(pa[i - 1], jump[i - 1]) + x;

            //如果此时是要到第一层 而且是使用跳的 那就是不用时间 直接跳过
            if (i == 1) continue;
            jump[i] = Math.min(pa[i - 1], pa[i - 2]);//如果不在i==1的时候continue 往下走 pa[i-2]会越界 并且到第一层用跳的话 不用花时间 所以等于0

        }

        System.out.println(Math.min(pa[n], jump[n]));


    }
}
