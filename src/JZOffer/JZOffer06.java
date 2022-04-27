package JZOffer;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName: JZOffer06
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/4/19
 * @Time: 9:50
 * 从尾到头打印链表
 */
public class JZOffer06 {
//
//    /**
//     * 递归法：
//     * 传入head 不断地递归 知道来到空节点null
//     * 然后再返回的时候不断的往列表里面存入节点的值
//     * 时间复杂度：O(N) 遍历链表 递归n次
//     * 空间复杂度：O(N) n个元素
//     * @param head
//     * @return
//     */
//    public List<Integer> temp=new ArrayList<>();
//    public int[] reversePrint(ListNode head) {
//
//        if (head==null) return new int[]{};
//
//        recur(head);
//
//        int res[]=new int[temp.size()];
//        for (int i=0;i<temp.size();i++){
//            res[i]=temp.get(i);
//        }
//        return res;
//
//    }
//
//    public void recur(ListNode node){
//        if (node==null) return;
//        recur(node.next);
//        temp.add(node.val);//递归回溯的时候加入节点
//    }

    /**
     * 辅助栈
     * 压入节点到栈 最后从栈顶开始弹出  实现从尾部开始打印
     * @param head
     * @return
     */
    public int[] reversePrint(ListNode head) {


        if (head==null) return new int[]{};
        Stack<Integer> stack=new Stack<>();

        while (head!=null){
            stack.add(head.val);
            head=head.next;
        }

        int n=stack.size();
        int res[]=new int[n];
        for (int i=0;i<n;i++){//注意不可以在循环的时候 采取<stack.size()的形式 不然会出错 因为size会随着栈的元素弹出而变小
            res[i]=stack.pop();
        }
        return res;
    }

    public static void main(String[] args) {

        ListNode head=new ListNode(0);
        ListNode p=head;
        p.next=new ListNode(1);
        p=p.next;
        p.next=new ListNode(3);
        p=p.next;
        p.next=new ListNode(2);

        JZOffer06 t=new JZOffer06();
        int[] res = t.reversePrint(head.next);
        for (int a:res)
            System.out.println(a);
    }
}
