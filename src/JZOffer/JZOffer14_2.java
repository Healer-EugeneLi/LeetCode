package JZOffer;

/**
 * @ClassName: JZOffer14_2
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/1/28
 * @Time: 10:15
 */
public class JZOffer14_2 {
    /**
     * 贪心思路 尽可能剪出长度为3的绳子
     *
     * @param n
     * @return
     */
    public int cuttingRope(int n) {

        //长度为2时 结果1
        //     3      2
        //n为4的时候直接返回res*n=1*4=4
        if (n < 4) return n - 1;

        long res = 1;

        while (n > 4) {
            res = res * 3 % 1000000007;
            n -= 3;
        }

        return (int) res * n % 1000000007;

    }
}
