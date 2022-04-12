package DP;

/**
 * @ClassName: p647
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/4/4
 * @Time: 23:01
 * 输入：s = "abc"
 * 输出：3
 * 解释：三个回文子串: "a", "b", "c"
 * 求出回文子串的个数
 */
public class p647 {

    /**
     * 动态规划做法
     * 令dp[i][j]表示 字符串s 的[i,j]是否为回文串
     * 有几种情况进行分析 对于s[i]==s[j]的时候，
     * 如果i==j 那么dp[i][j]=true 即该字符算是一个回文串
     *         如果j-i=1 dp[i][j]=true 即aa这种情况
     *         如果j-i>1  那么就是说超过2个字符了 就需要去判断dp[i+1][j-1] 来进行递推
     *         所以很显然当需要更新[i][j]的时候 需要的是其左下角位置的信息 也就是需要先得到后面的信息才能计算当前的信息
     *         对于 a a a 更新如下
     *                 -
     *               -
     *               - -
     *            -
     *            - -
     *            - -  -
     * @param s
     * @return
     */
//    public int countSubstrings(String s) {
//
//        int res=0;
//        boolean dp[][]=new boolean[s.length()][s.length()];
//        for (int i=s.length()-1;i>=0;i--){
//            for (int j=i;j<s.length();j++){
//
//                if (s.charAt(i)==s.charAt(j)){
//                    if (j-i<=1){
//                        //将前两种情况进行统一
//                        res++;
//                        dp[i][j]=true;
//                    }else if (dp[i+1][j-1]==true){
//                        res++;
//                        dp[i][j]=true;
//                    }
//                }
//            }
//        }
//        return res;
//
//    }

    /**
     * 双指针中心扩散法
     * 对1个字符 或者2个字符作为中心 使用双指针进行扩散
     * 比如abc
     * i=0的时候 a为中心 且left=a right=a 或则ab为中心 left=a right=b
     * i=1的时候 b为中心 且left=b right=b 或者bc为中心 left=b right=c
     * i=2的时候 c为中心 且left=c right=c 此时到达边界了
     * @param s
     * @return
     */
    public int countSubstrings(String s) {

        int res=0;
        for (int i=0;i<s.length();i++){

            //先以1个元素为中心
            int left=i;
            int right=i;
            while (left>=0&&right<s.length()&&s.charAt(left)==s.charAt(right)){
                res++;
                left--;
                right++;
            }

            //以2个元素为中心
            int left2=i;
            int right2=i+1;
            while (left2>=0&&right2<s.length()&&s.charAt(left2)==s.charAt(right2)){
                res++;
                left2--;
                right2++;

            }
        }

        return res;
    }

}
