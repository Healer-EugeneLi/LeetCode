package Backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: p46
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/10/3
 * @Time: 16:08
 * 首先排列是有序的，也就是说 [1,2] 和 [2,1] 是两个集合，这和之前分析的子集以及组合所不同的地方。
 *
 * 可以看出元素1在[1,2]中已经使用过了，但是在[2,1]中还要在使用一次1，所以处理排列问题就不用使用startIndex了。
 */
public class p46 {
//
//    public List<List<Integer>> res = new ArrayList<>();
//
//    void process(int[] nums, List<Integer> path, boolean used[]) {
//
//        if (path.size() == nums.length) {
//            res.add(new ArrayList<>(path));
//            return;
//        }
//
//        for (int i = 0; i < nums.length; i++) {
//            if (used[i] == false) {
//                //还没被用过
//                used[i] = true;
//                path.add(nums[i]);
//                process(nums, path, used);
//                used[i] = false;//取消标记 设置为没有用过
//                path.remove(path.size() - 1);
//            }
//        }
//    }
//
//    public List<List<Integer>> permute(int[] nums) {
//
//        boolean used[] = new boolean[nums.length];
//        for (int i = 0; i < used.length; i++) {
//            used[i] = false;//一开始默认都没有用过
//        }
//        List<Integer> path = new ArrayList<>();
//        process(nums, path, used);
//        return res;
//
//    }

    public List<List<Integer>> res=new ArrayList<>();
    public List<Integer> path=new ArrayList<>();
    public boolean used[];


    public List<List<Integer>> permute(int[] nums) {

        used=new boolean[nums.length];
        backTracking(nums);
        return res;
    }

    public void backTracking(int [] nums){

        if (path.size()==nums.length){
            res.add(new ArrayList<>(path));
            return;
        }

        //首先排列是有序的，也就是说 [1,2] 和 [2,1] 是两个集合，这和之前分析的子集以及组合所不同的地方。
        //可以看出元素1在[1,2]中已经使用过了，但是在[2,1]中还要在使用一次1，所以处理排列问题就不用使用startIndex了。
        //所以每一次进入搜索的时候 循环都是从索引为0开始
        for (int i=0;i< nums.length;i++){

            //去重 当前这个值==前面的出现过的值 而且user[i-1]为false 说明已经使用过了 然后回溯之后标记为false
            if (i>0&&nums[i]==nums[i-1]&&used[i-1]==false) continue;
            if (!used[i]){

                path.add(nums[i]);
                used[i]=true;
                backTracking(nums);
                used[i]=false;
                path.remove(path.size()-1);

            }
        }
    }
}
