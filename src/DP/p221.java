package DP;

/**
 * @ClassName: p221
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/5/9
 * @Time: 21:53
 */
public class p221 {

    /**
     * 求最大正方形
     * 输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
     * 输出：4
     * @param matrix
     * @return
     */
    public int maximalSquare(char[][] matrix) {

        int m=matrix.length;
        int n=matrix[0].length;

        int dp[][]=new int[m][n];

        int curMaxLength=0;

        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){

                if (i==0||j==0){
                    if (matrix[i][j]=='0')
                        dp[i][j]=0;
                    else
                        dp[i][j]=1;
                }else if(matrix[i][j]=='0'){
                    dp[i][j]=0;
                }else {
                    //当前位置所能构成的正方形的最大边长
                    dp[i][j]=Math.min( Math.min(dp[i][j-1],dp[i-1][j]) ,dp[i-1][j-1])+1;
                }
                curMaxLength=Math.max(curMaxLength,dp[i][j]);//记录最大边长
            }
        }

        return curMaxLength*curMaxLength;//求出面积
    }
}
