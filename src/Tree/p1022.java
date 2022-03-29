package Tree;

/**
 * @ClassName: p1022
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/3/29
 * @Time: 19:07
 *
 * 从根节点到叶子节点的二进制数字和
 * 每一条路径从根节点到叶子节点  表示一个数字的二进制 从高位到低位
 */
public class p1022 {

    public int res;//存放最终的各个路径组成的数字之后
    public int sumRootToLeaf(TreeNode root) {


        dfs(root,0);
        return res;
    }

    /**
     *
     * @param root 当前节点
     * @param parent 父亲节点的值 如果此时当前节点就是根节点的时候 那么parent=0
     */
    public void dfs(TreeNode root,int parent){

        if (root==null) return;

        //先序遍历
        parent*=2;
        parent+=root.val;
        //说明到达叶子节点 加入一个结果
        if (root.left==null&&root.right==null){
            res+=parent;
            return;
        }

        dfs(root.left,parent);
        dfs(root.right,parent);

    }
}
