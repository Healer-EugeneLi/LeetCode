package Array;

/**
 * @ClassName: p31
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/5/10
 * @Time: 17:32
 */
public class p31 {

    /**
     * 下一个排列
     * @param nums
     */
    public void nextPermutation(int[] nums) {

        //两轮遍历 4,5,2,6,3,1
        //1.先从后往前找 找到一个前面的数比后面小的 比如2小于6  因为后面的6 3 1 已经是没有办法调整了 这个是最大的序列
        //2.此时继续从后面往前找 找到一个数刚好比这个2大的数 进行交换 4,5,3,6,2,1 这个时候3交换2之后 就已经找到了下一个排序的开始了 然后这个时候换完 很显然6 2 1是降序的，
        //此时只需要将前面交换的位置的下一个 6 2 1进行翻转之后 变成1 2 6 最终4 5 3 1 2 6 是最后答案

        int k=-1;//来表示需要交换的位置 也就是找到一个nums[k]<nums[k+1] 如果一开始整个数组都是降序的 那么直接翻转就是答案

        //1.第一次查找 找到左边小于右边的 k位置的元素
        for (int i=nums.length-2;i>=0;i--){

            //找到左边小于右边的
            if (nums[i]<nums[i+1]){
                k=i;
                break;
            }
        }

        if(k==-1){
            reverse(nums,0,nums.length-1);
            return;
        }

        //2.第二次查找 从后往前找 找第一个大于k位置的元素
        for (int j= nums.length-1;j>k;j--){

            //找到第一个大于k位置的 交换
            if (nums[j]>nums[k]){
                int temp=nums[j];
                nums[j]=nums[k];
                nums[k]=temp;
                break;
            }
        }

        reverse(nums,k+1, nums.length-1);
    }

    /**
     * 在nums数组中 翻转start-end这段区间
     * @param nums
     * @param start
     * @param end
     */
    public void reverse(int []nums,int start,int end){

        int left=start;
        int right=end;

        while (left<right){
            int temp=nums[right];
            nums[right]=nums[left];
            nums[left]=temp;
            left++;
            right--;
        }
    }
}
