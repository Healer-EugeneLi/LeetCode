package DobulePoint;

/**
 * @ClassName: p917
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/2/23
 * @Time: 21:46
 */
public class p917 {





//    /**
//     * 双指针翻转 字母
//     * @param s
//     * @return
//     */
//    public String reverseOnlyLetters(String s) {
//
////        s = "Test1ng-Leet=code-Q!"
//        char[] chars = s.toCharArray();
//
//        int left=0,right=chars.length-1;
//
//        while (left<right){
//
//            char a=chars[left];
//            char b=chars[right];
//
//            //两个都是字母 交换
//            if (check(a)&&check(b)){
//                char temp=a;
//                chars[left++]=b;
//                chars[right--]=temp;
//            }else if (check(a)){
//                //只有左边这个是字母 那么右边指针左移
//                right--;
//            }else if (check(b)){
//                //只有右边这个是字母 那么左边指针右移
//                left++;
//            }else {
//                //都不是字母
//                left++;
//                right--;
//            }
//
//        }
//        return String.valueOf(chars);
//    }
//
//    public boolean check(char c){
//
//        if ((c>='a'&&c<='z')||(c>='A'&&c<='Z'))
//            return true;
//        return false;
//    }


    /**
     * 双指针 优雅写法
     * @param s
     * @return
     */
    public String reverseOnlyLetters(String s) {


        char[] chars = s.toCharArray();

        int left=0,right=chars.length-1;

        while (left<right){

            //从左边开始遍历 直到遇到字母
            while (left<right&&!Character.isLetter(chars[left])) left++;

            //从右边开始往左遍历 直到遇到字母
            while (left<right&&!Character.isLetter(chars[right])) right--;

            if (left<right){
                //进行交换
                char temp=chars[left];
                chars[left++]=chars[right];
                chars[right--]=temp;
            }

        }

        return String.valueOf(chars);
    }

    public static void main(String[] args) {

        String s="Test1ng-Leet=code-Q!";
        p917 t=new p917();
        String res = t.reverseOnlyLetters(s);
        System.out.println(res.toString());
    }
}
