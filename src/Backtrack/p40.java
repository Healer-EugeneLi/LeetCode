package Backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: p40
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/3/23
 * @Time: 15:41
 * 给定一个候选人编号的集合candidates和一个目标数target，
 * 找出candidates中所有可以使数字和为target的组合。
 *
 * candidates中的每个数字在每个组合中只能使用一次。
 *
 * 注意：解集不能包含重复的组合。
 * 输入: candidates =[10,1,2,7,6,1,5], target =8,
 * 输出:
 * [
 * [1,1,6],
 * [1,2,5],
 * [1,7],
 * [2,6]
 * ]
 *

 */
public class p40 {

    public List<List<Integer>> res=new ArrayList<>();
    public List<Integer> path=new ArrayList<>();
    public boolean[] used;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        used=new boolean[candidates.length];
        Arrays.sort(candidates);//先升序
        backTracking(candidates,target,used,0,0,path);
        return res;

    }

    public void  backTracking(int[] candidates,int target,
                              boolean used[], int startIndex,int curSum,List<Integer> path){

        if (curSum==target){
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i=startIndex;i<candidates.length;i++){

            //如果已经超过了目标和了
            if (curSum+candidates[i]>target) return;
            //在同一个树枝层上用过 不能重复取
            if (i>0&&candidates[i]==candidates[i-1]&&used[i-1]==false) continue;
            used[i]=true;
            curSum+=candidates[i];
            path.add(candidates[i]);
            backTracking(candidates,target,used,i+1,curSum,path);
            used[i]=false;
            curSum-=candidates[i];
            path.remove(path.size()-1);
        }

    }


}
