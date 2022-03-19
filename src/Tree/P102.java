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

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) queue.add(root);
        List<List<Integer>> result = new ArrayList<>();

        while (!queue.isEmpty()) {

            int size = queue.size();//当前队列中有多少个结点
            List<Integer> vec = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode peek = queue.peek();

                vec.add(peek.val);//添加值
                queue.poll();//删掉头结点
                if (peek.left != null) queue.add(peek.left);
                if (peek.right != null) queue.add(peek.right);

            }

            result.add(vec);

        }
        return result;

    }
}

public class P102 {
}
