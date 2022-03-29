package Backtrack;

import java.util.*;

/**
 * @ClassName: p491
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/3/26
 * @Time: 11:47
 */
public class p491 {

    public List<List<Integer>> res=new ArrayList<>();
    public List<Integer> path=new ArrayList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {

        if (nums.length<2) return res;
        backTracking(nums,0);
        return res;
    }

    public void backTracking(int[] nums,int startIndex){

        if (path.size()>=2)
            res.add(new ArrayList<>(path));

        //使用HashSet来记录同一个父节点下的子节点 也就是同一层内不能重复使用
        HashSet<Integer> set=new HashSet<>();
        for (int i=startIndex;i<nums.length;i++){

            //如果path中有元素 而且当前这个元素比里面的最后一个小 不能加入
            //或者当前要加入的这个元素 在这一层已经加过了 不能再加
            if ((!path.isEmpty()&&nums[i]<path.get(path.size()-1))||
                    set.contains(nums[i])) continue;

            //接下去就是可以加了
            path.add(nums[i]);
            set.add(nums[i]);
            backTracking(nums,i+1);
            path.remove(path.size()-1);
            //注意这里不需要在set中进行移除  因为要确保这一层里面不能重复使用该元素

        }


    }

    public static void main(String[] args) {
        p491 t=new p491();

        int arr[]={4,4,3,2,1};
        List<List<Integer>> subsequences = t.findSubsequences(arr);
        System.out.println();
    }
}
