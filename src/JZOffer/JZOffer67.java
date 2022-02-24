package JZOffer;

/**
 * @ClassName: JZOffer67
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/2/22
 * @Time: 21:58
 */
public class JZOffer67 {

//    public int strToInt(String str) {
//
//        String s=str.trim();//先取出开头存在的空格
//        if (s.equals("")) return 0;
//        char[] chars = s.toCharArray();
//        String res="";
//
//        //先处理不合法的情况 如果第一个字符既不是+ 也不是 -
//        if (!(chars[0]=='+'||chars[0]=='-')){
//
//            //而且这个字符也不是0~9的数字
//            if (chars[0]<'0'||chars[0]>'9')
//                return 0;//直接返回不符合要求的情况
//        }
//
//        //此时的第一个字符肯定是合理的 要么是数字 要么是+ -
//
//        res+=chars[0];
//        int index=1;
//        //在数组的长度范围内进行遍历 当遇到不是数字字符的时候跳出
//        while (index<chars.length&&chars[index]>='0'&&chars[index]<='9'){
//
//            res+=chars[index];
//            index++;
//        }
//        //如果最后的结果只有 "+" 或者 "-" 直接返回不符合要求的情况
//        if (res.equals("+")||res.equals("-")) return 0;
//
//        //先将结果转化为double类型 便于判断是否已经超出整数类型边界
//        Double d = Double.valueOf(res);
//
//        //超出边界 做出处理
//        if (d>=Integer.MAX_VALUE ) return Integer.MAX_VALUE;
//        else if (d<=Integer.MIN_VALUE) return Integer.MIN_VALUE;
//
//        //最后返回正确的情况
//        return Integer.valueOf(res);
//    }

    /**
     * 优雅的解法
     *
     * Integer.MAX_VALUE最大值为 2147483647
     * Integer.MIN_VALUE最小值为 -2147483648
     * 在模拟获得数字的时候 使用res=res*10+chars[i]-'0' 所以可以提前进行判断是否越界
     * 设定一个边界 boundary=Integer.MAX_VALUE/10  当遇到一个数字的时候 并且此时res>boundary 那么已经要越界了
     * 若res==boundary & 这个字符>'7' 也是需要返回Integer.MAX_VALUE 再考虑上前面的符号 对于如果是负数的情况下 越界时最终都需要返回MIN_VALUE
     * 所以无论是 = '8' ,还是 >'8',返回的都是MIN。
     * @param str
     * @return
     */

    public int strToInt(String str) {

        int sign=1,res=0,boundary=Integer.MAX_VALUE/10;

        if (str.length()==0) return 0;
        int i=0;
        //如果存在前面有空格 先遍历跳过前面的空格
        while (str.charAt(i)==' '){
            if (++i==str.length()) return 0;//遍历完已经到末尾了 说明全是空格
        }

        if (str.charAt(i)=='-') sign=-1;//标记是负数
        if (str.charAt(i)=='-'||str.charAt(i)=='+') i++;//开始判断下一个字符

        for (int j=i;j<str.length();j++){

            if (str.charAt(j)<'0'||str.charAt(j)>'9') break;

            if (res>boundary||res==boundary&&str.charAt(j)>'7'){
                return sign==1?Integer.MAX_VALUE:Integer.MIN_VALUE;
            }

            res=res*10+(str.charAt(j)-'0');
        }

        return res*sign;
    }
    public static void main(String[] args) {

//        String s= "2147483648";
//
//        JZOffer67 t=new JZOffer67();
//        int res = t.strToInt(s);
//        System.out.println(res);


    }
}
