package Tree;

import java.util.*;

/**
 * @ClassName: Traversal
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/9/27
 * @Time: 20:04
 * 实现非递归的遍历
 */
public class Traversal {

    /**
     * 实现非递归实现前序遍历
     * 1.root压栈
     * 2.开始弹栈 cur
     * 3.处理cur
     * 4.压入子节点  如果右孩子不为空 先压右 后压左 因为后面先弹出左孩子 这样才满足前序遍历
     * 5.循环2-4
     *
     * @param root
     * @return
     */
    public List<Integer> preOrderTraversal(TreeNode root) {

        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        if (root == null) return null;
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();

            list.add(cur.val);

            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }

        }

        return list;

    }

    /**
     * 实现非递归的后序遍历
     * 1. 弹出cur
     * 2. 处理节点，放入新栈（辅助栈）
     * 3. 入旧栈的时候，先左后右
     * 4. 重复1-3
     *
     * @param root
     * @return
     */
    public List<Integer> postOrderTraversal(TreeNode root) {

        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Stack<TreeNode> stack = new Stack<>();//第一个栈
        Stack<TreeNode> help = new Stack<>();//辅助栈
        stack.push(root);

        while (!stack.isEmpty()) {

            //弹栈
            TreeNode cur = stack.pop();

            help.push(cur);//压入辅助栈

            if (cur.left != null)
                stack.push(cur.left);
            if (cur.right != null)
                stack.push(cur.right);
        }

        while (!help.isEmpty()) {
            res.add(help.pop().val);
        }

        return res;
    }

    /**
     * 1. 先把当前节点的左边界即所有的左子节点全部进栈
     * 2. 弹出当前节点cur，处理
     * 3. 如果cur有右孩子结点，则压入右子节点
     * 4. 重复这个过程1-3
     *
     * @param root
     * @return
     */
    public List<Integer> inOrderTraversal(TreeNode root) {

        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Stack<TreeNode> stack = new Stack<>();

        while (!stack.isEmpty() || root != null) {

            if (root != null) {//左边界节点不断进栈
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();//开始弹栈
                res.add(root.val);
                root = root.right;
            }
        }

        return res;
    }


    /**
     * 层序便利
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {


        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            List<Integer> row = new ArrayList<>();

            int size = queue.size();
            for (int i = 0; i < size; i++) {//对每一层进行处理 每层的节点数
                TreeNode cur = queue.poll();//弹出
                row.add(cur.val);

                if (cur.left != null) queue.add(cur.left);
                if (cur.right != null) queue.add(cur.right);

            }
            res.add(row);
        }
        return res;

    }
}
