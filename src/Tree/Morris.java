package Tree;

/**
 * @ClassName: Morris
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/10/28
 * @Time: 21:57
 * Morris遍历
 */
public class Morris {

//-------------------------------------morris遍历原版--------------------------------------
    public void morris(Node head){

        if (head==null) return;

        Node cur=head;
        Node mostRight=null;


        while (cur!=null){
            //cur不为空的时候遍历

            mostRight=cur.left;//mostRight是cur的左孩子
            //不为空 表明有左子树
            if (mostRight!=null){

                //找到左子树的最右节点
                while (mostRight.right!=null&&mostRight.right!=cur){
                    //mostRight.right!=cur 表明这是第一次来到这个节点 此时是当前节点的左子树的最右结点
                    mostRight=mostRight.right;
                }

                //如果mostRight的右指针 指向空 让其指向cur 然后cur向左移动
                if (mostRight.right==null){
                    mostRight.right=cur;
                    cur=cur.left;
                    continue;//继续走
                }else {
                    //==cur的话 就表明是第二次来到这里 让其指向空
                    mostRight.right=null;
                }

                //然后跳出这个循环之后 同样指向cur向右移动
            }

            cur=cur.right;//
        }
    }
    //-------------------------------------------morris 先序遍历---------------------------------------

    /**
     * morris的先序遍历版本
     * @param head
     */
    public void morrisPre(Node head){

        if (head==null) return;

        Node cur=head;

        Node mostRight=null;

        while (cur!=null){

            mostRight=cur.left;

            if (mostRight!=null){

                while (mostRight.right!=null&&mostRight.right!=cur){
                    //还没经过两次
                    mostRight=mostRight.right;
                }

                if (mostRight.right==null){
                    //这是第一次来到
                    System.out.println(cur.val);
                    mostRight.right=cur;//开始设置指向cur了
                    continue;
                }else {
                    //第二次经过
                    mostRight.right=null;//取消cur节点的左子树的左右结点的指向
                }
            }else {
                //没有左子树的情况
                System.out.println(cur.val);
            }
            cur=cur.right;
        }

    }
//-----------------------------------morris 中序遍历-------------------------------------------
    /**
     * Morris的中序遍历
     * 第一次遇到的时候输出
     * 对于有两次遇到的 第二次遇到之后再输出
     * @param head
     */
    public void morrisIn(Node head){

        if (head==null) return;

        Node cur=head;
        Node mostRight=null;


        while (cur!=null){
            //cur不为空的时候遍历

            mostRight=cur.left;//mostRight是cur的左孩子
            //不为空 表明有左子树
            if (mostRight!=null){

                //找到左子树的最右节点
                while (mostRight.right!=null&&mostRight.right!=cur){
                    //mostRight.right!=cur 表明这是第一次来到这个节点 此时是当前节点的左子树的最右结点
                    mostRight=mostRight.right;
                }

                //如果mostRight的右指针 指向空 让其指向cur 然后cur向左移动
                if (mostRight.right==null){
                    mostRight.right=cur;
                    cur=cur.left;
                    continue;//继续走
                }else {
                    //==cur的话 就表明是第二次来到这里 让其指向空
                    mostRight.right=null;
                }

                //然后跳出这个循环之后 同样指向cur向右移动
            }

            System.out.println(cur.val);//由于在第一次遇到的时候会被continue跳过 所以执行完第二次跳出来之后 输出 也就是第二次遇到的时候输出

            cur=cur.right;//
        }
    }

//-----------------------------------------------morris 后序遍历--------------------------
    /**
     * 以x为头的树 逆序打印这棵树的右边界
     * @param x
     */
    public void printEdge(Node x){

        Node tail=reverseEdge(x);//先翻转一下
        Node cur=tail;
        while (cur!=null){
            System.out.println(cur.val+" ");
            cur=cur.right;
        }

        //再翻转回去 保持原样
        reverseEdge(tail);


    }

    //翻转以from为根节点的右子树 这条链表
    public Node reverseEdge(Node from){

        Node pre=null;
        Node next=null;

        while (from!=null){
            next=from.right;//临时保存from的下一个指针
            from.right=pre;//from的下一个指针指向前面 如果是第一个 那就是指向空啦
            pre=from;//pre往后移
            from=next;//from也往后移
        }
        return pre;//最后返回逆序之后的指针

    }


    /**
     * Morris实现后序遍历
     * @param head
     */
    public void morrisPos(Node head){

        if (head==null) return;

        Node cur=head;

        Node mostRight=null;

        while (cur!=null){

            mostRight=cur.left;

            if (mostRight!=null){

                while (mostRight.right!=null&&mostRight.right!=cur){
                    //还没经过两次
                    mostRight=mostRight.right;
                }

                if (mostRight.right==null){
                    //这是第一次来到
                    System.out.println(cur.val);
                    mostRight.right=cur;//开始设置指向cur了
                    continue;
                }else {
                    //第二次经过
                    mostRight.right=null;//取消cur节点的左子树的左右结点的指向

                    //对于后序遍历来说 第二次经过的时候逆序打印其左子树的右边界
                    printEdge(cur.left);
                }
            }
            cur=cur.right;
        }

        //最后再单独逆序打印头结点的右子树
        printEdge(head);

    }


    /**
     * 使用Morris判断一棵树是否是线索二叉树
     * @param head
     * @return
     */
    public boolean isBinaryTree(Node head){

        if (head==null) return true;

        int preVal=Integer.MIN_VALUE;

        Node cur=head;
        Node mostRight=null;

        while (cur!=null){


            mostRight=cur.left;

            if (mostRight!=null){

                while (mostRight!=null&&mostRight.right!=cur){
                    mostRight=mostRight.right;
                }

                if (mostRight.right==null){
                    mostRight.right=cur;
                    cur=cur.left;
                    continue;
                }else {
                    mostRight.right=null;

                }

            }
            if (cur.val<preVal){
                //出现结点比上一个遍历到的结点小的话 就不符合线索二叉树 值递增的要求
                return false;
            }
            preVal=cur.val;

            cur=cur.right;
        }
        return true;

    }


    public static void main(String[] args) {

    }

}
