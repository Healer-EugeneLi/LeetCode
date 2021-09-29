package Listnode;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: p138
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/9/27
 * @Time: 10:34
 */
public class p138 {

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    //使用哈希表的方法来实现
//    public Node copyRandomList(Node head) {
//
//        if (head==null) return head;
//
//        Map<Node,Node> map=new HashMap();
//        Node cur=head;
//        while (cur!=null){
//
//            map.put(cur,new Node(cur.val));
//            cur=cur.next;
//        }
//
//        cur=head;
//        while (cur!=null){
//            //取出来
//            map.get(cur).next=map.get(cur.next);//取出来的当前节点所克隆的结点 其next指向原先的结点的下一个的克隆节点
//            map.get(cur).random=map.get(cur.random);
//
//            cur=cur.next;
//        }
//
//        return map.get(head);//取出原先head所对应的克隆节点
//
//    }

    /**
     * 使用O(1)的空间来实现 1-1'-2-2'-3-3'
     * @param head
     * @return
     */
    public Node copyRandomList(Node head) {

        if (head==null) return head;

        Node cur=head;

        //1.先克隆节点 并放在原先节点的后面 1-2-3  1-1'-2-2'-3-3'
        while (cur!=null){

            Node next=cur.next;//下一个待克隆的结点
            Node cloneCur=new Node(cur.val);//克隆出来的结点
            cloneCur.next=next;
            cur.next=cloneCur;
            cur=next;//移动到下一个待克隆的结点
        }

        //2.复制random指针 通过旧节点next快速访问新节点
        cur=head;
        while (cur!=null){

            Node curClone=cur.next;//这就是当前节点的克隆节点
            Node next=curClone.next;//待寻找random的指针
            curClone.random=cur.random==null?null:cur.random.next;//cur.random是原先节点的random指针指向的结点 那他的克隆节点就是下一个
            cur=next;

        }

        //3.拆分链表

        cur=head;
        Node newHead=cur.next;

        while (cur!=null){
            Node curClone=cur.next;//cur的克隆节点
            Node curNext=curClone.next;//下一个旧节点
            Node curNextClone=curNext==null?null:curNext.next;//下一个结点节点的克隆节点
            cur.next=curNext;
            curClone.next=curNextClone;
            cur=curNext;


        }
        return newHead;
    }
}
