package DP;

import java.util.Scanner;

/**
 * @ClassName: SetDP
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/11/10
 * @Time: 17:23
 */

class Point{
    double x=0,y=0;
}
public class SetDP {

    public int n=4;
    public double INF=Double.MAX_VALUE;
    public Point point[];
    double dp[];

    private  double dist(int i, int j) {

        return Math.sqrt(Math.pow(point[i].x-point[j].x,2)+
                Math.pow(point[i].y-point[j].y,2));

    }
    public void compute(){



        Scanner scanner=new Scanner(System.in);
        n=scanner.nextInt();
        point=new Point[n];
        dp=new double[1<<n];
        dp[0]=0;

        for(int i=0;i<n;i++) {
            point[i]=new Point();
            point[i].x=scanner.nextDouble();
            point[i].y=scanner.nextDouble();

        }
        for(int i=0;i<n;i++){
            System.out.println(i+" "+"x:"+point[i].x+" y:"+point[i].y);
        }


        for(int s=1;s<(1<<n);s++){


            dp[s]=INF;//要求解最小 先设置一个最大的
            int i,j;//寻找子集的一个点，用该点跟其他点匹配，这里得到的 i 是子集s中最大的元素
            //这样寻找点的好处是确保i总是在S中
            for(i=n-1;i>=0;--i){

                if ((s&(1<<i))>0){
                    //判断元素是否在集合中
                    break;
                }
            }

            //因为取得子集中最大的元素，所以就从 i-1 找该子集的其他点了
            for( j=i-1;j>=0;j--){
                if((s&(1<<j))>0){
                    dp[s]=Math.min(dp[s],dist(i,j)+dp[s^(1<<i)^(1<<j)]);
                }
            }
        }

        for(int i=0;i<(1<<n);i++)
            System.out.println(dp[i]);

    }

    public static void main(String[] args) {
         SetDP test=new SetDP();
         test.compute();

    }


}
