package Sort;

/**
 * @ClassName: NetherlandsSort
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/9/12
 * @Time: 11:32
 */
public class NetherlandsSort {

    public void swap(int[] arr, int i, int j) {
        if (i != j) {
            arr[i] = arr[i] ^ arr[j];
            arr[j] = arr[i] ^ arr[j];
            arr[i] = arr[i] ^ arr[j];
        }
    }

    /**
     * 对nums数组进行划分 分成 <  =  >  三部分
     *
     * @param nums
     * @param target
     */
    public void sortColors(int[] nums, int target) {

        int left = -1;
        int right = nums.length;
        int i = 0;
        while (i < right) {

            if (nums[i] == target) {
                //等于目标的数 直接跳过 下一个
                i++;
            } else if (nums[i] < target) {
                //跟左区域的边界的下一个进行交换 然后然边界往前扩充++
                swap(nums, i, left + 1);
                i++;
                left++;
            } else {
                swap(nums, i, right - 1);
                right--;//i不能++ 因为换过来的数还需要再判断一次
            }
        }
        for (int a : nums)
            System.out.print(a + " ");

    }


    public static void main(String[] args) {

        int arr[] = {1, 4, 2, 5, 6, 7, 8, 4, 2};
        NetherlandsSort sort = new NetherlandsSort();

        sort.sortColors(arr, 5);

    }
}
