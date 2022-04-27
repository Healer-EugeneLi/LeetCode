package JZOffer;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: JZOffer57
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/12/5
 * @Time: 22:52
 */
public class JZOffer57 {

    /**
     * 1.使用滑动窗口的方法解决 双指针
     * 1-N的值中 找到连续序列其和==target的所有情况
     * @param target
     * @return
     */
    public int[][] findContinuousSequence(int target) {

        //保存所有的组合情况
        List<List<Integer>> list = new ArrayList<>();
        int left = 1, right = 1, sum = 0;

        for (left = 1, right = 1, sum = 0; right <= target - 1; right++) {

            //sum还不足target的时候 就直接加right的值 窗口又边界的值
            sum += right;
            while (sum > target) {
                //此时和已经大于目标了 说明原先窗口内的值的和是不足target 所以因为右移了一下 所以超过了 此时我们减少左边一个数
                sum -= left;
                left++;//并且左指针往右移 说明窗口的左边界往右移
            }

            //此时滑动窗口中的值 其和为target 那么找到一种情况
            if (sum == target) {
                List<Integer> cur = new ArrayList<>();
                //从left指针遍历到right指针就是满足情况的这些连续的数
                for (int i = left; i <= right; i++) {
                    cur.add(i);
                }
                list.add(cur);
            }
        }

        int res[][] = new int[list.size()][];//list.size()组符合条件的数据
        for (int i = 0; i < list.size(); i++) {

            List<Integer> cur = list.get(i);//当前满足的序列
            res[i] = new int[cur.size()];
            for (int j = 0; j < cur.size(); j++) {
                res[i][j] = cur.get(j);
            }

        }
        return res;

    }

    public static void main(String[] args) {
        int n = 9;
        JZOffer57 t = new JZOffer57();

        int[][] continuousSequence = t.findContinuousSequence(n);
        System.out.println();
    }
}
