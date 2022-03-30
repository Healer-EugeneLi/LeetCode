package HashMap;

import java.util.*;

/**
 * @ClassName: p532
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/3/30
 * @Time: 15:59
 *
 * 给定一个整数数组和一个整数k，你需要在数组里找到 不同的k-diff 数对，并返回不同的 k-diff 数对 的数目。
 *
 * 这里将-diff数对定义为一个整数对 (nums[i], nums[j])，并满足下述全部条件：
 *
 * 0 <= i < j < nums.length
 * |nums[i] - nums[j]| == k
 * 注意，|val| 表示 val 的绝对值。
 * 输入：nums = [3, 1, 4, 1, 5], k = 2
 * 输出：2
 * 解释：数组中有两个 2-diff 数对, (1, 3) 和 (3, 5)。
 * 尽管数组中有两个1，但我们只应返回不同的数对的数量。
 *
 * 输入：nums = [1, 2, 3, 4, 5], k = 1
 * 输出：4
 * 解释：数组中有四个 1-diff 数对, (1, 2), (2, 3), (3, 4) 和 (4, 5)。
 *
 */
public class p532 {
    public int findPairs(int[] nums, int k) {

        Set<Integer> set=new HashSet<>();//存放已经出现过的数
        Arrays.sort(nums);//从小到大排序
        HashMap<Integer,Integer> map=new HashMap<>();

        for (int i=0;i< nums.length;i++){
            if (set.contains(nums[i]-k)){
                //因为是从小到大进行排序 所以前面的数肯定是小的 所以前面的数如果存在可以匹配的话 肯定是通过value+k=num[i]-k
                map.put(nums[i]-k,nums[i]);//使用map来进行重复值的更新 去重
            }
            set.add(nums[i]);
        }
        /*for (Map.Entry<Integer,Integer> m:map.entrySet()){
            System.out.println(m.getKey()+" "+m.getValue());
        }*/

        return map.keySet().size();
    }

    public static void main(String[] args) {
        int arr[]={1,2,4,4,3,3,0,9,2,3};

        p532 t=new p532();
        int pairs = t.findPairs(arr, 3);
        System.out.println(pairs);
    }
}
