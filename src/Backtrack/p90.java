package Backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: p90
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/3/26
 * @Time: 11:28
 * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
 *输入：nums = [1,2,2]
 * 输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]

 */
public class p90 {


    public List<List<Integer>> res=new ArrayList<>();
    public List<Integer> path=new ArrayList<>();
    public boolean[] used;
    public List<List<Integer>> subsetsWithDup(int[] nums) {

        if (nums.length==0){
            res.add(path);
            return res;
        }
        used=new boolean[nums.length];
        Arrays.sort(nums);//先进行升序排序

        backTracking(nums,0,used);
        return res;

    }

    public void backTracking(int[] nums,int startIndex,boolean used[]){

        res.add(new ArrayList<>(path));

        if (startIndex== nums.length)
            return;

        for (int i=startIndex;i< nums.length;i++){
            // used[i - 1] == true，说明同一树枝nums[i - 1]使用过
            // used[i - 1] == false，说明同一树层nums[i - 1]使用过
            //如果在同一个层用过 就不再使用
            if (i>0&&nums[i]==nums[i-1]&&used[i-1]==false) continue;
            path.add(nums[i]);
            used[i]=true;
            backTracking(nums,i+1,used);
            used[i]=false;
            path.remove(path.size()-1);
        }
    }
}
