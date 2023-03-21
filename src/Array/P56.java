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

    /**
     * 合并区间
     * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
     * 输出：[[1,6],[8,10],[15,18]]
     * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
     * @param intervals
     * @return
     */
    public static int[][] merge(int[][] intervals) {


        //先对所有元组按照左端点从小到大排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        //res列表存放最后的区间结果
        List<int[]> res = new ArrayList<int[]>();

        //遍历每一个元组
        for (int i = 0; i < intervals.length; i++) {

            int curL = intervals[i][0];//当前元组的左区间
            int curR = intervals[i][1];//当前元组的右区间


            //如果此时为空 或者当前左端点大于已有的结果的最后一个区间里的右端点
            if (res.size() == 0 || curL > res.get(res.size()-1)[1]) {
                //那么直接加入当前元组 作为一个新的区间
                res.add(intervals[i]);
            } else {
                //如果当前左区间小于已有的最后一个的右区间  则选择更新最后一个区间的右端点

                //原先最后一个区间的右端点
                int oldR =res.get(res.size()-1)[1];
                //当前元组的右端点值
                int newR = intervals[i][1];

                //哪个更大就使用哪个为右区间
                res.get(res.size()-1)[1] = Math.max(oldR, newR);
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
