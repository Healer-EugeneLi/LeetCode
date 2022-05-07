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
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        stack.push(root);//先将根节点压入
        //当栈中不为空的时候 说明还有节点
        while (!stack.isEmpty()) {
            //弹出栈顶元素
            TreeNode cur = stack.pop();

            //直接加入 该元素到列表中  一开始压入的是根节点 所以此时弹出就可以压入根节点 符合前序遍历
            res.add(cur.val);

            //如果右子树不为空 那么先压入右子树的结点 因为栈是先进后出  所以压入的顺序是右子树 左子树 然后再弹出来的时候 就可以先得到左子树了
            //这样才符合前序遍历
            if (cur.right != null) {
                stack.push(cur.right);
            }
            //后压入左子树
            if (cur.left != null) {
                stack.push(cur.left);
            }

        }

        return res;

    }

    /**
     * 实现非递归的后序遍历
     * 1. 弹出cur
     * 2. 处理节点，放入新栈（辅助栈）
     * 3. 入旧栈的时候，先左后右
     * 4. 重复1-3
     *整体思想是先将最后要后续遍历的结果存放在辅助栈  等最后弹出的时候就是后序遍历的结果
     * @param root
     * @return
     */
    public List<Integer> postOrderTraversal(TreeNode root) {

        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Stack<TreeNode> stack = new Stack<>();//第一个数据栈
        Stack<TreeNode> help = new Stack<>();//辅助栈
        stack.push(root);

        //数据栈不为空
        while (!stack.isEmpty()) {

            //弹出栈顶结点
            TreeNode cur = stack.pop();

            //弹出一个就将它压入辅助栈
            help.push(cur);

            //此时先判断这个节点的左子树是否有左子树 有就加入辅助栈
            // 因为最后 左子树可以更后面弹出来 然后其子树的结点更后面加入到辅助栈 后面弹出来的时候就能够先出来 符合后序遍历
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

        //栈不为空 或者还没有到叶子结点
        while (!stack.isEmpty() || root != null) {

            //此时root当前节点不为空
            if (root != null) {
                //当前节点进栈
                stack.push(root);
                //然后root往左边走 因为我们要先把所有左子树都加进去
                root = root.left;
            } else {
               //栈不为空 但是当前root为null 说明来到叶子节点
               //开始弹栈
                root = stack.pop();
                //加入当前值
                res.add(root.val);
                //此时开始判断右子树是否有结点 往右走
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
        queue.add(root);//先加入根节点

        //当队列中不为空的时候
        while (!queue.isEmpty()) {

            //存放每一层的结点
            List<Integer> row = new ArrayList<>();

            int size = queue.size();//当前层的结点数
            //遍历当前层的所有结点
            for (int i = 0; i < size; i++) {
                //弹出当前节点
                TreeNode cur = queue.poll();
                row.add(cur.val);

                //左右子树不为空 就加入
                if (cur.left != null) queue.add(cur.left);
                if (cur.right != null) queue.add(cur.right);

            }
            //加入每一层的数据
            res.add(row);
        }
        return res;

    }
}
