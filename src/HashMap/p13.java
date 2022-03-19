package HashMap;

import java.util.HashMap;

/**
 * @ClassName: p13
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/10/1
 * @Time: 19:32
 */
public class p13 {

    public int romanToInt(String s) {

        //代表映射关系
        HashMap<Character, Integer> map = new HashMap<>();
        char key[] = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
        int value[] = {1, 5, 10, 50, 100, 500, 1000};
        for (int i = 0; i < key.length; i++)
            map.put(key[i], value[i]);
        int ans = 0;
        char[] chars = s.toCharArray();
        int i = 0;
        for (i = 0; i < chars.length - 1; ) {
            if (map.get(chars[i]) >= map.get(chars[i + 1])) {
                ans += map.get(chars[i]);
                i++;
            } else {
                //左边比右边小
                ans += (map.get(chars[i + 1]) - map.get(chars[i]));
                i += 2;
            }

        }
        if (i == chars.length) {
            //说明已经超过了整个字符串 表示都用完了
            return ans;
        } else {
            //还需要加最后一个数
            return ans + map.get(chars[i]);
        }


    }

    public static void main(String[] args) {

        String a = "III";
        p13 t = new p13();
        int i = t.romanToInt(a);
        System.out.println(i);
    }
}
