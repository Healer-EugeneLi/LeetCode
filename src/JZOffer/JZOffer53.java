package JZOffer;

/**
 * @ClassName: JZOffer53
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/12/6
 * @Time: 22:04
 * 在排序数组中找target这个数出现的次数
 */
public class JZOffer53 {
    public int search(int[] nums, int target) {

        int left = 0, right = nums.length - 1;
        int mid = 0, sum = 0;
        while (left <= right) {

            mid = (left + right) / 2;

            if (nums[mid] == target) {
                sum = 1;
                //从中往左
                int t1 = mid - 1, t2 = mid + 1;
                while (t1 >= 0 && nums[t1] == target) {
                    sum++;
                    t1--;
                }
                //从中往右
                while (t2 <= nums.length - 1 && nums[t2] == target) {
                    sum++;
                    t2++;
                }
                return sum;

            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }

        }
        return sum;
    }

    public static void main(String[] args) {


        int a[] = {5, 7, 7, 8, 8, 10};
        int target = 2;
        JZOffer53 t = new JZOffer53();
//        int search = t.search(a, target);
//        System.out.println(+search);
        for (int i = 0; i <= 13; i++) {
            int search = t.search(a, i);
            System.out.println(i + ":" + search);
        }


    }
}
