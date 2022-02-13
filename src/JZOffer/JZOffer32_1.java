package JZOffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName: JZOffer32_1
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/2/12
 * @Time: 10:36
 * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 */
public class JZOffer32_1 {

    public int[] levelOrder(TreeNode root) {

        if (root==null) return new int[]{};

        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        List<Integer> list=new LinkedList<>();
        while (!queue.isEmpty()){

            TreeNode cur = queue.poll();
            list.add(cur.val);
            if (cur.left!=null)
                queue.add(cur.left);
            if (cur.right!=null)
                queue.add(cur.right);

        }

        int res[]=new int[list.size()];
        for (int i=0;i<list.size();i++)
            res[i]=list.get(i);
        return res;

    }
}
