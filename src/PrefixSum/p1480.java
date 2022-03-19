package PrefixSum;

/**
 * @ClassName: p1480
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/3/19
 * @Time: 11:43
 * 动态和
 */
public class p1480 {
    public int[] runningSum(int[] nums) {

        int sum[]=new int[nums.length];

        sum[0]= nums[0];
        for (int i=1;i<nums.length;i++){

            sum[i]=sum[i-1]+nums[i];
        }
        return sum;

    }
}
