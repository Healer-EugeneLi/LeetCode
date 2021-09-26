package Listnode;

/**
 * @ClassName: p430
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/9/24
 * @Time: 20:25
 */
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
public class p430 {

//    public Node flatten(Node head) {
//
//        Node dummy=new Node();
//        dummy.next=head;
//        while (head!=null){
//            if (head.child==null){
//                head=head.next;
//            }else {
//                //遇到如果有child的点  先保存下一个
//                Node temp=head.next;
//
//                Node chead = flatten(head.child);//chead是下一层扁平化的最后结果
//                head.next=chead;
//                chead.prev=head;
//                head.child=null;//将head的孩子结点设置为空 因为已经连接成相邻节点了
//                while (head.next!=null) head=head.next;//使得head遍历到结尾了
//                head.next=temp;//与原先保存的临时节点相连
//                if (temp!=null){
//                    temp.prev=head;
//                }
//            }
//        }
//        return dummy.next;
//
//
//    }

    public Node flatten(Node head) {

        dfs(head);
        return head;
    }

    private Node dfs(Node head) {


        Node last=head;
        while (head!=null){

            if (head.child==null){
                last=head;
                head=head.next;
            }else {

                Node temp=head.next;
                Node childLast = dfs(head.child);
                head.next=head.child;
                head.child.prev=head;
                head.child=null;

                if (childLast!=null) childLast.next=temp;
                if (temp!=null) temp.prev=childLast;

                last=head;
                head=childLast;
            }

        }
        return last;
    }
}
