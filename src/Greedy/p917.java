package Greedy;

/**
 * @ClassName: p917
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/9/29
 * @Time: 22:10
 */
public class p917 {

    public int findMinMoves(int[] machines) {

        int total=0;
        for (int m:machines)
            total+=m;
        int n=machines.length;

        if (total%n!=0) return -1;

        int ans=0;
        int sum=0;//记录A 与 B 两组之间需要移动的次数
        int avg=total/n;
        for (int num:machines){
            num-=avg;//num实际就是组内移动
            sum+=num;//左边与右边 组间移动
            ans=Math.max(ans,Math.max(num,Math.abs(sum)));

        }
        return ans;
    }
}
