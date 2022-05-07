package Listnode;

/**
 * @ClassName: p160
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/5/2
 * @Time: 14:47
 */
public class p160 {

    /**
     * 返回相交链表的结点
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        //使用双指针遍历  设headA长度a headB长度b 第一个公共结点：node 两个链表的公共尾部长度为c
        //指针A先遍历链表headA 遍历完之后再开始遍历headB,当走到node的时候 总步数为 a+(b-c)
        //指针B先遍历链表headB 遍历完之后再开始遍历headA,当走到node的时候 总步数为 b+(a-c)
        //此时A B指针重合 a+(b-c)==b+(a-c) 有两种情况
        //1.若两个链表有公共尾部 c>0 此时A、B指向node
        //2.无公共尾部 c=0 A、B指向null

        ListNode A=headA;
        ListNode B=headB;

        while (A!=B){

            //此时A还没有遍历完headA
            if (A!=null){
                A=A.next;
            }else{
                //此时指向null 说明遍历完headA了 开始指向headB
                A=headB;
            }

            if (B!=null){
                B=B.next;
            }else{
                B=headA;
            }
        }

        //最后直接返回A或者B
        return A;

    }
}
