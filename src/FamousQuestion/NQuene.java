package FamousQuestion;

/**
 * @ClassName: NQuene
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/10/3
 * @Time: 10:58
 */
public class NQuene {

    /**
     * record[0...i-1]的皇后 任意两个皇后一定都不共行、不共列、不共斜线
     * 目前来到了第i行
     * record[0...i-1]表示之前放的行 放了皇后的位置
     * @param i
     * @param record
     * @param n
     * @return
     */
    public static int process1(int i,int [] record,int n){

        if (i==n) return 1;//来到终止行可以符合条件了可以放

        int res=0;
        for (int j=0;j<n;j++){
            //当前行在i行 尝试所有的列
            //当前i行的皇后 放在列会不会和之前的(0...i-1)的皇后 共行或者共斜线
            //如果是 认为无效 不是才有效
            if (isValid(record,i,j)){
                record[i]=j;
                res+=process1(i+1,record,n);
            }
        }
        return res;
    }

    /**
     * 返回在第i行第j列放置皇后是否有效
     * 从record[0...i-1]需要看 后面的不需要看
     * @param record
     * @param i
     * @param j
     * @return
     */
    private static boolean isValid(int[] record, int i, int j) {

        for (int k=0;k<i;k++){
            //之前的某个k行的皇后
            //j==record[k]判断是否在同一列
            //record[k]-j求列的差  如果等于 Math.abs(i-k)行的差  表示可以形成45度斜线
            if(j==record[k]||Math.abs(record[k]-j)==Math.abs(i-k)) return false;
        }
        return true;
    }

    public static int method1(int n){

        if (n<1) return 0;

        int []record=new int[n];
        return process1(0,record,n);

    }

    public static void main(String[] args) {

        int n=14;
        int res = method1(14);
        System.out.println(res);
    }
}
