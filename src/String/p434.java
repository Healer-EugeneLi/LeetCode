package String;

/**
 * @ClassName: p434
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/10/7
 * @Time: 8:57
 * ", , , ,        a, eaefa"
 */
public class p434 {

    public static int countSegments(String s) {

        if (s.equals("")) return 0;
        String[] strings = s.split(" ");
        int count=0;
        for (String a:strings){
            if (!a.equals("")){
                System.out.println(a);
                count++;
            }

        }


        return count;

    }

    public static void main(String[] args) {

        String t=" ";
        int res = countSegments(t);
        System.out.println(res);

    }
}
