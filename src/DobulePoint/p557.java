package DobulePoint;

/**
 * @ClassName: p557
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/9/19
 * @Time: 22:21
 */
public class p557 {

//    public void reverseString(char[] s) {
//
//
//        int length=s.length;
//        if (length==0||length==1) return;
//        int left=0,right=length-1;
//
//        while (left<right){
//
//            char temp=s[right];
//            s[right]=s[left];
//            s[left]=temp;
//
//            right--;
//            left++;
//        }
//    }
//
//    public String reverseWords(String s) {
//
//        if (s==null) return s;
//        String result="";
//        String[] res = s.split(" ");
//        for (int i=0;i<res.length;i++){
//            String temp=res[i];
//            char[] chars = temp.toCharArray();
//            this.reverseString(chars);
//            if (i!=res.length-1)
//                result+=String.valueOf(chars)+" ";
//            else
//                result+=String.valueOf(chars);
//
//
//        }
//        return result;
//
//    }


    public String reverseWords(String s) {

        int i = 0;
        int length = s.length();
        StringBuffer result = new StringBuffer();
        while (i < length) {

            int left = i;
            while (i < length && s.charAt(i) != ' ') {
                i++;
            }

            //开始交换
            int right = i - 1;
            for (int p = left; p <= right; p++) {
                result.append(s.charAt(left + right - p));//要记得+left 这样才会在下一个单词中找到正确的位置
            }
            while (i < length && s.charAt(i) == ' ') {
                i++;
                result.append(' ');
            }
        }

        return result.toString();

    }
}
