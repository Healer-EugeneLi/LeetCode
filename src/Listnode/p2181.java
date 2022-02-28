package Listnode;

/**
 * @ClassName: p2181
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/2/27
 * @Time: 14:09
 */
public class p2181 {
    public ListNode mergeNodes(ListNode head) {

        if (head==null) return head;

        ListNode cur=head.next;

        ListNode newHead=new ListNode();//指向新的链表的指针
        ListNode p=newHead;
        while (cur!=null){

            int temp= cur.val;
            ListNode next=cur.next;
            //未遇到节点值为0的结点
            while (next.val!=0){
                temp+=next.val;
                next=next.next;
            }
            //此时遇到节点为0的了 那么构建新节点
            ListNode newNode=new ListNode(temp);
            p.next=newNode;
            p=p.next;

            //让cur指针指向next的下一个
            cur=next.next;

        }

        return newHead.next;

    }

    public static void main(String[] args) {

    }
}
