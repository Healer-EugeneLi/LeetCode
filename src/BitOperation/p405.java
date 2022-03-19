package BitOperation;

/**
 * @ClassName: p405
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/10/2
 * @Time: 21:58
 */
public class p405 {

    public String toHex(int num) {

        if (num == 0) return "0";

        long a = num;
        if (a < 0) a = (long) Math.pow(2, 32) + a;

        String res = "";
        while (a != 0) {

            long temp = a % 16;
            char c = (char) (temp + '0');
            if (temp >= 10)
                c = (char) (temp - 10 + 'a');
            res += c;
            a /= 16;
        }

        return new StringBuffer(res).reverse().toString();

    }
}
