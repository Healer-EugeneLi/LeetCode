package MoveWindow;

/**
 * @ClassName: p209
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/2/28
 * @Time: 22:02
 * <p>
 * 长度最小的子数组
 * <p>
 * 给定一个含有n个正整数的数组和正整数 target
 * 找出该数组中满足其和>=target的长度最小的子数组 如果不符合返回0
 */
public class p209 {

    public int minSubArrayLen(int target, int[] nums) {

        int left = 0, right = 0;
        int curSum = 0;//当前和
        int minLength = 0;//最小的长度

        while (right < nums.length) {

            curSum += nums[right];

            //已经超过目标值了 不断的缩小窗口
            while (curSum >= target) {

                //此时更新最短值
                if (right - left + 1 < minLength || minLength == 0) {
                    minLength = right - left + 1;
                }

                //减去左边的值
                curSum -= nums[left];
                left++;
            }
            right++;
        }

        return minLength;
    }

    public static void main(String[] args) {

        int target = 7;
        int nums[] = {2, 3, 1, 2, 4, 3};

        p209 t = new p209();
        int res = t.minSubArrayLen(target, nums);
        System.out.println(res);
    }
}
