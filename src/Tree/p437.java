package Tree;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: p437
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/9/28
 * @Time: 21:30
 */
public class p437 {

    public int pathSum(TreeNode root, int targetSum) {

        Map<Integer, Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0, 1);//前缀和为0的路径有1条

        //前缀和的递归
        return recursionPathSum(root, prefixSumCount, targetSum, 0);

    }

    /**
     * @param root           树节点
     * @param prefixSumCount 前缀和Map
     * @param targetSum      目标值
     * @param curSum         当前路径和
     * @return
     */
    private int recursionPathSum(TreeNode root, Map<Integer, Integer> prefixSumCount,
                                 int targetSum, int curSum) {

        //1.返回
        if (root == null) return 0;

        //2.本层要做的事情
        int res = 0;

        //当前路径上的和
        curSum += root.val;

        res += prefixSumCount.getOrDefault(curSum - targetSum, 0);


        // 看看root到当前节点这条路上是否存在节点前缀和加target为currSum的路径
        // 当前节点->root节点反推，有且仅有一条路径，如果此前有和为currSum-target,而当前的和又为currSum,两者的差就肯定为target了
        // currSum-target相当于找路径的起点，起点的sum+target=currSum，当前点到起点的距离就是target
        //更新路径上当前节点前缀和个数
        prefixSumCount.put(curSum, prefixSumCount.getOrDefault(curSum, 0) + 1);

        //进入下一层
        res += recursionPathSum(root.left, prefixSumCount, targetSum, curSum);
        res += recursionPathSum(root.right, prefixSumCount, targetSum, curSum);

        //回到本层 恢复状态 去除当前节点的前缀和数量 因为这个不在被当做前缀和了
        prefixSumCount.put(curSum, prefixSumCount.getOrDefault(curSum, 0) - 1);
        return res;

    }
}
