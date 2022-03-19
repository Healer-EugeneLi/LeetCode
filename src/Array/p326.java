package Array;

/**
 * @ClassName: p326
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/9/23
 * @Time: 9:42
 */
public class p326 {
    //如果n是3的整数幂  必然可以一直除以3  最后等于1
    public boolean isPowerOfThree(int n) {

        while (n != 0 && n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }

}
