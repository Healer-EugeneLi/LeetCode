package DP;

/**
 * @ClassName: p5
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/4/4
 * @Time: 23:49
 * 最长回文子串 原理与p647大致差不多
 */
public class p5 {

    /**
     * 给你一个字符串 s，找到 s 中最长的回文子串。
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {

        String res="";
        int max=0;

        boolean dp[][]=new boolean[s.length()][s.length()];

        //控制子串的左端点开始位置 从后遍历回来 因为这样在计算的过程中才有办法利用到i+1,j-1这段是否是回文子串的判断
        for (int i=s.length()-1;i>=0;i--){
            //控制右端点的位置 一开始肯定是指向与左端点一起的位置
            for (int j=i;j<s.length();j++){

                //左右端点相等
                if (s.charAt(i)==s.charAt(j)){

                    //两个端点的距离<=1 说明是2个长度以内
                    if (j-i<=1){
                        dp[i][j]=true;
                    }else if (dp[i+1][j-1]==true){
                        //如果[i+1,j-1]区间范围内是回文子串
                        dp[i][j]=true;
                    }

                    if (dp[i][j]==true){
                        //更新最长的回文子串的长度
                        if (j-i+1>=max){
                            max=j-i+1;//记录最大值
                            res=s.substring(i,j+1);//划分子串
                        }
                    }

                }
            }
        }
        return res;
    }

//    public String longestPalindrome(String s) {
//
//        int max=0;
//        String res="";
//
//        for (int i=0;i<s.length();i++){
//
//
//            int left=i,right=i;
//            while (left>=0&&right<s.length()&&s.charAt(left)==s.charAt(right)){
//
//                if (right-left+1>=max){
//                    max=right-left+1;
//                    res=s.substring(left,right+1);
//                }
//                left--;
//                right++;
//
//            }
//
//
//            int left2=i,right2=i+1;
//            while (left2>=0&&right2<s.length()&&s.charAt(left2)==s.charAt(right2)){
//                if (right2-left2+1>=max){
//                    max=right2-left2+1;
//                    res=s.substring(left2,right2+1);
//                }
//                left2--;
//                right2++;
//            }
//        }
//
//        return res;
//
//    }


//    public String longestPalindrome(String s) {
//
//        if (s.length()==1) return s;
//        int ans=1;//一个字符的时候肯定是回文
//        int n=s.length();
//        String res=s.charAt(0)+"";//需要返回的最长回文子串 默认是一个字符
//
//        //dp[i][j] 表示字符串[i,j]位置是否是回文子串
//        boolean dp[][]=new boolean[s.length()][s.length()];
//
//        //先处理长度为1 长度为2的情况
//        for (int i=0;i<n;i++){
//
//            dp[i][i]=true;
//            if(i<n-1){
//                if (s.charAt(i)==s.charAt(i+1)){
//                    dp[i][i+1]=true;
//                    ans=2;//更新最长为2
//                    res=s.substring(i,i+2);
//                }
//            }
//        }
//
//        //从子串长度3开始算起
//        for (int L=3;L<=n;L++){
//
//            //子串左端点
//            for (int i=0;i+L-1<n;i++){
//
//                int j=i+L-1;//右端点
//                //因为每次计算当前长度比如3的时候 前面子串长度为2的已经计算过了 所以dp[i+1][j-1]已经有结果了
//                if (s.charAt(i)==s.charAt(j)&&dp[i+1][j-1]==true){
//                    dp[i][j]=true;
//                    ans=L;//更新为当前字符长度
//                    res=s.substring(i,j+1);
//
//                }
//            }
//        }
//
//        return res;
//
//    }

    public static void main(String[] args) {
        String s="cbdd";

        p5 t=new p5();
        String res = t.longestPalindrome(s);
        System.out.println(res);
    }
}
