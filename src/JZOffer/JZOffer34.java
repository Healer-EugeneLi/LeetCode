package JZOffer;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: JZOffer34
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/2/8
 * @Time: 20:38
 * 路径中可能有负的结点数
 */
public class JZOffer34 {


    public List<List<Integer>> res = new ArrayList<>();
    public List<Integer> path = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        if (root == null) return res;
        dfs(root, path, 0, target);
        return res;

    }

    public void dfs(TreeNode root, List<Integer> path, int cur, int target) {

        if (root == null) return;
        //加上当前节点 路径path也添加
        cur += root.val;
        path.add(root.val);

        //如果当前累积的值==target 并且已经是遇到了根节点 那么将整个路径加到res
        if (cur == target && root.left == null && root.right == null) {
            res.add(new ArrayList<>(path));
            return;
        } else {
            //如果不满足上述的条件

            //如果左节点不为空 往左遍历
            if (root.left != null) {
                dfs(root.left, path, cur, target);
                path.remove(path.size() - 1);//回溯的时候 移除最后添加的结点
            }
            if (root.right != null) {
                dfs(root.right, path, cur, target);
                path.remove(path.size() - 1);
            }
//            cur-=root.val;//回溯的时候现在的这个和减去当前节点

        }
    }


}
