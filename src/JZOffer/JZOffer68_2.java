package JZOffer;

/**
 * @ClassName: JZOffer68_2
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/1/18
 * @Time: 20:24
 * <p>
 * 在二叉树中找到最近公共祖先
 */
public class JZOffer68_2 {

    //时间复杂度 O(N) ： 其中 N 为二叉树节点数；最差情况下，需要递归遍历树的所有节点。
    //空间复杂度 O(N) ： 最差情况下，递归深度达到 NN ，系统使用 O(N) 大小的额外空间。

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        //当根节点是null的时候 返回null
        if (root == null) return null;
        //当递归遍历到所要找的根节点 返回此节点
        if (root == p) return p;
        if (root == q) return q;

        //一开始先遍历左子树 再遍历右子树 如果在该子树中遍历到所要找的目标节点 那么返回值就是先遇到的那个目标值
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left == null) return right;//如果左子树为空 那么返回值就应该是右子树返回的结果
        else if (right == null) return left;//同理left 不为空 right为空 返回左子树的结果
        else {
            return root;//都不为空 就返回此时的根节点 因为此时p q在两侧
        }

    }
}
