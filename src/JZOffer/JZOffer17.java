package JZOffer;

import java.util.Arrays;

/**
 * @ClassName: JZOffer17
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/11/26
 * @Time: 21:25
 * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
 * 输入: n = 1
 * 输出: [1,2,3,4,5,6,7,8,9]
 */
public class JZOffer17 {

//    public int[] printNumbers(int n) {
//
//        //n是n位十进制 比如n=1 就是1位的十进制1-9
//        //n=2 1-99
//        //n=3 1-999
//        int max=(int)Math.pow(10,n)-1;
//        int res[]=new int[max];
//        for (int i=0;i<max;i++)
//            res[i]=i+1;
//
//        return res;
//
//
//    }

    /**
     * 大数问题 使用全排列+字符串来解决
     *
     * @param n
     * @return
     */

    int res[];
    int pos = 0;

    public int[] printNumbers(int n) {

        //最大的 11 位数是 99 ，最大的 22 位数是 9999 ，最大的 33 位数是 999999 。则可推出公式：最大的位数为10^n-1
        res = new int[(int) Math.pow(10, n) - 1];

        //digit用来表示有几位数 从1位开始选
        for (int digit = 1; digit <= n; digit++) {

            char num[] = new char[digit];//如果digit=1 说明就是1位就行 存一个字符
            for (char first = '1'; first <= '9'; first++) {

                num[0] = first;//先选择首个数字
                dfs(1, digit, num);//接着dfs选择下一个数字

            }

        }

        return res;


    }
    //index表示当前已经选择了多少个数字了 digit表示需要多少个数字
    public void dfs(int index, int digit, char[] num) {
        //当前已经选择的数字已经==这一轮的目标数字digit 将num数组中的数字 解析成数字
        if (index == digit) {
            res[pos++] = Integer.parseInt(String.valueOf(num));
            return;
        }
        //来到这里的时候 前面已经固定了1个数字 比如digit=2  说明要求两个数字 那么index=1的时候 已经固定了一个数字 放在num[0]的位置 接下去就是选择下一个数字 然后继续dfs
        for (char first = '0'; first <= '9'; first++) {

            num[index] = first;
            dfs(index + 1, digit, num);
        }
    }

    public static void main(String[] args) {

        int n = 2;
        JZOffer17 jzOffer17 = new JZOffer17();
        int[] res = jzOffer17.printNumbers(n);
        for (int a:res)
            System.out.print(a+" ");

    }




}
