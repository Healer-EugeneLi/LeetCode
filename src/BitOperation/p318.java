package BitOperation;

import java.util.HashMap;

/**
 * @ClassName: p318
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/11/20
 * @Time: 22:03
 * 利用words[i]中的单词都是小写字母 并且只需要判断是否有字母重复
 * 使用一个int 类型的数来指代某个单词 使用低26位来表示a~z是否出现过
 * 然后对每个字符对对应的两个int值进行&操作 若两个单词无重复字符 则结果为0 并得出最终的答案
 */
public class p318 {

//    public int maxProduct(String[] words) {
//
//        int num=0,ans=0;
//        int arr[]=new int[words.length];
//        for (String word:words){
//
//            //对每一个单词 用int来表示
//            int t=0;
//            for (int i=0;i<word.length();i++){
//                int pos=word.charAt(i)-'a';
//                t|=(1<<pos);//将1出现的位置更新上去
//            }
//            arr[num++]=t;
//        }
//        //遍历数组 对每一个单词对进行判断 并且计算结果值
//        for (int i=0;i<words.length;i++){
//            for (int j=0;j<i;j++){
//                if ((arr[i]&arr[j])==0){
//                    ans=Math.max(ans,words[i].length()*words[j].length());
//                }
//            }
//        }
//        return ans;
//
//    }

    //使用哈希表来优化 对同一个int出现过的话 只记录长度最长的那个
    public int maxProduct(String[] words) {

        int num=0,ans=0;
        int arr[]=new int[words.length];
        HashMap<Integer,Integer> map=new HashMap<>();
        for (String word:words){

            //对每一个单词 用int来表示
            int t=0;
            for (int i=0;i<word.length();i++){
                int pos=word.charAt(i)-'a';
                t|=(1<<pos);//将1出现的位置更新上去
            }
            if (!map.containsKey(t)||map.get(t)<word.length()){
                //如果这个int没出现过 或者其出现过 但是长度比现在这个短
                map.put(t,word.length());
            }
            //其他情况就是存在 并且长度比现在这个长


        }
        //遍历数组 对每一个单词对进行判断 并且计算结果值
       for (int a:map.keySet()){
           for (int b:map.keySet()){
               if ((a&b)==0){
                   ans=Math.max(ans,map.get(a)*map.get(b));
               }
           }
       }
        return ans;

    }
}
