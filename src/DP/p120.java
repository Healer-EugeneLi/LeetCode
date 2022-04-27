package DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: p120
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/4/20
 * @Time: 20:59
 */
public class p120 {

    public int minimumTotal(List<List<Integer>> triangle) {

        //dp[j][j]表示 (i,j)这个节点到最后一层的最短路径
        //（i,j）这个点到下一层有两种方式可以走 走左边 走右边 因此dp[i][j]=Math.min(dp[i+1][j,dp[i][j+1])+ triangle[i][j]的值

        int row=triangle.size();

        int dp[][]=new int[row+1][row+1];
        //用i表示每一行
        for (int i=row-1;i>=0;i--){
            //用j来表示列的索引  比如当i=3那就是第4行 则这一行就有4列 也就是索引从0~3
            for (int j=0;j<=i;j++){

                //选择其下方两个子节点到最后一层的最短路径和的较小值 +当前自己这个节点的值
                dp[i][j]=Math.min(dp[i+1][j],dp[i+1][j+1])+triangle.get(i).get(j);
            }

        }
        return dp[0][0];
    }

    public static void main(String[] args) {



        int arr[][]={
                {2},
                {3,4},
                {6,5,7},
                {4,1,8,3}
        };
        List<List<Integer>>  triangle=new ArrayList<>();

        for (int  i=0;i<arr.length;i++){
            List list=new ArrayList();
            for (int j=0;j<arr[i].length;j++){
                list.add(arr[i][j]);
            }
            triangle.add(list);
        }
        p120 t=new p120();

        for (int i=0;i<triangle.size();i++){
            for (int j=0;j<triangle.get(i).size();j++){
                System.out.print(triangle.get(i).get(j));
            }
            System.out.println();
        }
        int res = t.minimumTotal(triangle);

        System.out.println(res);

    }
}
