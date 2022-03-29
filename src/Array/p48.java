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

        for (int i=0;i<n/2;i++){
            for (int j=0;j<(n+1)/2;j++){

                int temp=matrix[i][j];
                matrix[i][j]=matrix[n-1-j][i];
                matrix[n-1-j][i]=matrix[n-1-i][n-1-j];
                matrix[n-1-i][n-1-j]=matrix[j][n-1-i];
                matrix[j][n-1-i]=temp;
            }
        }

    }
}
