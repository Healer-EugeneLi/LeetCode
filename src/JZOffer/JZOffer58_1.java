package JZOffer;

/**
 * @ClassName: JZOffer58_1
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/1/16
 * @Time: 21:42
 */
public class JZOffer58_1 {
    public String reverseWords(String s) {

        //先遍历s 把其中的空格去掉
        String[] strings = s.split(" ");
        String res="";

        for (int i=strings.length-1;i>=0;i--){

            if (strings[i].equals("")) continue;
            res+=strings[i]+" ";
        }

        return res.trim();


    }

    public static void main(String[] args) {

        String s ="a good   example";

        JZOffer58_1 t=new JZOffer58_1();
        String res = t.reverseWords(s);
        System.out.println(res);
//        String[] s1 = s.split(" ");
//        System.out.println(s1);

    }
}
