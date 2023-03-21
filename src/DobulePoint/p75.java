package DobulePoint;

/**
 * @ClassName: p75
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/2/23
 * @Time: 22:08
 * 输入：nums = [2,0,2,1,1,0]
 * 输出：[0,0,1,1,2,2]
 * 0  1 2 分别表示红色、白色、蓝色
 * 原地进行排序 使得 相同颜色排在一块  按照红色 白色 蓝色 顺序
 */
public class p75 {

//    public void sortColors(int[] nums) {
//
//        //使用两轮交换 先交换0 与其他数
//        int left = 0, right = nums.length - 1;
//        while (left < right) {
//
//            while (left < right && nums[left] == 0) left++;
//            while (left < right && nums[right] != 0) right--;
//            if (left < right) {
//                //直接设置 left的位置为0 right的位置为2
//                nums[right--] = nums[left];
//                nums[left++] = 0;
//
//            }
//        }
//        //此时left指针的位置就是所有0的下一个位置 重新设定右指针从最右边开始
//        //此时交换的是1 2
//        right = nums.length - 1;
//
//        while (left < right) {
//            while (left < right && nums[left] != 2) left++;
//            while (left < right && nums[right] != 1) right--;
//            if (left < right) {
//                //直接设置 left的位置为0 right的位置为2
//                nums[left++] = 1;
//                nums[right--] = 2;
//            }
//        }
//
//
//    }


    /**
     * left right index 进行交换
     * 让index指向当前指针
     * left 指向左边界 left指针用来划分0 和 1的边界数据 left指针的左边永远是0 不包含left指向的位置
     * right 指向右边界 right指针用来划分 1 和 2的边界 right指针的右边永远是2 不包含right指向的位置
     * @param nums
     */
    public void sortColors(int[] nums) {

        int left=0,right=nums.length-1;

        int index=0;

        while (index<=right){

            if (nums[index]==0){
                //交换index指针指向的数据与left指向的进行交换
                swap(nums,left++,index++);//left跟index交换过来的时候 left指向的只有可能是1 因为如果有2的话之前就被换到后面去了 肯定所以此时index++ 判断下一个
            }else if (nums[index]==2){
                //交换index指针指向的数据与right指向的进行交换 right交换过来的数据有可能是0
                // 所以此时需要再判断1次index 而不能index++ 否则会错过1次判断
                swap(nums,right--,index);
            }else
                index++;//如果遇到的是1 那就继续走往下判断
        }

    }

    /**
     * 交换数组nums中的i j两个位置的元素
     * @param nums
     * @param i
     * @param j
     */
    public void swap(int nums[],int i,int j){

        if (nums==null) return;
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }

    public static void main(String[] args) {
        p75 t = new p75();

        int nums[] = {2, 0, 1};
        t.sortColors(nums);
        for (int num : nums)
            System.out.println(num);
    }
}
