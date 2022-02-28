package MoveWindow;

import java.util.Arrays;

/**
 * @ClassName: p567
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/9/22
 * @Time: 22:46
 * s1的排列之一是s2的子串
 * s1 = "ab" s2 = "eidbaooo"
 */
public class p567 {

    public boolean checkInclusion(String s1, String s2) {

        if (s1.length()>s2.length()) return false;

        char cnt1[]=new char[26];
        char cnt2[]=new char[26];

        int n=s1.length();
        char chars1[]=s1.toCharArray();
        char chars2[]=s2.toCharArray();
        //一开始先比较s1长度的的子串 也就是s2字符串中的前n个字符
        for (int i=0;i<n;i++){
            //记录s1字符串中的字符出现的次数
            cnt1[chars1[i]-'a']++;
            cnt2[chars2[i]-'a']++;
        }

        if (Arrays.equals(cnt1,cnt2)) return true;//前n个就相等了 返回

        //接下去要控制每次比较都是长度为n 而且从下标n开始往右移 滑动窗口大小为n 右边界往右移1个位置 左边界也移动一个单位
        for (int i=n;i<s2.length();i++){
            //开始进行活动窗口的遍历
            cnt2[chars2[i]-'a']++;//右边进来的字符次数加1
            cnt2[chars2[i-n]-'a']--;//左边的边界的字符前面的就要出去

            //新的窗口比较
            if (Arrays.equals(cnt1,cnt2)) return true;
        }
        return false;
    }
}
