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



    public int res=0;

    /**
     * 输入：grid = [
     *   ["1","1","1","1","0"],
     *   ["1","1","0","1","0"],
     *   ["1","1","0","0","0"],
     *   ["0","0","0","0","0"]
     * ]
     * 输出：1
     岛屿的数量
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {

        for (int i=0;i<grid.length;i++){
            for (int j=0;j<grid[0].length;j++){

                //遇到一个岛屿就去寻找搜索 然后在搜索的过程中就将找过的设置为0 这样一个dfs回来之后就说明找到一个大岛屿了 数量+1
                if (grid[i][j]=='1'){

                    dfs(grid,i,j);
                    res++;
                }
            }
        }

        return res;
    }


    /**
     * 遍历到(x,y)这一点了
     * @param grid
     * @param x
     * @param y
     */
    public void dfs(char[][] grid,int x,int y){

        //越界 或者不是岛屿
        if (x<0||x>=grid.length||y<0||y>=grid[0].length||grid[x][y]!='1')
            return;

        grid[x][y]=0;//遍历过直接设置为0
        //继续往四个方向遍历
        dfs(grid,x,y+1);//右
        dfs(grid,x+1,y);//下
        dfs(grid,x,y-1);//左
        dfs(grid,x-1,y);//上
    }

}
