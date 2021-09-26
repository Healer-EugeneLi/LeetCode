package Listnode;

/**
 * @ClassName: offer0204
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/9/26
 * @Time: 22:34
 */
public class offer0204 {

    //
    public ListNode partition(ListNode head, int x) {

        if (head==null) return head;

        ListNode lowBegin=null;
        ListNode lowEnd=null;

        ListNode equalAndHighBegin=null;
        ListNode equalAndHighEnd=null;
        ListNode next=null;
        while (head!=null){
            next=head.next;
            head.next=null;//当前节点从链表剥离开来 用next节点记录下个节点

            if (head.val<x){
                if (lowBegin==null){
                    lowBegin=head;
                    lowEnd=head;
                }else {
                    lowEnd.next=head;
                    lowEnd=head;
                }
            }else {

                if (equalAndHighBegin==null){
                    equalAndHighBegin=head;
                    equalAndHighEnd=head;
                }else {
                    equalAndHighEnd.next=head;
                    equalAndHighEnd=head;
                }
            }
            head=next;
        }

        //将2个链表串起来
        if (lowEnd!=null){
            lowEnd.next=equalAndHighBegin;
            equalAndHighEnd=equalAndHighEnd==null?lowEnd:equalAndHighEnd;
        }



        //总的而言 就是如果loBegin为空 那么判断 equalBegin是否为空 如果equalBegin为空 那么选择highBegin
        return lowBegin!=null?lowBegin:equalAndHighBegin;

    }
}
