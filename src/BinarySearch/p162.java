package BinarySearch;

/**
 * @ClassName: p162
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/9/11
 * @Time: 15:47
 */
public class p162 {

    public static int findPeakElement(int[] nums) {


        int n = nums.length;
        if (n == 1) return 0;
        //先判断边界
        if (nums[0] > nums[1]) return 0;
        if (nums[n - 2] < nums[n - 1]) return n - 1;

        int left = 0;
        int right = n - 1;

        while (left <= right) {


            int middle = left + (right - left) / 2;

            if (nums[middle] > nums[middle - 1] && nums[middle] > nums[middle + 1]) return middle;

            if (nums[middle] < nums[middle - 1]) right = middle;

            if (nums[middle] < nums[middle + 1]) left = middle;
        }
        return left;

    }

    public static void main(String[] args) {

        int[] arr = {3, 4, 3, 2, 1};
        int res = findPeakElement(arr);
        System.out.println(res);

    }
}

