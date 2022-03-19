package Code2020; /**
 * @ClassName: Code2020
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/10/9
 * @Time: 9:35
 */


import java.util.*;
import java.lang.*;

public class JDPailie {

    public static void creat(int n, List<List<Integer>> res,
                             List<Integer> path, boolean used[], int N) {

        if (path.size() == N) {
            res.add(new ArrayList(path));
            return;
        }
        for (int i = 1; i <= N; i++) {
            if (!used[i]) {
                used[i] = true;
                path.add(i);
                creat(i, res, path, used, N);
                path.remove(path.size() - 1);
                used[i] = false;
            }
        }
    }

    public static int f(int arr[], int x) {

        if (x == 1) return arr[1];
        else {
            return Math.abs(f(arr, x - 1) - arr[x]);
        }

    }

    public static List<Integer> minAndMax(List<List<Integer>> res) {

        List<Integer> result = new ArrayList();
        int arr[];
        for (List<Integer> list : res) {
            arr = new int[list.size() + 1];
            for (int j = 1; j <= list.size(); j++) {
                arr[j] = list.get(j - 1);
            }
            result.add(f(arr, list.size()));

        }

        result.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        int min = result.get(0);
        int max = result.get(result.size() - 1);
        List<Integer> r = new ArrayList();
        r.add(min);
        r.add(max);
        return r;

    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        List<List<Integer>> res;
        List<Integer> path;
        boolean used[];
        int t;
        t = scanner.nextInt();
        int arr[] = new int[t];
        for (int i = 0; i < t; i++) {
            arr[i] = scanner.nextInt();
        }

        int N;
        for (int i = 0; i < t; i++) {
            N = arr[i];
            res = new ArrayList();
            path = new ArrayList();
            used = new boolean[N + 1];//标记数组
            for (int j = 1; j <= N; j++) {
                if (!used[j]) {
                    used[j] = true;
                    path.add(j);
                    creat(j, res, path, used, N);
                    path.remove(path.size() - 1);
                    used[j] = false;
                }
            }

            List<Integer> temp = minAndMax(res);
            System.out.println(temp.get(0) + " " + temp.get(1));
        }

        String a = "sadasdad";
        a.indexOf("asd");


    }


}