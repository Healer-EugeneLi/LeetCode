package JZOffer;

/**
 * @ClassName: JZOffer47
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/4/27
 * @Time: 22:27
 * 在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。
 * 你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。
 * 给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
 */
public class JZOffer47 {

    public int maxValue(int[][] grid) {

        //从左上角移动到右下角  找到一条路径的最大值
        //令dp[i][j]表示从(0,0)这一点到达(i,j)这一点的当前最大路径和
        //那么转移方程即为dp[i][j]=max(dp[i-1][j],dp[i][j-1])+grid[i][j] 也就是从上一行或者左边这一列的值选择最大 再到到达当前这个点

        //为了不用考虑越界问题 选择创建dp数组的时候可以多创建一行一列 让dp[1][1]表示的是(0,0)这一点的值
        int row=grid.length;
        int col=grid[0].length;
        int dp[][]=new int[row+1][col+1];
        for (int i=1;i<=row;i++){
            for (int j=1;j<=col;j++){

                dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1])+grid[i-1][j-1];//记得这边的下标记得减去1 因为（1,1）实际是坐标(0,0)上的值
            }
        }
        return dp[row][col];

    }
}
