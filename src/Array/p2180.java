package Array;

/**
 * @ClassName: p2180
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/2/27
 * @Time: 11:48
 * 输入：num = 30
 * 输出：14
 * 解释：
 * 只有 14 个整数满足小于等于 30 且各位数字之和为偶数，分别是：
 * 2、4、6、8、11、13、15、17、19、20、22、24、26 和 28 。
 *

 */
public class p2180 {


//    public int countEven(int num) {
//
//        int count=0;
//        for (int i=1;i<=num;i++){
//
//            if (getSum(i)==true)
//                count++;
//        }
//        return count;
//    }
//
//    public boolean getSum(int a){
//
//        int sum=0;
//        while (a!=0){
//            sum+=a%10;
//            a/=10;
//        }
//        if (sum%2==0) return true;
//        return false;
//    }

    public int countEven(int num) {

        if (num<10)
            return num/2;
        else {

            int count=0;
            int first=num/10;
            int last=num%10;
            count=first*5-1;

            //求出剩下各位数和
            int sum=0;
            while (first!=0){

                sum+=first%10;
                first/=10;
            }

            if (sum%2==0){
                count+=(last/2+1);
            }
            else
                count+=(last+1)/2;
            return count;

        }


    }


}
