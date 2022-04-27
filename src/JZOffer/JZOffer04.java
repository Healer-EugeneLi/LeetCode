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

    /**
     * 这个数组是 从左到右递增的 从上到下递增
     * 行数为row
     * 列数为col
     * 可以选择从最右上角开始进行查找 即matrix[0][col-1]
     * 如果当前这个数大于目标 那说明应该往左找 因为右边以及下边都是比它大的
     * 如果当前这个数小于目标 那说明应该往下找 因为下边的是比它大的 之所以此时不往右走 是因为之前已经是从右边移动过来的
     * 如果当前值等于目标 直接返回
     * 当寻找的数已经越过边界了 这说明已经找完了 没找到 直接返回false
     * @param matrix
     * @param target
     * @return
     */
    public boolean findNumberIn2DArray(int[][] matrix, int target) {

        if (matrix.length == 0 || matrix[0].length == 0) return false;
        int row = matrix.length;
        int col = matrix[0].length;

        int i = 0, j = col - 1;
        while (i < row && j >= 0) {
            int current = matrix[i][j];
            if (current == target) return true;

            //如果当前这个数大于目标 那说明应该往左找 因为右边以及下边都是比它大的 缩小列的索引 即往左找
            if (current > target) {
                j--;
            }
            //如果当前这个数小于目标 那说明应该往下找 因为下边的是比它大的
            if (current < target) {
                i++;
            }
        }
        return false;
    }




}
