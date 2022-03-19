package Listnode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @ClassName: p148
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/9/18
 * @Time: 17:17
 */
//public class p148 {
//
//    //自顶向下归并排序
//    //使用归并排序来进行排序链表
//    public ListNode sortList(ListNode head) {
//
//        if(head==null||head.next==null) return head;
//
//        ListNode middle=middleNode(head);
//        ListNode middleRight=middle.next;
//        middle.next=null;//端开链表
//
//        ListNode left=sortList(head);//左边拍完序
//        ListNode right=sortList(middleRight);//右边拍完序
//
//        return merge(left,right);
//
//
//    }
//
//    //合并两个有序的链表
//    private ListNode merge(ListNode left, ListNode right) {
//
//        ListNode dummy=new ListNode(0);
//        ListNode res=dummy;
//
//        while (left!=null&&right!=null){
//
//            if (left.val<=right.val){
//                dummy.next=new ListNode(left.val);
//                left=left.next;
//            }else{
//                dummy.next=new ListNode(right.val);
//                right=right.next;
//            }
//            dummy=dummy.next;
//        }
//
//        dummy.next=left!=null?left:right;
//
//        return res.next;
//    }
//
//    //寻找中点
//    // 1 2 3 4 5的时候中点是2
//    // 1 2 3 4 5 6的时候中点是3
//    public ListNode middleNode(ListNode head) {
//
//        if (head==null||head.next==null) return head;
//
//        ListNode fast=head.next.next;
//        ListNode slow=head;
//
//        while (fast!=null&&fast.next!=null){
//            fast=fast.next.next;
//            slow=slow.next;
//        }
//        return slow;
//    }
//
//
//
//
//
//
//}


public class p148 {

    public ListNode sortList(ListNode head) {

        if (head == null || head.next == null) return head;

        //1.先统计链表的长度
        ListNode node = head;
        int length = 0;
        while (node != null) {
            length++;
            node = node.next;
        }
        //2.初始化引入虚拟结点
        ListNode dummy = new ListNode(0);
        dummy.next = head;


        //3.每次将链表拆分成若干个长度subLen的子链表 并按照每两个子链表移除进行合并
        for (int subLen = 1; subLen < length; subLen <<= 1) {

            ListNode pre = dummy;
            ListNode curr = dummy.next;//curr用于记录拆分链表的位置

            while (curr != null) {
                //如果链表没有拆完

                //拆分subLen长度的链表1
                ListNode head_1 = curr;
                for (int i = 1; i < subLen && curr != null && curr.next != null; i++) {
                    curr = curr.next;
                }

                ListNode head_2 = curr.next;
                curr.next = null;//断开
                curr = head_2;
                //拆分subLen长度的链表2
                for (int i = 1; i < subLen && curr != null && curr.next != null; i++) {
                    curr = curr.next;
                }

                //再次断开 第2个链表最后的next连接
                ListNode next = null;
                if (curr != null) {
                    next = curr.next;//拆分了两个链表之后的剩下的链表的头
                    curr.next = null;//断开连接
                }

                //合并两个subLen长度的有序链表
                ListNode merge = merge(head_1, head_2);
                pre.next = merge;//指向排序好的链表的头 这样就保证了拆分完之后合并起来还是一条完整的链表

                //将pre移到subLen*2的位置去
                while (pre.next != null) {
                    pre = pre.next;
                }
                curr = next;

            }
        }

        return dummy.next;


    }

    private ListNode merge(ListNode left, ListNode right) {

        ListNode dummy = new ListNode(0);
        ListNode res = dummy;

        while (left != null && right != null) {

            if (left.val <= right.val) {
                dummy.next = new ListNode(left.val);
                left = left.next;
            } else {
                dummy.next = new ListNode(right.val);
                right = right.next;
            }
            dummy = dummy.next;
        }

        dummy.next = left != null ? left : right;

        return res.next;
    }
}
