package JZOffer;

import java.util.Stack;

/**
 * @ClassName: JZOffer27
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/2/8
 * @Time: 22:20
 * <p>
 * 二叉树的镜像；输入一个二叉树，输出它的镜像
 */
public class JZOffer27 {

    /**
     * 使用栈来进行镜像翻转
     * @param root
     * @return
     */
//    public TreeNode mirrorTree(TreeNode root) {
//
//        if (root==null) return root;
//
//        Stack<TreeNode> stack=new Stack<>();
//        stack.add(root);
//
//        while (!stack.isEmpty()){
//            //栈不为空的时候
//            TreeNode cur = stack.pop();
//            if (cur.left!=null)
//                stack.push(cur.left);
//            if (cur.right!=null)
//                stack.push(cur.right);
//
//            //交换cur节点的左右两个节点
//            TreeNode temp=cur.left;
//            cur.left=cur.right;
//            cur.right=temp;
//
//        }
//
//        return root;
//
//    }

    /**
     * 使用递归的方法来进行镜像翻转
     *
     * @param root
     * @return
     */
    public TreeNode mirrorTree(TreeNode root) {

        if (root == null) return null;

        //分别将左子树 右子树进行翻转 当递归到最后的时候 子树不断的进行镜像翻转 最后根节点交换两个左右子树即可

        //从全局进行理解 这是左子树翻转完后的根节点
        TreeNode left = mirrorTree(root.left);

        //这是右子树翻转完后的根节点
        TreeNode right = mirrorTree(root.right);

        //重新指向 也就是交换左右子树
        root.left = right;
        root.right = left;

        //返回根节点
        return root;

    }

}
