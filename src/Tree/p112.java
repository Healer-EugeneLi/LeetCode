package Tree;

/**
 * @ClassName: p112
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/9/28
 * @Time: 19:42
 * 路径总和
 */
public class p112 {

    public boolean hasPathSum(TreeNode root, int targetSum) {

        if (root == null) return false;

        if (root.left == null && root.right == null && root.val == targetSum) return true;

        //左边的结果 右边的结果
        boolean left = hasPathSum(root.left, targetSum - root.val);
        boolean right = hasPathSum(root.right, targetSum - root.val);

        return left || right;


    }


}
