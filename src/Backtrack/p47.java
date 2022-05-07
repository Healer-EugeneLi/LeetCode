package Backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: p47
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/10/3
 * @Time: 16:43
 */
public class p47 {

    public List<List<Integer>> res = new ArrayList<>();

    public void backtrack(int nums[], List<Integer> path, boolean used[]) {

        if (nums.length == path.size()) {
            res.add(new ArrayList<>(path));
        }

        //可以看出元素1在[1,2]中已经使用过了，但是在[2,1]中还要在使用一次1，所以处理排列问题就不用使用startIndex了。
        //所以每一次进入搜索的时候 循环都是从索引为0开始
        for (int i = 0; i < nums.length; i++) {

            if (!used[i]) {

                if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                    //现在这个数等于前一个数 并且前一个数是没有被用过 实际就是表面这个已经在之前使用过 并且结果已经加好了
                    continue;
                }
                used[i] = true;
                path.add(nums[i]);
                backtrack(nums, path, used);
                used[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {


        boolean[] used = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++)
            used[i] = false;
        Arrays.sort(nums);//注意如果要去重必须先进行排序
        List<Integer> path = new ArrayList<>();

        backtrack(nums, path, used);
        return res;

    }
}
