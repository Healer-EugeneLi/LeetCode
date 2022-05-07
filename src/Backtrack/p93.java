package Backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: p93
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/3/25
 * @Time: 21:04
 *
 * 复原出有效的ip地址
 * 输入：s = "25525511135"
 * 输出：["255.255.11.135","255.255.111.35"]
 */
public class p93 {

    public List<String> res=new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {

        //有效的ip不可能超过12个数字
        if (s.length()>12) return res;
        backTracking(s,0,0);
        return res;

    }

    /**
     *
     * @param s
     * @param startIndex 当前要开始取数字的位置索引
     * @param pointNum 已经加了多少个 . 当有3个的时候 再判断最后一串数字 如果是合法的话 那么就构造出了一个有效的ip
     */
    public void  backTracking(String s,int startIndex,int pointNum){

        //当有3个的时候 再判断最后一串数字 如果是合法的话 那么就构造出了一个有效的ip
        if (pointNum==3){
            if (isValid(s,startIndex,s.length()-1))
                res.add(new String(s));
            return;
        }


        for (int i=startIndex;i<s.length();i++){
            //实际上startIndex用来控制准备开始切割的位置 i用来控制长度 一开始进入循环的时候 i==startIndex 所以切出来的是1个字符
            if (isValid(s,startIndex,i)){
                //当前是合法的 那么就可以在这个i这个位置后面插一个 . 记住substring中容易写错成substring(startIndex,i+1)
                //我们需要的是前面字符串全部切割出来 即[0,i]然后在后面加一个. 再将[i+1,往后的全部拿出来进行拼接
                s=s.substring(0,i+1)+'.'+s.substring(i+1);
                pointNum++;
                //注意由于此时是加了1个. 因此下一次开始的位置应该是i+2
                backTracking(s,i+2,pointNum);
                pointNum--;
                //将s还原为原先的状态
                // 上一个 . 是放在i的后面 因此需要切割0~i索引的位置 substring是左闭右开的 因此取[0,i]需要(0,i+1) 然后把 . 后面的字符拿出来进行拼接 还原
                s=s.substring(0,i+1)+s.substring(i+2);
            }
        }
    }


    /**
     * 在字符串s中进行判断 [start,end]构造的数字是否符合要求
     * 要求
     * 如果是超过1位数字的话 不能以0开头
     * 数字必须是0~9的整数
     * 不能超过255
     * @param s
     * @param start
     * @param end
     * @return
     */
    public boolean isValid(String s,int start,int end){

        if (start>end) return false;

        //如果是超过1位数字的话 不能以0开头
        if (s.charAt(start)=='0'&&start!=end)
            return false;

        int num=0;
        for (int i=start;i<=end;i++){
            //如果出现了小于0 大于9的字符也是不合法的
            if (s.charAt(i)<'0'||s.charAt(i)>'9')return false;

            num=num*10+s.charAt(i)-'0';
            //数字大于255也是不合法的
            if (num>255)
                return false;
        }
        return true;

    }

}
