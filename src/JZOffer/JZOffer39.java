package JZOffer;

import java.util.Arrays;

/**
 * @ClassName: JZOffer39
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/11/25
 * @Time: 22:39
 */
public class JZOffer39 {
//    public int majorityElement(int[] nums) {
//        //[1, 2, 3, 2, 2, 2, 5, 4, 2]
//
//        Arrays.sort(nums);
//        return nums[nums.length/2];//排完序之后肯定在中间
//    }
    public int majorityElement(int[] nums) {
        //[1, 2, 3, 2, 2, 2, 5, 4, 2]

       //摩根投票法
        int current=0;//当前被认为有可能是大于一半的数
        int vote=0;//票数和
        for (int i=0;i<nums.length;i++){

            if(vote==0) current=nums[i];

            vote+=current==nums[i]?1:-1;
        }
        return current;
    }

}
