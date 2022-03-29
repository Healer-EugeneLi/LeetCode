package Backtrack;

import jdk.nashorn.internal.codegen.FieldObjectCreator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: p51
 * @Description: n皇后问题
 * @Author EugeneLi
 * @Date: 2022/3/29
 * @Time: 10:24
 */
public class p51 {
    public List<List<String>> res=new ArrayList<>();

    public char[][] board;
    public List<List<String>> solveNQueens(int n) {

        board=new char[n][n];//棋盘 一开始全是 '.'
        for (char[] c:board)
            Arrays.fill(c,'.');
        backTracking(n,0,board);
        return res;


    }

    /**
     *
     * @param n 总的棋盘大小
     * @param row 当前到达进行判断的棋盘行数
     * @param board
     */
    public void backTracking(int n,int row,char[][] board){

        //row即深度 已经到达n说明可以收集结果了
        if (row==n){
            List<String> s=new ArrayList<>();
//            for (int i=0;i<board.length;i++){
//                String temp="";
//                for (int j=0;j<board.length;j++){
//                    temp+=board[i][j];
//                }
//                s.add(temp);
//            }
            for (char c[]:board)
                s.add(String.copyValueOf(c));
            res.add(s);
            return;
        }

        //每一次都是从最左边的列开始 所以col都从0开始进行遍历
        for (int col = 0; col<n ; col++) {

            //满足条件 则进入下一层
            if (isValid(board,row,col)){

                board[row][col]='Q';
                backTracking(n,row+1,board);
                board[row][col]='.';

            }
        }

    }

    /**
     * 判断在棋盘中的[row][col]放置q是否符合条件
     * 不能在同一列 因为是从上往下搜索的 只需要判断自己前面的那些行对应的列就行
     * 不能同一行 因为回溯的时候就是对当前每一行知取一个 无须考虑这个问题
     * 不同同一个斜线 即不能在当前元素的左上角 或者右下角
     * @param board
     * @param row
     * @param col
     * @return
     */
    private boolean isValid(char[][] board, int row, int col) {

        //先进行判断不能在同一个列
        for(int i=0;i<row;i++){
            if (board[i][col]=='Q')
                return false;
        }

        //不能在左上角的斜线
        for(int i=row-1, j=col-1;i>=0&&j>=0;i--,j--){
            if (board[i][j]=='Q')
                return false;
        }

        //不能在右上角的斜线
        for (int i=row-1,j=col+1;i>=0&&j<board.length;i--,j++){
            if (board[i][j]=='Q')
                return false;
        }
        return true;
    }
}
