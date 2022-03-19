package Code2020;

import java.io.BufferedReader;
import java.util.Scanner;

/**
 * @ClassName: JDSz
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/10/9
 * @Time: 10:47
 */
public class JDSz {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        //计算最大的点数
        int maxPoint = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] > maxPoint) maxPoint = arr[i];
        }

        double preE = 0.0;
        double expectation = 0.0;
        //xi>=2
        for (int k = 2; k <= maxPoint; k++) {

            double curE = 1.0;
            //计算每个骰子点数不超过k的概率 注意有些是投不到点数k
            for (int i = 0; i < n; i++) {
                curE *= Math.min(k, arr[i]) * 1.0 / arr[i];
            }
            expectation += (curE - preE) * k;
            preE = curE;
        }
        System.out.printf("%.2f", expectation);

    }
}
