package Listnode;

/**
 * @ClassName: p147
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/9/18
 * @Time: 19:24
 */
public class p147 {

    public ListNode insertionSortList(ListNode head) {

        if (head == null) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode lastNode = head;
        ListNode cur = head.next;//待插入节点

        while (cur != null) {

            if (cur.val >= lastNode.val) {
                lastNode = lastNode.next;
                cur = cur.next;
            } else {

                //开始遍历链表 寻找可以插入的位置
                ListNode pre = dummy;
                while (pre.next.val < cur.val) {
                    pre = pre.next;
                }
                //此时pre.next 的结点是比cur的大或者等于
                lastNode.next = cur.next;//先保存cur的下一个结点
                cur.next = pre.next;
                pre.next = cur;

                cur = lastNode.next;

            }
        }

        return dummy.next;

    }
}
