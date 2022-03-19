package PrefixSum;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName: p523
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/3/12
 * @Time: 22:55
 */
public class p523 {

    public boolean checkSubarraySum(int[] nums, int k) {

        int sum[] = new int[nums.length + 1];

        //注意sum[1]表示的是前一个元素的和
        for (int i = 1; i <= nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }

        //如果这个区间[i,j]满足和被k整除 那么sum[j]/k与sum[i-1]/k的余数相同 sum[j]-sum[i-1]=n*k 推导得来

        Set<Integer> set = new HashSet<>();

        //要求子数组的长度大于等于2
        for (int i = 2; i <= nums.length; i++) {

            set.add(sum[i - 2] % k);//i=2的时候sum[2-2]为0

            //当遍历区间右边j的时候 在它的左边 而且距离j有两个长度的左端点
            if (set.contains(sum[i] % k))//当i=2 此时sum[2]刚好表示前两个元素的和 此时如果可以整除 那么余数为0  此时判断是否包含0
                return true;
        }
        return false;

    }
}
