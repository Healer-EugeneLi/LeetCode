package JZOffer;

/**
 * @ClassName: JZOffer64
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/2/13
 * @Time: 20:56
 */
public class JZOffer64 {

//    public int sumNums(int n) {
//
//        int res=n;
//        boolean flag=n>0&&(res+=sumNums(n-1))>0;
//        return res;
//
//    }

    /**
     * 对递归写法进行转换
     * @param n
     * @return
     */
    public int sumNums(int n){

        boolean res=(n>0)&&(n+=sumNums(n-1))>0;
        return  n;
    }

    /**
     * 递归写法
     * @param n
     * @return
     */
    public int recur(int n){

        if (n==1) return 1;
        return recur(n-1)+n;
    }

}
