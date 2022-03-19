package Code2018;

import java.util.Scanner;

/**
 * @ClassName: HuaQ
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/10/7
 * @Time: 9:10
 * 4 4
 * YXXB
 * XYGX
 * XBYY
 * BXXY
 */
public class HuaQ {


    public static char[][] chars = new char[52][52];
    public static int n, m;

    /**
     * Y寻找的方向是 \
     * 将遇到的Y改成X表示可以画的点
     * 将遇到的G改成B 表明此时还需要B
     *
     * @param x
     * @param y
     */
    public static void dfsY(int x, int y) {

        //满足边界条件情况下 并且不是白色区域
        if (x >= 1 && x <= n && y >= 1 && y <= m && (chars[x][y] == 'Y' || chars[x][y] == 'G')) {

            //如果是Y
            if (chars[x][y] == 'Y') {

                chars[x][y] = 'X';
            } else {
                //另一种就是G
                chars[x][y] = 'B';

            }
            dfsY(x - 1, y - 1);//左上角
            dfsY(x + 1, y + 1);//右下角

        }
        return;
    }

    /**
     * B 寻找的方向是 /
     * 遇到B 修改成X
     * 遇到G 修改成Y
     *
     * @param x
     * @param y
     */
    public static void dfsB(int x, int y) {

        if (x >= 1 && x <= n && y >= 1 && y <= m && (chars[x][y] == 'B' || chars[x][y] == 'G')) {

            if (chars[x][y] == 'B') {
                chars[x][y] = 'X';
            } else {
                chars[x][y] = 'Y';
            }
            dfsB(x + 1, y - 1);//左下角
            dfsB(x - 1, y + 1);//右上角
        }
        return;//没有遇到B或者G 就不能画了 直接返回 表明这一笔到此为止 断开
    }

    public static void main(String[] args) {

        int num = 0;
        Scanner scanner = new Scanner(System.in);

        String first = scanner.nextLine();
        n = Integer.valueOf(first.split(" ")[0]);
        m = Integer.valueOf(first.split(" ")[1]);

        String line = "";
        for (int i = 1; i <= n; i++) {
            line = scanner.nextLine();
            for (int j = 1; j <= m; j++) {

                chars[i][j] = line.charAt(j - 1);
            }
        }


        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {

                if (chars[i][j] == 'Y') {

                    dfsY(i, j);
                    num++;
                } else if (chars[i][j] == 'B') {
                    dfsB(i, j);
                    num++;
                } else if (chars[i][j] == 'G') {

                    //画两次 先画y 如果在画y的过程中有遇到G的话 也会被改成B
                    dfsY(i, j);
                    num++;//画一笔

                    //接着画B
                    dfsB(i, j);
                    num++;
                }

            }
        }

        System.out.println(num);


    }
}
