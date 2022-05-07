package Listnode;

/**
 * @ClassName: p143
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/5/3
 * @Time: 15:37
 */
public class p143 {


    /**
     * 重排链表
     * 输入：head = [1,2,3,4]
     * 输出：[1,4,2,3]
     * 目标链表为 链表的前半部分与后半部分的链表的逆序进行合并 分三步
     * 1.找到原链表的中点
     * 2.将原链表的右半段进行翻转
     * 3.将原链表的两端进行合并
     * @param head
     */
    public void reorderList(ListNode head) {

        if (head==null) return;

        //1.获取中间节点
        ListNode mid = findMiddleNode(head);

        ListNode p1=head;
        ListNode midNext=mid.next;//中间节点的下一个 也就是后半段链表的起始节点

        mid.next=null;//将前半段与后段断开

        //2.翻转后半段链表 返回翻转之后的新链表的头结点
        midNext = reverseListNode(midNext);
        //3.合并左右两段链表
        mergeList(p1,midNext);

    }

    /**
     * 返回链表的中间节点
     * 使用快慢指针进行寻找
     * 1 2 3 4 5 返回3
     * 1 2 3 4   返回2
     * @param head
     */
    public ListNode findMiddleNode(ListNode head){

        ListNode slow=head;
        ListNode fast=head;

        while (fast.next!=null&&fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }

    /**
     * 翻转链表
     * @param head
     * @return
     */
    public ListNode reverseListNode(ListNode head){

        ListNode pre=null;
        ListNode cur=head;

        while (cur!=null){
            ListNode temp=cur.next;
            cur.next=pre;
            pre=cur;
            cur=temp;
        }
        return pre;
    }

    /**
     * 合并两段链表
     * @param p1
     * @param p2
     */
    public void mergeList(ListNode p1,ListNode p2){

        ListNode p1Next;
        ListNode p2Next;

        while (p1!=null&&p2!=null){

            //保存两个链表当前头结点的下一个
            p1Next=p1.next;
            p2Next=p2.next;

            //p1先指向p2
            p1.next=p2;
            //此时p1移动到其下一个结点
            p1=p1Next;
            //p2指向p1新节点
            p2.next=p1;
            //p2更新到其原先链表中的下一个结点的位置 使用之前保存的结果
            p2=p2Next;

        }

    }
}
