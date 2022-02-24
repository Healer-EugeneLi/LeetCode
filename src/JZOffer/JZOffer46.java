package JZOffer;

import sun.misc.Launcher;

import java.net.URL;

/**
 * @ClassName: JZOffer46
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/2/21
 * @Time: 10:13
 */
public class JZOffer46 {

    /**
     * 使用字符串进行切分之后 +动态规划 从左到右遍历
     * @param num
     * @return
     */
//    public int translateNum(int num) {
//        //f(i)表示到前i个数字组成的方案数
//
//        int curPre=1;//第一个数字有1种情况  当前数字i的前i-1个数字时的方案数
//        int curPrePre=1;//没有数字的时候有1种情况  当前数字i的前i
//        int cur=1;
//        // -2个数字的时候方案数
//        //i i-1两个数字可以一起翻译时  即i i-1 >=10 <=25        f(i)=f(i-2)+f(i-1)
//        //i单独翻译的时候 f(i)=f(i-1) i i-1 >25 <=99  说明i 0~9         f(i)=f(i-1)
//
//        String s = String.valueOf(num);
//        for (int i=2;i<=s.length();i++){
//
//            String check = s.substring(i - 2, i);//12258 当i=2的时候 切分出来为[0,1]  12
//            cur=check.compareTo("10")>=0&&check.compareTo("25")<=0?curPre+curPrePre:curPre;
//            curPrePre=curPre;//两个变量移动
//            curPre=cur;
//        }
//
//        return cur;
//
//    }

    /**
     * 使用字符串进行切分之后+动态规划+从右到左遍历
     * @param num
     * @return
     */
//    public int translateNum(int num) {
//
//        int curNext=1,curNextNext=1,cur=1;
//
//        String s = String.valueOf(num);
//        for (int i=s.length()-2;i>=0;i--){
//
//            String check = s.substring(i, i + 2);
//
//            cur=check.compareTo("10")>=0&&check.compareTo("25")<=0?curNext+curNextNext:curNext;
//            curNextNext=curNext;
//            curNext=cur;
//        }
//        return cur;
//
//
//    }

    /**
     * 从右到左遍历 采用数字取模 取余的方式 动态规划
     * @param num
     * @return
     */
    public int translateNum(int num) {

        int curNext=1,curNextNext=1,cur=1;

        int y=num%10;//第一位数 当前数字的后一个数字
        int x=0,check=0;
        while (num!=0){

            num/=10;//num去除最后一位
            x=num%10;//求出当前这个数字
            check=x*10+y;
            cur=(check>=10&&check<=25)?curNext+curNextNext:curNext;
            curNextNext=curNext;
            curNext=cur;
            y=x;

        }

        return cur;

    }

    public static void main(String[] args) {

//        int num=12258;
//        JZOffer46 t=new JZOffer46();
//        int res = t.translateNum(num);
//        System.out.println(res);

        System.out.println(93&3);

        URL[] urLs = Launcher.getBootstrapClassPath().getURLs();
        for (URL url:urLs)
            System.out.println(url);
    }
}
