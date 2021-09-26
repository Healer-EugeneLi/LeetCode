package MoveWindow;

import java.util.HashMap;

/**
 * @ClassName: p3
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/9/22
 * @Time: 22:27
 */
public class p3 {

    public int lengthOfLongestSubstring(String s) {

        if (s.length()==0||s.length()==1) return s.length();

        int start=0,end=0;
        int ans=-1;

        HashMap<Character,Integer> map=new HashMap<>();//key为字符 value存放下一个不重复的字符应该在的位置
        char[] chars = s.toCharArray();
        for (;end<s.length();end++){

            if (map.containsKey(chars[end])){
                //发现了重复的字符串 此时更新start的位置
                start=Math.max(start,map.getOrDefault(chars[end],0));
            }

            ans=Math.max(ans,end-start+1);//更新最大值
            map.put(chars[end],end+1);

        }
        return ans;
    }

    public static void main(String[] args) {

        String s= "pwwkew";
        p3 t=new p3();
        int res = t.lengthOfLongestSubstring(s);
        System.out.println(res);
    }
}
