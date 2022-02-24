package DP;

/**
 * @ClassName: p62
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/2/24
 * @Time: 14:40
 */
public class p62 {

//    public int uniquePaths(int m, int n) {
//
//        int dp[][]=new int[m][n];
//        dp[0][0]=1;
//        for (int i=0;i<m;i++){
//            for (int j=0;j<n;j++){
//
//                if (i-1>=0&&j-1>=0)
//                    dp[i][j]=dp[i][j-1]+dp[i-1][j];
//                else if (i-1>=0){
//                    dp[i][j]=dp[i-1][j];
//                }else if (j-1>=0)
//                    dp[i][j]=dp[i][j-1];
//            }
//        }
//        return dp[m-1][n-1];
//    }

//    /**
//     * 写法2
//     * 到达dp[0][0]只有1种方法
//     *  第一行 第一列都是只有1种方法 dp[0][j]=1 dp[i][0]=1
//     *
//     *  其他的点都是从左方 和 上方得到 dp[i][j]=dp[i][j-1]+dp[i-1][j]
//     * @param m m行
//     * @param n n列
//     * @return
//     */
//    public int uniquePaths(int m, int n) {
//
//        int dp[][]=new int[m][n];
//
//        //对第一行初始赋值
//        for (int j=0;j<n;j++) dp[0][j]=1;
//        //对第一列初始赋值
//        for (int i=0;i<m;i++) dp[i][0]=1;
//
//        //从(1,1) 开始即可 此时不需要很多的判断 因为接下去的所有的网格点都是从上方或者左方过来
//        for (int i=1;i<m;i++){
//            for (int j=1;j<n;j++)
//                dp[i][j]=dp[i-1][j]+dp[i][j-1];
//        }
//        return dp[m-1][n-1];
//    }


    /**
     * 二维可以转成1维数组来做 因为只跟上方 左方的数据相关
     * 因此可以设置两重循环 外层循环为n长度 即列长度大小 初始数组全为1 内层为行数 即需要更新m行
     * 然后每次到达当前行的时候 将左边加过来的数据 直接加到当前这个dp[i]位置
     * dp[i]+=dp[i-1]
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {

        int dp[]=new int[n];

        for (int j=0;j<n;j++) dp[j]=1;
        for (int i=1;i<m;i++){//总的有m行 因为第一行已经赋值好了 所以从i=1行开始
            for (int j=1;j<n;j++){
                dp[j]+=dp[j-1];
            }

        }

        return dp[n-1];
    }
    public static void main(String[] args) {

        int m=3,n=7;
        p62 t=new p62();
        int res = t.uniquePaths(m, n);
        System.out.println(res);
    }
}
