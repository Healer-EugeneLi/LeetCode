package BFS;

import java.util.*;

/**
 * @ClassName: p752
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/3/30
 * @Time: 20:58
 *
 * 打开键盘锁
 * 你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' 。
 * 每个拨轮可以自由旋转：例如把 '9' 变为'0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。
 *
 * 锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。
 *
 * 列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。
 *
 * 字符串 target 代表可以解锁的数字，你需要给出解锁需要的最小旋转次数，如果无论如何不能解锁，返回 -1 。
 *输入：deadends = ["0201","0101","0102","1212","2002"], target = "0202"
 * 输出：6
 * 解释：
 * 可能的移动序列为 "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202"。
 * 注意 "0000" -> "0001" -> "0002" -> "0102" -> "0202" 这样的序列是不能解锁的，
 * 因为当拨动到 "0102" 时这个锁就会被锁定。
 *
 */
public class p752 {
    /**
     * 实际上并不是一棵树 但是可以想象成一棵树 就像图的BFS遍历一样，
     * 需要使用一个变量来记录访问过的节点 或者说set 如果被访问过之后 下次就不再访问了
     * @param deadends
     * @param target
     * @return
     */
    public int openLock(String[] deadends, String target) {

        //使用广度优先搜素 4个字符  每个字符可以有两种旋转情况 也就是说每个节点 可以产生8个子节点
        //同时需要注意比如从 0000 转换成1000之后 下一次旋转 不能在转成0000 否则会陷入死循环 所以需要有个Set来记录旋转过的状态

        Set<String> dead=new HashSet<>(Arrays.asList(deadends));//记录死亡节点 即不合法节点
        Set<String> visit=new HashSet<>();



        if (dead.contains("0000"))
            return -1;

        Queue<String> queue=new LinkedList<>();
        queue.add("0000");//初始节点是  0000
        visit.add("0000");//记得也把0000加入
        //层序遍历的层数 等价于需要旋转几次才能到达目标节点 比如一开始就是0 如果初始节点就=target 那就说明不需要旋转 即0次达到目标
        int level=0;
        while (!queue.isEmpty()){

            int size = queue.size();
            while (size-->0){

                //弹出当前节点
                String cur = queue.poll();
                if (cur.equals(target))
                    return level;
                //每个节点的4个字符 都有两种旋转方向
                for (int i=0;i<4;i++){

                    char curChar=cur.charAt(i);//当前字符
                    //该字符+1 注意'9' +1 需要来到'0'
                    String strAdd=cur.substring(0,i)+(curChar=='9'?0:curChar-'0'+1)+cur.substring(i+1);

                    //该字符-1 注意'0' -1 需要来到'9'
                    String strSub=cur.substring(0,i)+(curChar=='0'?9:curChar-'0'-1)+cur.substring(i+1);

                    //分别判断两种情况的字符是否是访问过 是否是合法的 只有符合了 才能加入
                    if (!visit.contains(strAdd)&&!dead.contains(strAdd)){
                        visit.add(strAdd);
                        queue.add(strAdd);//同时加入到下一层的队列里
                    }
                    if (!visit.contains(strSub)&&!dead.contains(strSub)){
                        visit.add(strSub);
                        queue.add(strSub);//同时加入到下一层的队列里
                    }

                }
            }
            //这一层都访问完了 层数+1
            level++;
        }
        return -1;

    }
}
