package JZOffer;

import java.util.HashSet;

/**
 * @ClassName: JZOffer03
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/11/22
 * @Time: 21:28
 * 找到数组中任意一个重复的数字
 */
public class JZOffer03 {


    /**
     * 哈希表解法：
     * 时间复杂度：时间复杂度 O(N) ： 遍历数组使用 O(N) ，HashSet 添加与查找元素皆为 O(1) 。
     * @param nums
     * @return
     */
//    public int findRepeatNumber(int[] nums) {
//
//        HashSet set=new HashSet();
//        for (int a:nums){
//            if (set.contains(a)){
//                return a;
//            }else {
//                set.add(a);
//            }
//        }
//        return 0;
//    }


    /**
     * 原地交换
     * 若nums[i]==i 说明已经在该位置了 无需交换
     * 若nums[i]=nums[nums[i]] 比如i=5 5这个位置上的数为2 而num[2]=2 说明已经有个数字2存在在该位置了 重复 直接返回
     * 最后就是交换 将nums[i]放到他应该在的位置上
     *
     * @param nums
     * @return
     */
    public int findRepeatNumber(int[] nums) {

        int i = 0;
        while (i < nums.length) {


            if (nums[i] == i) {
                i++;
                continue;
            }

            if (nums[i] == nums[nums[i]]) return nums[i];
            int temp = nums[i];
            nums[i] = nums[temp];
            nums[temp] = temp;
        }

        return -1;
    }
}
