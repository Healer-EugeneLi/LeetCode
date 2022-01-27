package Listnode;

/**
 * @ClassName: p237
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/11/2
 * @Time: 9:30
 */
public class p237 {

    public void deleteNode(ListNode node) {

//        4 5 1 9---> 4 1 9

        ListNode nextNode=node.next;
        ListNode pre=null;

        while (node!=null&&nextNode!=null){

            node.val=nextNode.val;
            pre=node;
            node=nextNode;
            nextNode=nextNode.next;

        }
        pre.next=null;



    }
}
