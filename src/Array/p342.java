package Array;

/**
 * @ClassName: p342
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/9/23
 * @Time: 10:13
 */
public class p342 {
    public boolean isPowerOfFour(int n) {

        while (n > 0 && n % 4 == 0) {
            n /= 4;
        }
        return n == 1;

    }
}
