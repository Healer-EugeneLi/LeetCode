package JZOffer;

import java.util.*;

/**
 * @ClassName: JZOffer38
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/2/14
 * @Time: 23:44
 */
public class JZOffer38 {


    //使用set去重
//    public Set<String> set=new HashSet<>();
//    public boolean used[]=new boolean[10];//题目最大长度为10
//    public String[] permutation(String s) {
//
//        char[] chars = s.toCharArray();
//
//        dfs(chars,0,"");
//
//        int index=0;
//        String res[]=new String[set.size()];
//        for (String str:set){
//            res[index++]=str;
//        }
//
//        return res;
//
//
//    }
//
//
//    public void dfs(char[] chars,int step,String cur){
//
//        if (chars.length==step){
//            set.add(new String(cur));
//            return;
//        }
//
//        for (int i=0;i<chars.length;i++){
//
//            if (!used[i]){
//                //还没被访问过
//                used[i]=true;
//                dfs(chars,step+1,cur+String.valueOf(chars[i]));
//                used[i]=false;
//            }
//        }
//    }


    public List<String> list = new LinkedList<>();
    public boolean used[] = new boolean[10];

    public String[] permutation(String s) {

        char[] chars = s.toCharArray();
        Arrays.sort(chars);//注意先排序
        dfs(chars, 0, "");

        String res[] = new String[list.size()];

        for (int i = 0; i < list.size(); i++) {

            res[i] = list.get(i);
        }

        return res;


    }

    public void dfs(char chars[], int step, String cur) {

        if (chars.length == step) {
            list.add(new String(cur));
            return;
        }

        for (int i = 0; i < chars.length; i++) {

            if (i > 0 && used[i - 1] == false && chars[i] == chars[i - 1]) continue;

            if (!used[i]) {
                used[i] = true;
                dfs(chars, step + 1, cur + String.valueOf(chars[i]));
                used[i] = false;
            }
        }
    }

}
