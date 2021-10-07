package Array;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @ClassName: p414
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/10/6
 * @Time: 20:15
 * 数组中第三大的数
 */
public class p414 {

    public int thirdMax(int[] nums) {

       Arrays.sort(nums);
       if (nums.length<3)
           return nums[nums.length-1];

       int flag=nums[nums.length-1];
       int num=1;
       for (int i=nums.length-2;i>=0;i--){

           if (flag!=nums[i]){
               //遇到不同的数
               flag=nums[i];
               num+=1;
           }
           if (num==3) return flag;
       }
       return nums[nums.length-1];//第三大的数不在 返回最大的数
    }
}
