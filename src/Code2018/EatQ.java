package Code2018;

import java.util.Scanner;

/**
 * @ClassName: EatQ
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/10/7
 * @Time: 21:33
 */
public class EatQ {



    public static int n;//出差天数
    public static int m;//巧克力

    /**
     * 第一天吃s块 最后总的多少
     * @param s
     */
    public static int sumStartWithS(int s){

        int sum=0;
        for (int i=1;i<=n;i++){
            sum+=s;
            s=((s+1)>>1);//奇数的话 向上取整 偶数原先的一半
        }
        return sum;
    }
    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);

        n=scanner.nextInt();
        m=scanner.nextInt();
        if (n==1) {
            System.out.println(m);
            return;
        }

        int low=1;
        int high=m;//m块
        int resultWithS=0;
        int mid=0;
        while (low<high){

            mid=(low+high+1)/2;
            resultWithS=sumStartWithS(mid);
            if (resultWithS==m){
                System.out.println(mid);
                return;
            }else if (resultWithS<m){
                low=mid;//表示还有剩巧克力 让low=start 选大一点的 如果设置成mid+1 会有可能跳过答案
            }else {
                high=mid-1;//大于总的巧克力 说明第一天吃的巧克力太多 选小一点
            }

        }


        System.out.println(low);

    }
}
