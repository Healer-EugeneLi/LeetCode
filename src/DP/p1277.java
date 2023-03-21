package DP;

/**
 * @ClassName: p1277
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/5/9
 * @Time: 21:10
 */
public class p1277 {


    /**
     * 统计全为1的正方形子矩阵
     * @param matrix
     * @return
     */
    public int countSquares(int[][] matrix) {


        int m=matrix.length;
        int n=matrix[0].length;

        int dp[][]=new int[m][n];
        //dp[i][j] 表示以(i,j)为右下角的正方形的最大边长，dp[i][j]=x 也表示长度分别为1 2 ...x 的正方形包含了这个位置 每个长度刚好都有1个
        //转移方程 dp[i][j]=min(dp[i][j-1],dp[i-1][j],dp[i-1][j-1])+1 比如min(1,1,1)=1 =2 刚好在一个3x3的正方形矩阵
        //(i,j)这个位置左边 上边 左上角 都是1 而且他们没有办法与其他位置构成更大的矩形 所以1+1=2 i j 这个位置就能够组成最大边长为2的
        //边界条件 i==0 或者 j==0 dp[i][j]=matrix[i][j] 也就是该位置为1的时候 就是只能最大边长为1 该位置为0的时候 最大边长为0
        //遇到位置为0的 那直接就是0了

        int ans=0;
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){

                //最上面一行 最左边一列
                if(i==0||j==0)
                    dp[i][j]=matrix[i][j];
                else if(matrix[i][j]==0)//该位置为0的时候 直接就是结果为0
                    dp[i][j]=0;
                else
                    dp[i][j]=Math.min( Math.min(dp[i][j-1],dp[i-1][j]) ,dp[i-1][j-1])+1;
                ans+=dp[i][j];//遍历每个点 将其所能围成的正方形个数 累加起来

            }
        }
        return ans;
    }
}
