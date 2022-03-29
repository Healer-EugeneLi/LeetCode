package DobulePoint;

import java.util.Arrays;
import java.util.Collections;

/**
 * @ClassName: p31
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/3/23
 * @Time: 9:17
 *
 * 寻找下一个排列
 * 先找出最大的索引 k 满足 nums[k] < nums[k+1]，如果不存在，就翻转整个数组；
 * 再找出另一个最大索引 p 满足 nums[p] > nums[k]；
 * 交换 nums[p] 和 nums[k]；
 * 最后翻转 nums[k+1:]。

 */
public class p31 {

    public void nextPermutation(int[] nums) {

        if (nums.length==1) return;

        //从后往前找 先找到一对相邻的数对 满足nums[k] < nums[k+1]
        int k= -1;
        for (int i= nums.length-2;i>=0;i--){

            if (nums[i]<nums[i+1]){
                k=i;
                break;//找到最大的索引 满足nums[k] < nums[k+1]
            }
        }
        //如果没有符合这样的条件直接进行翻转
        if (k==-1){
            reverse(nums,0, nums.length-1);
            return;
        }

        //从后往前找 找到一个索引p使得其满足 nums[p]>nums[k]

        for (int j= nums.length-1;j>=0;j--){
            if (nums[j]>nums[k]){
                int temp=nums[j];
                nums[j]=nums[k];
                nums[k]=temp;
                break;
            }
        }

        //交换完之后翻转数组中nums[k:]
        reverse(nums,k+1,nums.length-1);
    }

    /**
     * 在数组中翻转从start开始翻转到end的位置
     * @param nums
     * @param start
     * @param end
     */
    public void reverse(int nums[],int start,int end){

        int left=start,right=end;
        while (left<=right){
            int temp=nums[right];
            nums[right]=nums[left];
            nums[left]=temp;
            left++;
            right--;
        }

    }

    public static void main(String[] args) {
        int nums[]={1,2,7,4,3,1};

        p31 t=new p31();
        t.nextPermutation(nums);
        for (int num:nums)
            System.out.println(num);
//        System.out.println(nums);
    }
}
