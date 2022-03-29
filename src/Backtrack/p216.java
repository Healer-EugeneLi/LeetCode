package Backtrack;

import java.util.ArrayList;
import java.util.List;


/**
 *在1-9中找到k个数 其和为n
 */
public class p216 {

    public List<List<Integer>> res=new ArrayList<>();
    public List<Integer> path=new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {

        backTracking(n,k,0,1);
        return res;

    }

    public void backTracking(int n,int k,int curSum,int startIndex){


        //满足条件 加入并返回
        if (path.size()==k&&curSum==n){

            res.add(new ArrayList<>(path));
            return;
        }
        //此时已经满足和了 但是个数还不够 不行
        if (curSum>=n)
            return;

        for (int i=startIndex;i<=9-(k-path.size())+1&&i<=(n-curSum);i++){

            path.add(i);
            curSum+=i;
            backTracking(n,k,curSum,i+1);
            path.remove(path.size()-1);
            curSum-=i;
        }
    }

    public static void main(String[] args) {

        int k=3,n=7;

        p216 t=new p216();

        List<List<Integer>> lists = t.combinationSum3(k, n);
        System.out.println();
    }
}
