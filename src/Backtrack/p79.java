package Backtrack;

/**
 * @ClassName: p79
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/3/23
 * @Time: 14:45
 * 在一个m*n的矩阵中
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，
 * 其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 */
public class p79 {

    public boolean[][] used;
    public boolean exist(char[][] board, String word) {

        used=new boolean[board.length][board[0].length];

        for (int i=0;i<board.length;i++){
            for (int j=0;j<board[0].length;j++){

                //从每一个位置开始去搜索
                if (backTracking(board,used,i,j,0,word)==true)
                    return true;
            }
        }

        return false;

    }

    /**
     *
     * @param board
     * @param used
     * @param x 当前要遍历的字符的x坐标
     * @param y 当前要遍历的字符的y坐标
     * @param step 当前此次要判断的word的字符索引
     * @param word 判断的字符串
     * @return
     */
    public boolean backTracking(char [][] board,boolean[][] used,
                             int x,int y,int step,String word){

        //当搜索的步伐step=目标的长度的时候 说明我们上一步验证的时候索引step-1已经是word的最后一个字符的下标
        //他们已经一样了  所以符合要求 返回true
        if (word.length()==step){
            return true;
        }

        //先判断是否已经越界了
        //再判断是否有用过该字符
        //再判断如果没有用过该字符的话 那么当前这个字符是否等于目标字符串对应的step索引的字符
        if (x>=board.length||x<0||y>=board[0].length||y<0||
                used[x][y]==true||word.charAt(step)!=board[x][y])
            return false;

        //符合条件 这一个step索引到的字符是符合要求的

        used[x][y]=true;//标记为用过当前字符

        //遍历四个方向
        boolean result=
                backTracking(board,used,x,y+1,step+1,word)||
                backTracking(board,used,x+1,y,step+1,word)||
                backTracking(board,used,x,y-1,step+1,word)||
                backTracking(board,used,x-1,y,step+1,word);

        //当返回true的时候 说明找到了
        if (result==true) return true;

        //没有的话 恢复原先未使用该字符的状态
        used[x][y]=false;

        //没有找到
        return false;

    }

    public static void main(String[] args) {

//        char board[][]={
//                {'A','B','C','E'},
//                {'S','F','C','S'},
//                {'A','D','E','E'}
//        }
    }
}
