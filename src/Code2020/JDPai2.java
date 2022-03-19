package Code2020;

import java.util.Scanner;

/**
 * @ClassName: JDPai2
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/10/9
 * @Time: 9:45
 */
public class JDPai2 {

    public static void main(String[] args) {


        int t;
        Scanner scanner = new Scanner(System.in);
        t = scanner.nextInt();

        int arr[] = new int[t];

        for (int i = 0; i < t; i++) {
            arr[i] = scanner.nextInt();
        }

        //最小值通过该数%4 如果等于1 或者2 则结果为1  其他为0
        //最大值等于N-fmin(N-1)
        for (int i = 0; i < t; i++) {

            int temp = arr[i];
            int min = 0;
            int max = 0;
            min = getMin(temp);
            max = temp - getMin(temp - 1);
            System.out.println(min + " " + max);

        }

    }


    public static int getMin(int n) {

        if (n % 4 == 1 || n % 4 == 2) return 1;
        else return 0;
    }
}
