package MoveWindow;

import java.util.Arrays;

/**
 * @ClassName: p567
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/9/22
 * @Time: 22:46
 */
public class p567 {

    public boolean checkInclusion(String s1, String s2) {

        if (s1.length()>s2.length()) return false;

        char cnt1[]=new char[26];
        char cnt2[]=new char[26];

        int n=s1.length();
        char chars1[]=s1.toCharArray();
        char chars2[]=s2.toCharArray();
        for (int i=0;i<n;i++){
            //记录s1字符串中的字符出现的次数
            cnt1[chars1[i]-'a']++;
            cnt2[chars2[i]-'a']++;
        }

        if (Arrays.equals(cnt1,cnt2)) return true;//前n个就相等了 返回

        for (int i=n;i<s2.length();i++){
            //开始进行活动窗口的遍历
            cnt2[chars2[i]-'a']++;//右边进来的字符次数加1
            cnt2[chars2[i-n]-'a']--;//左边的边界的字符前面的就要出去

            if (Arrays.equals(cnt1,cnt2)) return true;
        }
        return false;
    }
}
