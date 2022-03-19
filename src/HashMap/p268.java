package HashMap;

import java.util.HashSet;

/**
 * @ClassName: p268
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/9/26
 * @Time: 16:02
 */
public class p268 {

//    public int missingNumber(int[] nums) {
//
//        HashSet<Integer> set=new HashSet<>();
//
//        int res=0;
//        for (int num:nums)
//            set.add(num);
//        for (int i=0;i<=nums.length;i++){
//            if (set.contains(i)) continue;
//
//            res=i;
//            break;
//        }
//        return res;
//
//    }

    public int missingNumber(int[] nums) {

        int missing = nums.length;

        for (int i = 0; i < nums.length; i++) {
            missing ^= i * nums[i];
        }

        return missing;
    }
}
