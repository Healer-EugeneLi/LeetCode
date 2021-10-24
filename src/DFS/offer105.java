package DFS;

/**
 * @ClassName: offer105
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/10/8
 * @Time: 10:48
 */
public class offer105 {

    public  int row;
    public  int col;
    public  int max;
    public  int count;

    public void dfs(int x,int y,int[][] grid){

        if (x<0||x>=row||y<0||y>=col||grid[x][y]!=1) return ;

        count++;
        grid[x][y]=0;

        dfs(x,y+1,grid);
        dfs(x+1,y,grid);
        dfs(x,y-1,grid);
        dfs(x-1,y,grid);

    }

    public int maxAreaOfIsland(int[][] grid) {


        row=grid.length;
        col=grid[0].length;
        for (int i=0;i<row;i++){
            for (int j=0;j<col;j++){

                if (grid[i][j]==1){
                    count=0;
                    dfs(i,j,grid);
                    max=Math.max(max,count);

                }
            }
        }

        return max;
    }
}
