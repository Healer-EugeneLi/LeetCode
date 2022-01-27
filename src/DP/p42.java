package DP;

/**
 * @ClassName: p42
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/11/9
 * @Time: 22:55
 */
public class p42 {

//    public int trap(int[] height) {
//
//        /**
//         * 遍历数组中的每个元素
//         * 在该元素往左找 最大的高度
//         * 在该元素往右找 最大的高度
//         * 根据短板才能放水的常识
//         * 取 两个最大值的较小值-当前元素的值=此时可以盛的雨水
//         */
//        int ans=0;
//        for (int i=0;i<height.length;i++){
//
//            int leftMax=0,rightMax=0;
//            //往左找
//            for (int j=i;j>=0;j--){
//                leftMax=Math.max(height[j],leftMax);
//            }
//            //往又找
//            for (int k=i;k<height.length;k++){
//                rightMax=Math.max(height[k],rightMax);
//            }
//            ans+=Math.min(leftMax,rightMax)-height[i];
//
//        }
//        return ans;
//
//    }

    /**
     * 利用动态规划的思想 提前存好当前i两边对应的最大值
     * @param height
     * @return
     */
    public int trap(int[] height) {

        int leftMax[]=new int[height.length];
        int rightMax[]=new int[height.length];

        leftMax[0]=height[0];//第一个元素的左边最大值等于本身
        for (int i=1;i<height.length;i++){
            leftMax[i]=Math.max(height[i],leftMax[i-1]);
        }

        rightMax[height.length-1]=height[height.length-1];//最后一个元素的右边最大值等于本身
        for (int j=height.length-2;j>=0;j--){
            rightMax[j]=Math.max(height[j],rightMax[j+1]);
        }

        int ans=0;
        for (int index=0;index<height.length;index++){
            ans+=Math.min(leftMax[index],rightMax[index])-height[index];
        }
        return ans;
    }

}
