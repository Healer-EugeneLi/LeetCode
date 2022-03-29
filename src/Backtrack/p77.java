package Backtrack;

import java.util.ArrayList;
import java.util.List;


/**
 *给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 *
 *输入：n = 4, k = 2
 * 输出：
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 */
public class p77 {

    public List<List<Integer>> res=new ArrayList<>();//保存所有的结果结合
    public List<Integer> path=new ArrayList<>();//保存符合条件的组合

    public List<List<Integer>> combine(int n, int k) {


        backTracking(n,k,1);
        return res;

    }

//    /**
//     *
//     * @param n
//     * @param k
//     * @param startIndex 表示在元素1~n中此时要进去读取的位置
//     */
//    public void backTracking(int n,int k,int startIndex){
//
//        //当此时构成的组合长度已经达到k 符合条件 加入
//        if (path.size()==k){
//            res.add(new ArrayList<>(path));
//            return;
//        }
//
//        for (int i=startIndex;i<=n;i++){
//
//            path.add(i);//加入当前位置的元素
//            backTracking(n,k,i+1);//进入下一个元素进行搜索
//            path.remove(path.size()-1);//回溯的时候把元素去掉
//        }
//
//
//    }


    /**
     *剪枝版本
     * @param n
     * @param k
     * @param startIndex 表示在元素1~n中此时要进去读取的位置
     */
    public void backTracking(int n,int k,int startIndex){

        //当此时构成的组合长度已经达到k 符合条件 加入
        if (path.size()==k){
            res.add(new ArrayList<>(path));
            return;
        }

        //当前这一次开始的时候 没有必要遍历到最后一个元素
        // 比如当前已经放入了2个元素 假设还需要2个元素  那么符合条件的边界就算n-(k-path.size())+1
        for (int i=startIndex;i<=n-(k-path.size())+1;i++){

            path.add(i);//加入当前位置的元素
            backTracking(n,k,i+1);//进入下一个元素进行搜索
            path.remove(path.size()-1);//回溯的时候把元素去掉
        }


    }

}
