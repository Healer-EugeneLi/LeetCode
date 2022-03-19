package Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: p113
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/9/28
 * @Time: 19:58
 */
public class p113 {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        if (root == null) return res;

        List<Integer> path = new ArrayList<>();//路径

        traversal(root, targetSum, path);
        return res;


    }

    private void traversal(TreeNode root, int targetSum, List<Integer> path) {
        //进入搜索之后 路径上加入当前根节点的值
        path.add(root.val);

        //当满足条件的时候
        if (root.left == null && root.right == null) {
            if (targetSum - root.val == 0) {
                res.add(new ArrayList(path));

            }
            return;
        }

        if (root.left != null) {
            //遍历左子树
            traversal(root.left, targetSum - root.val, path);
            path.remove(path.size() - 1);
        }

        if (root.right != null) {
            //遍历右子树
            traversal(root.right, targetSum - root.val, path);
            path.remove(path.size() - 1);
        }


    }
}
