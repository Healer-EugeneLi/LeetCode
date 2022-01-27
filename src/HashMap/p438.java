package HashMap;

import Tree.P144;

import java.util.*;

/**
 * @ClassName: p438
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/11/28
 * @Time: 20:22
 */
public class p438 {

    //超时版本
//    public List<Integer> findAnagrams(String s, String p) {
//
//        int pLen=p.length();
//        int sLen=s.length();
//        HashMap<Character,Integer> map=new HashMap<>();
//
//        char[] pChars = p.toCharArray();
//        for (int i=0;i<pLen;i++){
//            map.put(pChars[i],map.getOrDefault(pChars[i],0)+1);
//        }
//
//        List<Integer> res=new ArrayList<>();
//
//        for (int i=0;i<=sLen-pLen;i++){
//            char cur=s.charAt(i);//当前字符
//            if (map.containsKey(cur)){
//                //如果遇到了该字符是在p中有的
//                String temp=new String(s);
//                String substring = temp.substring(i, i + pLen);//切割出子串 判断内容与p是符合条件
//                if(check(substring,new HashMap<>(map))){
//                    res.add(i);
//                }
//
//            }
//        }
//
//        return res;
//    }
//
//    public boolean check(String sub,HashMap<Character,Integer> map){
//
//        HashMap<Character,Integer> subTemp;
//        for (int i=0;i<sub.length();i++){
//            char c=sub.charAt(i);
//            if (!map.containsKey(c)){
//                //不包含 表示不一致 不用比较 直接返回不符合
//                return false;
//            }else {
//                if (map.get(c)==1){
//                    //只有一个的话 直接移除
//                    map.remove(c);
//                }else {
//                    map.put(c,map.get(c)-1);
//                }
//            }
//        }
//        return true;
//    }


    /**
     * 使用双指针+滑动窗口来判断
     * @param s
     * @param p
     * @return
     */
    public List<Integer> findAnagrams(String s, String p) {

        int sLen=s.length();
        int pLen=p.length();
        int curNum[]=new int[26];//每次需要判断的该子串的字符频率统计
        int targetNum[]=new int[26];//目标字符串 字符频率
        for (int i=0;i<pLen;i++)
            targetNum[p.charAt(i)-'a']++;

        int left=0,right=0;
        List<Integer> res=new ArrayList<>();

        for (left=0,right=0;right<sLen;right++){
            curNum[s.charAt(right)-'a']++;//当前字符出现的次数加1

            if (right-left+1>pLen){
                //此时right已经越过需要长度的滑动窗口了
                curNum[s.charAt(left++)-'a']--;//right所对应的
            }
            if (right-left+1==pLen){
                if (check(curNum,targetNum))
                    res.add(left);
            }

        }

        return res;

    }

    public boolean check(int cur[],int target[]){

        for (int i=0;i<26;i++){
            if (cur[i]!=target[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {

        String s="abab";
        String p="ab";

        p438 t=new p438();
        List<Integer> res = t.findAnagrams(s, p);
        for (Integer a:res)
            System.out.println(a);
//        System.out.println(res.stream().toArray());
    }
}
