package Tree;

import org.omg.CORBA.PRIVATE_MEMBER;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * @ClassName: p98
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/9/28
 * @Time: 9:45
 */
public class p98 {


    private  long preValue=Long.MIN_VALUE;


    /**
     * 判断一颗树是否是二叉树
     * 通过前序遍历 如果遍历的过程中出现了降序 则不是二叉搜索树
     * @param root
     * @return
     */
//    public boolean isValidBST(TreeNode root) {
//
//        if (root==null) return true;
//
//        boolean left = isValidBST(root.left);
//        if (left==false) return false;
//
//        if(root.val<=preValue){
//            return false;//当前父节点小于等于前一个值 很显然出现降序了
//        }else
//            preValue=root.val;
//
//       return isValidBST(root.right);
//
//
//    }

    /**
     * 使用非递归来实现
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {

        if (root==null||(root.left==null&&root.right==null)) return true;

        Stack<TreeNode> stack=new Stack<>();

        while (!stack.isEmpty()||root!=null){

            if (root!=null){
                stack.push(root);
                root=root.left;
            }else {
                root = stack.pop();
                if (root.val>preValue){
                    preValue=root.val;
                }else return false;
                root=root.right;
            }
        }
        return true;
    }

    /**
     * 判断一棵树是否是完全二叉树
     * @param root
     * @return
     */
    public boolean isCompleteTree(TreeNode root){
        if (root==null) return true;

        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        boolean flag=false;
        while (!queue.isEmpty()){

            TreeNode cur = queue.poll();
            TreeNode curLeft = cur.left;
            TreeNode curRight=cur.right;
            if (cur.right!=null&&cur.left==null) {
                return false;//右孩子节点不为空 但是左孩子节点为空  显然不符合完全二叉树
            }
            else if (flag==true&&(curLeft!=null||curRight!=null)) {
                return false;//如果已经出现过有那种孩子不全的情况 那么接下来的结点就必须都是叶子节点 不可能有左孩子 或者不可能有右孩子
            }

            if (curLeft!=null) queue.offer(curLeft);

            if (curRight!=null) queue.offer(curRight);

            if (curLeft==null||curRight==null) flag=true;//标记一下已经有出现过孩子结点不全的情况

        }
        return true;
    }


    static class  ResultType{
        boolean isBalanced;
        int height;

        public ResultType(boolean isBalanced,int height){
            this.isBalanced=isBalanced;
            this.height=height;
        }
    }
    /**
     * 判断一颗树是否是平衡二叉树
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {

        return process(root).isBalanced;

    }

    //开始递归的处理过程
    private ResultType process(TreeNode root) {

        //1.边界条件
        if(root==null) return new ResultType(true,0);

        //2调用左右子树的信息
        ResultType leftResult = process(root.left);
        ResultType rightResult = process(root.right);

        //3.根据左右子树的信息来判断当前节点的情况
        boolean curBalanced=false;
        if (leftResult.isBalanced==true&&rightResult.isBalanced==true&&
        Math.abs(leftResult.height-rightResult.height)<=1){
            curBalanced=true;
        }

        //返回当前情况
        return new ResultType(curBalanced,Math.max(leftResult.height,rightResult.height)+1);

    }


    //判断满二叉树的信息体
    public static class Info{
        int height;
        int nodes;

        public Info(int height, int nodes) {
            this.height = height;
            this.nodes = nodes;
        }
    }

    /**
     * 满二叉树的递归处理过程
     * @param root
     * @return
     */
    public Info f(TreeNode root){

        if (root==null) return new Info(0,0);

        //获取左子树 右子树信息
        Info left = f(root.left);
        Info right = f(root.right);

        int height=0;
        int nodes=0;


        height=Math.max(left.height,right.height)+1;
        nodes=left.nodes+right.nodes+1;

        return new Info(height,nodes);


    }

    /**
     * 判断是否是满二叉树
     * @param root
     * @return
     */
    public boolean isFullBinaryTree(TreeNode root){
        if (root==null) return true;

        Info res = f(root);

        return res.nodes==(1<<res.height-1);
    }
}
