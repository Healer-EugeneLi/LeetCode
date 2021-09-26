package Array;

/**
 * @ClassName: p283
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/9/19
 * @Time: 21:23
 * 移动0
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 */
public class p283 {

    public void moveZeroes(int[] nums) {

        int length=nums.length;
        if (length==0||length==1) return;

        int left=0,right=1;

        for (;left<length&&right<length;){

            //当碰到left指针指向的不是0  那么left往后移动
            if (nums[left]!=0){
                left++;
                right++;
            }else if (nums[left]==0&&nums[right]==0){
                //此时无法与right交换 让right继续往前走找到right不为0的 来交换
                right++;
            }else if (nums[left]==0&&nums[right]!=0){
                //left可以与right交换
                nums[left]=nums[right];
                nums[right]=0;
                left++;
                right++;
            }

        }

    }
}
