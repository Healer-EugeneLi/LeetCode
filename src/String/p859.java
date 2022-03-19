package String;

import javax.naming.ldap.HasControls;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName: p859
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/11/23
 * @Time: 22:21
 * <p>
 * 亲密字符串
 */
public class p859 {

    /**
     * 1.如果两个字符串长度不相等 肯定不是亲密字符串
     * <p>
     * 2.如果两个字符串长度相等
     * 2.1两个字符串完全相等 只有这两个字符串中有重复字符时 才符合 abca abca
     * 2.2两个字符串不相同
     * 那么只能有两个位置不同 然后交换这两个不同的位置就能得到另一个 abcd bacd
     * 如果不同的位置不是两个 肯定不符合
     *
     * @param s
     * @param goal
     * @return
     */
    public boolean buddyStrings(String s, String goal) {

        if (s.length() != goal.length()) return false;

        int diff = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
            if (s.charAt(i) != goal.charAt(i)) {
                //不同的字符个数
                diff++;
            }
        }

        if (s.equals(goal)) {
            //如果两个字符串完全一样
            Set<Character> characters = map.keySet();
            for (Character c : characters) {
                if (map.get(c) > 1) return true;//存在重复的字符时
            }
            return false;

        } else if (diff > 2) {
            return false;
        } else {
            int temp[] = new int[2];
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != goal.charAt(i)) {
                    temp[--diff] = i;
                }
            }
            if (goal.charAt(temp[0]) == s.charAt(temp[1]) &&
                    goal.charAt(temp[1]) == s.charAt(temp[0])) {
                return true;
            }
            return false;

        }


    }
}
