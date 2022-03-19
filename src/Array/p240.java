package Array;

/**
 * @ClassName: p240
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/10/25
 * @Time: 22:37
 * <p>
 * 二维矩阵
 * 从左到右变大
 * 从上到下变大
 * 寻找是否存在target值
 */
public class p240 {

    public boolean searchMatrix(int[][] matrix, int target) {

        if (matrix.length == 0 || matrix[0].length == 0)
            return false;

        int row = 0;
        int col = matrix[0].length - 1;//一开始是整个矩阵的右上角位置

        while (row < matrix.length && col >= 0) {
            //还没出界
            int cur = matrix[row][col];//当前值 实际就是右上角的值 不断变化
            if (target < cur) {
                //当目标小于当前值的时候 说明该列肯定不可能
                col--;
            } else if (target > cur) {
                //当目标比当前值大的时候 说明该行不可能 要下一行
                row++;
            } else
                return true;//找到了
        }

        return false;

    }
}
