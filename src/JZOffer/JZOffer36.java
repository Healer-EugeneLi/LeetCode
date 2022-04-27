package JZOffer;

/**
 * @ClassName: JZOffer36
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/2/8
 * @Time: 20:03
 */

public class JZOffer36 {

    //让pre指向最后一个结点 head指向新链表的头结点
    public Node pre = null, head = null;

    public Node treeToDoublyList(Node root) {

        if (root == null) return root;
        dfs(root);
        //最后pre会指向的是整棵树的最右边的结点 循环链表 进行连接
        head.left = pre;
        pre.right = head;
        return head;

    }

    /**
     * 虑使用中序遍历访问树的各节点 cur ；
     * 并在访问每个节点时构建 cur 和前驱节点 pre 的引用指向；
     * 中序遍历完成后，最后构建头节点和尾节点的引用指向即可。
     * @param root
     */
    public void dfs(Node root) {

        if (root == null) return;

        //中序遍历模板
        dfs(root.left);
        if (pre == null) head = root;//此时遍历到的是第一个结点  也就是原先二叉树的最左节点 此时pre为空 借助pre为空来判断 所以让head来指向root
        else pre.right = root;//不为空的时候 pre的后继结点就是当前节点
        root.left = pre;//当前节点的前驱节点是pre
        pre = root;//让pre往其后继节点移动 即移动到当前节点 最为后继节点的前驱
        dfs(root.right);
    }
}
