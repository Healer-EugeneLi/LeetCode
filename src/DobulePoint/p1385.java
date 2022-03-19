package DobulePoint;

import Tree.P102;

/**
 * @ClassName: p1385
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/9/30
 * @Time: 23:09
 */
public class p1385 {

    /**
     * 输入：arr1 = [4,5,8], arr2 = [10,9,1,8], d = 2
     * 输出：2
     * 解释：
     * 对于 arr1[0]=4 我们有：
     * |4-10|=6 > d=2
     * |4-9|=5 > d=2
     * |4-1|=3 > d=2
     * |4-8|=4 > d=2
     * 所以 arr1[0]=4 符合距离要求
     *
     * @param arr1
     * @param arr2
     * @param d
     * @return
     */
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {

        boolean flag = true;
        int num = 0;
        for (int i = 0; i < arr1.length; i++) {
            flag = true;
            for (int j = 0; j < arr2.length; j++) {
                int a = arr1[i];
                int b = arr2[j];
                if (Math.abs(a - b) <= d) {
                    flag = false;
                    break;
                }
            }
            if (flag)
                num++;
        }

        return num;
    }

    public static void main(String[] args) {
        int arr1[] = {4, 5, 8};
        int arr2[] = {10, 9, 1, 8};
        p1385 t = new p1385();
        int res = t.findTheDistanceValue(arr1, arr2, 2);
        System.out.println(res);
    }
}
