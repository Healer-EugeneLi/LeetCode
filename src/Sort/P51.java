package Sort;

/**
 * @ClassName: P51
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/9/11
 * @Time: 22:15
 */

/**
 * 逆序对 [7,5,6,4]
 *
 * 7>5 7>6 7>4 5>4 6>4
 */
public class P51 {


    public int result = 0;

    public int reversePairs(int[] nums) {
        if (nums.length < 2) return 0;

        process(nums, 0, nums.length - 1);
        return result;

    }

    private void process(int[] nums, int left, int right) {

        if (left == right) {
            return;
        }
        int mid = left + ((right - left) >> 1);
        process(nums, left, mid);
        process(nums, mid + 1, right);
        merge(nums, left, mid, right);
    }

    private void merge(int[] nums, int left, int mid, int right) {

        int[] help = new int[right - left + 1];
        int i = 0;
        int p1 = left, p2 = mid + 1;
        while (p1 <= mid && p2 <= right) {
            //统计当前元素右侧比它小的数，降序
            if (nums[p1] > nums[p2]) {
                //如果左边比右边大
                this.result += (right - p2 + 1);
                help[i++] = nums[p1++];
            } else
                help[i++] = nums[p2++];

        }

        while (p1 <= mid)
            help[i++] = nums[p1++];
        while (p2 <= right)
            help[i++] = nums[p2++];
        for (int j = 0; j < help.length; j++) {
            nums[left + j] = help[j];
        }
    }
}
