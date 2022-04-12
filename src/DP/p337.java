package DP;



/**
 * @ClassName: p337
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/4/7
 * @Time: 23:57
 * 输入: root = [3,2,3,null,3,null,1]
 * 输出: 7
 * 解释: 小偷一晚能够盗取的最高金额 3 + 3 + 1 = 7
 */
public class p337 {

    /**
     * 使用树形dp
     * 用一个状态数组来表示当前节点 偷与不偷的值
     * res[0]表示当前节点不偷 res[1]表示当前节点偷
     *
     * 那么对于一个节点 其最大值等于 其偷与不偷的max值
     * 如果不偷当前节点 则res[0]=Math.max(左子树不偷，左子树偷)+Math.max(右子树不偷，右子树偷)
     * 如果偷当前节点 则res[1]=左子树不偷+右子树不偷+当前值
     * @param root
     * @return
     */
    public int rob(TreeNode root) {

        if (root==null) return 0;

        int res[  ]=func(root);
        return Math.max(res[0],res[1]);

    }

    public int[] func(TreeNode root){

        int res[]=new int[2];
        if (root==null)
            return res;

        //当前节点的左右子树的情况
        int left[]=func(root.left);
        int right[]=func(root.right);

        //当前节点不偷
        res[0]=Math.max(left[0],left[1])+Math.max(right[0],right[1]);
        //当前节点偷
        res[1]=root.val+left[0]+right[0];

        return res;


    }
}
