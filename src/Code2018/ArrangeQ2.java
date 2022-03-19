package Code2018;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @ClassName: ArrangeQ2
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/10/7
 * @Time: 17:17
 * 参考答案
 * m个任务 每个任务有两个参数 x,y
 * n个机器，每个机器有两个参数 z w
 * 一个任务只能和一个机器匹配 匹配上以后获得了200*x+3*y的利润
 * 需要完成任务数量最大，如果有多种安排方案，需要找到收益最大的那个方案
 * 关注数据范围 y和w都是0-100 x和z是从0-1000的 而且一份x对于答案的贡献是200 一份y对于答案的贡献是3
 * 所以以x作为进行排序的第一优先级
 * 将任务和机器都使用x降序，x相等的时候使用y降序
 */
public class ArrangeQ2 {

    public static class Node {
        int time;
        int level;

        public Node(int time, int level) {
            this.time = time;
            this.level = level;
        }
    }

    public static final int MAXN = 100007;

    public static int n, m;
    public static int levelSatisfy[] = new int[101];
    public static int num;
    public static long sum;

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] s = line.split(" ");
        n = Integer.valueOf(s[0]);
        m = Integer.valueOf(s[1]);
        Node[] machine = new Node[n];
        Node[] task = new Node[m];
        for (int i = 0; i < n; i++) {
            int mTime = scanner.nextInt();
            int mLevel = scanner.nextInt();
            machine[i] = new Node(mTime, mLevel);
        }
        for (int j = 0; j < m; j++) {
            int tTime = scanner.nextInt();
            int tLevel = scanner.nextInt();
            task[j] = new Node(tTime, tLevel);
        }

        Comparator<Node> comparator = new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if (o1.time == o2.time)
                    return o2.level - o1.level;
                return o2.time - o1.time;
            }
        };
        Arrays.sort(machine, comparator);
        Arrays.sort(task, comparator);

        int j = 0;
        //对于每一个任务 找到满足条件的机器 并且尽量找等级较小的
        for (int i = 0; i < m; i++) {

            while (j < n && task[i].time <= machine[j].time) {

                levelSatisfy[machine[j].level]++;//该等级++ 表示这个等级有机器
                j++;
            }

            for (int k = task[i].level; k <= 100; k++) {

                if (levelSatisfy[k] != 0) {
                    //找到符合条件的机器 且级别较小
                    num++;
                    levelSatisfy[k]--;//该等级机器数量--
                    sum += task[i].time * 200 + 3 * task[i].level;
                    break;
                }
            }

        }

        System.out.println(num + " " + sum);

    }
}
