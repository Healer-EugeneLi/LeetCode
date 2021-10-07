package FamousQuestion;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: p51
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/10/3
 * @Time: 11:12
 */
public class p51 {


    /**
     * record[0...i-1]的皇后 任意两个皇后一定都不共行、不共列、不共斜线
     * 目前来到了第i行
     * record[0...i-1]表示之前放的行 放了皇后的位置
     * @param i
     * @param record
     * @param n
     * @return
     */
    public  int process1(int i,int [] record,int n,List<Integer> path,
                         List<List<Integer>> list){

        if (i==n) {
            System.out.println(path.toString());
            list.add(new ArrayList<>(path));
            return 1;//来到终止行可以符合条件了可以放
        }

        int res=0;
        for (int j=0;j<n;j++){
            //当前行在i行 尝试所有的列
            //当前i行的皇后 放在列会不会和之前的(0...i-1)的皇后 共行或者共斜线
            //如果是 认为无效 不是才有效
            if (isValid(record,i,j)){
                record[i]=j;
                path.add(j);
                res+=process1(i+1,record,n,path,list);
                path.remove(path.size()-1);//回溯
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
    private  boolean isValid(int[] record, int i, int j) {

        for (int k=0;k<i;k++){
            //之前的某个k行的皇后
            //j==record[k]判断是否在同一列
            //record[k]-j求列的差  如果等于 Math.abs(i-k)行的差  表示可以形成45度斜线
            if(j==record[k]||Math.abs(record[k]-j)==Math.abs(i-k)) return false;
        }
        return true;
    }
    public List<List<String>> solveNQueens(int n) {

        if (n<1) return null;
        int []record=new int[n];

        List<Integer> path=new ArrayList<>();
        List<List<Integer>> list=new ArrayList<>();
        process1(0,record,n,path,list);
        System.out.println(list);
        //对于得到的list数据 开始转换成字符串形式
        List<List<String>> res=new ArrayList<>();
        for (List<Integer> num:list){
            //比如[".Q..","...Q","Q...","..Q."] 1 3 0 2
            List<String> temp=new ArrayList<>();//每一种解法
            for (int pos:num){
                StringBuffer s=new StringBuffer();
                for (int e=0;e<n;e++)
                    s.append(".");
                s.setCharAt(pos,'Q');
                temp.add(s.toString());

            }
            res.add(temp);//最后的结果
        }

        return res;
    }
}
