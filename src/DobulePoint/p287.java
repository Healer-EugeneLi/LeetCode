package DobulePoint;

/**
 * @ClassName: p287
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/4/8
 * @Time: 11:12
 * 输入：nums = [1,3,4,2,2]
 * 输出：2
 */
public class p287 {

    /**
     * 使用快慢指针解决 不重复的数
     * 将数组抽象成链表
     * 0-1
     * 1-3
     * 2-4
     * 3-2
     * 4-2
     * 构成链表0-1-3-2-4-2
     * @param nums
     * @return
     */
    public int findDuplicate(int[] nums) {

        int slow=0,fast=0;

        slow=nums[slow];
        fast=nums[nums[fast]];
        while (slow!=fast){
            fast=nums[nums[fast]];
            slow=nums[slow];
        }

        fast=0;
        while (fast!=slow){
            fast=nums[fast];
            slow=nums[slow];
        }
        return fast;
    }
}
