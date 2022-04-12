package DobulePoint;

/**
 * @ClassName: p680
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/4/10
 * @Time: 15:19
 * 最多删除一个字符 判断其是否可以成为回文字符串
 */
public class p680 {


    /**
     * 通过设置双指针 left  right 分别从字符串的两边往中间进行移动 当两个指针指向的字符一样的时候 继续往中间移动
     * 如果两个字符不一样的时候 考虑两种情况
     * 让left指针往中间进行移动一个位置 right不变 进行判断后面组成的字符串是不是回文串
     * 让right指针往中间进行移动一个位置 left不变 进行判断
     * @param s
     * @return
     */
    public boolean validPalindrome(String s) {

        int left=0,right=s.length()-1;

        while (left<right){

            //碰到字符不相等的情况
            if (s.charAt(left)!=s.charAt(right)){
                return isPalindrome(s,left+1,right)||isPalindrome(s,left,right-1);
            }

            //字符相等的情况
            left++;
            right--;
        }
        return true;
    }

    /**
     * 在字符串s中 子串[i,j]是否构成一个回文串
     * @param s
     * @param i
     * @param j
     * @return
     */
    public boolean isPalindrome(String s,int i,int j){

        while (i<j){
            if (s.charAt(i)!=s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}
