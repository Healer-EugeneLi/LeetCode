package MoveWindow;

/**
 * @ClassName: p1004
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/3/5
 * @Time: 22:33
 * 输入：nums = [1,1,1,0,0,0,1,1,1,1,0], K = 2
 * 输出：6
 * 解释：[1,1,1,0,0,1,1,1,1,1,1]
 * 粗体数字从 0 翻转到 1，最长的子数组长度为 6。
 * <p>
 * 转换成出现最多k个0的区间场景
 */
public class p1004 {

    public int longestOnes(int[] nums, int k) {

        int left = 0, right = 0;
        int res = 0, zero = 0;
        while (right < nums.length) {

            if (nums[right] == 0)
                zero++;

            //此时0的个数大于k个的时候 需要滑动窗口的左边界往右移
            while (zero > k) {

                if (nums[left] == 0) {
                    zero--;
                }
                left++;
            }

            //这个时候已经是控制为不超过k个0了
            res = Math.max(res, right - left + 1);
            right++;
        }

        return res;
    }

    public static void main(String[] args) {

        int arr[] = {0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1};

        p1004 t = new p1004();
        int res = t.longestOnes(arr, 3);
        System.out.println(res);
    }
}
