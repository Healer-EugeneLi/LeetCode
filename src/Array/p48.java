package Array;


/**
 * 翻转图像 将一个二维数组 顺时针翻转90度
 */
public class p48 {
//    public void rotate(int[][] matrix) {
//
//        int n=matrix.length;//n行n列
//        //1.先沿着左上角 右下角轴 翻转
//        for (int i=0;i<n;i++){
//            for (int j=0;j<i;j++){
//
//                int temp=matrix[i][j];
//                matrix[i][j]=matrix[j][i];
//                matrix[j][i]=temp;
//            }
//        }
//        //2.再沿着中轴翻转
//        for (int i=0;i<n;i++){
//
//            //j控制中轴的左边  k控制中轴的右边
//            for (int j=0,k=n-1;j<k;j++,k--){
//                int temp=matrix[i][j];
//                matrix[i][j]=matrix[i][k];
//                matrix[i][k]=temp;
//            }
//        }
//
//    }


    /**
     * 四个角转换
     * @param matrix
     */
    public void rotate(int[][] matrix) {

        int n=matrix.length;//n行n列

        //对四个角进行交换
        //行数的一半
        for (int i=0;i<n/2;i++){
            //列的一半 如果n为奇数的话 向上取整 比如n=3 (3+1)/2=2
            for (int j=0;j<(n+1)/2;j++){

                int temp=matrix[i][j];//存此时的左上角的点
                matrix[i][j]=matrix[n-1-j][i];//左上角的点==左下角的点 因为是在这一列上进行变换 不断地缩小行 所以列的i是不变的 变的是行n-1-j
                matrix[n-1-j][i]=matrix[n-1-i][n-1-j];//左下角的点==右下角的点
                matrix[n-1-i][n-1-j]=matrix[j][n-1-i];//右下角的点==右上角的点
                matrix[j][n-1-i]=temp;//右上角的点==左上角的点
            }
        }

    }
}
