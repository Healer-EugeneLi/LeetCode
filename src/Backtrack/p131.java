package Backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: p131
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/3/24
 * @Time: 9:27
 * 分割子串 使得每个字串都是回文串
 * 输入：s = "aab"
 * 输出：[["a","a","b"],["aa","b"]]
 */
public class p131 {

    public List<List<String>> res=new ArrayList<>();
    public List<String> path=new ArrayList<>();

    public List<List<String>> partition(String s) {

        backTracking(s,0);
        return res;
    }

    /**
     *
     * @param s 需要被切割的字符串
     * @param startIndex 当前要切割的字符串的起始位置的索引
     */
    public void backTracking(String s,int startIndex){

        if (startIndex>=s.length()){
            res.add(new ArrayList<>(path));
            return;
        }

        //等同与startIndex来控制这个子串的位置 i不断右移 来控制要切割的长度
        for (int i=startIndex;i<s.length();i++){

            //切割出字符串
            String cur=s.substring(startIndex,i+1);
            if (!isPalindrome(s,startIndex,i)){
                //此时不是回文串 那么continue就会继续让i右 选择更长的一个子串进行判断
                continue;
            }

            path.add(cur);//符合条件就加入
            backTracking(s,i+1);//startIndex设置为下一个位置开始
            path.remove(path.size()-1);//回溯的时候 还原状态
        }
    }

    /**
     * 判断是否是回文串 s中的[start,end]的子串是否是回文串
     * @param s 总的串
     * @param start 串开始的位置索引
     * @param end 串结束的位置索引
     * @return
     */
    public boolean isPalindrome(String s,int start,int end){

        for (int left=start,right=end;left<right;left++,right--){

            if (s.charAt(left)!=s.charAt(right))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s="aab";
        p131 t=new p131();
        List<List<String>> partition = t.partition(s);
        System.out.println();
    }
}
