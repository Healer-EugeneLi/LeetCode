package Listnode;

/**
 * @ClassName: p23
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/9/10
 * @Time: 21:41
 */

import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 * 合并k个有序链表
 */
public class p23 {

    public ListNode mergeKLists(ListNode[] lists) {

        if (lists == null | lists.length == 0) return null;

        return mergeSort(lists, 0, lists.length - 1);

    }


    private ListNode mergeSort(ListNode[] lists, int begin, int end) {
        //通过mid将数组一分为二，并不断缩小规模，当规模为1时返回并开始合并
        //通过合并两个链表，不断增大其规模，整体看就是不断缩小-最后不断扩大的过程
        if (begin == end) return lists[begin];

        int middle = begin + ((end - begin) >> 1);

        ListNode n1 = mergeSort(lists, begin, middle);
        ListNode n2 = mergeSort(lists, middle + 1, end);

        return merge(n1, n2);//合并两个有序链表
    }


    private ListNode merge(ListNode n1, ListNode n2) {

        if (n1 == null) return n2;
        if (n2 == null) return n1;

        ListNode head = new ListNode();
        ListNode p = head;

        while (n1 != null && n2 != null) {

            if (n1.val < n2.val) {
                p.next = n1;
                n1 = n1.next;
            } else {
                p.next = n2;
                n2 = n2.next;
            }
            p = p.next;
        }

        if (n1 != null) {
            p.next = n1;
        }

        if (n2 != null) {
            p.next = n2;
        }
        return head.next;

    }
}
