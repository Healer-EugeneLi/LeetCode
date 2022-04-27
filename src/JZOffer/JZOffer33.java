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
     * 三个前提
     * <
     * 注意此时的i是对输入列表的逆序来表达的 也就是题目输入的是 1 3 2 6 5
     * 那么需要先转成5 6 2 3 1
     * 1.两个数如果arr[i]<arr[i+1]，那么arr[i+1]一定是arr[i]的右孩子
     *
     * 2.如果arr[i]>arr[i+1]，那么arr[i+1]一定是arr[0]……arr[i]中某个节点的左孩子，
     * 并且这个值是大于arr[i+1]中的所有值里面的 最小的
     *
     * 3.递增栈
     *
     * 当遇到一个值a小于栈顶值时，需要找到该值的父节点b(即栈内最早压栈的且大于该值的值)
     *
     * 找到该值b以后作为parent值, a为b的左孩子
     *
     * 后续再遇到值x，有如下情况：
     *
     * 1.它是栈内某个值的左孩子，那么该值肯定小于等于栈顶值a，(递增栈，栈顶最大)-->x<a<b(parent);
     *
     * 2.它是栈顶值a的右孩子,但是a是b的左孩子，因此它的孩子值也不能大于b --> x<b(parent);
     *
     * 这就是为什么该值X无论如何也不能大于b(parent)的原因。
     */
//
//    public boolean verifyPostorder(int[] postorder) {
//
//        Stack<Integer> stack = new Stack();
//        int parent = Integer.MAX_VALUE;//一开始parent设置为最大
//
//        //开始倒序遍历 后序遍历的链表
//        for (int i = postorder.length - 1; i >= 0; i--) {
//            int cur = postorder[i];
//            //当栈不为空 并且此时当前节点小于栈顶 也就是说此时出现递减 查找当前节点作为左子树的根节点
//            //比如后序的倒序是 5 6 2 3 1 那么当遍历到2的时候 此时2小于栈顶 说明此时2肯定是栈中的某个元素的左子树 也就是此时我们去寻找这个节点2的根
//            //而根据二叉搜索树的特点 其跟肯定是此时栈中大于2的元素中最小的 所以在这个递增栈中不断弹出 直到栈为空 或者找到一个比2大的最小元素 作为新的parent
//            while (!stack.isEmpty() && stack.peek() > cur) {
//                parent = stack.pop();
//            }
//
//            if (cur > parent) return false;
//            stack.push(cur);//将此时的元素压入
//        }
//
//        return true;
//
//    }

    /**
     * 使用递归分治的方法  设postordder范围为[0,j]
     * 对后序遍历列表先找到左右子树的边界 split
     * 寻找split的方法：从左边界开始遍历 直到posorder[split]>直到posorder[j]
     * 划分左子树为[0,split-1]
     * 右子树为[split,j-1] 并且需要继续判断这个范围内的所有元素是否都大于这一轮的根节点 如果不满足就是不符合二叉搜索树的
     * 方法：通过split不断的往右移 如果其不大于postordder[j]则说明不符合了
     * @param postorder
     * @return
     */
    public boolean verifyPostorder(int[] postorder) {

        return recur(postorder,0,postorder.length-1);
    }

    public boolean recur(int[] postorder,int i,int j){

        if (i>j) return true;//说明已经符合条件了

        int split=0;
        //这一轮的根节点为
        int root=postorder[j];
        while (postorder[split]<root) split++;

        //继续判断通过split划分的右子树上的所有结点是否都大于root
        int p=split;
        while (postorder[p]>root) p++;

        if (p!=j) return false;//说明p没有走到最后一个结点 也就是右子树中出现了小于根节点的值 则不符合情况

        //通过split进行划分的左子树 右子树 必须也符合二叉搜索树
        boolean left= recur(postorder,i,split-1);//显然左子树的左边界 是原先树的左边界 右边界为split的前一个位置
        boolean right=recur(postorder,split,j-1);
        return left&&right;

    }
}
