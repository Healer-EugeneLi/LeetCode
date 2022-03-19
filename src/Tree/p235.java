package Tree;

/**
 * @ClassName: p235
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/11/25
 * @Time: 22:10
 */
public class p235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        //如果一个比根节点小 一个比根节点大 那么在两侧 根节点就是最近祖先
        if ((p.val - root.val) * (q.val - root.val) < 0)//异号说明了该情况
            return root;

        //如果不是异号 即说明要么都大于根节点 要么都小于根节点
        if (p.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else
            return lowestCommonAncestor(root.right, p, q);


    }
}
