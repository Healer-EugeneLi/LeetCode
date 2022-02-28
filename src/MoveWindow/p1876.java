package MoveWindow;

import java.util.HashMap;

/**
 * @ClassName: p1876
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/2/28
 * @Time: 17:09
 * 如果一个字符串不含有任何重复字符，我们称这个字符串为 好 字符串。
 *
 * 给你一个字符串 s ，请你返回 s 中长度为 3 的 好子字符串 的数量。
 *
 * 注意，如果相同的好子字符串出现多次，每一次都应该被记入答案之中。
 *
 * 子字符串 是一个字符串中连续的字符序列。
 *输入：s = "xyzzaz"
 * 输出：1
 * 解释：总共有 4 个长度为 3 的子字符串："xyz"，"yzz"，"zza" 和 "zaz" 。
 * 唯一的长度为 3 的好子字符串是 "xyz" 。


 */
public class p1876 {

    public int countGoodSubstrings(String s) {

        if (s.length()<3) return 0;

        int num=0;
        int right=3;
        for (int i=0;i<s.length()-2;i++){

            String sub=s.substring(i,i+right);
            if (check(sub)==true) num++;
        }

        return num;
    }

    public boolean check(String s){

        if (s.charAt(0)==s.charAt(1)) return false;
        else if (s.charAt(0)==s.charAt(2)) return false;
        else if(s.charAt(1)==s.charAt(2)) return false;
        else return true;
    }

    public static void main(String[] args) {

        String s="aababcabc";

        p1876 t=new p1876();
        int res = t.countGoodSubstrings(s);
        System.out.println(res);
    }
}
