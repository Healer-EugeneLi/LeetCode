package DobulePoint;

/**
 * @ClassName: p75
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/2/23
 * @Time: 22:08
输入：nums = [2,0,2,1,1,0]
输出：[0,0,1,1,2,2]
 0  1 2 分别表示红色、白色、蓝色
 原地进行排序 使得 相同颜色排在一块  按照红色 白色 蓝色 顺序
 *

 */
public class p75 {

    public void sortColors(int[] nums) {

        //使用两轮交换 先交换0 与其他数
        int left=0,right=nums.length-1;
        while (left<right){

            while (left<right&&nums[left]==0)left++;
            while (left<right&&nums[right]!=0) right--;
            if (left<right){
                //直接设置 left的位置为0 right的位置为2
                nums[right--]=nums[left];
                nums[left++]=0;

            }
        }
        //此时left指针的位置就是所有0的下一个位置 重新设定右指针从最右边开始
        //此时交换的是1 2
        right=nums.length-1;

        while (left<right){
            while (left<right&&nums[left]!=2)left++;
            while (left<right&&nums[right]!=1) right--;
            if (left<right){
                //直接设置 left的位置为0 right的位置为2
                nums[left++]=1;
                nums[right--]=2;
            }
        }


    }

    public static void main(String[] args) {
        p75 t=new p75();

        int nums[]={2,0,2,1,1,0};
        t.sortColors(nums);
        for (int num:nums)
            System.out.println(num);
    }
}
