package DP;

/**
 * @ClassName: p96
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/2/24
 * @Time: 16:46
 * 求不同的二叉树搜索树的个数
 * n=2  1
 * n=2 2
 * n=3 5
 * 当n为3时 1 2 3 三个数可以组成5种不同的二叉树
 * 假设 n 个节点存在二叉排序树的个数是 G (n)，令 f(i) 为以 i 为根的二叉搜索树的个数，则
 * G(n)=f(1)+f(2)+f(3)+f(4)+...+f(n)
 * 当 i 为根节点时，其左子树节点个数为 i-1 个，右子树节点为 n-i，则 f(i)=G(i−1)∗G(n−i)
 */
public class p96 {

    public int numTrees(int n) {

        //令dp[i] 表示i个结点组成的二叉搜索树的种类个数
        int dp[]=new int[n+1];
        dp[0]=1;//为了在乘法的时候 不会得到值为0
        dp[1]=1;
        for (int i=2;i<=n;i++){

            for (int j=1;j<=i;j++){
                //i为头结点的时候 dp[j-1]表示当左子树有j-1个结点的时候 右子树为dp[i-j] 代表了不同的元素从1到i分别为根节点的时候的个数
                dp[i]+=dp[j-1]*dp[i-j];
                //比如 此时i=3 j=1 +=dp[0]*dp[2]表示的是左子树没有元素 右子树有2个元素的情况 那么很明显此时的根节点为1
                //i=3 j=2 +=dp[1]*dp[1] 表示左右各有1个元素 此时根节点为2
                //i=3 j=3 +=dp[2]*dp[0] 左子树两个元素 右子树0个元素 此时根节点为3
                //也就是说i代表总的结点个数  那么内层循环就是要遍历1到i个元素 这些值当根节点的时候 其组成的种类求和才是i个结点最终可以构成多少个二叉搜索树
            }
        }

        return dp[n];
    }
}