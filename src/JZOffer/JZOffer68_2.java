package JZOffer;

/**
 * @ClassName: JZOffer68_2
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/1/18
 * @Time: 20:24
 */
public class JZOffer68_2 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        //当根节点是null的时候 返回null
        if (root==null) return null;
        //当递归遍历到所要找的跟节点 返回此节点
        if (root==p) return p;
        if (root==q) return q;

        //一开始先遍历左子树 再遍历右子树 如果在该子树中遍历到所要找的目标节点 那么返回值就是先遇到的那个目标值
        TreeNode left=lowestCommonAncestor(root.left,p,q);
        TreeNode right=lowestCommonAncestor(root.right,p,q);

        if (left==null) return right;//如果左子树为空 那么返回值就应该是右子树返回的结果
        else if (right==null) return left;//同理left 不为空 right为空 返回左子树的结果
        else {
            return root;//都不为空 就返回此时的根节点 因为此时p q在两侧
        }

    }
}
