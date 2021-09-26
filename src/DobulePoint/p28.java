package DobulePoint;

/**
 * @ClassName: p28
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/9/20
 * @Time: 21:20
 *
 * 寻找子串
 * haystack = "hello", needle = "ll"
 * 输出 2
 */
public class p28 {

    public int strStr(String haystack, String needle) {

        if (needle.equals("")) return 0;
        int j=0;
        for (int i=0;i<haystack.length();i++){
            if (haystack.charAt(i)==needle.charAt(j)){
                j++;//继续寻找下一个
                if (j==needle.length()){
                    //已经满足了
                    return i-needle.length()+1;
                }
            }else{
                i=i-j;//回到原先的位置 让i往下走
                j=0;
            }

        }
        return -1;

    }
}
