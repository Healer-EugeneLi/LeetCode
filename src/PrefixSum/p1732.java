package PrefixSum;

/**
 * @ClassName: p1732
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/3/18
 * @Time: 23:05
 */
public class p1732 {


    int res=0;
    int curSum=0;

    public int largestAltitude(int[] gain) {


        for (int g:gain){
            curSum+=g;//当前海拔高度
            res=Math.max(curSum,res);
        }
        return res;
    }
}
