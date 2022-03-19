package Array;

/**
 * @ClassName: p5859
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/9/19
 * @Time: 16:41
 */
public class p5859 {
    public int countKDifference(int[] nums, int k) {

        int num = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {

                if (Math.abs(nums[i] - nums[j]) == k)
                    num++;
            }
        }

        return num;
    }
}
