package JZOffer;

;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName: JZOffer32_2
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/11/28
 * @Time: 22:59
 * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
 */
public class JZOffer32_2 {

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            int size = queue.size();//当前层有多少个节点
            List<Integer> curLevel = new ArrayList<>();
            for (int i = 0; i < size; i++) {

                TreeNode poll = queue.poll();//弹出的节点
                curLevel.add(poll.val);
                if (poll.left != null) queue.add(poll.left);
                if (poll.right != null) queue.add(poll.right);
            }

            res.add(curLevel);
        }
        return res;


    }
}
