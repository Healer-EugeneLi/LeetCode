package BinarySearch;

/**
 * @ClassName: p35
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/5/7
 * @Time: 17:09
 */
public class p35 {


    /**
     * 有序数组中查找某个数字 如果数字存在 就返回下标
     * 如果数字不存在 就返回应该插入的位置
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {



        int left=0,right=nums.length-1;

        while (left<=right){

            int mid=left+((right-left)>>1);

            if (nums[mid]==target)
                return mid;
            else if (nums[mid]<target){
                //left来表示下一个可能是会等于target的位置 或者说最后这个位置放入target
                left=mid+1;
            }else
                right=mid-1;
        }
        return left;
    }

    public static void main(String[] args) {

        int arr[]={1,3,5,6};

        p35 t=new p35();
        int res = t.searchInsert(arr, 7);

    }
}
