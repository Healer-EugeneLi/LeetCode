package MoveWindow;

/**
 * @ClassName: p1031
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/3/6
 * @Time: 10:10
 *
 * 两个非重叠子数组的最大和 其中一个子数组长度为 firstLen 另一个secondLen
 *
 * 可以先固定其中一长度 然后切分开来 从后续长度继续往后走 找另一个长度的最大和
 */
public class p1031 {
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {

        //先求前缀和 sum[i]表示下标0到i的所有元素和
        int sum[]=new int[nums.length];
        sum[0]=nums[0];
        for (int i=1;i< nums.length;i++){
            sum[i]=sum[i-1]+nums[i];
        }

        //先firstLen长度 后secondLen长度
        int maxSum=0;
        int res=0;
        for (int i=0;i<firstLen;i++){
            res+=nums[i];
        }
        maxSum=res+sum[firstLen+secondLen-1]-sum[firstLen-1];

        for (int j=firstLen;j< nums.length-secondLen;j++){

            res=Math.max(res,sum[j]-sum[j-firstLen]);//更新j来往右移 更新前面firstLen长度的最大值
            int after=sum[j+secondLen]-sum[j];
            maxSum=Math.max(maxSum,res+after);
        }

        //先secondLen长度 后firstLen长度
        res=0;
        for (int i=0;i<secondLen;i++){
            res+=nums[i];
        }
        for (int j=secondLen;j< nums.length-firstLen;j++){
            res=Math.max(res,sum[j]-sum[j-secondLen]);
            int after=sum[j+firstLen]-sum[j];
            maxSum=Math.max(maxSum,res+after);
        }

        return maxSum;


    }





    public static void main(String[] args) {

        int arr[]={0,6,5,2,2,5,1,9,4};
        int a=1;
        int b=2;

        p1031 t=new p1031();
        int res = t.maxSumTwoNoOverlap(arr, a, b);
        System.out.println(res);
    }
}
