package BinarySearch;

/**
 * @ClassName: Base
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/5/2
 * @Time: 11:26
 */
public class Base {

    /**
     * 二分查找
     * @param nums
     * @param target
     * @return
     */
    public int binarySearch(int nums[],int target){

        int low=0,hight=nums.length-1,mid=0;

        while (low<=hight){
            mid=low+((hight-low)>>1);

            if (nums[mid]==target)
                return mid;
            if (nums[mid]<target)
                low=mid+1;
            else
                hight=hight-1;
        }
        return -1;

    }
}
