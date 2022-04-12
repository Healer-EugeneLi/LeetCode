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

//    public String longestPalindrome(String s) {
//
//        String res="";
//        int max=0;
//
//        boolean dp[][]=new boolean[s.length()][s.length()];
//
//        for (int i=s.length()-1;i>=0;i--){
//            for (int j=i;j<s.length();j++){
//
//                if (s.charAt(i)==s.charAt(j)){
//
//                    if (j-i<=1){
//                        dp[i][j]=true;
//                    }else if (dp[i+1][j-1]==true){
//                        dp[i][j]=true;
//                    }
//                    if (dp[i][j]==true){
//                        if (j-i+1>=max){
//                            max=j-i+1;
//                            res=s.substring(i,j+1);
//                        }
//                    }
//
//                }
//            }
//        }
//        return res;
//    }

    public String longestPalindrome(String s) {

        int max=0;
        String res="";

        for (int i=0;i<s.length();i++){


            int left=i,right=i;
            while (left>=0&&right<s.length()&&s.charAt(left)==s.charAt(right)){

                if (right-left+1>=max){
                    max=right-left+1;
                    res=s.substring(left,right+1);
                }
                left--;
                right++;

            }


            int left2=i,right2=i+1;
            while (left2>=0&&right2<s.length()&&s.charAt(left2)==s.charAt(right2)){
                if (right2-left2+1>=max){
                    max=right2-left2+1;
                    res=s.substring(left2,right2+1);
                }
                left2--;
                right2++;
            }
        }

        return res;

    }
}
