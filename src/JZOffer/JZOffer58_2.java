package JZOffer;

/**
 * @ClassName: JZOffer58_2
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/1/16
 * @Time: 22:21
 */
public class JZOffer58_2 {

    /**
     * 左旋转字符串
     *
     * @param s
     * @param n
     * @return
     */
    public String reverseLeftWords(String s, int n) {


        char resChars[] = new char[s.length()];
        char[] chars = s.toCharArray();
        //对于index位置的字符 其左旋转n之后 其位置为  (  index-n+s.length() )% s.length()
        for (int i = 0; i < chars.length; i++) {
            int pos = (i - n+ s.length() ) % s.length();
            resChars[pos] = chars[i];//把当前字符 放入它旋转之后该放入的位置
        }

        String res = String.valueOf(resChars);
        return res;

    }

    public static void main(String[] args) {

        String s = "abcdefg";
        int n = 2;
        JZOffer58_2 t = new JZOffer58_2();

        String s1 = t.reverseLeftWords(s, n);
        System.out.println(s1);

        String result = "";
        for (int i = n; i < n + s.length(); i++) {
            result += s.charAt(i % s.length());
        }
        System.out.println(result);
    }
}
