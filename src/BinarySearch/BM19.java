package BinarySearch;

/**
 * @ClassName: BM19
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/5/6
 * @Time: 15:40
 */
public class BM19 {

    /**
     * 寻找峰值 比如 2 4 1 2 7 8 6 返回的下标是8所对应的下标
     * @param nums
     * @return
     */
    public int findPeakElement (int[] nums) {

        int left=0;
        int right=nums.length-1;


        while(left<right){

            int mid=(left+right)/2;

            //右边是往下 不一定有波峰 所以往左边缩小区间
            if(nums[mid]>nums[mid+1]){
                right=mid;
            }else{
                //右边是往上的 右边的值更大 所以让left来指向下一个位置 往右边区间靠找到更大的值
                left=mid+1;
            }
        }
        //最后left==right 或者left>right的时候 返回right是峰值的位置
        // 之所以不选择left 是因为通过条件也可以看出left=mid+1 也就是往右这个位置才是更大的往右是往right靠
        //结合right=mid的第一个判断条件就知道 right一直在指向的是峰值的位置
        return right;
        // write code here
    }

    public int peakIndexInMountainArray(int[] arr) {


        int left=0;
        int right=arr.length-1;


        while(left<right){

            int mid=(left+right)/2;

            //右边是往下 不一定有波峰 所以往左边缩小区间
            if(arr[mid]>arr[mid+1]){
                right=mid;
            }else{
                //右边是往上的 右边的值更大 所以让left来指向下一个位置 往右边区间靠找到更大的值
                left=mid+1;
            }
        }
        //最后left==right 或者left>right的时候 返回right是峰值的位置
        // 之所以不选择left 是因为通过条件也可以看出left=mid+1 也就是往右这个位置才是更大的往右是往right靠
        //结合right=mid的第一个判断条件就知道 right一直在指向的是峰值的位置
        return right;

    }
}
