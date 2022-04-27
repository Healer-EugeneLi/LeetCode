package JZOffer;

/**
 * @ClassName: JZOffer05
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/11/25
 * @Time: 22:17
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 */
public class JZOffer05 {
//    public String replaceSpace(String s) {
//
//        char[] chars = s.toCharArray();
//        String res = "";
//
//        for (int i = 0; i < chars.length; i++) {
//            if (chars[i] == ' ')
//                res += "%20";
//            else
//                res += chars[i];
//        }
//        return res;
//
//    }

    public String replaceSpace(String s) {

        char[] chars = s.toCharArray();
       StringBuilder res=new StringBuilder();

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ')
                res.append("%20");
            else
                res.append(chars[i]);
        }
        return res.toString();

    }
}
