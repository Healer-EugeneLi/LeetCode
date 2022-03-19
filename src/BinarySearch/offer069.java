package BinarySearch;

/**
 * @ClassName: offer069
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/10/14
 * @Time: 9:42
 * 山峰位置
 */
public class offer069 {


    public int peakIndexInMountainArray(int[] arr) {

        int left = 0;
        int right = arr.length;
        int mid = 0;

        while (left < right) {

            mid = left + (right - left) / 2;

            if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1])
                return mid;
            else if (arr[mid] > arr[mid - 1] && arr[mid] < arr[mid + 1]) {
                left = mid + 1;
            } else if (arr[mid] < arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {

        int arr[] = {0, 1, 0};

        offer069 t = new offer069();
        int i = t.peakIndexInMountainArray(arr);
        System.out.println(i);
    }
}
