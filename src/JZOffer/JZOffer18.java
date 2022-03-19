package JZOffer;

/**
 * @ClassName: JZOffer18
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/11/27
 * @Time: 22:26
 */
public class JZOffer18 {
//    public ListNode deleteNode(ListNode head, int val) {
//
//        if (head==null) return null;
//
//        ListNode dump=new ListNode(0);
//        dump.next=head;//虚拟节点的下一个节点才是头结点
//        ListNode p=dump;
//        ListNode cur;
//        ListNode pre=dump;
//
//        while (p.next!=null){
//
//            cur=p.next;
//            if (cur.val==val){
//                //遇到了需要删除的节点
//                pre.next=cur.next;
//                break;
//            }else {
//                pre=pre.next;
//                p=p.next;
//
//            }
//
//        }
//        return dump.next;
//
//    }

    public ListNode deleteNode(ListNode head, int val) {

        if (head.val == val) return head.next;

        ListNode pre = head, cur = head.next;

        while (cur != null && cur.val != val) {
            //当链表还没有遍历完 并且当前节点不等于val
            pre = cur;
            cur = cur.next;
        }

        //此时如果cur还不为空 说明遇到了需要删除的节点
        if (cur != null) {
            pre.next = cur.next;
        }
        return head;

    }
}
