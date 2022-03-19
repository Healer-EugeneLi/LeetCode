package JZOffer;

/**
 * @ClassName: JZOffer28
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/2/8
 * @Time: 23:48
 * <p>
 * 判断一棵树是否是对称的
 * <p>
 * 如果同一层节点 需要进行比较的对应的结点其值不相等或者其中一个为空 则不对称
 * 如果需要进行比较的对应的结点其左右子树都是空说明到达了叶子节点 返回true
 * 继续进行判断往下走
 */
public class JZOffer28 {
    public boolean isSymmetric(TreeNode root) {

        if (root == null) return true;

        return recur(root.left, root.right);

    }

    public boolean recur(TreeNode left, TreeNode right) {

        if (left == null && right == null) return true;//都到达叶子节点

        //其中一个为空 或者节点值不相等 返回false
        if (left == null || right == null || left.val != right.val) return false;

        //这一层判断完了 判断下一层

        return recur(left.left, right.right) && recur(left.right, right.left);


    }
}
