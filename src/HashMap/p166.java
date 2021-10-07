package HashMap;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: p166
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/10/3
 * @Time: 22:20
 * 小数转分数
 */
public class p166 {

    /**
     * 计算 numerator/denominator
     * @param numerator
     * @param denominator
     * @return
     */
    public String fractionToDecimal(int numerator, int denominator) {

        //转long 类型防止溢出
        long a=numerator;
        long b=denominator;
        //如果能整除 直接返回结果
        if (a%b==0) return String.valueOf(a/b);

        StringBuffer sb=new StringBuffer();
        if (a*b<0) sb.append('-');//如果有一个为0 那么需要先在结果面前补0
        a=Math.abs(a);
        b=Math.abs(b);

        //计算小数点前面的部分 并将余数赋值给a
        sb.append(String.valueOf(a/b)+'.');
        a%=b;//余数赋值给a

        Map<Long,Integer> map=new HashMap<>();//存储循环小数的位置
        while (a!=0){
            map.put(a,sb.length());
            a*=10;
            sb.append(String.valueOf(a/b));
            a%=b;
            //如果当前余数之前出现过 则将出现位置到当前位置的部分抠出来
            if (map.containsKey(a)){
                int pos=map.get(a);
                return String.format("%s(%s)", sb.substring(0,pos),sb.substring(pos));
            }
        }

        return sb.toString();
    }
}
