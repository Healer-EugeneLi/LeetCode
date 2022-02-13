package JZOffer;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName: JZOffer56
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/2/13
 * @Time: 21:19
 */
public class JZOffer56 {

    /**
     * 使用哈希表解决
     * @param nums
     * @return
     */
//    public int singleNumber(int[] nums) {
//
//        HashMap<Integer,Integer> map=new HashMap<>();
//
//        for (int num:nums){
//            if (!map.containsKey(num)){
//                map.put(num,1);
//            }else {
//                map.put(num,map.get(num)+1);
//            }
//        }
//
//        Set<Integer> keys= map.keySet();
//        for (Integer key:keys){
//            if (map.get(key)==1) return key;
//        }
//
//        return 0;
//    }

    /**
     * 使用位运算的方法来解决
     * 对于每一个数字  统计其对应的32位中的每一位出现的次数
     * 对于出现3次的该位 对3取%之肯定为0
     * 对于出现1次的该位 对3取%之后肯定为1
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {

        int arr[]=new int[32];

        for (int i=0;i<nums.length;i++){
            for (int j=0;j<32;j++){
                //数组中的第0位就是对应32位中的最左边 &1 取值来统计该位中是否有值
                arr[j]+=( (nums[i]>>(31-j))&1 );
            }
        }

        //对3去%进行处理
        for (int i=0;i<32;i++){
            arr[i]%=3;
        }

        //处理完之后 进行计算
        int res=0;
        for (int i=0;i<32;i++){

            res= (res<<1)+arr[i];//统计该位的值 因为此时arr[i]%3肯定不是0 所以得到该位的值
            //最后不断地进行左移就可以统计出各位中的值
        }

        return res;

    }

    public static void main(String[] args) {
        int res=0;
        res<<=1;
        System.out.println(res);
    }
}
