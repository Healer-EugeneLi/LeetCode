package DobulePoint;

/**
 * @ClassName: p344
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/9/19
 * @Time: 22:15
 */
public class p344 {
    public void reverseString(char[] s) {


        int length=s.length;
        if (length==0||length==1) return;
        int left=0,right=length-1;

        while (left<right){

            char temp=s[right];
            s[right]=s[left];
            s[left]=temp;

            right--;
            left++;
        }
    }
}
