package Greedy;

/**
 * @ClassName: p55
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/5/11
 * @Time: 15:45
 */
public class p55 {

    /**
     * 跳跃游戏
     * 输入：nums = [2,3,1,1,4]
     * 输出：true
     * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
     * 先从第0个位置开始跳  然后每一次都计算次数能够更新到的最大范围
     * 然后接下去就是在这个范围内继续走，同时看有没有办法继续更新这个最大范围 如果最大范围已经超过最后一个下标了 就说明是可行的
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {

        int cover=0;//当前
        for (int i=0;i<=cover;i++){

            cover=Math.max(cover,i+nums[i]);//更新最大范围

            if (cover>= nums.length-1) return true;//此时已经跳到最后一个位置了 直接返回
        }
        return false;//此时能够出来到这里 肯定是还没有到达最后一个下标
    }
}
