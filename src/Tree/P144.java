package Tree;

/**
 * @ClassName: P144
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/6/20
 * @Time: 20:36
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Definition for a binary tree node.
 *
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(){};
    TreeNode(int val){
        this.val=val;
    }

    TreeNode(int val,TreeNode left,TreeNode right){
        this.val=val;
        this.left=left;
        this.right=right;
    }


}
public class P144 {

    //前序遍历
    public void preNode(TreeNode root,List<Integer> res){

        if(root==null) return;
        res.add(root.val);//先中
        preNode(root.left,res);//左节点
        preNode(root.right,res);//右结点
    }

    //中序遍历
    public void inorderNode(TreeNode root,List<Integer> res){
        if(root==null) return;

        inorderNode(root.left,res);//先往左走
        res.add(root.val);//添加值
        inorderNode(root.right,res);//往右走
    }

    //后序遍历
    public void postorderNode(TreeNode root,List<Integer> res){
        if(root==null) return;

        postorderNode(root.left,res);//先往左走
        postorderNode(root.right,res);//往右走
        res.add(root.val);//添加值

    }

    //迭代法 进行前序遍历
    public List<Integer> preorderTraversalByIter(TreeNode root){

        Stack<TreeNode> stack=new Stack<>();

        List<Integer> result=new ArrayList<>();

        if(root==null) return result;

        stack.add(root);

        while (!stack.isEmpty()){
            //当栈中不为空的时候

            TreeNode top = stack.pop();
            result.add(top.val);//先得到栈顶的值 即此时为 中

            //先压入右结点 再压左节点 这样取出来的才是先左后右
            if(top.right!=null) stack.push(top.right);

            if(top.left!=null) stack.push(top.left);

        }

        return result;
    }


    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> res=new ArrayList<>();
        preNode(root,res);
        return res;

    }

    public static void main(String[] args) {

        TreeNode treeNode=new TreeNode(1);
        TreeNode left=new TreeNode(2);
        TreeNode right=new TreeNode(3);
        treeNode.left=left;
        treeNode.right=right;
        P144 solution=new P144();

        List<Integer> list = solution.preorderTraversal(treeNode);
        for(Integer temp:list)
            System.out.println(temp);
    }
}


