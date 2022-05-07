package Listnode;

/**
 * @ClassName: p82
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/5/6
 * @Time: 14:50
 */
public class p82 {

    /**
     * 给定一个已经排序的链表删除重复的结点
     * 输入：head = [1,1,1,2,3]
     * 输出：[2,3]
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {

        if (head==null||head.next==null) return head;

        ListNode dumpy=new ListNode(-1);//创建一个虚拟头结点 指向head
        dumpy.next=head;


        ListNode pre=dumpy;//初始化时dumpy
        ListNode cur=head;//初始化为第一个结点


        while (cur!=null){

            //出现重复值的结点
           while (cur.next!=null&&cur.val==cur.next.val){
               cur=cur.next;
           }
           //while循环跳出之后 cur此时指向的是重复数字的最后一个数字

            //如果按照正常没有出现重复数字的话 pre的下一个结点其实是cur
            // 但是此时pre的下一个结点不等于cur 说明出现了重复数字
            // 那么就直接让pre的下一个结点为cur的下一个结点 也就是将重复数字都删除
            if (pre.next!=cur){
                pre.next=cur.next;
            }else {
                //如果pre的next为cur 说明实际是没有出现重复数字 那么让pre指向cur 也就是其下一个结点
                pre=pre.next;
            }

            //上述操作不管是有没有出现重复数字 都需要将cur下移 即来到下一个结点
            cur=cur.next;
        }

        return dumpy.next;//最后返回虚拟结点的下一个
    }


    public static void main(String[] args) {

        int arr[]={1,1,1,2,3};
        ListNode head=new ListNode(0);
        ListNode p=head;
        for (int i=0;i<arr.length;i++){
            p.next=new ListNode(arr[i]);
            p=p.next;
        }
        p82 t=new p82();
        ListNode node = t.deleteDuplicates(head.next);
        System.out.println();
    }
}
