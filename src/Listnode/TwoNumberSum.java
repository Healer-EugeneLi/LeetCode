package Listnode;

/**
 * @ClassName: TwoNumberSum
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/5/12
 * @Time: 20:19
 */

/**
 * Definition for singly-linked list.
 * */
//class ListNode {
//      int val;
//      ListNode next;
//      ListNode() {}
//      ListNode(int val) { this.val = val; }
//      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
// }

/**
 *
 * 两个链表相加 看成是相同长度进行遍历 如果一个链表长度比较短 在前面补0 987+23=987+023
 *
 * 每一位计算的时候考虑进位问题 而当前位计算结束后同样需要更新进位值
 * 如果两个链表全部遍历之后 进位值为1 则在新链表最前方添加节点1
 *  对于链表问题 返回结果为头结点时  通常需要先初始化一个预选指针 pre 该pre指针的下一个结点才是真正的头结点head
 *  987+023
 *
 *  就是 9 8 7   指针从7 开始
 *  +   0 2 3   指针从3开始
 *  ——————————
 * =  1 0 1 0
 */

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode pre=new ListNode(0);//预设一个头指针 指向头结点
        ListNode cur=pre;//当前节点 一开始也是指向pre

        int add=0;//记录进位

        while(l1!=null||l2!=null){
            //使用||才能使得当一个链表为空的时候 另一个不为空 可以继续进行相加

            int a= l1==null ? 0: l1.val;
            int b=l2==null?0:l2.val;

            int sum=a+b+add;//两数相加
            add=sum/10;//获取进位
            sum=sum%10;//进位之后剩下的值

            cur.next=new ListNode(sum);//创建一个新的结点
            cur=cur.next;//当前指针移到新的结点

            if(l1!=null) l1=l1.next;
            if(l2!=null) l2=l2.next;

        }

        if(add!=0)
            cur.next=new ListNode(add);//如果最后有进位值  新增一个节点
        return pre.next;//返回预设的头指针的下一个节点 才是真的头节点


    }
}

public class TwoNumberSum {

    public static void main(String[] args) {

        ListNode h1=new ListNode(7);
        ListNode head=h1;
        h1.next=new ListNode(8);
        h1=h1.next;
        h1.next=new ListNode(9);

        ListNode h2=new ListNode(3);
        h2.next=new ListNode(2);

        Solution s=new Solution();
        ListNode listNode = s.addTwoNumbers(head, h2);

        while (listNode!=null){
            System.out.println(listNode.val);
            listNode=listNode.next;
        }

    }


}
