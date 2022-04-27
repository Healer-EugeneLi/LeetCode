package Recursion;

/**
 * @ClassName: Multi
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/4/27
 * @Time: 10:31
 */
public class Multi {


    public int recur(int a,int b){
        if (a==0||b==0) return 0;
        if (a==1)
            return b;
        return recur(a-1,b)+b;
    }
    public static void main(String[] args) {

        Multi multi=new Multi();
        int res = multi.recur(2, 1);
        System.out.println(res);
    }
}
