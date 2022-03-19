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

        res = new int[(int) Math.pow(10, n) - 1];

        for (int digit = 1; digit <= n; digit++) {

            char num[] = new char[digit];//如果i=0 说明就是1位就行 存一个字符
            for (char first = '1'; first <= '9'; first++) {

                num[0] = first;
                dfs(1, digit, num);

            }

        }

        return res;


    }

    public void dfs(int index, int digit, char[] num) {

        if (index == digit) {
            res[pos++] = Integer.parseInt(String.valueOf(num));
            return;
        }

        for (char first = '0'; first <= '9'; first++) {

            num[index] = first;
            dfs(index + 1, digit, num);
        }
    }

    public static void main(String[] args) {

        int n = 2;
        JZOffer17 jzOffer17 = new JZOffer17();
        int[] res = jzOffer17.printNumbers(n);
        System.out.println(Arrays.stream(res).toArray());
    }


}
