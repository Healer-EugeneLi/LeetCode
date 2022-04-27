package JZOffer;

/**
 * @ClassName: JZOffer24
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/11/27
 * @Time: 20:26
 * 翻转链表
 */
public class JZOffer24 {
    public ListNode reverseList(ListNode head) {

        if (head == null || head.next == null) return head;

        ListNode cur = head;
        ListNode pre = null;//前驱节点一开始指向null 在翻转的时候一开始头结点就可以指向前驱节点 直接设置为null

        //cur指向当前节点 不断的往后遍历 知道null的时候说明翻转结束
        while (cur != null) {

            ListNode next = cur.next;//暂存当前节点的下一个节点
            cur.next = pre;//当前节点的下一个节点指向pre
            pre = cur;//pre往下移动一次
            cur = next;//cur来到暂存的节点

        }
        //最后pre指向的是翻转之后的头结点
        return pre;

    }

    public static void main(String[] args) {

    }
}
