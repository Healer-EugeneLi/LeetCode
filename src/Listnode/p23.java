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
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 * */
public class p23 {

    public ListNode mergeKLists(ListNode[] lists) {

        if(lists.length==0) return null;

        ListNode pre=new ListNode(0);
        ListNode cur=pre;//当前指针先指向这个头结点

        //遍历所有的链表 找到最长的长度
        int maxLength=0;
        for (ListNode node:lists){



        }

        return null;

    }
}
