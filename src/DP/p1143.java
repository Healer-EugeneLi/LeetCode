package DP;

/**
 * @ClassName: p1143
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/4/20
 * @Time: 19:39
 *
 * 输入：text1 = "abcde", text2 = "ace"
 * 输出：3
 * 解释：最长公共子序列是 "ace" ，它的长度为 3 。
 */
public class p1143 {

//
//    /**
//     * 返回两个字符串的最长公共子序列长度
//     * @param text1
//     * @param text2
//     * @return
//     */
//    public int longestCommonSubsequence(String text1, String text2) {
//
//        if (text1.length()==0||text2.length()==0) return 0;
//
//        //令dp[i][j] 表示串1 从字符串[0,i]处子串与 串2[0,j]的最长公共子序列长度
//        int len1=text1.length();
//        int len2=text2.length();
//
//        int dp[][]=new int[len1][len2];
//        //先处理串1的首字符与串2的所有字符的比较
//        int i=0;
//        for (i=0;i<len2;i++){
//            if (text1.charAt(0)==text2.charAt(i)){
//                break;
//            }
//        }
//        if (i!=len2){
//            while (i!=len2)
//                dp[0][i++]=1;
//        }
//        //再处理串2的首字符与串1的所有字符比较
//        int j=0;
//        for (j=0;j<len1;j++){
//            if (text2.charAt(0)==text1.charAt(j))
//                break;
//        }
//        if (j!=len1){
//            while (j!=len1)
//                dp[j++][0]=1;
//        }
//
//
//        for ( i=1;i<len1;i++){
//
//            for (j=1;j<len2;j++){
//
//                //如果两个串的这两个位置相等 那么很显然dp[i][j]=dp[i-1][j-1]
//                if (text1.charAt(i)==text2.charAt(j)){
//                    dp[i][j]=dp[i-1][j-1]+1;
//                }else {
//                    //不相等 那么就分两种情况
//                    dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]);
//                }
//            }
//        }
//
//        return dp[len1-1][len2-1];
//
//    }

    public int longestCommonSubsequence(String text1, String text2) {

        //让dp[i][j] 来表示串1[0,i-1] 与串2[0,j-1]的最长公共子序列

        int len1=text1.length();
        int len2=text2.length();

        //为了方便处理边界 我们选择从下标开始来记录字符串的比较
        int dp[][]=new int[len1+1][len2+1];
        //实际当i=0  dp[0][j]=0 或者 j=0的时候 dp[i][0] 但是数组初始化的时候已经全为0了

        for (int i=1;i<=len1;i++){
            for (int j=1;j<=len2;j++){

                //当两个位置字符相等的时候 则dp[i][j]表示前面字符串的最长公共子序列+1
                // 比如abc 与dc 中c是相等的 则dp[3][2]=dp[2][1]+1 也就是ab 与d的最长公共子序列的长度+1
                if (text1.charAt(i-1)==text2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else {
                    //如果两个字符不相等的时候 则判断哪个子序列长度更大  比如abc 与def c不等f 则dp[3][3]=ab与def的最长公共子序列长度  和abc与de的最长公共子序列长度 两者的最大值
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }

        return dp[len1][len2];

    }

    public static void main(String[] args) {
        String text1="abc";
        String text2="defa";

        p1143 t=new p1143();
        int res = t.longestCommonSubsequence(text1, text2);
        System.out.println(res);
    }
}
