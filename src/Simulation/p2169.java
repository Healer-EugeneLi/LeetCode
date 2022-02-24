package Simulation;

/**
 * @ClassName: p2169
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/2/20
 * @Time: 11:52
 *
 * 模拟 两个数相减得到0的操作次数
 */
public class p2169 {

//    public int countOperations(int num1, int num2) {
//        if (num1==0||num2==0) return 0;
//        if (num1-num2==0) return 1;
//
//        int count=0;
//        while (Math.abs(num1-num2)!=0){
//
//            if (num1>num2){
//                num1-=num2;
//            }else {
//                num2-=num1;
//            }
//            count++;
//        }
//        return ++count;
//    }

//    public int countOperations(int num1, int num2) {
//
//        int count=0;
//        while (num1!=0&&num2!=0){
//
//            if (num1>num2){
//                num1/=num2;
//            }else {
//                num2-=num1;
//            }
//            count++;
//        }
//        return count;
//    }


    /**
     * 辗转相除法 求解
     * @param num1
     * @param num2
     * @return
     */
    public int countOperations(int num1, int num2) {

        int count=0;
        while (num1!=0&&num2!=0){

            //不必保证num1需要大于num2 因为进入第一次循环之后 就可以翻转一下两个数了 此时count+=0 不贡献次数
           count+=num1/num2;
           num1%=num2;
           int temp=num1;
           num1=num2;
           num2=temp;
        }
        return count;
    }
    public static void main(String[] args) {
        p2169 t=new p2169();
        int res = t.countOperations(2, 3);
        System.out.println(res);
    }
}
