package HashMap;

import java.util.*;

/**
 * @ClassName: p187
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/10/8
 * @Time: 9:14
 */
public class p187 {

    public List<String> findRepeatedDnaSequences(String s) {

        List<String> list = new ArrayList<>();
        Set<String> set = new HashSet<>();//用来去重
        HashMap<String, Integer> map = new HashMap<>();//存放子串出现次数

        int length = s.length();
        if (length < 10) return list;

        int i = 0;
        for (int pos = 10; pos <= length; pos++) {

            String sub = s.substring(i, pos);
            i++;
            if (map.containsKey(sub)) {
                //有这个子串
                set.add(sub);
            } else
                map.put(sub, 1);
        }

        for (String temp : set)
            list.add(temp);
        return list;

    }
}
