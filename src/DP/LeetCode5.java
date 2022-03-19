package DP;

/**
 * @ClassName: leetcode5
 * @Description: 最长回文子串
 * @Author EugeneLi
 * @Date: 2021/5/16
 * @Time: 21:13
 */
class Solution {
    public String longestPalindrome(String s) {

        char c[] = s.toCharArray();

        int length = s.length();
        int ans = 1;
        int left = 0;

        boolean dp[][] = new boolean[length][length];

        //设置边界 dp[i][i]=1  dp[i][i+1]=
        for (int i = 0; i < length; i++) {
            dp[i][i] = true;

            if (i < length - 1) {
                if (c[i] == c[i + 1]) {
                    dp[i][i + 1] = true;
                    ans = 2;
                    left = i;
                }
            }
        }

        //动态规划转移方程 dp[i][j]=dp[i+1][j-1]
        //使用长度来遍历 L=3开始
        for (int L = 3; L <= length; L++) {
            //左端点从0开始 i+L-1就是右端点
            for (int i = 0; i + L - 1 < length; i++) {

                int j = i + L - 1;
                if (c[i] == c[j] && dp[i + 1][j - 1] == true) {
                    dp[i][j] = true;
                    ans = L;//更新最大长度
                    left = i;
                }
            }

        }

        return s.substring(left, left + ans);

    }
}


public class LeetCode5 {

    public static void main(String[] args) {

        Solution s = new Solution();
        String str = "a";
        String res = s.longestPalindrome(str);
        System.out.println(res);


    }
}
