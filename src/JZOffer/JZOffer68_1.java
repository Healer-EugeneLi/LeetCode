package JZOffer;

/**
 * @ClassName: JZOffer68_1
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/1/18
 * @Time: 20:05
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，
 * 最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 *时间复杂度 O(N) ： 其中 N 为二叉树节点数；每循环一轮排除一层，二叉搜索树的层数最logN （满二叉树），最大为 N （退化为链表）。
 * 空间复杂度 O(N) ： 最差情况下，即树退化为链表时，递归深度达到树的层数 NN 。
 *
 *
 */
public class JZOffer68_1 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        //利用二叉搜索树的特点 如果跟节点大于p q较大值 小于p q较小值 则根节点即为最近公共祖先
        if ((root.val-p.val)*(root.val-q.val)<=0){
            //异号说明 此时的根节点即为公共祖先
            return root;
        }else {
            //同号说明在同一侧

            //都在左侧
            if (root.val>p.val){
                return lowestCommonAncestor(root.left,p,q);
            }else {
                //都在右侧
                return lowestCommonAncestor(root.right,p,q);
            }
        }

    }
}
