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

        while (n > count) {

            n -= count;
            digit += 1;
            start = start * 10;
            count = 9 * start * digit;
        }

        //比如当n=15的时候 15-9=6  然后start=10  然后将start视为第一个开始的数字 （6-1）/2=2 所以10 11 12 13... 第2个数字是12
        long num = start + (n - 1) / digit;//从start开始 第num个数字 start是第0个数字

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
