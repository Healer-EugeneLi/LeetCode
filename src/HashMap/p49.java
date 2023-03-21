package HashMap;

import java.util.*;

/**
 * @ClassName: p49
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/5/11
 * @Time: 15:17
 */
public class p49 {


    /**
     * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
     * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
     *
     [["tea"],["bat"],["nat"],["ate"],["eat"],["tan"]]
     *字母异位词分组
     * 最后结果的每一个list里面其实就是有同样字母组成的不一样的单词而已
     * 1.遍历每一个字符串，转成数组形式，排序，排完序之后，作为map的key
     * 2.对遍历到的每一个单词都进行其字母的排序 如果发现其在map中是一个key 那么当前这个字符串就可以加入到这个key对应的value的list里面
     * 3.如果是第一次出现的 那么就将其拍完序后的字符串作为key
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> res=new ArrayList<>();
        if(strs.length==0) return res;
        Map<String,List<String>> map=new HashMap<>();//这些字母异位词拍完序后作为key 对应的单词放到集合里
        //遍历每一个字符串
        for (String s:strs){

            char[] chars = s.toCharArray();
            Arrays.sort(chars);//排序
            String key=String.valueOf(chars);//准备作为key
            //如果集合中不存在 第一次出现
            if(!map.containsKey(key)){
                map.put(key,new ArrayList<String>());//加入map中，同时value是一个集合的形式
            }

            //把当前这个单词加入对应字母拍完序后的这个key的列表中
            map.get(key).add(s);
        }

        //最后遍历这个map value都取出来
        res.addAll(map.values());
        return  res;

    }

    public static void main(String[] args) {
        String[] strs={"eat", "tea", "tan", "ate", "nat", "bat"};
        p49 t=new p49();
        List<List<String>> lists = t.groupAnagrams(strs);
        System.out.println();
    }
}
