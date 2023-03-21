package BinarySearch;

/**
 * @ClassName: p69
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/5/7
 * @Time: 11:01
 */
public class p69 {


    /**
     * 求x的平方根
     * @param x
     * @return
     */
    public int mySqrt(int x) {

        //使用二分查找 假设最后的答案为ans 满足k*k<=x的最大k值，因此对k进行二分查找
        //二分查找的下界为0  上届定义为x 在二分查找的每一步中 只需要比较中间元素mid的平方与x的大小关系，并通过比较的结果调整上下姐的范围

        int left=0,right=x,ans=-1;

        while (left<=right){
            int mid=left+((right-left)>>1);

            if ((long)mid*mid<=x){
                ans=mid;
                left=mid+1;//往右边去找
            }else {
                right=mid-1;
            }
        }

        return ans;

    }
}
