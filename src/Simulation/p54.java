package Simulation;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName: p54
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/5/3
 * @Time: 11:23
 */
public class p54 {

    /**
     * 顺时针打印矩阵中的值
     * @param matrix
     * @return
     */
    public List<Integer> spiralOrder(int[][] matrix) {

        if(matrix.length==0) return new ArrayList<>();
        int row=matrix.length;//行
        int col=matrix[0].length;//列数
        List<Integer> res=new LinkedList<>();
        int top=0,right=col-1,bom=row-1,left=0;;
        int sum=row*col;//最终所有的数目

        //注意这边不能写成<= 否则陷入死循环因为一直在等于
        while (res.size()<row*col){

            //先打印顶部行
            for (int i=left;i<=right&&res.size()<sum;i++){
                res.add(matrix[top][i]);//控制行不变 不断右移列下标
            }
            top++;//准备下一层

            //打印最右边列
            for (int i=top;i<=bom&&res.size()<sum;i++){
                res.add(matrix[i][right]);//控制列不变 不断下移行下标
            }
            right--;//左移一层

            //打印最底部行
            for (int i=right;i>=left&&res.size()<sum;i--){
                res.add(matrix[bom][i]);//控制行不变 不断左移列下标
            }
            bom--;//上移一层

            //打印最左边列
            for (int i=bom;i>=top&&res.size()<sum;i--){
                res.add(matrix[i][left]);//控制列不变 不断上移行下标
            }
            left++;//右移一列
        }

        return  res;
    }
}
