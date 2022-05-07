package HashMap;

import java.util.HashMap;

/**
 * @ClassName: p1
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/5/1
 * @Time: 19:41
 */
public class p1 {

    /**
     * 两数之和
     * 输入：nums = [2,7,11,15], target = 9
     * 输出：[0,1]
     * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        //遍历数组nums i为当前下标 每个值都在map中进行判断 是否存在target-nums[i]的key值
        //如果存在则找到了两个值 如果不存在 则将当前的nums[i],i存入map中 继续遍历直到找到为止
        HashMap<Integer,Integer> map=new HashMap<>();
        for (int i=0;i< nums.length;i++){

            //如果找到一个target-nums[i]的值在map中 说明找到了
            if (map.containsKey(target-nums[i])){
                return new int[]{map.get(target-nums[i]),i};
            }
            //如果没有在map中找到 则向map中压入nums[i] 以及对应的下标i
            map.put(nums[i],i );
        }

        return new int[]{0};
    }
}
