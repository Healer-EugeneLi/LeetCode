package DobulePoint;

/**
 * @ClassName: p26
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/9/20
 * @Time: 20:05
 * 删除有序数组的重复项
 * 输入：nums = [1,1,2]
 * 输出：2, nums = [1,2,_]
 * 解释：函数应该返回新的长度 2 ，并且原数组 nums 的前两个元素被修改为 1, 2 。不需要考虑数组中超出新长度后面的元素。
 *
 */
public class p26 {

//    public int removeDuplicates(int[] nums) {
//
//        int length = nums.length;
//        if (length == 0 || length == 1) return length;
//
//        int left = 0;//指向当前已满足条件的数的指针
//
//        //i用于寻找下一个与left所指向的结点不一样的 如果该节点在left的下一个 则直接left++ i++ 如果该节点不在left的下一个 那么与其交换 left++ i++
//        for (int i = 1; i < length; i++) {
//
//
//            if (nums[i] == nums[left]) continue;
//            else if (nums[i] != nums[left] && i == left + 1) {
//                //说明是前后而已
//                left++;
//            } else {
//                //num[i]该节点与left下一个结点交换
//                int temp = nums[i];
//                nums[i] = nums[left + 1];
//                nums[left + 1] = temp;
//                left++;
//            }
//        }
//        return left + 1;//left是下标索引 个数应该等于索引+1
//
//    }

    /**
     * 使用双指针来进行控制
     * left指向当前已经符合条件的不重复数的最后一个数的下标
     * 让right不断地往后面进行移动，如果right当前指向的数据与left一样，那么right继续往后移动，
     * 如果right指向的数据与left不一致，那么将right指向的数据赋值给left的下一个位置 然后left++ right++
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {

        if (nums.length==0||nums.length==1) return nums.length;

        int left=0;
        for (int right=1;right<nums.length;right++){

            if (nums[left]!=nums[right]){
                nums[++left]=nums[right];
            }
        }
        return ++left;//最终的个数等于下标+1
    }

    public static void main(String[] args) {
        int arr[] = {1, 1, 2};
        p26 p26 = new p26();
        int res = p26.removeDuplicates(arr);

    }
}
