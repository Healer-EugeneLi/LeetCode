package BFS;

import java.util.*;

/**
 * @ClassName: p127
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/3/31
 * @Time: 23:12
 * 输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
 * 输出：5
 * 解释：一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog", 返回它的长度 5。

 */
public class p127 {


    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        //方便查找
        Set<String> set=new HashSet<>(wordList);
        if (!set.contains(endWord))
            return 0;
        //对已经试过的字符串 加入访问过的队列
        Set<String> visit=new HashSet<>();

        Queue<String> queue=new LinkedList<>();
        queue.add(beginWord);

        int level=1;//题目要求第一个初始字符串就算1次
        while (!queue.isEmpty()){

            int size = queue.size();

            //每一层  逐个字符串进行尝试 也就是对每一个字符串的每一个位置进行变换 直到能在某一层找到目标
            for (int i=0;i<size;i++){

                //当前字符串
                String cur = queue.poll();

                //对当前字符串的每一个字符串进行变换 每一次变换字符串中的一个字符
                // 并判断是否存在在字典中 表明可以作为路径中的一个节点 加入队列
                for (int j=0;j<cur.length();j++){
                    char[] chars = cur.toCharArray();
                    //对每一个字符进行从a到z的变换
                    for (char k='a';k<='z';k++){

                        if (chars[j]==k) continue;//遇到本身的时候 不需要换

                        chars[j]=k;//修改当前字符
                        //构造新的字符串
                        String newStr=String.valueOf(chars);


                        //当存在 在字典中 以及没有被访问过 此时才可以加入
                        if (set.contains(newStr)&&!visit.contains(newStr)){
                            //遇到了目标字符 新建的节点在下一层 所以返回level+1
                            if (newStr.equals(endWord))
                                return level+1;
                            queue.add(newStr);
                            visit.add(newStr );//访问过的也需要加入
                        }

                    }
                }

            }
            level++;
        }
        return 0;

    }

    public static void main(String[] args) {
        String begin="cat";
        String end="dog";
        String[] list={"cat","dog"};

        p127 t=new p127();
        int res = t.ladderLength(begin, end, Arrays.asList(list));
        System.out.println(res);
    }
}
