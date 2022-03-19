package Backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: p46
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/10/3
 * @Time: 16:08
 */
public class p46 {

    public List<List<Integer>> res = new ArrayList<>();

    void process(int[] nums, List<Integer> path, boolean used[]) {

        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i] == false) {
                //还没被用过
                used[i] = true;
                path.add(nums[i]);
                process(nums, path, used);
                used[i] = false;//取消标记 设置为没有用过
                path.remove(path.size() - 1);
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {

        boolean used[] = new boolean[nums.length];
        for (int i = 0; i < used.length; i++) {
            used[i] = false;//一开始默认都没有用过
        }
        List<Integer> path = new ArrayList<>();
        process(nums, path, used);
        return res;

    }
}
