package JZOffer;

/**
 * @ClassName: JZOffer25
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/4/20
 * @Time: 10:12
 * 合并两个有序的链表
 */
public class JZOffer25 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (l1==null) return l2;
        if (l2==null) return l1;

        ListNode head=new ListNode(0);
        ListNode p=head;

        //比较两个链表的结点
        while (l1!=null&&l2!=null){

            //插入更小的结点值
            if (l1.val<=l2.val){
                p.next=new ListNode(l1.val);
                l1=l1.next;
            }else {
                p.next=new ListNode(l2.val);
                l2=l2.next;
            }
            p=p.next;
        }

        //判断哪个链表还没找完
        while (l1!=null){
            p.next=new ListNode(l1.val);
            p=p.next;
            l1=l1.next;
        }


        while (l2!=null){
            p.next=new ListNode(l2.val);
            p=p.next;
            l2=l2.next;
        }

        return head.next;

    }
}
