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
     * 若nums[i]=nums[nums[i]] 比如i=5 5这个位置上的数为2 而2==nums[nums[5]] 2==nums[2] 说明已经有个数字2存在在该位置了 重复 直接返回
     * 如果不是就是交换 将nums[i]放到他应该在的位置上 nums[i]的值为value 就将value这个值放在下标为value的位置
     *
     * @param nums
     * @return
     */
    public int findRepeatNumber(int[] nums) {

        int i = 0;
        while (i < nums.length) {

            //当前元素已经放在其值对应的下标位置 继续下一个元素遍历
            if (nums[i] == i) {
                i++;
                continue;
            }
            //当前元素nums[i] 该值对应的下标在数组中存放的元素等于当前值 说明出现重复 直接返回
            if (nums[i] == nums[nums[i]]) return nums[i];
            //将当前元素放到其值对应的下标位置
            int temp = nums[i];
            nums[i] = nums[temp];
            nums[temp] = temp;
        }

        return -1;
    }
}
