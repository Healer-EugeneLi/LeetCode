package HashMap;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName: p3
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/5/9
 * @Time: 19:25
 */
public class p3 {


    /**
     * 无重复最长子串
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {

        if (s.length()==0) return 0;

        Set<Character> set=new HashSet<>();//存放当前集合中已有的字符

        int left=0,right=0;
        int max=1;

        for (left=0,right=0;right<s.length()&&left<s.length();right++){

            char c=s.charAt(right);//当前字符
            while (set.contains(c)){

                set.remove(s.charAt(left++));//移动左边界窗口
            }

            //将当前字符加进来
            set.add(s.charAt(right));

            //当前滑动窗口的长度
            int curLength=right-left+1;
            max=Math.max(max,curLength);
        }

        return max;
    }
}
