package JZOffer;

/**
 * @ClassName: JZOffer55_2
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/1/18
 * @Time: 17:59
 * <p>
 * 输入一棵二叉树的根节点，判断该树是不是平衡二叉树。
 * 如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树
 */
public class JZOffer55_2 {

//    /**
//     *   //以root为根节点的树是平衡二叉树：则该树的左右子树的深度差不超过1
//     *   并且继续判断其左右子树 也都必须同时满足平衡二叉树
//     *   时间复杂度：O(NlogN)
//     *   空间复杂度：O(N)
//     *   从顶部至底部
//     * @param root
//     * @return
//     */
//    public boolean isBalanced(TreeNode root) {
//
//        if (root == null) return true;
//        else {
//
//            return Math.abs(getHigh(root.left) - getHigh(root.right)) <= 1
//                    && isBalanced(root.left) && isBalanced(root.right);
//        }
//
//    }
//
//    /**
//     * 返回以root为根节点的子树的 树的深度
//     * @param root
//     * @return
//     */
//    public int getHigh(TreeNode root) {
//
//        if (root == null) return 0;
//
//        int left = getHigh(root.left);
//        int right = getHigh(root.right);
//        return Math.max(left, right) + 1;
//    }


    /**
     * 从顶部至底部
     * 后序遍历+剪枝
     * 当节点root 左 / 右子树的深度差 ≤1 ：则返回当前子树的深度，即节点 root 的左 / 右子树的深度最大值+1 （ max(left, right) + 1 ）；
     * 当节点root 左 / 右子树的深度差 >2 ：则返回 −1 ，代表 此子树不是平衡树 。
     *当 root 为空：说明越过叶节点，因此返回高度 0 ；
     *
     * 当左（右）子树深度为 -1 ：代表此树的 左（右）子树 不是平衡树，因此剪枝，直接返回 -1 ；
     *
     * 时间复杂度 O(N)： N 为树的节点数；最差情况下，需要递归遍历树的所有节点。
     * 空间复杂度 O(N)： 最差情况下（树退化为链表时），系统递归需要使用 O(N) 的栈空间。
     *

     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {

        if (recur(root)==-1) return false;

        return true;
    }

    public int recur(TreeNode root){

        if (root==null) return 0;

        //当前节点的左子树返回值
        int left=recur(root.left);
        if (left==-1) return -1;

        //当前节点的右子树返回值 符合条件的时 返回的是子树的深度
        int right=recur(root.right);
        if (right==-1) return -1;

        //子树都满足条件 继续判断root为根的情况 如果是符合平衡二叉树的话 返回一root为跟的树的深度
        if (Math.abs(left-right)<2)
            return Math.max(left,right)+1;
        else
            return -1;//不符合直接返回-1
    }
}
