package Greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @ClassName: p45
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/10/2
 * @Time: 21:10
 */
public class p45 {


//    public class MyComparator implements Comparator<String> {
//
//
//        @Override
//        public int compare(String o1, String o2) {
//            return (o1 + o2).compareTo(o2 + o1);
//        }
//    }
//
//    public String minNumber(int[] nums) {
//
//        String strs[] = new String[nums.length];
//        for (int i = 0; i < nums.length; i++) {
//            strs[i] = String.valueOf(nums[i]);
//        }
//
//        Arrays.sort(strs, new MyComparator());
//
//        String res = "";
//        for (int i = 0; i < strs.length; i++) {
//            res += strs[i];
//        }
//        return res;
//
//    }


    /**
     *跳跃游戏2：求最少的跳跃次数
     * 输入: nums = [2,3,1,1,4]
     * 输出: 2
     * 解释: 跳到最后一个位置的最小跳跃数是 2。
     从下标为 0 跳到下标为 1 的位置，跳1步，然后跳3步到达数组的最后一个位置。

     * @param nums
     * @return
     */
    public int jump(int[] nums) {

        /**
         * 思路 从第一个下标开始 更新右边界 也就是最远能够到达的位置 并且使用从头遍历到nums.length-1即可 因为最终肯定是可以跳跃到达最后一个位置的
         * 然后我们在右边界这边记录跳跃次数 比如一开始右边界end为0 也就是第一个位置 此时我们就跳一次 step++
         * 然后更新最大右边界end 下一次i继续走 走到这个新的右边界的时候 继续step++
         *
         */

        int end=0,step=0,maxCanGo=0;
        //只遍历到最后一个位置的前一个即可
        for (int i=0;i< nums.length-1;i++){

            maxCanGo=Math.max(maxCanGo,nums[i]+i);//更新最大可到达的位置
            if (maxCanGo>= nums.length-1) return step+1;
            //到达右边界的时候 可以更新一次跳跃次数
            if (i==end){
                end=maxCanGo;
                step++;
            }

        }
        return step;
    }

    public static void main(String[] args) {

        int nums[]={2,3,1,1,4};

        p45 t=new p45();
        int jump = t.jump(nums);
        System.out.println(jump);
    }
}
