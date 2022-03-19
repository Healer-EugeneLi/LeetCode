package JZOffer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @ClassName: JZOffer48
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/2/16
 * @Time: 12:07
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 */
public class JZOffer48 {

    public int lengthOfLongestSubstring(String s) {

        if (s.equals("")) return 0;
        char[] chars = s.toCharArray();
        int max = 0;

        Set<Character> set = new HashSet<>();//存不重复的字符

        //滑动窗口 left right 两个指针
        for (int left = 0, right = 0; right < chars.length; right++) {
            char c = chars[right];
            //遇到已经存在的字符 那么就需要将左指针不断的右移 因为此时这个子串已经不符合要求了
            while (set.contains(c)) {
                set.remove(chars[left++]);//滑动窗口的左边的元素删除 并且边界左移
            }
            //直到此时的串中不存在当前要加入的字符
            set.add(c);

            int curLength = right - left + 1;
            max = curLength > max ? curLength : max;
        }
        return max;


    }
}
