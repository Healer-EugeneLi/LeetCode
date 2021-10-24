package Code2020;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @ClassName: JDDirectory
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/10/9
 * @Time: 10:25
 */
public class JDDirectory {


    public static void main(String[] args) {

        BigInteger[][] dp=new BigInteger[50][50];
        Scanner scanner=new Scanner(System.in);

        int N=scanner.nextInt();
        int M=scanner.nextInt();
        long K=scanner.nextLong();
        for (int i=0;i<=N;i++){
            dp[i][0]=new BigInteger(Integer.toString(i));//i个a组成i种情况
        }
        for (int i=0;i<=M;i++){
            dp[0][i]=new BigInteger(Integer.toString(i));
        }

        for (int i=1;i<=N;i++){
            for (int j=1;j<=M;j++){
                //dp[i][j]=dp[i-1][j]+1+dp[i][j-1]+1
                dp[i][j]=dp[i-1][j].add(dp[i][j-1]).add(new BigInteger("2"));
            }
        }

        StringBuffer sb=new StringBuffer();
        int n=N,m=M;
        long k=K;
        while (k>0){

            if (n>0&&m>0){
                //判断是落在哪个子树上  是以a开头还是以b开头
                //如果k<=dp[n-1][m]+1 说明在以a开头的子树上
                if (dp[n-1][m].compareTo(new BigInteger(Long.toString(k-1)))>=0){
                    k--;
                    sb.append('a');
                    n--;
                }else {
                    k-=(dp[n-1][m].longValue()+1);//先减去a子树的所有情况
                    // 再减去要在b子树中以b开头 减少一个b继续往下走
                    k-=1;
                    sb.append('b');
                    m--;

                }
            }else if (n>0&&m==0){
                //只剩下a 没有b
                k--;
                sb.append('a');
                n--;
            }else if (n==0&&m>0){
                //只剩下b 没有a
                k--;
                sb.append('b');
                m--;
            }else {
                k=0;
            }
        }
        System.out.println(sb.toString());
    }
}
