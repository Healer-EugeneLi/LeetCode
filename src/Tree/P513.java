package Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName: P513
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/8/22
 * @Time: 17:14
 */
public class P513 {

    public int findBottomLeftValue(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) queue.add(root);

        int res = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();//弹出头结点 并移除
                if (i == 0) {

                    res = poll.val;
                }

                if (poll.left != null) queue.offer(poll.left);
                if (poll.right != null) queue.offer(poll.right);

            }

        }

        return res;


    }
}
