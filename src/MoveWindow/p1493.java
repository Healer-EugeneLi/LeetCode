package MoveWindow;

/**
 * @ClassName: p1493
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/3/11
 * @Time: 13:41
 * <p>
 * 给定一个二进制数组  删除其中一个0 使得到全为1的最长的非空子数组长度
 * <p>
 * 转换成 在数组中找到只包含1个0的最长子数组长度
 * [0,1,1,1,0,1,1,0,1]
 */
public class p1493 {

    public int longestSubarray(int[] nums) {


        int left = 0, right = 0;
        int zero = 0;
        int ans = 0;

        while (right < nums.length) {

            //遇到0 开始更新
            if (nums[right] == 0) {
                zero++;

            }

            while (zero == 2) {
                //不断移动左边界 直到只包含1个0
                if (nums[left] == 0) {
                    zero--;
                }
                left++;
            }
            ans = Math.max(ans, right - left + 1 - 1);
            right++;//移动右边界
        }

        return ans;

    }

    public static void main(String[] args) {
        int arr[] = {1, 1, 0, 1};

        p1493 t = new p1493();
        int res = t.longestSubarray(arr);
        System.out.println(res);
    }
}
