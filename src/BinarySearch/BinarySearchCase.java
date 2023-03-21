package BinarySearch;

/**
 * @ClassName: p34
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/5/7
 * @Time: 17:23
 */
public class BinarySearchCase {


    /**
     * 返回有序数组的重复数字的左边界 右边界
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {


        int left=leftBound(nums,target);//左边界
        int right=rightBound(nums,target);//右边界

        //不存在
        if (right<left)
            return new int[]{-1,-1};
        return new int[]{left,right};

    }


    /**
     * 查找一个有序数组中可能重复出现的最左边的那一个
     * 比如1 5 5 7 8 查找5 最后返回的是第一个5的下标位置
     * 对于不存在该target的情况 返回比target大的最小数的位置
     * 比如 1 5 5 7 8 找6  最后返回的是7的下标位置
     * @param nums
     * @param target
     * @return
     */
    public int leftBound(int []nums,int target){

        int left=0,right=nums.length-1;

        while (left<=right){

            int mid=left+((right-left)>>1);

            //当目标值小于等于nums[mid]时 我们让right来等于mid-1 就是前一个位置 因为有可能出现重复的数字
            //此时如果nums[mid]==target的话 有可能就是不是最左边的那个值 比如1 5 5 7 8 可能此时是指向第2个5 所以继续在左边区间查找
            if (target<=nums[mid]){//技巧：找左边第一个 就是>=target
                right=mid-1;
            }else if (target>nums[mid])//目标比当前mid指向的更大  那肯定是让left来指向下一个位置 继续往右区间查找
                left=mid+1;
        }

        return left;

    }

    /**
     * 返回一个有序数组某个目标值的下标 如果目标值是重复的 那返回最右边的那一个
     * 如果数组中没有这个数字 那就返回小于这个target的最小的数的下标索引
     *比如1,5,5,5,6,7,8 找4  返回的下标是0 即该位置是1
     * @param nums
     * @param target
     * @return
     */
    public int rightBound(int[] nums,int target){


        int left=0,right=nums.length-1;

        while (left<=right){

            int mid=left+((right-left)>>1);

            //目标值>=nums[mid] 如果target>nums[mid] 那肯定是right=mid+1 继续在右区间上进行寻找
            //如果是target==num[mid] 那么我们知道这个时候由于数字重复的原因 不一定就是最右边的那个target
            //所以此时也是继续在右区间上进行查找 所以right=mid+1
            if (target>=nums[mid]){//找右边的最后一个 <=target
                left=mid+1;
            }else if(target<nums[mid]){
                //目标值小于mid 那肯定是需要往左区间上查找
                right=mid-1;
            }
        }
        return right;

    }


    /**
     * 有序数组中返回大于目标target的第一个元素的下标 >target
     * @param nums
     * @param target
     * @return
     */
    public int lowBoundNum(int[] nums,int target){

        int left=0,right=nums.length-1;

        while (left<=right){

            //求中间值
            int mid=left+((right-left)>>1);
            //大于目标值的情况
            if(nums[mid]>target){

                //如果mid是第一个位置 说明数组里面的所有数都比target大
                if(mid==0||nums[mid-1]<=target){
                    return mid;
                }else{
                    //mid-1的位置还是大于target的话
                    right=mid-1;//说明需要继续往左区间找
                }
            }else if(nums[mid]<=target){
                //目标值在右边 继续往右区间找
                left=mid+1;
            }
        }

        return -1;//找不到就返回-1

    }


    /**
     * 返回有序数组中最后一个小于目标的元素索引 <target
     * nums = {1,3,5,5,6,6,8,9,11} target = 7
     * 查找最后一个小于目标数的元素，比如我们的目标数为 7 ，
     * 此时他前面的数为 6，最后一个 6 的索引为 5，此时我们返回 5 即可，
     * 如果目标数元素为 12，那么我们最后一个元素为 11，仍小于目标数，那么我们此时返回 8
     * @param nums
     * @param target
     * @return
     */
    public int rightBoundNum(int[] nums,int target){

        int left=0,right=nums.length-1;

        while (left<=right){
            int mid=left+((right-left)>>1);

            if (nums[mid]<target){
                //如果已经到达末尾元素了 那mid就是小于target的最后一个 或者mid+1大于target了 就说明mid这个位置也是最后一个大于target的元素
                if (mid==right||nums[mid+1]>=target){
                    return mid;
                }else {
                    left=mid+1;//就是说nums[mid+1]<target  还是得继续往右区间找
                }
            }else if(nums[mid]>=target){
                //mid所对应的元素大于target 继续往左区间找
                right=mid-1;
            }

        }

        return -1;
    }


    public static void main(String[] args) {

        int arr[]={1,5,5,5,6,7,8};

        BinarySearchCase t=new BinarySearchCase();
        int res = t.lowBoundNum(arr, 3);
        System.out.println(res);
        System.out.println(arr[res]);
    }
}
