package DFS;

/**
 * @ClassName: p200
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/10/8
 * @Time: 9:30
 * 计算岛屿数量
 */
public class p200 {

    public int row;
    public int col;
    public int res;

    public static int next[][] = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    /**
     * 从(x,y)这一点开始往下找
     *
     * @param x
     * @param y
     * @param grid
     */
    public void dfs(int x, int y, char[][] grid) {


        if (x < 0 || x >= row || y < 0 || y >= col || grid[x][y] != '1') return;
        else {
            //没有越界

            grid[x][y] = '0';
            for (int k = 0; k < 4; k++) {
                int nextX = x + next[k][0];
                int nextY = y + next[k][1];
                dfs(nextX, nextY, grid);
            }

        }
    }

    public int numIslands(char[][] grid) {

        row = grid.length;
        col = grid[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {

                if (grid[i][j] == '1') {
                    //遇到陆地开始寻找
                    dfs(i, j, grid);
                    res++;
                }
            }
        }

        return res;
    }
}
