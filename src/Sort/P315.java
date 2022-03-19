package Sort;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: P315
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/9/11
 * @Time: 22:10
 */
public class P315 {

    public int[] numIndex;
    public int[] tempIndex;
    public int[] resultIndex;

    public List<Integer> countSmaller(int[] nums) {

        int n = nums.length;
        resultIndex = new int[n];
        numIndex = new int[n];
        tempIndex = new int[n];
        for (int i = 0; i < n; i++)
            numIndex[i] = i;
        mergeSort(nums, 0, n - 1);
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            res.add(resultIndex[i]);
        }

        return res;

    }

    private void mergeSort(int[] nums, int left, int right) {

        if (left == right) {
            return;
        }
        int mid = left + ((right - left) >> 1);
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        merge(nums, left, mid, right);
    }


    private void merge(int[] nums, int left, int mid, int right) {

        int[] help = new int[right - left + 1];
        int i = 0;
        int p1 = left, p2 = mid + 1;
        while (p1 <= mid && p2 <= right) {
            //统计当前元素右侧比它小的数，降序
            if (nums[p1] > nums[p2]) {
                //如果左边比右边大
                resultIndex[numIndex[p1]] += (right - p2 + 1);
                tempIndex[i] = numIndex[p1];
                help[i++] = nums[p1++];
            } else {
                tempIndex[i] = numIndex[p2];
                help[i++] = nums[p2++];
            }

        }

        while (p1 <= mid) {
            tempIndex[i] = numIndex[p1];
            help[i++] = nums[p1++];
        }

        while (p2 <= right) {
            tempIndex[i] = numIndex[p2];
            help[i++] = nums[p2++];
        }

        for (int j = 0; j < help.length; j++) {
            numIndex[left + j] = tempIndex[j];
            nums[left + j] = help[j];
        }
    }
}
