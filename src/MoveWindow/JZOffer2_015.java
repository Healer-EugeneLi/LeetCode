package MoveWindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: JZOffer2_015
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/2/28
 * @Time: 22:53
 * 输入: s = "cbaebabacd", p = "abc"
 * 输出: [0,6]
 */
public class JZOffer2_015 {

    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> res=new ArrayList<>();
        if(p.length()>s.length())
            return res;

        int cntS[]=new int[26];
        int cntP[]=new int[26];

        int n=p.length();
        for (int i=0;i<n;i++){

            cntS[s.charAt(i)-'a']++;
            cntP[p.charAt(i)-'a']++;
        }

        //前n个字符一样
        if (Arrays.equals(cntP,cntS))
            res.add(0);

        //接下去从索引为n开始
        for (int i=n;i<s.length();i++){

            //窗口右边的字符进来 那么++
            cntS[s.charAt(i)-'a']++;

            //窗口左边的字符出去 那么++
            cntS[s.charAt(i-n)-'a']--;

            if (Arrays.equals(cntP,cntS))
                res.add(i-n+1);
        }

        return res;
    }

    public static void main(String[] args) {


        String s="abab";
        String p="abasasa";
        JZOffer2_015 t=new JZOffer2_015();
        List<Integer> res = t.findAnagrams(s, p);
        System.out.println(res);
    }

}
