package MoveWindow;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName: p219
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/4/10
 * @Time: 15:10
 * 给你一个整数数组nums 和一个整数k ，判断数组中是否存在两个 不同的索引i j ，满足 nums[i] == nums[j] 且 abs(i - j) <= k 。
 * 如果存在，返回 true ；否则，返回 false 。
输入：nums = [1,2,3,1], k = 3
输出：true
 */
public class p219 {

    /**
     * 使用set来存滑动窗口中的数据 维持一个k+1大小的窗口 在该窗口内如果有相同的元素 则返回true 否则false
     * @param nums
     * @param k
     * @return
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {

        Set<Integer> set=new HashSet<>();

        for (int i=0;i<nums.length;i++){

            //已经超过窗口大小了 将窗口左边的元素移除
            if (i>k){
                set.remove(nums[i-k-1]);
            }

            //接下去都是在窗口内 进行判断
            if(set.contains(nums[i])){
                return true;
            }

            set.add(nums[i]);//加入该元素到set中
        }
        return false;

    }
}
