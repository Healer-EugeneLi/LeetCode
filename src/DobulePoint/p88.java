package DobulePoint;

/**
 * @ClassName: p88
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/5/2
 * @Time: 15:17
 */
public class p88 {


    /**
     * 合并两个有序数组
     * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
     * 输出：[1,2,2,3,5,6]
     * 解释：需要合并 [1,2,3] 和 [2,5,6] 。
     * 合并结果是 [1,2,2,3,5,6] ，其中斜体加粗标注的为 nums1 中的元素。
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        //使用双指针
        int p1=m-1;//p1指向nums1中有存在数据的最后一个数据的下标 比如上面的[1,2,3,0,0,0]3的下标 后面的0是要用来存放2 5 6 加进来的
        int p2=n-1;//p2指向num2中的最后一个索引
        int p=m+n-1;//p指向nums1的最后一个下标 通过m+n得到总长度 然后-1就是索引

        //当nums2中的数据还未拿出来填完到nums1中
        while (p2>=0){

            //nums1中的数字更大 则该位置放入nums1此时指向的数字
            if (p1>=0&&p>=0&&nums1[p1]>=nums2[p2]){
                nums1[p--]=nums1[p1--];//记得同时让指针往前移动
            }else {
                //如果nums2更大 或者说nums1中此时已经没有需要比较的数字 就是p1<0了 那么这边直接把nums2中的数字填进来
                nums1[p--]=nums2[p2--];
            }
        }
    }

}
