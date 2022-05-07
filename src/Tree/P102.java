package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName: P102
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/6/26
 * @Time: 15:58
 */



public class P102 {

    /**
     * 层序遍历
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) queue.add(root);
        List<List<Integer>> result = new ArrayList<>();

        //当队列中不为空
        while (!queue.isEmpty()) {

            int size = queue.size();//当前队列中有多少个结点 实际就是这一层有多少个结点
            List<Integer> curLevel = new ArrayList<>();//存放当前层的结点
            for (int i = 0; i < size; i++) {
                TreeNode peek = queue.peek();//返回队列中的结点

                curLevel.add(peek.val);//添加值
                queue.poll();//弹出结点
                //如果该节点的左右子树不为空 也就是下一层的结点 放入队列中
                if (peek.left != null) queue.add(peek.left);
                if (peek.right != null) queue.add(peek.right);

            }
            //当前这一层遍历完了 存入最终的结果列表
            result.add(curLevel);

        }
        return result;

    }
}
