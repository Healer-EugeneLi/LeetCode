package DobulePoint;

/**
 * @ClassName: p80
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/4/10
 * @Time: 21:44
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 最多出现两次 ，返回删除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 *

 * 输入：nums = [1,1,1,2,2,3]
 * 输出：5, nums = [1,1,2,2,3]
 * 解释：函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3 。 不需要考虑数组中超出新长度后面的元素。
 *

 */
public class p80 {

    public int removeDuplicates(int[] nums) {

        if (nums.length==0||nums.length==1||nums.length==2) return nums.length;

        int left=1;//当前满足条件的数组下标
       for (int right=2;right<nums.length;right++){

           //如果right指向的数==left 指向的数 并且==left=-1指向的数 说明此时如果加入当前这个元素 那么就会导致超过2个元素重复了
           if (nums[right]==nums[left]&&nums[right]==nums[left-1])
               continue;
           //此时这个元素不与前面的元素重复
           left++;//下一个位置准备放入该元素
           nums[left]=nums[right];

       }

        return ++left;
    }

    public static void main(String[] args) {

        int arr[]={0,0,1,1,1,2,2,3,3,4};
        p80 t=new p80();
        int res = t.removeDuplicates(arr);
        System.out.println(res);
    }
}
