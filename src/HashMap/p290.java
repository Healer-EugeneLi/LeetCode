package HashMap;

import java.util.*;

/**
 * @ClassName: p290
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/10/2
 * @Time: 15:39
 */
public class p290 {
    public boolean wordPattern(String pattern, String s) {


        HashMap<Character, List<Integer>> map=new HashMap<>();

        String[] target = s.split(" ");

        char[] chars = pattern.toCharArray();
        if (chars.length!=target.length) return false;
        //放置赌对应的关系 a:[0,3]
        for (int i=0;i<chars.length;i++){

            List<Integer> temp=new ArrayList<>();
            temp=map.getOrDefault(chars[i],temp);
            temp.add(i);
            map.put(chars[i],temp);

        }

        Set<Character> characters = map.keySet();
        Set<String> has=new HashSet<>();//标记目前已有的字符串
        for (Character c:characters){

            List<Integer> list = map.get(c);
            Integer integer = list.get(0);//第一个值索引
            String s1 = target[integer];//第一个 后面的必须与他一样
            if (list.size()>1){
                for (int i=1;i<list.size();i++){
                    //先用list.get(i) 获取在目标字符串数组中的索引 然后使用target来得到这个字符串 判断如果不与s1一样 就表明规律不符合了
                    if (!s1.equals(target[list.get(i)])) return false;
                }
            }
            if (has.contains(s1)) return false;//如果set中已经有这个字符串了 说明不应该再出现这个字符串 返回false
            has.add(s1);
        }

        return true;
    }

    public static void main(String[] args) {
        String patten="abba";
        String target="dog cat cat dog";
        p290 t=new p290();
        boolean b = t.wordPattern(patten, target);
        System.out.println(b);
    }
}
