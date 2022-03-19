package Code2020;

import java.util.Scanner;

/**
 * @ClassName: JDK
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/10/9
 * @Time: 11:34
 */
public class JDK {

    //找第k小 m行 n列
    public static int findNMK(int n, int m, int k) {

        int left = 1;
        int right = n * m;
        int mid = 0;
        int count = 0;//比中位数小的个数
        while (left < right) {

            mid = left + (right - left) / 2;
            count = 0;

            //可以根据矩阵排列的规律知道
            /**1*i 2*i 3*i....n*i  当i=1就是第一行
             * 1 2 3
             * 2 4 6
             * 3 6 9
             * 所以比5小的数 5/3=1 那么第一行的数全部比5小
             */
            int row = mid / n;
            count += row * n;
            //接下去找剩下的
            for (int j = row + 1; j < m + 1; j++) {
                count += mid / j;//同样的规律 比如 5/2=2 表示地2行有2个数比5 小
            }

            if (count < k) {
                left = mid + 1;
            } else
                right = mid;
        }
        return left;

    }

    public static void main(String[] args) {


        int n, m, k;
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        k = scanner.nextInt();

        //第k大转换成第 k'小
        k = n * m - k + 1;
        System.out.println(findNMK(n, m, k));

    }
}
