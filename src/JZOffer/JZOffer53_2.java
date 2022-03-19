package JZOffer;

/**
 * @ClassName: JZOffer53_2
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/12/7
 * @Time: 19:15
 * 寻找缺失的数字
 */
public class JZOffer53_2 {

//    public int missingNumber(int[] nums) {
//        //[0,1,2,3,4,5,6,7,9]
//
//        for (int i=0;i<nums.length;i++){
//            if (nums[i]!=i)
//                return i;
//        }
//
//
//        return nums.length;
//    }

    //二分查找
    public int missingNumber(int[] nums) {
        //[0,1,2,3,4,5,6,7,9]

        int left = 0, right = nums.length - 1, mid = 0;

        while (left <= right) {

            mid = (left + right) / 2;

            if (nums[mid] == mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }

        }

        return left;
    }
}
