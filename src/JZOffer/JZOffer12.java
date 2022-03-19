package JZOffer;

/**
 * @ClassName: JZOffer12
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/1/21
 * @Time: 12:37
 */
public class JZOffer12 {


    public boolean exist(char[][] board, String word) {

        boolean result = false;
        //因为字符串有可能只是其中字符矩阵里的某一部分 所以需要将矩阵中存在的字符串逐个作为开头

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {

                result = dfs(board, i, j, word, 0);
                if (result == true) return true;
            }
        }

        return false;

    }


    /**
     * @param board         矩阵
     * @param i             当前位置行索引i
     * @param j             当前位置列索引j
     * @param word          目标字符串
     * @param currentLength 当前已经匹配到的长度
     * @return
     */
    public boolean dfs(char[][] board, int i, int j, String word, int currentLength) {

        //不符合条件
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(currentLength))
            return false;
        //匹配成功
        if (currentLength == word.length() - 1) return true;

        board[i][j] = '\0';

        //继续dfs 从4个方向 右 下 左 上

        boolean res = dfs(board, i, j + 1, word, currentLength + 1) ||
                dfs(board, i + 1, j, word, currentLength + 1) ||
                dfs(board, i, j - 1, word, currentLength + 1) ||
                dfs(board, i - 1, j, word, currentLength + 1);

        //回溯
        board[i][j] = word.charAt(currentLength);

        return res;

    }

    public static void main(String[] args) {

        char board[][] = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'},
        };

        String word = "ABCCED";

        JZOffer12 t = new JZOffer12();
        boolean exist = t.exist(board, word);
        System.out.println(exist);
    }
}
