package Heap;

/**
 * @ClassName: HeapOperation
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/9/25
 * @Time: 19:56
 */
public class HeapOperation {


    /**
     * 交换数组arr中i j的位置 注意i!=j
     *
     * @param arr
     * @param i
     * @param j
     */
    public static void swap(int arr[], int i, int j) {
        if (i != j) {
            arr[i] = arr[i] ^ arr[j];
            arr[j] = arr[i] ^ arr[j];
            arr[i] = arr[i] ^ arr[j];
        }
    }

    /**
     * 某个数出现在index位置上 进行不断调整 构建大根堆 放到合适的位置
     *
     * @param arr
     * @param index
     */
    public static void heapInsert(int arr[], int index) {

        while (arr[index] > arr[(index - 1) / 2]) {//(index-1)/2 是父亲坐标
            swap(arr, index, (index - 1) / 2);
        }

        index = (index - 1) / 2;

    }


    /**
     * 某个数在index位置 能否往下移动
     *
     * @param arr
     * @param index
     * @param heapSize
     */
    public static void heapify(int arr[], int index, int heapSize) {

        //先算左孩子的下标
        int left = index * 2 + 1;

        while (left < heapSize) {

            //有右孩子的时候 需要去判断哪个孩子更大 把下标赋值个largest
            int largest = left + 1 < heapSize && arr[left + 1] > arr[left] ? left + 1 : left;

            //父节点和孩子结点之间 谁的值大 就把下标给largest
            largest = arr[largest] > arr[index] ? largest : index;

            if (largest == index) break;//最大的没有父节点大 之间返回

            //如果子节点比父节点大
            swap(arr, index, largest);

            index = largest;
            left = index * 2 + 1;
        }
    }

    /**
     * 堆排序
     *
     * @param arr
     */
    public static void heapSort(int arr[]) {

        if (arr == null || arr.length < 2) return;

        //先调整成大根堆 建大根堆的过程O(logN)
        for (int i = 0; i < arr.length; i++) {//O(N)
            heapInsert(arr, i);//O(logN)
        }

        //如果给定一个数组 直接变成大根堆  有O(N)的做法
//        for (int j=arr.length-1;j>=0;j--){
//            heapify(arr,arr[j],arr.length);
//        }

        //堆大小 显然就是数组长度
        int heapSize = arr.length;

        swap(arr, 0, --heapSize);//第0个位置 即最大值跟--heapSize 交换 也就是最后一个值 同时也将堆大小减1了

        while (heapSize > 0) {//O(N)
            heapify(arr, 0, heapSize);//此时对第0个位置进行调整 O(logN)
            swap(arr, 0, --heapSize);//调整完之后再交换 O(1)
        }

    }
}
