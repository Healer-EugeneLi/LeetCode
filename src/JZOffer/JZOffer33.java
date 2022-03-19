package JZOffer;

import java.util.Stack;

/**
 * @ClassName: JZOffer33
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/2/13
 * @Time: 19:48
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。
 * 如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同
 */
public class JZOffer33 {

//    public boolean verifyPostorder(int[] postorder) {
//
//        return help(postorder,0,postorder.length-1);
//    }
//
//
//    public boolean help(int[] postorder,int left,int right){
//
//        if (left>=right) return true;//当left==right的时候 说明只有一个结点了 直接返回true
//
//        //先找到第一个大于跟节点的节点
//        int mind=left;
//        int root=postorder[right];//最右边的结点是根节点
//
//        //这边不能<= 否则进入死循环 会导致栈溢出
//        while (postorder[mind]<root){
//            mind++;
//        }
//
//        //此时mind已经指向了左边第一个大于根节点的元素 其后面全是right处作为根节点的右子树
//        int temp=mind;
//
//        while (temp<right){
//            if (postorder[temp++]<root)
//                return false;//如果这些结点中有小于根节点的 说明不符合二叉搜索树的要求
//        }
//
//        //符合要求之后继续对左子树 右子树进行判断
//        return help(postorder,left,mind-1)&&help(postorder,mind,right-1);
//
//    }

    /**
     * 借助辅助栈进行操作
     * 关于if (cur > parent) return false; 的思考
     * <p>
     * 三个前提
     * <p>
     * 1.两个数如果arr[i]<arr[i+1]，那么arr[i+1]一定是arr[i]的右孩子
     * <p>
     * 2.如果arr[i]>arr[i+1]，那么arr[i+1]一定是arr[0]……arr[i]中某个节点的左孩子，
     * 并且这个值是大于arr[i+1]中最小
     * <p>
     * 3.递增栈
     * <p>
     * 当遇到一个值a小于栈顶值时，需要找到该值的父节点b(即栈内最早压栈的且大于该值的值)
     * <p>
     * 找到该值b以后作为parent值, a为b的左孩子
     * <p>
     * 后续再遇到值x，有如下情况：
     * <p>
     * 1.它是栈内某个值的左孩子，那么该值肯定小于等于栈顶值a，(递增栈，栈顶最大)-->x<a<b(parent);
     * <p>
     * 2.它是栈顶值a的右孩子,但是a是b的左孩子，因此它的孩子值也不能大于b --> x<b(parent);
     * <p>
     * 这就是为什么该值X无论如何也不能大于b(parent)的原因。
     */

    public boolean verifyPostorder(int[] postorder) {

        Stack<Integer> stack = new Stack();
        int parent = Integer.MAX_VALUE;//一开始parent设置为最大
        for (int i = postorder.length - 1; i >= 0; i--) {
            int cur = postorder[i];
            //当栈不为空 并且此时当前节点小于栈顶 是倒序 查找当前节点作为左子树的根节点
            while (!stack.isEmpty() && stack.peek() > cur) {
                parent = stack.pop();
            }

            if (cur > parent) return false;
            stack.push(cur);
        }

        return true;

    }
}
