package DP;

/**
 * @ClassName: p72
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/5/3
 * @Time: 17:02
 */
public class p72 {


    /**
     * 编辑距离
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {

        int len1=word1.length();
        int len2=word2.length();
        //dp[i][j] 表示以下标i-1为结尾的字符串word1 和以下标j-1为结尾的字符串word2 最近编辑距离

        int dp[][]=new int[len1+1][len2+1];
        //以下标i-1为结尾的字符串word1，和空字符串word2，最近编辑距离为dp[i][0]
        //那么dp[i][0]就应该是i，对word1里的元素全部做删除操作，
        for (int i=0;i<=len1;i++)
            dp[i][0]=i;//表示
        for (int j=0;j<=len2;j++){
            dp[0][j]=j;
        }

        for (int i=1;i<=len1;i++){
            for (int j=1;j<=len2;j++){
                // 因为dp数组有效位从1开始
                // 所以当前遍历到的字符串的位置为i-1 | j-1
                //当两个元素相同的时候 编辑距离就等于前一个
                if (word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];
                }else {

                    //当两个元素不一样的时候 可以有几种操作
                    //word1删除一个元素 以下标i - 2为结尾的word1 与 j-1为结尾的word2的最近编辑距离 再加上一个操作。
                    int case1=dp[i-1][j]+1;

                    //word2删除一个元素
                    int case2=dp[i][j-1]+1;

                    //替换元素 word1替换word1[i - 1]，使其与word2[j - 1]相同，
                    // 此时不用增加元素，那么以下标i-2为结尾的word1 与 j-2为结尾的word2的最近编辑距离 加上1个替换元素的操作。
                    int case3=dp[i-1][j-1]+1;

                    //最后取三种操作的最小值
                    dp[i][j]=Math.min(Math.min(case1,case2),case3);
                }
            }
        }

        return dp[len1][len2];

    }
}
