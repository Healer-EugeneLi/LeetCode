package Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName: p1032
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/3/29
 * @Time: 19:21
 *
 * 返回层数最深的叶子节点 的和
 */
public class p1032 {

    /**
     * bfs 层序遍历
     * @param root
     * @return
     */
//    public int deepestLeavesSum(TreeNode root) {
//
//        //层序遍历 得到最后一层 对该层的节点进行求和
//
//        Queue<TreeNode> queue=new LinkedList<>();
//        queue.add(root);
//        int res=0;
//        while (!queue.isEmpty()){
//
//            res=0;
//            int size = queue.size();
//            for (int i = 0; i < size; i++) {
//
//                TreeNode cur = queue.poll();
//                res+=cur.val;
//
//                if (cur.left!=null) queue.add(cur.left);
//                if (cur.right!=null) queue.add(cur.right);
//
//            }
//        }
//
//        return res;
//    }

    public int maxLevel=0;//记录最大深度层数
    private int sum=0;//记录最大值
    public int deepestLeavesSum(TreeNode root) {

        dfs(root,0);
        return sum;

    }

    /**
     *
     * @param root 当前节点
     * @param level 当前层数
     */
    public void dfs(TreeNode root,int level){

        if (root==null) return;

        //如果是跟之前最深的层一样的长度 累加和
        if (level==maxLevel){
            sum+=root.val;
        }

        //发现更深的层 更新最深层的值 以及最深的层数
        if (level>maxLevel){
            maxLevel=level;
            sum= root.val;
        }

        dfs(root.left,level+1);
        dfs(root.right,level+1);
    }


}
