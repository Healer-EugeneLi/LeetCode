package JZOffer;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @ClassName: JZOffer44
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/2/19
 * @Time: 11:05
 * 数字序列中的某一个数字
 */
public class JZOffer44 {

    public int findNthDigit(int n) {


        int digit = 1;
        long start = 1, count = 9;
        //1.确定是在多少位的数字范围内
        //假设n=15
        while (n > count) {

            n -= count;//15-=9 n=6
            digit += 1;//digit=2  每个数字2个位
            start = start * 10;//起始数字为1*10=10
            count = 9 * start * digit;//2个位的数字个数为 9*10*2=180个
        }
        //2.确定是在哪个数字上
        //比如当n=15的时候 15-9=6  然后start=10  然后将start视为第一个开始的数字 （6-1）/2=2 所以10 11 12 13... 第2个数字是12
        long num = start + (n - 1) / digit;//从start开始 第num个数字 start是第0个数字

        //确定是这个数字的哪个位的字符
        int index = (n - 1) % digit;
        char c = Long.toString(num).charAt(index);
        return c - '0';

    }

    public static void main(String[] args) {
        int n = 15;

        JZOffer44 t = new JZOffer44();
        int nthDigit = t.findNthDigit(n);
        System.out.println(nthDigit);


    }
}
