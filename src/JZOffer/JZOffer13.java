package JZOffer;

/**
 * @ClassName: JZOffer13
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/1/28
 * @Time: 0:26
 */
public class JZOffer13 {

    public int count = 0;
    public boolean arr[][];

    //m 行 n列 位数和为k
    public int movingCount(int m, int n, int k) {

        arr = new boolean[m][n];
        dfs(0, 0, m, n, k);


        return count;
    }

    public boolean dfs(int x, int y, int m, int n, int k) {

        //不符合条件
        if (x < 0 || x >= m || y < 0 || y >= n || (getSum(x) + getSum(y) > k) || arr[x][y] == true)
            return false;
        //符合条件 加一个格子 并且设置为true 表示访问过
        // 而且后面回溯的时候不需要设置回false
        // 因为题目要求的是可以走的总的格子数  所以设置为true表示我们已经走过 加上去1次了 如果设置回false的话 后面又访问到 又会被加1次 那显然是不对的
        count++;
        arr[x][y] = true;

        //从四个方向继续 右 下 左 上
//        return dfs(x,y+1,m,n,k)||dfs(x+1,y,m,n,k)||
//                dfs(x,y-1,m,n,k)||dfs(x-1,y,m,n,k);

        //根据题目特点 因为格子都是可以通过上方或者左方移动得到 因此我们只需要从右边 下边进行移动就行
        return dfs(x, y + 1, m, n, k) || dfs(x + 1, y, m, n, k);
    }

    //这种写法也是可以的
    public void dfs(int x, int y, boolean arr[][], int m, int n, int k) {

        if (x < 0 || x >= m || y < 0 || y >= n || (getSum(x) + getSum(y)) > k || arr[x][y] == true)
            return;

        count++;
        arr[x][y] = true;

        //往右 往下即可
        dfs(x, y + 1, arr, m, n, k);
        dfs(x + 1, y, arr, m, n, k);
    }

    public int getSum(int a) {

        //比如a=35
        int sum = 0;
        while (a != 0) {
            sum += a % 10;
            a /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {

    }
}
