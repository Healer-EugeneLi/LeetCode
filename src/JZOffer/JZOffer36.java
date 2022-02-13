package JZOffer;

/**
 * @ClassName: JZOffer36
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/2/8
 * @Time: 20:03
 */

public class JZOffer36 {

    public Node pre=null,head=null;

    public Node treeToDoublyList(Node root) {

        if (root==null) return root;
        dfs(root);
        head.left=pre;
        pre.right=head;
        return head;

    }


    public void dfs(Node root){

        if (root==null) return;

        dfs(root.left);
        if (pre==null) head=root;//此时遍历到的是第一个结点 此时pre为空
        else pre.right=root;//不为空的时候 pre的后继结点就是当前节点
        root.left=pre;//当前节点的前驱节点是pre
        pre=root;//让pre往其后继节点移动
        dfs(root.right);
    }
}
