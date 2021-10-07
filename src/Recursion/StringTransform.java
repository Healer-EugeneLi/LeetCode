package Recursion;

/**
 * @ClassName: StringTransform
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/10/3
 * @Time: 21:27
 * 字符串构造情况
 * 1 对应 a
 * 2对应 b
 * ...
 * 26对应 z
 * 求一个数字字符串可以对应多少种情况
 * 比如1111
 */
public class StringTransform {

    /**
     * ...i-1 这些是已经转化好的结果
     * 接下来判断i...后面有多少种情况
     * @param str
     * @param i
     * @return
     */
    public static int process(char[] str,int i){

        if (i==str.length) return 1;//此时已经拿到一种合法的结果了

        if (str[i]=='0') return 0;//不合法的情况

        if (str[i]=='1'){
            //如果是1的话 有两种情况 一个是单独作为一个码 i+1开始有多少种情况
            // 另外就是跟后面的数构成一个码  判断i+2开始有多少种1情况
            int res=process(str,i+1);
            if (i+1<str.length){
                res+=process(str,i+2);
            }
            return res;
        }

        if (str[i]=='2'){
            //如果是2的话 第一种情况 单独作为一个码
            int res=process(str,i+1);
            //另外一种情况 2+ 1~6
            if (i+1<str.length&&str[i+1]>='0'&&str[i+1]<='6'){
                res+=process(str,i+2);
            }
            return res;
        }
        //对于其他情况 3-9 只有一种情况
        return process(str,i+1);

    }
}
