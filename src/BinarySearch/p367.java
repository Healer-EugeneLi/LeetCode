package BinarySearch;

/**
 * @ClassName: p367
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/11/4
 * @Time: 21:23
 */
public class p367 {

    public boolean isPerfectSquare(int num) {

        int left=0,right=num,mid=0;
        while (left<=right){
            mid=left+((right-left)>>1);

            long ans=(long) mid*mid;
            if (ans<num){
                left=mid+1;
            }else if (ans>num){
                right=mid-1;
            }else
                return true;

        }
        return false;

    }

    public static void main(String[] args) {

        p367 t=new p367();
        boolean res = t.isPerfectSquare(2147483647);
        System.out.println(res);
    }
}
