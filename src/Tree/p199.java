package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName: p199
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/5/7
 * @Time: 10:10
 */
public class p199 {


    /**
     * 返回二叉树的右视图 就是最右边的结点 从上到下
     * @param root
     * @return
     */

    public List<Integer> rightSideView(TreeNode root) {

        //使用层序遍历的时候 只记录每一层最后一个结点
        List<Integer> res=new ArrayList<>();

        if (root==null) return res;

        Queue<TreeNode> queue=new LinkedList<>();

        queue.add(root);//先加入根节点

        //当队列中不为空
        while (!queue.isEmpty()){

            int size = queue.size();//当前层的结点数

            //遍历每一层的所有结点
            for (int i=0;i<size;i++){

                TreeNode poll = queue.poll();//弹出每一层的每一个结点
                if (poll.left!=null) queue.add(poll.left);
                if (poll.right!=null) queue.add(poll.right);
                //说明是这个层的最右边的结点
                if (i==size-1){
                    res.add(poll.val);
                }
            }

        }

        return res;

    }



}
