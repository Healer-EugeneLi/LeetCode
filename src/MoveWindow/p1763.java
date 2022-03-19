package MoveWindow;

import java.util.HashSet;

/**
 * @ClassName: p1763
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/2/28
 * @Time: 19:40
 */
public class p1763 {

//    public String longestNiceSubstring(String s) {
//
//        if (s.length()==1) return "";
//
//        int left=0,right=0,ans=0;
//        for (int i=0;i<s.length();i++){
//
//            int j=s.length();
//            for (;j>i;j--){
//
//                String substring = s.substring(i, j);//子串
//
//                String up = substring.toUpperCase();//子串的大写版本
//
//                //子串构建set
//                HashSet<Character> set1=getSet(substring);
//
//                //大写版本穿set
//                HashSet set2=getSet(up);
//
//                if (set1.size()==2*set2.size()&&(j-i+1)>ans){
//                    left=i;
//                    right=j;
//                    ans=j-i+1;
//                }
//
//            }
//        }
//
//        if (!(left==0&&right==0))
//            return s.substring(left,right);
//        return "";
//
//    }
//
//    public HashSet getSet(String s){
//        HashSet set=new HashSet();
//
//        for (int i=0;i<s.length();i++){
//            set.add(s.charAt(i));
//        }
//        return set;
//    }


    public String longestNiceSubstring(String s) {

        int n = s.length();
        int[][] cnt = new int[n + 1][128];

        //行数为n+1 记录从下标为1的行开始记录 比如cnt[1][j] 这个1表示的是从下标0开始长度为1的子串 记录j出现的次数
        for (int i = 1; i <= n; i++) {

            char c = s.charAt(i - 1);
            cnt[i] = cnt[i - 1].clone();//把前i-1个构成的子串统计的记录保留下来
            cnt[i][c - 'A']++;// cnt[i + 1][j] 所代表的含义为在子串 s[0...i] 中字符 j 的出现次数。
            //所以 当i=1 c为d 表示 cnt[1][d-'A'] 0-1这个子串中出现字符d的个数
        }

        int index = -1, len = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {

                if (j - i + 1 <= len) continue;
                //i是左边界 j是右边界
                int a[] = cnt[i];
                int b[] = cnt[j + 1];

                if (check(a, b)) {
                    index = i;
                    len = j - i + 1;

                }
            }
        }
        return index == -1 ? "" : s.substring(index, index + len);
    }


    boolean check(int[] a, int[] b) {

        for (int i = 0; i < 26; i++) {

            int low = b[i] - a[i];
            int up = b[i + 32] - a[i + 32];

            if (low != 0 && up == 0) return false;
            if (low == 0 && up != 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "dDzeE";

        p1763 t = new p1763();
        String res = t.longestNiceSubstring(s);
        System.out.println(res);
    }
}
