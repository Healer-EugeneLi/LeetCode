package Tree;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @ClassName: p236
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/9/28
 * @Time: 15:03
 * 求最低公共祖先
 */
public class p236 {

//    private HashMap<TreeNode,TreeNode> map=new HashMap<>();
//
//    /**
//     * 方法1 使用map来存储每个节点的父节点
//     *       再用set来存储从p网上走的链
//     *       同样从q网上走 构建链  找到第一个出现在set的就是最近的公共祖先
//     * @param root
//     * @param p
//     * @param q
//     * @return
//     */
//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//
//        map.put(root,root);//root 的父节点是本身
//
//        saveParent(root);
//        HashSet<TreeNode> set=new HashSet<>();
//
//        TreeNode cur=p;
//        while (cur!=map.get(cur)){//本身不等于父节点 说明还没有到root
//            set.add(cur);
//            cur=map.get(cur);
//        }
//        set.add(root);
//        //开始让q往上找
//
//        cur=q;
//
//        while (cur!=map.get(cur)){
//
//            if (set.contains(cur)){
//                //说明找到了这个祖先
//                return cur;
//            }
//            cur=map.get(cur);
//        }
//
//        return root;
//    }
//
//    public void saveParent(TreeNode node){
//
//        if (node==null) return;
//
//        map.put(node.left,node);//node的左孩子的父节点当然就是node
//        map.put(node.right,node);
//
//        //递归遍历 存储孩子的情况
//        saveParent(node.left);
//        saveParent(node.right);
//    }

    /**
     * 方法2：
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){

        if(root==null||p==root||q==root)//当前节点直接就是根节点  那么直接就是祖先
            return root;

        TreeNode leftResult = lowestCommonAncestor(root.left, p, q);//左子树是否有p q
        TreeNode rightResult = lowestCommonAncestor(root.right, p, q);//右子树是否有p q
        if (leftResult!=null&&rightResult!=null)
            return root;
        return leftResult!=null?leftResult:rightResult;//只有一方有p 或者q

    }

}
