package JZOffer;

import java.util.HashSet;
import java.util.List;

/**
 * @ClassName: JZOffer52
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/1/16
 * @Time: 20:48
 */
public class JZOffer52 {


    /**
     * 使用哈希set的方式 存放其中一条链表的结点
     * 遍历另一条链表 判断是否在set中
     * @param headA
     * @param headB
     * @return
     */
//    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//
//        HashSet<ListNode> set=new HashSet<>();
//
//        ListNode pA=headA;
//        while (pA!=null){
//            set.add(pA);
//            pA=pA.next;
//        }
//
//        ListNode pB=headB;
//        while (pB!=null){
//
//            if (set.contains(pB))
//                return pB;
//            pB= pB.next;
//        }
//
//        return null;
//
//    }

    /**
     * 使用双指针进行遍历
     * 两个指针分别遍历两条链表
     * pA 遍历headA
     * pB 遍历headB
     * 当其中一条遍历到结尾 将该指针指向另一条链表的头结点 继续遍历
     * 直到两个指针汇聚
     * @param headA
     * @param headB
     * @return
     */

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if (headA==null||headB==null)
            return null;
       ListNode pA=headA;
       ListNode pB=headB;

       while (pA!=pB){

           if (pA==null)
               pA=headB;//到达链表结点  指向另一条链表的头结点
           else
               pA=pA.next;

           if (pB==null)
               pB=headA;
           else
               pB=pB.next;
       }
       return pA;

    }
}
