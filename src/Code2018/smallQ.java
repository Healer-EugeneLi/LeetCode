package Code2018;

import java.util.Scanner;

/**
 * @ClassName: Code2018.smallQ
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/9/27
 * @Time: 9:47
 */
public class smallQ {


    public static void main(String[] args) {


        long mod = 1000000007;
        long c[][] = new long[101][101];
        c[0][0] = 1;
        //先计算组合数
        for (int i = 1; i <= 100; i++) {
            c[i][0] = 1;
            for (int j = 1; j <= 100; j++) {
                c[i][j] = (c[i - 1][j - 1] + c[i - 1][j]) % mod;
            }
        }

        Scanner scanner = new Scanner(System.in);

        int k = 0;//总的歌单数
        int a = 0;//A的歌单里每首歌的长度
        int x = 0;//A的歌单里的歌的数量
        int b = 0;//B 长度
        int y = 0;//B 数量
        k = scanner.nextInt();
        a = scanner.nextInt();
        ;
        x = scanner.nextInt();
        b = scanner.nextInt();
        y = scanner.nextInt();
        long ans = 0;
        for (int i = 0; i <= x; i++) {

            //判断是否符合条件 选择i首A
            if (i * a <= k && (k - i * a) % b == 0 && (k - i * a) / b <= y) {
                int j = (k - i * a) / b;
                ans = (ans + (c[x][i] * c[y][j]) % mod) % mod;

            }
        }

        System.out.println(ans % mod);
    }
}
