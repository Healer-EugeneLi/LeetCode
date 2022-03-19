package DP;

/**
 * @ClassName: p474
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/2/25
 * @Time: 11:23
 * 输入：strs = ["10", "0001", "111001", "1", "0"], m = 5, n = 3
 * 输出：4
 * 解释：最多有 5 个 0 和 3 个 1 的最大子集是 {"10","0001","1","0"} ，因此答案是 4 。
 * 其他满足题意但较小的子集包括 {"0001","1"} 和 {"10","1","0"} 。{"111001"} 不满足题意，因为它含 4 个 1 ，大于 n 的值 3 。
 */
public class p474 {


    public int findMaxForm(String[] strs, int m, int n) {


        //dp[i][j] 表示最多有i个0 j个1的最大子集大小
        //那么对于当前字符串而言 dp[i][j]=max(dp[i][j],dp[i-zeroNum][j-oneNum]+1)
        // 也就是说当前这个字符串可以贡献出zeroNum个0 oneNum个1 那么i个0 j个1扣去这些数之后 得到之前的最大子集大小 再加上1个字符串 得到新的集合大小
        int dp[][] = new int[m + 1][n + 1];

        for (String str : strs) {

            int zeroNum = 0, oneNum = 0;
            //统计当前这个字符串的0 1 个数
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '0') zeroNum++;
                else oneNum++;
            }

            for (int i = m; i >= zeroNum; i--) {
                for (int j = n; j >= oneNum; j--) {

                    dp[i][j] = Math.max(dp[i][j], dp[i - zeroNum][j - oneNum] + 1);
                }
            }


        }

        return dp[m][n];

    }

    public static void main(String[] args) {

        String str[] = {"10", "0001", "111001", "1", "0"};
        int m = 5, n = 3;
        p474 t = new p474();
        int res = t.findMaxForm(str, m, n);
        System.out.println(res);
    }
}
