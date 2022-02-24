package JZOffer;

import java.util.HashMap;

/**
 * @ClassName: JZOffer35
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/2/20
 * @Time: 22:54
 */

public class JZOffer35 {

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

    public Node copyRandomList(Node head) {


        if (head==null) return null;
        Node cur=head;
        HashMap<Node,Node> map=new HashMap<>();

        while (cur!=null){
            map.put(cur,new Node(cur.val));
            cur=cur.next;
        }

        cur=head;

        while (cur!=null){

            map.get(cur).next=map.get(cur.next);
            map.get(cur).random=map.get(cur.random);
            cur=cur.next;
        }

        return map.get(head);
    }
}
