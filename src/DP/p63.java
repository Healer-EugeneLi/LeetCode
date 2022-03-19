package DP;

/**
 * @ClassName: p63
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/2/24
 * @Time: 15:26
 */
public class p63 {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {


//        if (obstacleGrid[0][0]==1) return 0;
        int m = obstacleGrid.length;//行
        int n = obstacleGrid[0].length;//列
        int dp[][] = new int[m][n];

        //先对第一行赋值1 但是需要注意遇到障碍物之后 接下去的值肯定都是0 因为无法可达
        for (int j = 0; j < n && obstacleGrid[0][j] == 0; j++) {
            dp[0][j] = 1;
        }

        //先对第一列赋值1
        for (int i = 0; i < m && obstacleGrid[i][0] == 0; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {

                //遇到障碍物的时候 设置dp值为0 表示无法到达这个位置 这个位置不行 行不通
                if (obstacleGrid[i][j] == 1)
                    dp[i][j] = 0;
                else
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];

    }
}
