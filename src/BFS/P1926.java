package BFS;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName: P1926
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/9/23
 * @Time: 17:08
 */
public class P1926 {

//    int visited[][]=new int[102][102];
//    char[][] MAZE=new char[102][102];
//    int min=-1;
//    int dx[]={1,0,-1,0};
//    int dy[]={0,1,0,-1};//右下左上
//    void dfs(int x,int y,int step){
//
//        //边界条件 遇到墙
//        if (MAZE[x][y]=='0'){
//            if (step-1==0) return;
//            min = min == -1 ? step-1 : Math.min(min,step-1);
//            return;
//        }
//        if (MAZE[x][y]=='+'||visited[x][y]==1) return;
//
//        visited[x][y]=1;
//        //继续往四周寻找
//        for (int k=0;k<4;k++){
//
//            int nextX=x+dx[k];
//            int nextY=y+dy[k];
//            if (MAZE[nextX][nextY] == '.'&&visited[nextX][nextY]==0) {
//                dfs(nextX,nextY,step+1);//往下走
//            }
//
//        }
//        visited[x][y]=0;
//    }
//    public int nearestExit(char[][] maze, int[] entrance) {
//
//        //初始化值
//        for (int i=0;i<102;i++){
//            for (int j=0;j<102;j++){
//                MAZE[i][j]='0';
//            }
//        }
//
//        //赋值真正的信息
//       for (int i=1;i<=maze.length;i++){
//           for (int j=1;j<=maze[i-1].length;j++){
//               MAZE[i][j]=maze[i-1][j-1];
//           }
//       }
//
//       int startX=entrance[0]+1,startY=entrance[1]+1;
////       visited[startX][startY]=1;
//       dfs(startX,startY,0);
//
//      return min;
//
//
//    }

    class Point {

        int x, y, step;//step为入口到当前点的步数

        public Point(int x, int y, int step) {
            this.x = x;
            this.y = y;
            this.step = step;
        }
    }

    public int nearestExit(char[][] maze, int[] entrance) {
        return bfs(maze, entrance[0], entrance[1]);
    }

    private int bfs(char[][] maze, int i, int j) {
        int dx[] = {1, 0, -1, 0};
        int dy[] = {0, 1, 0, -1};//下右上左

        Queue<Point> queue = new LinkedList();
        queue.offer(new Point(i, j, 0));

        int row = maze.length;
        int col = maze[0].length;
        maze[i][j] = '+';//标记已经访问过

        while (!queue.isEmpty()) {

            Point poll = queue.poll();
            //不为入口 且是边界
            if (!(poll.x == i && poll.y == j) && (poll.x == 0 || poll.x == row - 1 || poll.y == 0 || poll.y == col - 1)) {
                return poll.step;//因为使用的是bfs所以找到的肯定是答案
            }
            //枚举四个方向
            for (int k = 0; k < dx.length; k++) {

                int nextX = poll.x + dx[k];
                int nextY = poll.y + dy[k];
                //没越界 且没有访问过
                if (nextX >= 0 && nextX < row && nextY >= 0 && nextY < col && maze[nextX][nextY] == '.') {
                    queue.offer(new Point(nextX, nextY, poll.step + 1));
                    maze[nextX][nextY] = '+';//标记为已访问过
                }
            }
        }

        return -1;

    }


    public static void main(String[] args) {
        char[][] chars = {
                {'+', '+', '.', '+'}, {'.', '.', '.', '+'}, {'+', '+', '+', '.'},
        };

        P1926 t = new P1926();
        int res = t.nearestExit(chars, new int[]{1, 2});
        System.out.println(res);
    }
}


//class Solution {
//    public int res = -1;
//    public void dfs(char[][] maze,int row,int col,int curX,int curY,int dis,boolean[][] visited){
//        if(curX < 0 || curY < 0 || curX>=row || curY>=col){
//            if(dis-1 == 0)
//                return;
//            res = res == -1 ? dis-1 : Math.min(res,dis-1);
//            return;
//        }
//        if(maze[curX][curY] == '+' || visited[curX][curY] == true)
//            return;
//
//        visited[curX][curY] = true;
//        dfs(maze,row,col,curX+1,curY,dis+1,visited);
//        dfs(maze,row,col,curX-1,curY,dis+1,visited);
//        dfs(maze,row,col,curX,curY+1,dis+1,visited);
//        dfs(maze,row,col,curX,curY-1,dis+1,visited);
//        visited[curX][curY] = false;
//    }
//
//
//
//    public int nearestExit(char[][] maze, int[] entrance) {
//        int row = maze.length;
//        int col = maze[0].length;
//        res = -1;
//        boolean[][] visited = new boolean[row][col];
//        dfs(maze,row,col,entrance[0],entrance[1],0,visited);
//
//        return res;
//    }
//}
