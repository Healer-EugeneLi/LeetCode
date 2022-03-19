package DobulePoint;

/**
 * @ClassName: p27
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/9/19
 * @Time: 22:52
 */
public class p27 {

    public int removeElement(int[] nums, int val) {

        if (nums.length == 0) return 0;
        int j = 0;
        int i = 0;

        while (i < nums.length) {


            if (nums[i] != val) {

                int temp = nums[j];
                nums[j++] = nums[i];
                nums[i] = temp;
            }
            i++;
        }
        return j;

    }
}
