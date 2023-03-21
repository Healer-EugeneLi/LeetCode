package Backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: p39
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/3/22
 * @Time: 20:24
 * 输入：candidates = [2,3,6,7], target = 7
 * 输出：[[2,2,3],[7]]
 * 解释：
 * 2 和 3 可以形成一组候选，2 + 2 + 3 = 7 。注意 2 可以使用多次。
 * 7 也是一个候选， 7 = 7 。
 * 仅有这两种组合。

 */
public class p39 {


    public List<List<Integer>> res=new ArrayList<>();

    public List<Integer> path=new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        Arrays.sort(candidates);
        backTracking(candidates,target,0,0,path);
        return res;
    }


    /**
     *
     * @param candidates
     * @param target 目标和
     * @param curSum 当前和
     * @param startIndex 这一次遍历的时候从数组的哪个下标开始
     * @param path 已经构成的数
     */
    public void backTracking(int [] candidates,int target,
                             int curSum,int startIndex,List<Integer> path){



        if (curSum==target){
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i=startIndex;i<candidates.length;i++){

            //在求和问题中，排序之后加剪枝是常见的套路！
            //因为前面已经从小到大排序了
            // 所以加上当前这个数的时候 如果和已经超过目标和 后面的数也不用试了 加上去肯定也更大 break回到上一层 将上一个加入的元素删除
            if (curSum+candidates[i]>target) break;
            path.add(candidates[i]);
            curSum+=candidates[i];
            //因为可以重复取  所以在搜索的时候就可以继续使用当前这个下标的数 所以传入i到startIndex
            backTracking(candidates,target,curSum,i,path);
            path.remove(path.size()-1);//移除最后加入的一个元素
            curSum-=candidates[i];//记得把加进来的数删除回去
        }
    }
}
