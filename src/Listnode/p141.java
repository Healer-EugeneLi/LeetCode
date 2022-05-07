package Listnode;

/**
 * @ClassName: p141
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/5/1
 * @Time: 19:53
 */
public class p141 {

    /**
     * 判断一个链表中是否有环
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {

        //使用快慢指针去寻找 快指针每次走两步 慢指针每次走一步 那么快指针最后一定会追上满指针 说明有环
        if (head==null||head.next==null)return false;

        ListNode fast=head;
        ListNode slow=head;
        while (fast.next!=null&&fast.next.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if (slow==fast)//相遇了 说明是有环的
                return true;
        }
        return false;


    }

}
