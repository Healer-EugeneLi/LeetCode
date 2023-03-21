package Backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: p22
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/5/10
 * @Time: 16:48
 */
public class p22 {

    /**
     * 括号生成
     * 在dfs的过程中判断 当前(括号还未到达目标对数 那么就加入(到路径字符串path
     * 当一直dfs到左括号的个数已经达到需要的对数了 那么实际就可以判断)了
     *  判断)是否能够加入的原则： 当前)小于目标括号的个数 且当前)的个数小于(的个数 因为符合要求的括号组是不能有)个数大于(个数的
     *
     *  最终当(的个数==)的个数==目标个数n 则可以加入一组path
     * @param n
     * @return
     */
    public List<String> res=new ArrayList<>();
    public List<String> generateParenthesis(int n) {

        backTracking(n,0,0,"");
        return res;
    }


    /**
     *
     * @param n 目标括号对数
     * @param leftNumber 当前左括号个数
     * @param rightNumber 当前右括号个数
     * @param path
     */
    public void backTracking(int n,int leftNumber,int rightNumber,String path){

        if (leftNumber==n&&rightNumber==n){
            res.add(path);
            return;
        }

        //左括号的个数还小于目标括号对数，表示还可以加入括号，同时左括号个数+1
        if (leftNumber<n)
            backTracking(n,leftNumber+1,rightNumber,path+"(");

        //右括号的个数小于目标括号个数
        if (rightNumber<n&&rightNumber<leftNumber){
            backTracking(n,leftNumber,rightNumber+1,path+")");
        }



    }
}
