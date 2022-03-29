package Backtrack;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ScheduledFuture;

/**
 * @ClassName: p301
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/3/29
 * @Time: 15:29
 *
 * 删除无效的字符串
 * 输入：s = "()())()"
 * 输出：["(())()","()()()"]
 */
public class p301 {

    public Set<String> res=new HashSet<>();

    //遇到一个 ( 加1分  遇到一个 ) -1 所以最终的答案肯定是0分  那么maxScore就是最大的符合要求的串中(的长度
    public int maxScore;
    public int leftDelete,rightDelete;//分别为需要删除的左括号数量 右括号数量
    public int left,right;//总的输入的左括号的数量 右括号的数量
    public int length;//最终扣除需要删除的( )留下来的字符串长度
    public int n;//输入字符串长度
    public List<String> removeInvalidParentheses(String s) {

        //可以通过预处理 先得到最终的最大得分maxScore 以及长度
        n=s.length();

        char[] chars = s.toCharArray();
        for (char c:chars){
            if (c=='('){
                leftDelete++;//需要删除的(加1
                left++;
            }else if (c==')'){
                //此时遇到一个) 那么如果leftDelete不为0
                // 说明前面有( 此时可以进行匹配 那么需要被删除的(数量就可以减1 也就是不需要删除
                if (leftDelete!=0){
                    leftDelete--;
                }else {
                    rightDelete++;//如果没有 说明这个右括号需要被删除 需要删除的)右括号数量+1
                }
                right++;
            }
        }

        length=n-leftDelete-rightDelete;//最终扣除需要删除的( )留下来的合法的字符串长度

        maxScore=Math.min(left,right);//最大的分数肯定是( )中少数的 这样才能正常匹配

        dfs(s,"",leftDelete,rightDelete,0,0);
        return new ArrayList<>(res);

    }

    /**
     * @param s 原先字符串
     * @param cur 当前构成的字符串
     * @param leftDelete 还需要删除的左括号数量
     * @param rightDelete 还需要删除的右括号数量
     * @param index 在原先字符串的下标索引
     */
    public void dfs(String s,String cur,int leftDelete,int rightDelete,int score,int index){

        //删除过头 或者分数超过最大的结果 score<0说明此时已经加入了一个) 前面没有左括号进行匹配 不合法 直接返回
        if (leftDelete<0||rightDelete<0||score>maxScore||score<0) return;

        //当符合要求时
        if (leftDelete==0&&rightDelete==0&&cur.length()==length)
            res.add(new String(cur));
        //到达结尾了
        if (index==n)
            return;

        char c=s.charAt(index);

        if (c=='('){
            //可以选择加入( 加1分
            dfs(s,cur+c,leftDelete,rightDelete,score+1,index+1);
            //可以选择不加入 ( 等价于删除一个(  所以leftDelete-1
            dfs(s,cur,leftDelete-1,rightDelete,score,index+1);
        }else if (c==')'){
            //可以选择加入) 减1分
            dfs(s,cur+c,leftDelete,rightDelete,score-1,index+1);
            //可以选择不加入 ) 等价于删除一个) 所以rightDelete-1
            dfs(s,cur,leftDelete,rightDelete-1,score,index+1);
        }else {
            //遇到其他字符 正常加入
            dfs(s,cur+c,leftDelete,rightDelete,score,index+1);
        }

    }

    public static void main(String[] args) {
        String s="()())()";

        p301 t=new p301();
        List<String> strings = t.removeInvalidParentheses(s);
        for (String k:strings)
            System.out.println(k);
    }
}
