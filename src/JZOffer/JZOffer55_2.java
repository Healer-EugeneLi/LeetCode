package JZOffer;

/**
 * @ClassName: JZOffer55_2
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/1/18
 * @Time: 17:59
 *
 * 输入一棵二叉树的根节点，判断该树是不是平衡二叉树。
 * 如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树
 */
public class JZOffer55_2 {

    public boolean isBalanced(TreeNode root) {

        if (root==null) return true;
        else {
            return Math.abs(getHigh(root.left)-getHigh(root.right))<=1
                    &&isBalanced(root.left)&&isBalanced(root.right);
        }

    }

    public int getHigh(TreeNode root){

        if (root==null) return 0;

        int left=getHigh(root.left);
        int right=getHigh(root.right);
        return Math.max(left,right)+1;
    }
}
