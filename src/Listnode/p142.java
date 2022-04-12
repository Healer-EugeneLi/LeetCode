package Listnode;

/**
 * @ClassName: p142
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/4/8
 * @Time: 10:43
 * 环形链表 找到入环的结点
 */
public class p142 {


    public ListNode detectCycle(ListNode head) {

        if (head==null||head.next==null) return null;
        //快指针走2步 慢指针走1步 第一次相遇之后 让快指针指向头结点 然后此时两个指针同时移动 每次移动1步 直到再次相遇

        ListNode fast=head;
        ListNode slow=head;

        while (fast.next!=null&&fast.next.next!=null){

            fast=fast.next.next;
            slow=slow.next;

            if (fast==slow){

                fast=head;
                while (fast!=slow){
                    fast=fast.next;
                    slow=slow.next;
                }
                return fast;
            }
        }
        return null;

    }
}
