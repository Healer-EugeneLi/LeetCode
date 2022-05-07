package Tree;

/**
 * @ClassName: p124
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/5/6
 * @Time: 11:57
 */
public class p124 {


    private int result=Integer.MIN_VALUE;//题目中节点有可能是负的 所以不能设置为0
    public int maxPathSum(TreeNode root) {

        dfs(root);
        return result;
    }

    /**
     * 最终返回root为根节点的子树为其父亲所能提供的贡献
     * @param root
     * @return
     */
    public int dfs(TreeNode root){


        //当前节点是叶节点 那么对父亲贡献为0
        if (root==null) return 0;

        //如果不是叶子节点，计算当前节点的左右孩子对自身的贡献分别为多少

        int left=dfs(root.left);
        int right=dfs(root.right);
        //更新最大值 就是以当前节点为根节点 所能得到的最大路径和
        result=Math.max(result,root.val+left+right);

        //计算当前root节点能够为其父亲提供的贡献 就是取左右子树的最大值加上root.val 因为走完左边又走右边
        int max=Math.max(root.val+left,root.val+right);
        return max<0?0:max;

    }
}
