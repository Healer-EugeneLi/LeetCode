package DP;

/**
 * @ClassName: p64
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/5/11
 * @Time: 18:36
 */
public class p64 {

    //每次只能向下 或者向右移动一步 求解在m*n的矩阵中，从左上角到达右下角的最短路径
    public int minPathSum(int[][] grid) {

        int m=grid.length;//行
        int n=grid[0].length;//列
        int dp[][]=new int[m][n];
        dp[0][0]=grid[0][0];
        //初始化第一行
        for (int i=1;i<n;i++){

            dp[0][i]=dp[0][i-1]+grid[0][i];//到达当前位置的最短路径等于前一个位置的dp值加上当前值
        }
        //初始化第一列
        for (int j=1;j<m;j++){
            dp[j][0]=dp[j-1][0]+grid[j][0];
        }

        for (int i=1;i<m;i++){
            for (int j=1;j<n;j++){

                //选择到达上方或者左方的点的最短的路径和 加上 当前点的值
                dp[i][j]=Math.min(dp[i-1][j],dp[i][j-1])+grid[i][j];
            }
        }
        return dp[m-1][n-1];

    }
}
