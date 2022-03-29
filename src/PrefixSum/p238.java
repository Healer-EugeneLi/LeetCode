package PrefixSum;

/**
 * @ClassName: p238
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/3/22
 * @Time: 20:49
 *
 * 给定一个数组 answer[i]=数组中除了nums[i]之前的所有其他数的乘积
 * 输入: nums = [1,2,3,4]
 * 输出: [24,12,8,6]
 */
public class p238 {

//    public int[] productExceptSelf(int[] nums) {
//
//        int res[]=new int[nums.length];
//
//        //left[i]表示i这个位置的元素 其左边的所有元素的乘积
//        int left[]=new int[nums.length];
//
//        //right[i]表示i这个位置的元素 其右边的所有元素的乘积
//        int right[]=new int[nums.length];
//        int leftTemp=1,rightTemp=1;
//        for (int i=0;i< nums.length;i++){
//            //当i=0时 此时是第一个元素 其左边没有元素 考虑到乘积需要 设置为1才不会得到0
//            left[i]=leftTemp;
//            //此时更新左边的乘积 这样下一次i=1的时候 得到的就算num[0]的元素了
//            leftTemp*=nums[i];
//        }
//
//        for (int j=nums.length-1;j>=0;j--){
//
//            right[j]=rightTemp;
//            rightTemp*=nums[j];
//        }
//
//        //最后遍历每一个元素  然后将其左边 右边的乘积 相乘
//        for (int i=0;i< nums.length;i++){
//            res[i]=left[i]*right[i];
//        }
//        return res;
//    }

    public int[] productExceptSelf(int[] nums) {

        int res[]=new int[nums.length];
        for (int i=0;i< res.length;i++)
            res[i]=1;//全部先设置为1
        int n= nums.length;

        int leftTemp=1,rightTemp=1;

        for (int i=0;i<nums.length;i++){

            res[i]*=leftTemp;//左边乘积
            leftTemp*=nums[i];


            res[n-1-i]*=rightTemp;//右边乘积
            rightTemp*=nums[n-1-i];
        }
        return res;
    }
}
