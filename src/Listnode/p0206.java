package Listnode;

import com.sun.org.apache.bcel.internal.generic.DUP;

import java.util.Stack;

/**
 * @ClassName: p0206
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/9/26
 * @Time: 21:19
 */
public class p0206 {

    //判断是否回文链表 使用栈的方法 先压栈 再弹栈 与原先的链表一一比较
//    public boolean isPalindrome(ListNode head) {
//
//        if (head==null) return false;
//        Stack<ListNode> stack=new Stack<>();
//
//        ListNode cur=head;
//
//        while (cur!=null){
//            stack.push(cur);
//            cur=cur.next;
//        }
//
//        cur=head;
//        while (cur!=null){
//
//            ListNode pop = stack.pop();
//            if (pop.val!=cur.val) return false;
//            cur=cur.next;
//        }
//
//        return true;
//
//    }


    /**
     * 同样用栈实现 借助快慢指针 只进栈一半的数据就好 空间复杂度O(N/2)
     * @param head
     * @return
     */
//    public boolean isPalindrome(ListNode head) {
//
//        ListNode dummy=new ListNode();
//        dummy.next=head;
//        Stack<Integer> stack=new Stack<>();
//
//        ListNode slow=head;
//        ListNode fast=head;
//        //1.快慢指针 找中点
//        while (fast!=null&&fast.next!=null){
//            fast=fast.next.next;
//            slow=slow.next;
//        }
//
//        ListNode middle=slow;//指向中点
//
//        //2.后半部分进栈
//        while(slow!=null){
//            stack.add(slow.val);
//            slow=slow.next;
//        }
//
//        //3.只需要遍历到中点就能进行回文比较
//        while (head!=middle){
//            Integer value = stack.pop();
//            if (value!=head.val) return false;
//            head=head.next;
//        }
//
//        return true;
//    }

    /**
     * 逆序右半部分链表  1->3->5->3->1         slow->5 pre->3
     *      变成两部分：1->3->5 1->3-5
     *               1->3->5->4->3->1       slow->4 pre->5
     *      变成两部分：1->3->5 1->3-4
     * @param head 复杂度O(n)
     * @return
     */
    //方法3 右半部分链表逆序 进行比较
    public boolean isPalindrome(ListNode head) {

        if (head==null||head.next==null) return true;
        ListNode dummy=new ListNode();
        dummy.next=head;

        ListNode slow=head;
        ListNode fast=head;
        ListNode pre=null;

        //找中点
        while (fast!=null&&fast.next!=null){
            pre=slow;
            slow=slow.next;
            fast=fast.next.next;

        }

        //链表翻转
        ListNode temp=null;
        fast=slow;//用来指向后半部分
        pre.next=null;//前半部分断开
        pre=null;

        while (fast!=null){
            temp=fast.next;
            fast.next=pre;
            pre=fast;
            fast=temp;
        }

        //比较链表
        slow=dummy.next;//前半部分链表头
        fast=pre;//后半部分链表头
        while (slow!=null&&fast!=null){
            if (slow.val!=fast.val) return false;
            slow=slow.next;
            fast=fast.next;
        }


        return true;

    }
}
