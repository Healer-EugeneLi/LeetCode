package Sort;

import java.util.Arrays;
import java.util.List;

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


    public void quickSort(int nums[],int start,int end){

        if(start>=end)
            return ;
        int base=nums[start];//基准值
        int left=start;//左指针
        int right=end;//右指针

        while(left<right){

            //直到找到一个比base小的值
            while (left<right&&nums[right]>=base) right--;
            //直到找到一个比base大的值
            while(left<right&&nums[left]<=nums[right]) left++;

            if (left<right){
                //交换
                int temp=nums[right];
                nums[right]=nums[left];
                nums[left]=temp;
            }
            //递归排序两个区间
            quickSort(nums,start,left-1);
            quickSort(nums,left+1,end);
        }

    }
    public static void main(String[] args) {

        int arr[] = {2, 4,6,8,1,3,5,7};
        FastSort fastSort = new FastSort();
        fastSort.sort(arr, 0, arr.length - 1);

        for (int a : arr)
            System.out.print(a + " ");
    }
}
