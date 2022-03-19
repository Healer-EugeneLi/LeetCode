package Code2018;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName: QP
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/10/7
 * @Time: 22:28
 */
public class QP {


    public static int n;//n张牌
    public static int arr[];

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        arr = new int[n + 1];
        for (int i = 0; i < n; i++)
            arr[i] = scanner.nextInt();
        Arrays.sort(arr);//从小到大排序
        int sumNiu = 0;
        int sumYang = 0;
        for (int j = arr.length - 1; j >= 0; j--) {

            sumNiu += arr[j];
            if (j == 0) break;
            j--;
            sumYang += arr[j];

        }
        System.out.println(sumNiu - sumYang);
    }
}
