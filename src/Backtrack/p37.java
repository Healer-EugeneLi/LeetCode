package Backtrack;

import java.util.Arrays;

/**
 * @ClassName: p37
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/3/29
 * @Time: 10:52
 */
public class p37 {

    public void solveSudoku(char[][] board) {


        backTracking(board);

    }

    /**
     * 找到结果的时候返回true 得到结果了
     * @param board
     * @return
     */
    public boolean backTracking(char[][] board){

        //需要每一行每一列进行判断
        for (int row = 0; row < board.length; row++) {

            for (int col = 0; col < board[0].length; col++) {

                if (board[row][col]!='.') continue;//存在数的话 不需要填充
                //对其进行1~9的填充来判断
                for (char value='1';value<='9';value++){
                    if (isValid(board,row,col,value)){

                        board[row][col]=value;
                        if (backTracking(board)) return true;
                        board[row][col]='.';

                    }
                }
                //如果1~9都试过了还是不行 说明这种情况已经不行了 返回false进行回溯
                return false;
            }

        }
        return true;


    }

    /**
     * 判断[rol][]这个位置存放value是否合法
     * @param board
     * @param row
     * @param col
     * @param value
     * @return
     */
    private boolean isValid(char[][] board, int row, int col, char value) {

        //判断同一行是否重复
        for (int j = 0; j < 9; j++) {
            if (board[row][j]==value) return false;
        }

        //判断同一列是否重复
        for (int i=0;i<9;i++){
            if (board[i][col]==value) return false;
        }

        //判断所属的9宫格位置是否重复
        int startRow=(row/3)*3;
        int startCol=(col/3)*3;
        for (int i=startRow; i <startRow+3 ; i++) {
            for (int j = startCol; j < startCol+3; j++) {

                if (board[i][j]==value)
                    return false;
            }

        }
        return true;
    }
}
