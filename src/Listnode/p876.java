package Listnode;

/**
 * @ClassName: p876
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/9/18
 * @Time: 20:27
 */
public class p876 {

    public ListNode middleNode(ListNode head) {

        if (head == null || head.next == null) return head;

        ListNode fast = head;
        ListNode slow = head;

        while (fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == null)//对于偶数个结点 此时 fast已经指向空了 如果再循环 那么fast.next 会报空指针的错
                return slow;

        }
        return slow;
    }
}
