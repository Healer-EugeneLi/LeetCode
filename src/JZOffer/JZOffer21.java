package JZOffer;

/**
 * @ClassName: JZOffer21
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/4/19
 * @Time: 11:24
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数在数组的前半部分，所有偶数在数组的后半部分。
 *输入：nums = [1,2,3,4]
 * 输出：[1,3,2,4]
 * 注：[3,1,2,4] 也是正确的答案之一。
 */
public class JZOffer21 {
    public int[] exchange(int[] nums) {

        int left=0,right=nums.length-1;

        while (left<right){

           //当left指向偶数 right指向奇数 那么交换
            if (nums[left]%2==0&&nums[right]%2==1){
                swap(nums,left,right);
            }else if (nums[left]%2==1){
                //如果left此时指向的是奇数 往右移动
                left++;
            }else if (nums[right]%2==0){
                //如果right执行偶数 往左移动
                right--;
            }

        }

        return nums;

    }

    public void  swap(int nums[],int i,int j){

        if (i!=j){
            nums[i]=nums[i]^nums[j];
            nums[j]=nums[i]^nums[j];
            nums[i]=nums[i]^nums[j];
        }
    }
}
