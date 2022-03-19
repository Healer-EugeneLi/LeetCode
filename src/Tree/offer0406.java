package Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: offer0406
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/9/28
 * @Time: 19:25
 */
public class offer0406 {


    private List<TreeNode> res = new ArrayList<TreeNode>();

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {

        inOrder(root);
        res.add(null);//最后补充一下 最后一个结点的后继节点为空
        int i;
        for (i = 0; i < res.size(); i++) {
            if (res.get(i) == p) {
                break;
            }
        }
        return res.get(i + 1);

    }

    //中序遍历
    private void inOrder(TreeNode root) {
        if (root == null) return;

        inOrder(root.left);
        res.add(root);
        inOrder(root.right);
    }
}
