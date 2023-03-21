package Listnode;

/**
 * @ClassName: p19
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/5/7
 * @Time: 10:33
 */
public class p19 {


    /**
     * 删除链表的倒数第n个结点
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {

        //要删除倒数第n个结点 那么使用快慢指针 一开始两个指针都指向虚拟头节点
        //然后让fast先走n+1步 比如求倒数第2个结点 先让他走3个结点

        ListNode dummy=new ListNode(-1);
        dummy.next=head;

        ListNode fast=dummy;
        ListNode slow=dummy;

        //fast指针先走n+1步
        for (int i=0;i<n+1&&fast!=null;i++){
            fast=fast.next;
        }

        //此时slow fast一起走 直到fast为空
        while (fast!=null){
            fast=fast.next;
            slow=slow.next;
        }

        //此时slow的下一个结点就是要被删除的结点
        slow.next=slow.next.next;
        return dummy.next;
    }
}
