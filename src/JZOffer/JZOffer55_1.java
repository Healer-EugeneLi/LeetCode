package JZOffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName: JZOffer51
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/2/9
 * @Time: 11:51
 */
public class JZOffer55_1 {

    /**
     * 使用递归的方式
     * @param root
     * @return
     */
//    public int maxDepth(TreeNode root) {
//
//        if (root==null) return 0;
//
//        int left = maxDepth(root.left);
//        int right = maxDepth(root.right);
//
//        return Math.max(left,right)+1;
//
//    }

    /**
     * 使用层序遍历
     *
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {

        if (root == null) return 0;
        int depth = 0;
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            depth++;//每一层深度加1
            //将当前层的所有结点处理完
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();//弹出头结点
                //添加子节点
                if (poll.left != null)
                    queue.add(poll.left);
                if (poll.right != null)
                    queue.add(poll.right);
            }

        }
        return depth;
    }
}
