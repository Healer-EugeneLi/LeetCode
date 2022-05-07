package BinarySearch;

/**
 * @ClassName: p33
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/5/2
 * @Time: 11:23
 */
public class p33 {

    /**
     * 螺旋数组的查找
     * 原本是有序 在某一个地方经过旋转
     * 输入：nums = [4,5,6,7,0,1,2], target = 0
     * 输出：4
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {

        int length = nums.length;
        if (length==0) return -1;
        if (length==1) return nums[0]==target?0:-1;

        int left=0,right=length-1,mid=0;

        while (left<=right){

            mid=left+((right-left)>>1);

            //找到目标 返回下标
            if (nums[mid]==target)
                return mid;

            //如果左半段有序
            if (nums[0]<=nums[mid]){

                //且 这个目标值是在这个区间内
                if (nums[0]<=target&&target<nums[mid]){
                    //那么就是在这个区间内继续寻找
                    right=mid-1;
                }else
                    left=mid+1;//否则就是在另外一个区间

            }else {
                //在右半段有序

                //目标值在右边这个范围内
                if (nums[mid]<target&&target<=nums[length-1]){
                    //那么继续在这个区间寻找
                    left=mid+1;
                }else
                    right=mid-1;//否则就是在左边区间内寻找
            }
        }
        return -1;

    }
}
