package PrefixSum;

import java.util.HashMap;

/**
 * @ClassName: p525
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/3/19
 * @Time: 9:29
 * 给定一个二进制数组 nums , 找到含有相同数量的 0 和 1 的最长连续子数组，并返回该子数组的长度。
 * 输入: nums = [0,1,0]
 * 输出: 2
 * 说明: [0, 1] (或 [1, 0]) 是具有相同数量0和1的最长连续子数组。
 */
public class p525 {



//    public int findMaxLength(int[] nums) {
//
//        int res=0;
//
//        //令dp[i]表示 以索引为i 即nums[i]结尾的包含相同数量的0和1的最长联系子数组的长度
//        int dp[]=new int[nums.length+1];
//
//        //sum[i]表示 前i个数的前缀和
//        int sum[]=new int[nums.length+1];
//
//        for (int i=1;i<=nums.length;i++)
//            sum[i]=sum[i-1]+nums[i-1];
//
//        for (int i=0;i< nums.length;i++){
//
//            for (int j=0;j<i;j++){
//
//                int length=i-j+1;
//                if ((sum[i+1]-sum[j])*2==length)
//                    res=Math.max(res,length);
//            }
//        }
//
//        return res;
//
//    }

    public int findMaxLength(int[] nums) {


        int curSum=0;
        int res=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,-1);//前缀和为0  一开始第一次出现的索引设置为-1
        for (int i=0;i< nums.length;i++){

            if (nums[i]==0)
                curSum-=1;
            else
                curSum+=1;

            if (map.containsKey(curSum)){
                //如果此时在前面已经出现了该前缀和
                int preIndex=map.get(curSum);
                res=Math.max(res,i-preIndex);
            }else
                map.put(curSum,i);

        }
        return res;
    }

    public static void main(String[] args) {


        int nums[]={0,1,0};

        p525 t=new p525();
        int maxLength = t.findMaxLength(nums);
        System.out.println(maxLength);
    }
}
