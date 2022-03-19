package DobulePoint;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @ClassName: p594
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/11/20
 * @Time: 20:26
 * 找到数组中最长的和谐子序列
 * 序列中最大元素与最小的元素的值只差1
 */
public class p594 {

    //使用双指针的方式
//    public int findLHS(int[] nums) {
//
//        if (nums==null||nums.length==0||nums.length==1) return 0;
//
//        Arrays.sort(nums);//先升序排序
//        int ans=0;
//       //使用双指针做滑动窗口
//        int left=0,right=0;
//        for (left=0,right=0;right<nums.length;right++){
//
//            while (left<right&&nums[right]-nums[left]>1){
//                //此时左指针往后移
//                left++;
//            }
//            if (nums[right]-nums[left]==1){
//                ans=Math.max(ans,right-left+1);
//            }
//        }
//        return ans;
//
//    }

    //使用哈希计数的方式
    public int findLHS(int[] nums) {

        if (nums == null || nums.length == 0 || nums.length == 1) return 0;

        int ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        //和谐数组肯定是 a a a a+1 a+1 这种形式
        for (int num : nums) {
            if (map.containsKey(num - 1)) {
                ans = Math.max(ans, map.get(num - 1) + map.get(num));
            }

        }
        return ans;
    }

    public static void main(String[] args) {

        int arr[] = {1, 3, 2, 2, 5, 2, 3, 7};
        p594 t = new p594();
        int res = t.findLHS(arr);
        System.out.println(res);
    }
}
