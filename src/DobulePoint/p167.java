package DobulePoint;

/**
 * @ClassName: p167
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/9/19
 * @Time: 22:06
 */
public class p167 {

    public int[] twoSum(int[] numbers, int target) {

        int left = 0;
        int right = numbers.length - 1;

        while (left <= right) {

            if (numbers[left] + numbers[right] == target) {
                return new int[]{left + 1, right + 1};
            } else {
                while (numbers[left] + numbers[right] > target) right--;

                while (numbers[left] + numbers[right] < target) left++;

            }
        }
        return new int[]{};
    }
}
