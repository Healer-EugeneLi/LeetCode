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

    public HashMap<Integer,Integer> inorderSave=new HashMap<>();

    public int [] preSave;

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        for (int i=0;i<inorder.length;i++)
            inorderSave.put(inorder[i],i);

        preSave=preorder;

        return recur(0,0,inorder.length-1);
    }

    public TreeNode recur(int preRoot,int leftIndex,int rightIndex){

        //相等的话就是自己
        if (leftIndex>rightIndex) return null;

        //获取当前前序遍历到的根节点
        Integer index = inorderSave.get(preSave[preRoot]);

        TreeNode root=new TreeNode(preSave[preRoot]);

        //划分左子树
        //左子树的根节点 即为前序遍历到的根节点下一个结点
        // 左子树边界为原先的左子树边界
        // 右子树边界为 中序遍历中当前根节点索引的前一个
        root.left=recur(preRoot+1,leftIndex,index-1);

        //划分右子树
        //右子树的根节点为 当前根节点的索引+左子树的结点数量 再+1就是右子树根节点的位置
        //右子树的左边界为 中序遍历中当前根节点的下一个结点位置
        //右边界就是原先的右边界
        root.right=recur(preRoot+index-leftIndex+1,index+1,rightIndex);
        return root;

    }
}

