package JZOffer;

import java.util.Arrays;

/**
 * @ClassName: JZOffer29
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/11/27
 * @Time: 19:46
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 *
 *
 */
public class JZOffer29 {
    public int[] spiralOrder(int[][] matrix) {

        if (matrix.length==0) return new int[]{};

        int row=matrix.length;//行
        int col=matrix[0].length;//列

        int res[]=new int[row*col];
        int num=0;//记录目前已经存下的个数
        //四个边界 top right bom left
        int top=0,right=col-1,bom=row-1,left=0;

        //从四个方向进行模拟
        while (num<row*col){


            //第一行 此时的左边界是left
            for (int i=left;i<=right&&num<row*col;i++){
                res[num++]=matrix[top][i];//top表示当前行 i从左往右一直移动
            }
            top++;//上一行模拟完 往下移动下一行

            //右边这一列 从上到下
            for (int i=top;i<=bom&&num<row*col;i++){
                res[num++]=matrix[i][right];//此时控制列不变 行一直往下移
            }
            right--;//右边的这一列模拟完  往左移动一次

            for (int i=right;i>=left&&num<row*col;i--){
                res[num++]=matrix[bom][i];//此时控制行不变 列从右往左一直移动
            }
            bom--;//最下面一行模拟完 往上移动一行

            for (int i=bom;i>=top&&num<row*col;i--){
                res[num++]=matrix[i][left];
            }
            left++;//左侧这一列模拟完 往右扩展一步

        }

        return res;

    }

    public static void main(String[] args) {

       int num[][]=new int[][]{{1,2,3},{4,5,6},{7,8,9},{10,11,12}};
       JZOffer29 t=new JZOffer29();
        int[] res = t.spiralOrder(num);

        System.out.println(Arrays.stream(res).toArray());
    }
}
