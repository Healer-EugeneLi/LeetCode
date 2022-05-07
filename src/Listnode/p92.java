package Listnode;

/**
 * @ClassName: p92
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/9/26
 * @Time: 19:52
 * <p>
 * 翻转双向链表
 */
public class p92 {

    /**
     * 翻转节点 从left位置到right位置
     *
     * @param head
     * @param left
     * @param right
     * @return
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {

        // 1->2->3->4->5->6
        //     left=3  right=5
        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode pre = dummy;//指向前一个节点
        ListNode cur = dummy.next;//当前节点
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
            cur = cur.next;
        }
        //总体的思想是逐个将要翻转的结点插入到区间的左边 最后翻转区间的左节点就变成在区间的最右边了 最右边的在最前面 实现翻转
        //此时 cur指向3 pre 指向2
        for (int i = 0; i < right - left; i++) {
            ListNode remove = cur.next;// 第一轮remove指向4  第二轮 remove指向5

            cur.next = cur.next.next;//第一轮3->5    第二轮3-6
            remove.next = pre.next;//第一轮 4->3   第二轮 5-4-3

            pre.next = remove;//2->4        第二轮2--5
            //第一轮下来变成1-2-4-3-5-6   1-2-5-4-3-6


        }

        return dummy.next;


    }

    public static void main(String[] args) {


        int arr[] = {1, 2, 3, 4, 5};

        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        for (int a : arr) {
            head.next = new ListNode(a);
            head = head.next;
        }

        p92 p92 = new p92();
        p92.reverseBetween(dummy.next, 2, 4);
    }
}
