package Listnode;

/**
 * @ClassName: p2
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/4/8
 * @Time: 9:50
 */
public class p2 {

//    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//
//        ListNode newHead=new ListNode();
//        ListNode p=newHead;
//        int add=0;//表示进位
//        int val=0;//当前要加进链表的值
//        int sum=0;//元素求和的值
//
//        while (l1!=null&&l2!=null){
//
//            sum=l1.val+l2.val+add;
//            val=sum%10;
//            add=sum/10;//表示进位
//            p.next=new ListNode(val);
//            l1=l1.next;
//            l2=l2.next;
//            p=p.next;
//        }
//
//        //如果此时l1不为空
//        while (l1!=null){
//
//            sum=l1.val+add;
//            val=sum%10;
//            add=sum/10;
//            p.next=new ListNode(val);
//            p=p.next;
//            l1=l1.next;
//        }
//        //如果此时l2不为空
//        while (l2!=null){
//            sum=l2.val+add;
//            val=sum%10;
//            add=sum/10;
//            p.next=new ListNode(val);
//            p=p.next;
//            l2=l2.next;
//
//        }
//
//        if (add!=0)
//            p.next=new ListNode(add);//如果最后还有进位
//
//        return newHead.next;
//
//    }

    //一种更加优雅的写法
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode newHead=new ListNode();
        ListNode p=newHead;
        int add=0;
        int sum=0;

        //如果两个链表有一个不为空 或者进位add不是0 就可以继续
        while (l1!=null||l2!=null||add!=0){

            sum=add;//先设置为上一次的进位 也就是先加进来
            if (l1!=null){
                sum+=l1.val;
                l1=l1.next;
            }

            if (l2!=null){
                sum+=l2.val;
                l2=l2.next;
            }

            p.next=new ListNode(sum%10);
            add=sum/10;
            p=p.next;
        }
        return newHead.next;
    }
}
