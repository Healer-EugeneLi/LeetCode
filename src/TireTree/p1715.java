package TireTree;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

/**
 * @ClassName: p1715
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/10/6
 * @Time: 15:06
 * 输入： ["cat","banana","dog","nana","walk","walker","dogwalker"]
 * 输出： "dogwalker"
 * 解释： "dogwalker"可由"dog"和"walker"组成。
 *先把字符串数组按字符串长度进行排序，如果长度相同按字符串的字典序进行倒序
 *
 * 于是我们直接从字符串数组尾部开始寻找结果，对每个字符串直接使用暴力法，例如dogwalker
 * 从第一个字符匹配到最后一个字符，每次往后移一个位置，都去判断当前字符之前的所有字符能否匹配一个字符串
 * 流程如下
 * d ogwalker,d 字典中无匹配，后移
 * do gwalker,do 字典中无匹配，后移
 * dog walker,dog 字典有匹配,递归判断walker
 *

 */
public class p1715 {

    public String longestWord(String[] words) {

        List<String> list = Arrays.asList(words);//转换成列表
        HashSet<String> set=new HashSet<>(list);
        Arrays.sort(words,new Comparator<String>(){
            @Override
            public int compare(String s1, String s2) {

                //如果两者长度相同 按照字典序降序
                if (s1.length()==s2.length())
                    return s2.compareTo(s1);
                return s1.length()-s2.length();

            }
        });

        //从尾部开始遍历
        for (int i=words.length-1;i>=0;i--){

            String word=words[i];
            set.remove(word);//避免匹配到自身 先移除
            if (check(word,set)){
                return word;
            }
        }

        return "";
    }

    //比如一开始匹配dogwalker
    private boolean check(String word, HashSet<String> set) {

        if (word.length()==0) return true;//已经匹配到最后 整个字符串被匹配完了

        //j在控制前半部分的单词 剩下的继续切
        for (int j=1;j<=word.length();j++){

            //切分字符串 j=1 先切割出[0,j)  如果存在 再去找[j,..)这个字符串是否也存在
            String s1=word.substring(0,j);
            if (set.contains(s1)){
                String s2=word.substring(j);//表示j到结束
                if (check(s2,set))//递归下去找s2是否可以被匹配到
                    return true;
            }
        }

        return false;//匹配过去还是没找到有存在的 返回false
    }
}





