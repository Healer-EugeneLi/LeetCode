package DFS;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: p22
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/3/21
 * @Time: 12:10
 */
public class p22 {

    public List<String> res=new ArrayList<>();
    public List<String> generateParenthesis(int n) {


        //一开始左括号 右括号的数目都是0
        dfs(n,0,0,"");
        return res;
    }

    /**
     *
     * @param n 括号对数
     * @param leftNumber 当前左括号的数目
     * @param rightNumber 当前右括号的数目
     * @param cur 当前构成的字符串对象
     */
    public void dfs(int n,int leftNumber,int rightNumber,String cur){

        //当左右括号数都等于所要求的括号对数的时候 将所构成的字符串加入结果
        if (leftNumber==n&&rightNumber==n){
            res.add(cur);
            return;
        }

        //此时左括号数还小于目标括号对数  表示还可以加入左括号 加入1个左括号 同时左括号的数目+1
        if (leftNumber<n){
            dfs(n,leftNumber+1,rightNumber,cur+"(");
        }

        //如果右括号数小于目标括号对数  同时当前左括号数比右括号数多 说明此时可以加入右括号
        if (rightNumber<n&&leftNumber>rightNumber){

            dfs(n,leftNumber,rightNumber+1,cur+")");
        }


    }

    public static void main(String[] args) {


        int n=3;

        p22 t =new p22();

        List<String> list = t.generateParenthesis(n);
        for (String s:list)
            System.out.println(s);
    }
}
