package MoveWindow;

import java.util.Arrays;

/**
 * @ClassName: p1984
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/2/28
 * @Time: 22:39
 * <p>
 * 给定一个数组 找到其中k个值 使得这k个值里面最大值与最小值的差最小
 */
public class p1984 {

    public int minimumDifference(int[] nums, int k) {

        if (k == 1) return 0;

        int min = Integer.MAX_VALUE, right = k - 1, left = 0;
        //先排序
        Arrays.sort(nums);

        //每隔k个值更新一次值
        while (right < nums.length) {

            left = right - (k - 1);//当k=3的时候 一开始right=2 表示第三个元素 那么left应该是第一个元素 也就是下标为2-3=1=0
            min = Math.min(min, nums[right] - nums[left]);
            right++;
        }

        return min;
    }

    public static void main(String[] args) {

        int arr[] = {2, 3, 5, 6, 1};
        Arrays.sort(arr);
        System.out.println();
    }
}
