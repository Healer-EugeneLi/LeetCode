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
//            //往左找 最大的高度
//            for (int j=i;j>=0;j--){
//                leftMax=Math.max(height[j],leftMax);
//            }
//            //往右找 最大的高度
//            for (int k=i;k<height.length;k++){
//                rightMax=Math.max(height[k],rightMax);
//            }
//            //使用短板效应 让两边更小的减去当前高度 得到当前这个位置可以盛多少水 然后累加
//            ans+=Math.min(leftMax,rightMax)-height[i];
//
//        }
//        return ans;
//
//    }

    /**
     * 利用动态规划的思想 提前存好当前i两边对应的最大值
     *
     * @param height
     * @return
     */
    public int trap(int[] height) {

        int n=height.length;
        int leftMax[] = new int[n];
        int rightMax[] = new int[n];

        //第一个元素的左边最大值等于本身
        leftMax[0] = height[0];
        //提前存好当前元素的左边最大值
        for (int i = 1; i < n; i++) {
            //当前i这个位置其左边的最大值为当前这个位置的高度与前一个位置的所求好的leftMax[i-1]即前一个位置的左边的最大值
            leftMax[i] = Math.max(height[i], leftMax[i - 1]);
        }

        //最后一个元素的右边最大值等于本身
        rightMax[n - 1] = height[n - 1];
        //从倒数第二个位置开始往左遍历 找到当前位置的右边的最大值
        for (int j = n- 2; j >= 0; j--) {
            rightMax[j] = Math.max(height[j], rightMax[j + 1]);
        }

        //遍历所有位置的元素
        int ans = 0;
        for (int index = 0; index < n; index++) {
            //根据短板效应 选择当前位置两边更小的高度 来减去当前的高度 得到盛多少水
            ans += Math.min(leftMax[index], rightMax[index]) - height[index];
        }
        return ans;
    }
    public static void main(String[] args) {

        int arr[]={0,1,0,2,1,0,1,3,2,1,2,1};

        p42 t=new p42();
        int res = t.trap(arr);
        System.out.println(res);
    }

}
