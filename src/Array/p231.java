package Array;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: p231
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/9/23
 * @Time: 9:59
 */
public class p231 {
//    public boolean isPowerOfTwo(int n) {
//
//        while (n!=0&&n%2==0){
//            n/=2;
//        }
//        return n==1;
//
//    }


    public boolean isPowerOfTwo(int n) {

        return n>0&&1073741824%n==0;

    }

    public static void main(String[] args) {


//        int res=1;
//        List list=new ArrayList();
//        while (res<Math.pow(2,31)-1){
//            res=res*2;
//            System.out.println(res);
//
//        }
        int n=1;
        for (int i=0;i<16;i++){
            n*=4;
            System.out.println(n);
        }

    }
}
