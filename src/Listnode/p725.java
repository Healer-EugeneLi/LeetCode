package Listnode;

/**
 * @ClassName: p725
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/9/22
 * @Time: 16:39
 */
public class p725 {

    public ListNode[] splitListToParts(ListNode head, int k) {

        ListNode res[]=new ListNode[k];
        if (head==null){
            for (int i=0;i<k;i++)
                res[i]=new ListNode();
        }

        int arr[]=new int[1000];

        int length=0;
        ListNode p=head;
        while (p!=null){
            length++;
            p=p.next;
        }

       ListNode q=head;

        int a=length/k;
        int left=length%k;
        if (a<0){
            //说明不够分 left个链表有值 k-left个为[]
            int i=0;
            for (i=0;i<left;i++){
                res[i]=new ListNode(q.val);
                ListNode temp=q.next;
                q.next=null;
                q=temp;
            }
            for (int j=i;j<k;j++){
                res[j]=new ListNode();
            }
        }else {
            //a大于0说明 可以分配a个 但是剩下的left要分别加在已有的值上去 left个a+1 剩下k-left个是a而已
            int onlyA=k-left;
            int index=0;//结果的数组的下标

            while (left>0){
                int len=a+1;
                ListNode node=new ListNode();
                ListNode temp=node;
                for (int i=0;i<len;i++){

                    node.next=new ListNode(q.val);
                    q=q.next;
                    node=node.next;
                }
                node.next=null;
                //遍历完之后
                res[index]=temp.next;
                left--;
                index++;

            }

            while (onlyA>0){
                ListNode node=new ListNode();
                ListNode temp=node;
                for (int i=0;i<a;i++){

                    node.next=new ListNode(q.val);
                    q=q.next;
                    node=node.next;
                }
                res[index]=temp.next;
                index++;
                onlyA--;
            }

        }
        return res;
    }
}
