package Listnode;

/**
 * @ClassName: p67
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/9/21
 * @Time: 20:25
 */
public class p67 {

    public String addBinary(String a, String b) {

        //让a 指向短的字符串
        if (b.length() < a.length())
            return addBinary(b, a);

        StringBuffer bufferA = new StringBuffer(a);
        StringBuffer reverseA = bufferA.reverse();

        StringBuffer bufferB = new StringBuffer(b);
        StringBuffer reverseB = bufferB.reverse();

        StringBuffer res = new StringBuffer();

        int sum = 0, add = 0, value;
        int i = 0;
        //这样a指向的就是短的字符串  b指向的是长的字符串
        for (i = 0; i < a.length(); i++) {

            int a1 = reverseA.charAt(i) - '0';
            int b1 = reverseB.charAt(i) - '0';
            sum = a1 + b1 + add;
            value = sum % 2;
            add = sum / 2;
            res.append(value);
        }
        //b还没遍历完
        for (int j = i; j < b.length(); j++) {
            int b2 = reverseB.charAt(j) - '0';
            sum = b2 + add;
            value = sum % 2;
            add = sum / 2;
            res.append(value);
        }
        if (add != 0)
            res.append(add);

        return new String(res.reverse());

    }

    public static void main(String[] args) {
        p67 p67 = new p67();
        String s = p67.addBinary("11", "1");
        System.out.println(s);
    }
}
