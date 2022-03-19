package MoveWindow;

/**
 * @ClassName: p643
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/3/10
 * @Time: 22:17
 * <p>
 * 在数组中找到长度为k的子数组 而且它的平均值最大
 */
public class p643 {

    /**
     * 滑动窗口
     * @param nums
     * @param k
     * @return
     */
//    public double findMaxAverage(int[] nums, int k) {
//
//
//        double cur=0;
//        double res=0;
//
//        for (int i=0;i< nums.length;i++){
//
//            cur+=nums[i];
//            if (i==k-1){
//                res=cur/k;
//            }
//            if (i>=k){
//                cur-=nums[i-k];//等同于滑动窗口的左边右移 该元素出去
//                res=Math.max(res,cur/k);
//            }
//
//        }
//
//        return res;
//    }

    /**
     * 前缀和
     *
     * @param nums
     * @param k
     * @return
     */
    public double findMaxAverage(int[] nums, int k) {


        //sum[i]表示从0到i位置的所有元素和
        double sums[] = new double[nums.length];

        sums[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            sums[i] = sums[i - 1] + nums[i];
        }
        double res = sums[k - 1] / k;
        for (int j = k; j < nums.length; j++) {
            res = Math.max(res, (sums[j] - sums[j - k]) / k);
        }

        return res;
    }

    public static void main(String[] args) {

        int arr[] = {1, 12, -5, -6, 50, 3};

        int k = 4;
        p643 t = new p643();
        double res = t.findMaxAverage(arr, k);
        System.out.println(res);


    }
}
