package Backtrack;

import java.util.ArrayList;
import java.util.List;

public class p17 {

    public  String[] map={
            "",
            "",
            "abc",//2
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz"//9
    };
    List<String> res=new ArrayList<>();
    StringBuffer path=new StringBuffer();
    public List<String> letterCombinations(String digits) {

        if (digits.length()==0) return res;

        backTracking(digits,0,path);
        return res;
    }

    /**
     *
     * @param digits 数字
     * @param index 当前搜索到的数字的索引
     * @param path 组成的路径
     */
    public void backTracking(String digits,int index,StringBuffer path){

        if (index==digits.length()){
            res.add(new String(path));
            return;
        }

        int digit=digits.charAt(index)-'0';//此时遍历到的数字
        String s = map[digit];//数字对应的字符串

        for (int i=0;i<s.length();i++){

            path.append(s.charAt(i));
            backTracking(digits,index+1,path);
            path.deleteCharAt(path.length()-1);//回溯回来之后删掉上一轮添加的字符 然后继续这个for循环就可以继续加入 当前s这个数字字符串里面的其他数字
        }

    }


    public static void main(String[] args) {

        String digits="23";
        p17 t=new p17();
        List<String> res = t.letterCombinations(digits);
        for (String temp:res){
            System.out.println(temp);
        }

        StringBuilder builder=new StringBuilder();
    }
}
