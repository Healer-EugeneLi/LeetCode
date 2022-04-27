package JZOffer;

/**
 * @ClassName: JZOffer22
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/4/19
 * @Time: 22:18
 *
 * 链表中倒数第k个节点
 */
public class JZOffer22 {

//    public ListNode res=null;
//    public int count=0;
//    public ListNode getKthFromEnd(ListNode head, int k) {
//
//        count=k;
//        recur(head);
//        return res;
//    }
//
//    /**
//     * 递归到最后一个结点 然后不断返回 返回回溯的时候找到倒数第k个结点
//     * @param node
//     */
//    public void recur(ListNode node){
//
//        if (node==null)
//            return;
//
//        recur(node.next);
//        count--;
//        if (count==0){
//            res=node;
//            return;
//        }
//    }

    /**
     * 使用两个指针的方式
     * 一开始前指针former 与后指针later都指向head
     * 让前指针先走k步  然后后指针与前指针一起往前走
     * 当前指针来到null的时候，由于later指针一直在former的前面k个位置，因此此时later指向的就是倒数第k个结点
     * @param head
     * @param k
     * @return
     */
    public ListNode getKthFromEnd(ListNode head, int k) {

        if (k==0) return null;
        ListNode former=head;//前指针
        ListNode later=head;//后指针

        for (int i=0;i<k&&former!=null;i++)
            former=former.next;
        while (former!=null){
            former=former.next;
            later=later.next;
        }
        return later;
    }
}
