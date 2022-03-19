package Sort;

import java.util.Arrays;

/**
 * @ClassName: FastSort
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/9/26
 * @Time: 15:13
 * 归版的快速排序：通过把基准插入到合适的位置来实现分治，并递归地对分治后的两个划分继续快排
 */
public class FastSort {

    public void sort(int arr[], int low, int high) {

        //已经排完
        if (low >= high) {
            return;
        }

        int left = low;
        int right = high;

        //保存基准值
        int pivot = arr[left];
        while (left < right) {

            //从后向前找比基准小的数
            while (left < right && arr[right] >= pivot) right--;
            //找到了 放到a[left]上
            arr[left] = arr[right];

            //从前向后找比基准大的值
            while (left < right && arr[left] <= pivot) left++;
            //找到了 放到a[right]上
            arr[right] = arr[left];
        }

        //放置基准值
        arr[left] = pivot;
        sort(arr, low, left - 1);
        sort(arr, left + 1, high);
    }

    public static void main(String[] args) {

        int arr[] = {2, 3, 1, 2, 3, 4, 5, 6, 2, 4, 5, 8, 8, 1};
        FastSort fastSort = new FastSort();
        fastSort.sort(arr, 0, arr.length - 1);

        for (int a : arr)
            System.out.print(a + " ");
    }
}
