package JZOffer;

import java.util.HashMap;

/**
 * @ClassName: JZOffer07
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/1/28
 * @Time: 1:37
 */
public class JZOffer07 {

    public HashMap<Integer, Integer> inorderSave = new HashMap<>();

    public int[] preSave;

    /**
     *
     * @param preorder 前序遍历结果
     * @param inorder 中序遍历结果
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        //inorderSave 存放中序遍历结果的值 其对应的位置索引 值->下标
        for (int i = 0; i < inorder.length; i++)
            inorderSave.put(inorder[i], i);

        preSave = preorder;

        return recur(0, 0, inorder.length - 1);
    }
    //preRoot是表示当前根节点在前序列表的位置索引 而leftIndex rightIndex都是在中序遍历中的位置下标 注意区分
    public TreeNode recur(int preRoot, int leftIndex, int rightIndex) {

        //相等的话就是自己
        if (leftIndex > rightIndex) return null;

        //获取当前前序遍历到的根节点的值 其在中序遍历结果列表中所对应的下标index
        Integer curRoot=preSave[preRoot];
        Integer index = inorderSave.get(curRoot);

        //建立根节点的值
        TreeNode root = new TreeNode(curRoot);

        //划分当前root的左子树
        //左子树的根节点 即为前序遍历到的根节点下一个结点
        // 左子树边界为原先的左子树边界
        // 右子树边界为 中序遍历中当前根节点索引的前一个 因为中序遍历中根节点的左边全部是它的左子树的结点 所以其左子树的右边界肯定是最后一个 也就是index-1 即index的前一个
        root.left = recur(preRoot + 1, leftIndex, index - 1);

        //划分右子树
        // 在前序遍历的列表中计算：当前根节点的索引+这个根节点的左子树的节点数量+1即下一个位置就是这个根节点的右子树的根
        //比如 此时preRoot就是当前根节点在前序列表的位置索引 而index是这个根节点其在中序列表的位置索引 通过index-leftIndex=左子树的根节点数量 所以回到先序遍历列表去定位根节点就很明显了
        //右子树的左边界为 中序遍历中当前根节点的下一个结点位置 中序遍历中根节点的右边全是其右子树 并且中序遍历的遍历特点就是从其子树的left先遍历的 因此右子树的左边界就是index+1
        //右边界就是原先的右边界
        root.right = recur(preRoot + index - leftIndex + 1, index + 1, rightIndex);
        return root;

    }

    public static void main(String[] args) {

        int preOrder[]={3,9,2,1,7};
        int inOrder[]={9,3,1,2,7};
        JZOffer07 t=new JZOffer07();
        TreeNode node = t.buildTree(preOrder, inOrder);
        System.out.println();
    }
}

