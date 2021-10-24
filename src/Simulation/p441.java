package Simulation;

/**
 * @ClassName: p441
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/10/13
 * @Time: 11:20
 */
public class p441 {

//    public int arrangeCoins(int n) {
//
//        if (n==1) return 1;
//
//        int target=1;
//        int sum=1;
//        int count=0;
//
//        for (int i=1;i<=n;){
//
//            if (i==sum){
//                count++;
//                target++;//上一轮需要的金币数++ =下一轮
//                //那么下一轮总的就是要
//                sum=sum+target;
//            }
//            i+=target;
//        }
//        return count;
//
//    }

    public int arrangeCoins(int n) {


        return (int)(-1+Math.sqrt(8.0*n+1))/2;


    }

    public static void main(String[] args) {

        int n=8;
        p441 t=new p441();
        int res = t.arrangeCoins(n);
        System.out.println(res);
    }
}
