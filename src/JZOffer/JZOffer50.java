package JZOffer;

import java.util.*;

/**
 * @ClassName: JZOffer50
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/11/27
 * @Time: 21:00
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 */
public class JZOffer50 {

//    public char firstUniqChar(String s) {
//
//        char[] chars = s.toCharArray();
//        HashSet<Character> set=new HashSet<>();
//        List<Character> list=new ArrayList<>();
//        for (int i=0;i<chars.length;i++){
//            char cur=chars[i];
//            if (set.contains(cur)){
//                //说明这个字符已经存在了
//                for (int j=0;j<list.size();j++){
//                    if (list.get(j)==cur)
//                        list.remove(j);
//                }
//            }else {
//                set.add(cur);
//                list.add(cur);
//            }
//        }
//
//        if (list.isEmpty())
//            return ' ';
//        else
//            return list.get(0);
//
//    }

    /**
     * 哈希表简洁写法
     *
     * @param s
     * @return
     */
    public char firstUniqChar(String s) {

        HashMap<Character, Boolean> map = new HashMap<>();

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            map.put(c, !map.containsKey(c));//如果已经存在的话 那么就是true 取反之后变成false
        }
        //最后map中存在的就只有出现过一次的字符 此时再重新遍历字符串 先遍历到的在map中存在的便是第一个出现的只出现一次的的字符
        for (char c : chars) {
            if (map.containsKey(c) && map.get(c) == true)
                return c;
        }
        return ' ';
    }
}
