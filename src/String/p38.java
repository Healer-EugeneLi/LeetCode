package String;

/**
 * @ClassName: p38
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/10/15
 * @Time: 9:18
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 第一项是数字 1
 * 描述前一项，这个数是 1 即 “ 一 个 1 ”，记作 "11"
 * 描述前一项，这个数是 11 即 “ 二 个 1 ” ，记作 "21"
 * 描述前一项，这个数是 21 即 “ 一 个 2 + 一 个 1 ” ，记作 "1211"
 * 描述前一项，这个数是 1211 即 “ 一 个 1 + 一 个 2 + 二 个 1 ” ，记作 "111221"
 *
 */
public class p38 {

    public String countAndSay(int n) {

        if (n==1) return "1";
        if (n==2) return "11";
        String[] str=new String[31];
        str[1]="1";
        str[2]="11";

        for (int i=3;i<=n;i++){

            String cur="";

            String before=str[i-1];//前一个字符串
            char[] chars = before.toCharArray();
            int length=chars.length;//至少2
            char a=chars[0];
            int count=1;
            for (int j=1;j<length;j++){

                if (a==chars[j]){
                    count++;
                }else {
                    //发现不一样的话

                    cur+=String.valueOf(count)+a;//拼接一下
                    count=1;
                    a=chars[j];//a给下一个
                }
            }
            cur+=String.valueOf(count)+a;
            str[i]=cur;


        }

        return str[n];

    }

    public static void main(String[] args) {

        p38 t=new p38();
        String s = t.countAndSay(5);
        System.out.println(s);
    }
}
