package Listnode;

/**
 * @ClassName: p86
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/9/18
 * @Time: 22:25
 */
public class p86 {

    public ListNode partition(ListNode head, int x) {

        if (head==null) return head;
        ListNode smaller=new ListNode(0);
        ListNode leftHead=smaller;

        ListNode bigger=new ListNode(0);
        ListNode rightHead=bigger;

        int count=0;
        while (head!=null){

            if (head.val<x){
                smaller.next=new ListNode(head.val);
                smaller=smaller.next;
            }else{
                bigger.next=new ListNode(head.val);
                bigger=bigger.next;
            }

            head=head.next;
        }

        bigger.next=null;//加上这个确保最后的结点不会指向一个比x小的结点 切断
        smaller.next=rightHead.next;
        return leftHead.next;

    }

    public static void main(String[] args) {

        int[] arr={1,4,3,2,5,2};

        p86 temp=new p86();

        ListNode head=new ListNode(0);
        ListNode dummy=head;
        for (int a:arr){
            dummy.next=new ListNode(a);
            dummy=dummy.next;
        }
        ListNode partition = temp.partition(head.next, 3);

        System.out.println();

    }
}
