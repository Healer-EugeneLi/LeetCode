package JZOffer;

/**
 * @ClassName: JZOffer24
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/11/27
 * @Time: 20:26
 */
public class JZOffer24 {
    public ListNode reverseList(ListNode head) {

        if (head==null||head.next==null) return head;

        ListNode cur=head;
        ListNode pre=null;

        while (cur!=null){

            ListNode next=cur.next;//暂存当前节点的下一个节点
            cur.next=pre;//当前节点的下一个节点指向pre
            pre=cur;//pre往下移动一次
            cur=next;//cur来到暂存的节点

        }
        return pre;

    }

    public static void main(String[] args) {

    }
}
