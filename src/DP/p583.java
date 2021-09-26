package DP;

/**
 * @ClassName: p58
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/9/25
 * @Time: 9:20
 */
public class p583 {

    public int minDistance(String word1, String word2) {

        int len1=word1.length();
        int len2=word2.length();
        int dp[][]=new int[len1+1][len2+1];//dp[i][j]表示 字符串1 i这个位置 字符串2 j这个位置 最长的公共子序列
        char[] chars1 = word1.toCharArray();
        char[] chars2 = word2.toCharArray();

        //一开始单独一个字符的时候当前没有最小公共子序列
        for (int i=0;i<word1.length();i++){
            dp[i][0]=0;
        }
        for (int j=0;j<word2.length();j++){
            dp[0][j]=0;
        }

        for (int i=1;i<=len1;i++){
            for (int j=1;j<=len2;j++){

                if (chars1[i-1]==chars2[j-1]){
                    //因为前面i j都是从1开始 所以索引数组时下标-1  如果当前这个字符相等 那么最长子序列长度肯定等于前面最长的+1
                    dp[i][j]=dp[i-1][j-1]+1;
                }else {
                    //不相等
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }

        //最后最长的子序列长度为
        int max=dp[len1][len2];

        //所以最小步数等于
        return len1+len2-2*max;

    }
}
