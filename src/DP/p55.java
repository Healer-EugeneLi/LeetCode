package DP;

/**
 * @ClassName: p55
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/4/26
 * @Time: 11:15
 * 跳跃游戏
 * 输入：nums = [2,3,1,1,4]
 * 输出：true
 * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
 */
public class p55 {

    public boolean canJump(int[] nums) {

        int cover=0;//此时所能到达的最大长度

        //每一次就是在cover范围内 来继续走 然后判断是否可以走更远 也就是得到比cover更大的范围
        //如果在此过程中 cover已经可以超出最后一个位置 就说明可以到达目标

        for (int i=0;i<=cover;i++){

            //此时i这个位置 可以跳nums[i] 所以在这个位置所能达到的最远距离为 i+nums[i]
            cover=Math.max(cover,i+nums[i]);

            //如果此时已经到达了结尾 或者超出结尾了
            if (cover>=nums.length-1) return true;
        }
        return false;

    }
}
