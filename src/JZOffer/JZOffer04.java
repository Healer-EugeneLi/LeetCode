package JZOffer;

/**
 * @ClassName: JZOffer04
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/11/22
 * @Time: 21:55
 * 在特殊的二维数组中找到是否存在某一个数
 */
public class JZOffer04 {

    public boolean findNumberIn2DArray(int[][] matrix, int target) {

        if (matrix.length == 0 || matrix[0].length == 0) return false;
        int row = matrix.length;
        int col = matrix[0].length;

        int i = 0, j = col - 1;
        while (i < row && j >= 0) {
            int current = matrix[i][j];
            if (current == target) return true;

            if (current > target) {
                j--;
            }
            if (current < target) {
                i++;
            }
        }
        return false;
    }


}
