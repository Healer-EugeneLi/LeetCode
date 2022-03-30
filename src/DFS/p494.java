package DFS;

/**
 * @ClassName: p494
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/3/30
 * @Time: 15:34
 * 给你一个整数数组 nums 和一个整数 target 。
 *
 * 向数组中的每个整数前添加'+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
 *
 * 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
 * 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
 *
 让每个节点都尝试+ 与 -两种清空 使用dfs从根节点进行搜索 当到达叶子节点之后等于target的话 就说明找到了一个方案
 */
public class p494 {

    public int res=0;
    public int findTargetSumWays(int[] nums, int target) {

        dfs(nums,target,0);
        return res;

    }

    /**
     *
     * @param nums
     * @param target 用来控制 当对于一个节点进行+的时候 就用target-节点值 -的时候target+节点值 x1+x2-x3-x4=target
     *               如果arget-x1-x2+x3+x4=0
     *              最后到达叶子节点的时候 如果target=0 说明找到一种方案
     * @param index
     */
    public void dfs(int nums[],int target,int index){

        if(index== nums.length){
            //说明到达叶子节点
            if (target==0)
                res++;
        }
        if (index>=nums.length)
            return;


        //对当前节点进行+
        dfs(nums,target-nums[index],index+1);

        //对当前节点进行-
        dfs(nums,target+nums[index],index+1);

    }
}
