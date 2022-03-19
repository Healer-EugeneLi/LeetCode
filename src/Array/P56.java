package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @ClassName: P56
 * @Description: 合并区间
 * @Author EugeneLi
 * @Date: 2021/5/17
 * @Time: 16:48
 */
public class P56 {


    public static int[][] merge(int[][] intervals) {


        //先对左端点排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        List<int[]> res = new ArrayList<int[]>();

        for (int i = 0; i < intervals.length; i++) {

            int L = intervals[i][0];
            int R = intervals[i][1];
            if (res.size() == 0 || L > res.get(res.size() - 1)[1]) {
                //如果此时为空 或者当前左端点大于已有的区间里的右端点
                res.add(intervals[i]);
            } else {
                //如果当前左区间小于已有的最后一个的右区间  更新右端点

                //原先最后一个区间的右端点
                int oldR = res.get(res.size() - 1)[1];
                int newR = intervals[i][1];

                res.get(res.size() - 1)[1] = Math.max(oldR, newR);
            }
        }


        int mergeIntervals[][] = res.toArray(new int[res.size()][2]);


        return mergeIntervals;
    }

    public static void main(String[] args) {


        int[][] a = {{5, 7}, {2, 6}, {8, 10}, {15, 18}};

        int[][] merge = P56.merge(a);
        System.out.println(merge);

    }
}
