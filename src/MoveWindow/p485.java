package MoveWindow;

/**
 * @ClassName: p485
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/3/4
 * @Time: 22:33
 * 最大连续1的个数
 */
public class p485 {

    public int findMaxConsecutiveOnes(int[] nums) {


        int left=0,right=0;
        int res=0;

        while (right<nums.length){

            if (nums[right]==1) right++;
            else {
                //此时窗口右侧不等于1 计算这一轮
                res=Math.max(res,right-left);
                right++;//滑动窗口右移
                left=right;//此时左指针也与右指针在同一个位置 开启新的一滑动窗口

            }

        }
        //最后需要注意 当right已经遍历完了出来了 需要再计算一次这一轮的滑动窗口
        res=Math.max(res,right-left);
        return res;
    }

    public static void main(String[] args) {
        int arr[]={1,1,0,1,1,1};

        p485 t=new p485();
        int res = t.findMaxConsecutiveOnes(arr);
        System.out.println(res);
    }
}
