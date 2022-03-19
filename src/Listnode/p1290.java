package Listnode;

/**
 * @ClassName: p1290
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/9/13
 * @Time: 22:06
 */
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class p1290 {
    public int getDecimalValue(ListNode head) {

        int res = 0;
        //1.根据逆推法 计算回去
        while (head != null) {
            res = res * 2 + head.val;
            head = head.next;
        }
        return res;

    }
}
