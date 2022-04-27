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

//
//    //使用哈希表存储原先结点的对应关系
//    // 时间复杂度 O(N)
//    //空间复杂度 O(N)
//    //定义一个结点类
//    class Node {
//        int val;
//        Node next;
//        Node random;
//
//        public Node(int val) {
//            this.val = val;
//            this.next = null;//指向下一个结点
//            this.random = null;//指向下一个random节点
//        }
//    }
//
//    public Node copyRandomList(Node head) {
//
//
//        if (head == null) return null;
//        Node cur = head;//cur指向当前节点
//        HashMap<Node, Node> map = new HashMap<>();
//
//        while (cur != null) {
//            //map存储了遍历到的当前节点 其对应的新建的该值的结点
//            map.put(cur, new Node(cur.val));
//            cur = cur.next;//往下遍历
//        }
//
//        //此时cur再指向回头结点
//        cur = head;
//
//        //当还没遍历到尾部的时候
//        while (cur != null) {
//
//            //将cur传入map中得到其对应的该值的新节点  然后让新节点指向 cur.next值对应的新节点
//            map.get(cur).next = map.get(cur.next);
//            //同时将random指针指向 原本cur.random对应的新节点 完成random的指向
//            map.get(cur).random = map.get(cur.random);
//            //cur继续往下遍历
//            cur = cur.next;
//        }
//
//        //最后返回新链表的头结点 也就是原本的head对应的新head
//        return map.get(head);
//    }

    class Node {
                int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;//指向下一个结点
            this.random = null;//指向下一个random节点
        }
    }
    //使用原地修改的方式
    //时间复杂度 O(N)
    //空间复杂度 O(N)
    public Node copyRandomList(Node head) {

        //1.先复制链表 将新节点直接生成在原节点值的下一个

        if (head==null) return head;

        Node  cur=head;

        while (cur!=null){

            Node newNode=new Node(cur.val);
            newNode.next=cur.next;//新节点指向原先结点的下一个
            cur.next=newNode;//新节点连在旧结点的后面
            cur=newNode.next;//此时cur移动到新节点的下一个 也就是原先结点的下一个
        }

        //2.此时开始设置random的关系
        Node pre=head;//原先结点的第一个结点
        //旧节点还未遍历完
        while (pre!=null){

            //当前节点有random
            if (pre.random!=null){
                pre.next.random=pre.random.next;
            }
            pre=pre.next.next;//移动到下一个结点
        }


        //3.此时开始拆分两个链表
        Node res=head.next;//最后要返回的新链表的头结点
        pre=head;
        cur=head.next;//同上

        while (cur.next!=null){
            pre.next=pre.next.next;//将旧结点指向 旧节点的下一个的下一个
            cur.next=cur.next.next;//新节点指向 新节点的下一个的下一个

            pre=pre.next;//此时pre指向了下一个旧节点了 所以只需要让pre移到这个位置就行
            cur=cur.next;
        }
        pre.next=null;//单独处理链表尾结点
        return res;

    }
}
