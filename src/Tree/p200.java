package Tree;

/**
 * @ClassName: p200
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/11/26
 * @Time: 21:19
 */
public class p200 {

    public TreeNode searchBST(TreeNode root, int val) {

        if (root == null) return null;
        if (root.val == val) return root;
        else if (root.val > val) {
            return searchBST(root.left, val);
        } else {
            return searchBST(root.right, val);
        }
    }
}
