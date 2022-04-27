package Listnode;

/**
 * @ClassName: p25
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/4/20
 * @Time: 21:44
 * k个一组进行翻转链表
 */
public class p25 {

    /**
     * 使用递归的方式 每一次进行翻转k个 翻转完之后继续递归下去翻转
     *
     * 当后续的结点达不到k个的时候直接返回
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode tail=head;//指向当前进入的头结点
        for (int i=0;i<k;i++){

            if (tail==null){
                return head;//说明此时已经不够k个了 直接返回传进来的头结点
            }
            tail=tail.next;
        }

        //如果满足条件的话 则已经转化成翻转head到tail的这些结点
        ListNode pre=null;
        ListNode cur=head;
        while (cur!=tail){
            ListNode next=cur.next;//临时节点
            cur.next=pre;//指向前一个节点
            pre=cur;//同时让pre往下移
            cur=next;//此时cur指向临时保存的结点next
        }

        //翻转了这k个之后肯定是之前的头结点在最后 所以将头结点指向 后续递归翻转的结果
        head.next=reverseKGroup(tail,k);//tail指向的下一轮的起始结点

        //而最后pre指向的正是翻转之后的头结点
        return pre;

    }
}
