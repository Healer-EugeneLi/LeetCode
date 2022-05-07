package Listnode;

import java.util.List;

/**
 * @ClassName: p206
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/5/1
 * @Time: 15:05
 */
public class p206 {

    /**
     * 翻转链表
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {

        //如果head为空 或者只有一个结点
        if(head==null||head.next==null) return head;

        ListNode pre=null;//首先设置前驱为null
        ListNode cur=head;//cur首先指向当前head结点

        //遍历整个链表 当链表不为空的时候
        while (cur!=null){
            ListNode next=cur.next;//当前节点的下一个节点
            cur.next=pre;//将当前节点的下一个节点的指针指向前驱 表示翻转
            pre=cur;//前驱指针后移来到当前节点的位置
            cur=next;//next来到当前指针的下一个
        }

        //最后cur肯定指向null 此时pre指向了翻转之后的链表头节点
        return pre;
    }
}
