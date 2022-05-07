package BinarySearch;

/**
 * @ClassName: p704
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/5/7
 * @Time: 10:06
 */
public class p704 {


    /**
     * 二分查找
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {


        int left=0,right=nums.length-1;
        int mid=0;
        while (left<=right){

            mid=left+((right-left)>>1);

            int temp=nums[mid];
            if (temp==target) return mid;
            else if(temp>target){
                right=mid-1;//中间结点比目标节点大 往左区间靠
            }else {
                //中间结点比目标节点小 往右区间靠
                left=mid+1;
            }
        }
        return -1;
    }
}
