package JZOffer;

/**
 * @ClassName: JZOffer56_2
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/4/28
 * @Time: 10:51
 */
public class JZOffer56_2 {

    /**
     * 在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。
     *
     * 输入：nums = [3,4,3,3]
     * 输出：4
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {


        int res=0;
        int arr[]=new int[32];

        //遍历每一个数
        for (int i=0;i<nums.length;i++){
            //对每一个位进行判断 其中arr[0]对应的是最高位 也就是第32位 如果该位为1 那么arr[j]++ 可以求出这个有多少个数在此位为1
            for (int j=0;j<32;j++){
                arr[j]+=( nums[i]>>(31-j) )&1;//因为j=0是要存放高位是否出现1的判断 因此当j=0 即将所需判断的数右移31-0=31位 可以计算出该位是否出现1
            }
        }

        //对每个位置进行%3 可以得到最后那个只出现1次的数 在那些位置上是1
        for (int i=0;i<arr.length;i++)
            arr[i]%=3;

        //所以现在已经知道arr[]数组 从下标0~31 对应的从左到右 从高位到低位 哪几个位置出现了1
        for (int i=0;i<32;i++){

            res=(res<<1)+arr[i];
        }

        return res;
    }
}
