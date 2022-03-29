package Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: p114
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/3/22
 * @Time: 21:16
 *
 * 将二叉树展开为链表
 */
public class p114 {

//    public List<Integer> res=new ArrayList<>();
//    public void flatten(TreeNode root) {
//
//        if (root==null) return ;
//
//        if (root.left==null&&root.right==null) return;
//
//        dfs(root);//先获得所有的值
//
//        TreeNode cur=root;//当前指针指向root
//
//
//        //重新让root指向值
//       for (int i=1;i<res.size();i++){
//           cur.left=null;
//           cur.right=new TreeNode(res.get(i));
//           cur=cur.right;//往下移动
//       }
//
//
//    }
//
//    public void dfs(TreeNode root){
//
//        if (root==null) return;
//
//        res.add(root.val);
//        dfs(root.left);
//        dfs(root.right);
//    }


    /**
     * 原地修改的方法
     * 将当前节点的左子树 插入到右子树
     * 将原先节点的右子树 插入到 之前左子树的最右节点
     * @param root
     */
    public void flatten(TreeNode root) {

        while (root!=null){

            //如果左子树直接为空的话 那么直接遍历它的右子树
            if (root.left==null){
                root=root.right;
            }else {
                //左子树不为空

                //找到左子树的最右节点
                TreeNode pre=root.left;
                while (pre.right!=null){
                    pre=pre.right;
                }
                //到达左子树的最右节点之后 直接将原先节点的右子树插入作为右子树
                pre.right=root.right;

                root.right=root.left;//将root的左子树插入到右节点这个位置
                root.left=null;//将原先节点的左子树设置为null

                //开始判断下一个节点
                root=root.right;
            }
        }
    }
}
