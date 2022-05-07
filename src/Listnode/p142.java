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

    /**
     * 返回环形链表中入环的第一个结点
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {

        if (head==null||head.next==null) return null;
        //快指针走2步 慢指针走1步 第一次相遇之后 让快指针指向头结点 然后此时两个指针同时移动 每次移动1步 直到再次相遇

        ListNode fast=head;
        ListNode slow=head;
        //因为后面快指针需要连续走两步 所以在while中可以写这样的判断条件
        while (fast.next!=null&&fast.next.next!=null){

            fast=fast.next.next;//快指针走2步
            slow=slow.next;//慢指针走1步

            //当fast==slow的时候 此时说明链表中存在环
            if (fast==slow){
                //此时让fast指向head 头结点
                fast=head;
                //此时fast slow都走一步 直到两者相等 就是入环的第一个结点了
                while (fast!=slow){
                    fast=fast.next;
                    slow=slow.next;
                }
                return fast;//直接返回fast 或者slow都行
            }
        }
        return null;//没有换的话 直接返回null

    }
}
