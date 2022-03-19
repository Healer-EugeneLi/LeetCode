package Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName: P116
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/9/23
 * @Time: 22:27
 */
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};

public class P116 {
    public Node connect(Node root) {
        if (root == null) return root;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);


        while (!queue.isEmpty()) {


            int size = queue.size();
            Node pre = null;
            for (int i = 0; i < size; i++) {

                Node poll = queue.poll();//弹出节点
                if (pre != null) {
                    //说明已经有指向的结点了
                    pre.next = poll;
                }
                //如果为空的话 以及移动到下一个结点都是这一行
                pre = poll;

                if (poll.left != null) queue.offer(poll.left);
                if (poll.right != null) queue.offer(poll.right);
            }


        }
        return root;


    }
}
