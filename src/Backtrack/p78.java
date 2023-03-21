package Backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: p78
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/3/25
 * @Time: 21:55
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * 子集是收集树形结构中树的所有节点的结果。
 */
public class p78 {

    public List<List<Integer>> res=new ArrayList<>();
    public List<Integer> path=new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {

        //数组为空 直接返回一个空集的结果
        if (nums.length==0){
            res.add(path);
            return res;
        }
        //从下标0开始
        backTracking(nums,0);
        return res;
    }

    public void backTracking(int[] nums,int startIndex){

        //子集是收集树形结构中树的所有节点的结果。 所以在每次进入一层之后就开始加结果
        res.add(new ArrayList<>(path));
        //当下标已经来到数组长度了 说明用完所有的数据了 开始返回
        if (startIndex== nums.length){
            return;
        }

        //i从startIndex开始往后遍历
        for (int i=startIndex;i< nums.length;i++){
            path.add(nums[i]);//加入当前数字
            backTracking(nums,i+1);//继续搜索
            path.remove(path.size()-1);//回溯的时候 删掉加入的数字

        }
    }

    public static void main(String[] args) {
        int arr[]={1,2,3};
        p78 t=new p78();
        List<List<Integer>> res = t.subsets(arr);
        System.out.println(res);
    }
}
