package Listnode;

/**
 * @ClassName: NodeLooper
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/9/27
 * @Time: 11:31
 */
public class NodeLooper {

    /**
     * 判断链表是否有环
     * @param head
     * @return
     */
    public static ListNode getLooper(ListNode head){

        if (head==null||head.next==null) return null;

        if (head.next.next==head) return head;//一个节点与自己本身相交
        //到这里已经表明 至少有2个节点
        ListNode slow=head.next;
        ListNode fast=head.next.next;

        boolean loop=false;

        while (slow.next!=null&&fast.next.next!=null){

            if (slow==fast){
                //如果有环 必定相遇
                loop=true;
                break;
            }
            slow=slow.next;
            fast=fast.next.next;
        }

        if (!loop) return null;//无环
        //让fast指向头结点
        fast=head;//相遇点与开头一起走 每次走一步
        while (fast!=slow){
            fast=fast.next;
            slow=slow.next;
        }

        return fast;//返回第一个入环节点


    }

    /**
     * 计算无环的情况下两个相交链表的入环节点
     * @param headA
     * @param headB
     * @param lastNode 两个链表的最后一个结点
     * @return
     */
    public static ListNode getIntersectionByLastNode(ListNode headA,ListNode headB,ListNode lastNode){

        //1.先计算两个链表长度
        int lenA=0;
        int lenB=0;
        ListNode curA=headA;
        ListNode curB=headB;
        while (curA!=null){
            lenA++;
            curA=curA.next;
        }

        while (curB!=null){
            lenB++;
            curB=curB.next;
        }

        curA=lenA>lenB?headA:headB;//curA此时指向了长的链表
        curB=curA==headA?headB:headA;//curB指向短的

        //2.长链表走差值步
        int n=Math.abs(lenA-lenB);//差值 长的链表需要先走n步
        while (n>0){
            curA=curA.next;
            n--;
        }

        while (curA!=curB){

            curA=curA.next;
            curB=curB.next;
        }

        return curA;


    }

    /**讨论两个链表无环的情况  a
     * 计算两个无环链表的相交节点，有则返回该节点，否则返回null
     * @param headA
     * @param headB
     * @return
     */
    public static ListNode getIntersectionNodeByNoLoop(ListNode headA,ListNode headB){

        ListNode headAEnd =headA;
        ListNode headBEnd=headB;

        while (headAEnd.next!=null){
            headAEnd=headAEnd.next;
        }
        while (headBEnd.next!=null){
            headBEnd=headBEnd.next;
        }

        if (headAEnd!=headBEnd) return null;//a.1  两个无环链表不相交 返回null
        else
            return getIntersectionByLastNode(headA,headB,headAEnd);//a.2  相交了 找相交的节点

    }

    /**
     * 讨论两个链表有环的情况  b
     * 求两个有环链表的相交节点
     * @param headA
     * @param headB
     * @param loopA A的入环节点
     * @param loopB B的入环节点
     * @return
     */
    public static ListNode getIntersectionNodeByLoop(ListNode headA,ListNode headB,ListNode loopA,ListNode loopB){

        if (loopA==loopB){
            //b.2   转化为求 两个无环链表的的相交节点
            return getIntersectionByLastNode(headA,headB,loopA);
        }
        //绕一周
        ListNode curA=loopA.next;
        while (curA!=loopB){

            if (curA==loopB){
                //相交在环内 b.3情况 返回其中一个相交节点就行
                return loopB;
            }
            loopA=loopA.next;
        }

        //b.1的情况 loopA 绕了一周没与loopB 相遇 所以不相交
        return null;

    }

    /**
     * 完整的讨论两个链表的相交情况
     * @param headA
     * @param headB
     * @return
     */
    public static ListNode getIntersectionNode(ListNode headA,ListNode headB){

        ListNode loopA=getLooper(headA);
        ListNode loopB=getLooper(headB);

        if (loopA==null&&loopB==null){
            // 两个都无环 a情况
            return getIntersectionNodeByNoLoop(headA,headB);
        }else if (loopA!=null&&loopB!=null){
            //两个都有环 b情况
            return getIntersectionNodeByLoop(headA,headB,loopA,loopB);
        }else
            return null;// 一个有环 一个无环 c情况
    }
}
