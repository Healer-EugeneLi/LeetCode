package DobulePoint;

/**
 * @ClassName: p11
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/5/9
 * @Time: 19:46
 */
public class p11 {


    /**
     * 盛最多水的容器
     * 输入：[1,8,6,2,5,4,8,3,7]
     * 输出：49
     * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）
     * 的最大值为 第1个8的位置 到最后一个7的位置 然后计算结果为7*(8-1)=49 其中1为左边8这个高度的位置 8为右边这个7的位置 两个相减得到底部的长度
     * 每一轮都计算min(height(i),height(j))*(j-1)
     *使用双指针进行移动 一开始left指向第一个板  right指向最后一个板  那么每次移动我们有两种方案
     * 移动较短的板：移动完之后 min(height(i),height(j))有可能是会变大 因为让短板的这个进行移动 有可能是会得到更高的板 虽然底部长度缩短了 但是结果有可能变大
     * 移动较长的板：移动完之后 min(height(i),height(j)) 有可能就是不变或者变小 那么很显然 最后乘法求出来的结果肯定是小的
     * 所以我们每一轮都进行移动更短的板 直到两个指针相遇
     * @param height
     * @return
     */
    public int maxArea(int[] height) {

        int left=0,right=height.length-1;
        int max=0;
        while (left<right){

            //求出当前left与right指向的容器结果
            int curResult=Math.min(height[left],height[right])*(right-left);
            max=Math.max(max,curResult);

            //左边更短 移动更短的板
            if (height[left]<=height[right]){
                left++;
            }else
                right--;
        }

        return max;
    }
}
