package JZOffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName: JZOffer32_1
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/2/12
 * @Time: 10:36
 * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 */
public class JZOffer32_1 {

    public int[] levelOrder(TreeNode root) {

        if (root == null) return new int[]{};

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);//先加入根节点
        List<Integer> list = new LinkedList<>();
        //队列存的是每一层的结点 当队列不为空的时候
        while (!queue.isEmpty()) {
            //此时这一层的某一个结点
            TreeNode cur = queue.poll();
            list.add(cur.val);//加入
            //左右子树都不为空 就加入结点 即下一层的结点
            if (cur.left != null)
                queue.add(cur.left);
            if (cur.right != null)
                queue.add(cur.right);

        }

        int res[] = new int[list.size()];
        for (int i = 0; i < list.size(); i++)
            res[i] = list.get(i);
        return res;

    }
}
