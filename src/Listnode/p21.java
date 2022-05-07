package Listnode;

/**
 * @ClassName: p21
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/5/1
 * @Time: 19:29
 */
public class p21 {

    /**
     * 合并两个有序的链表
     * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if (list1==null) return list2;
        if (list2==null) return list1;

        ListNode head=new ListNode();
        //哪个链表的头结点 先让head指向他
        if (list1.val<list2.val){
            head=list1;
            list1=list1.next;
        }else{
            head=list2;
            list2=list2.next;
        }

        ListNode cur=head;

        while (list1!=null&&list2!=null){
            //哪个更小就指向哪个
            if (list1.val<=list2.val){
                cur.next=list1;
                cur=cur.next;
                list1=list1.next;
            }else {
                cur.next=list2;
                cur=cur.next;
                list2=list2.next;
            }
        }

        //list1还未遍历完 直接指向此时的list1
        if (list1!=null){
            cur.next=list1;
        }
        if (list2!=null){
            cur.next=list2;
        }
        return head;

    }
}
