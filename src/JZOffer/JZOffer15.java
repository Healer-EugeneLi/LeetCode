package JZOffer;

/**
 * @ClassName: JZOffer15
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/11/25
 * @Time: 22:36
 * 统计无符号数的1的个数
 */
public class JZOffer15 {
    public int hammingWeight(int n) {

        int res = 0;
        while (n != 0) {

            res += n & 1;
            n >>>= 1;//无符号右移1位
        }
        return res;

    }
}
