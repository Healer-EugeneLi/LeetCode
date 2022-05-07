package Listnode;

/**
 * @ClassName: BM2
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/5/1
 * @Time: 15:20
 */
public class BM2 {

    /**
     * 指定区间翻转链表
     * @param head
     * @param m
     * @param n
     * @return
     */
    public ListNode reverseBetween (ListNode head, int m, int n) {

        //采用一次遍历的方法

        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode pre=dummy;
        for (int i=0;i<m-1;i++){
            pre=pre.next;
        }
        //pre此时执行的是要翻转第m个结点的前一个

        ListNode cur=pre.next;
        ListNode curNext;//指向的是cur的下一个结点
        //总的需要翻转n-m个结点
        for (int i=0;i<n-m;i++){

            curNext=cur.next;
            cur.next=curNext.next;//让cur来指向下一个结点的下一个结点
            curNext.next=pre.next;//让cur的下一个结点指向pre的下一个 也就是每次遍历到一个结点都拿来放到pre的下一个 也就是m结点的这个位置
            pre.next=curNext;//让pre指向curNext
        }

        return dummy.next;

    }
}
