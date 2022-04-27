package JZOffer;

import java.util.ArrayList;
import java.util.LinkedList;
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


//    public List<List<Integer>> res = new ArrayList<>();//存放最终结果的列表
//    public List<Integer> path = new ArrayList<>();//存放当前路径
//
//    public List<List<Integer>> pathSum(TreeNode root, int target) {
//        if (root == null) return res;
//        dfs(root, path, 0, target);
//        return res;
//
//    }
//
//    /**
//     *
//     * @param root 当前搜到的的节点
//     * @param path 此时的路径
//     * @param cur 当前累加和
//     * @param target 目标值
//     */
//    public void dfs(TreeNode root, List<Integer> path, int cur, int target) {
//
//        //此时已经遍历到了叶子节点了
////        if (root == null) return; 因为在left right的时候已经做了判断了 所以其实这边是不会执行到的
//
//        //加上当前节点 路径path也添加
//        cur += root.val;
//        path.add(root.val);
//
//        //如果当前累积的值==target 并且已经是遇到了叶子节点 那么将整个路径加到res
//        if (cur == target && root.left == null && root.right == null) {
//            //注意此时要使用new ArrayList<>(path) 而不能直接添加path Java是值传递的 path是存的地址 后面会被继续修改 最后回溯到一开始的状态就为空了
//            res.add(new ArrayList<>(path));
//            return;
//        } else {
//            //如果不满足上述的条件
//
//            //如果左节点不为空 往左继续搜索
//            if (root.left != null) {
//                dfs(root.left, path, cur, target);
//                path.remove(path.size() - 1);//回溯的时候 移除最后添加的结点  也就是该节点的已经是叶子节点了
//            }
//
//            //当执行到往左全部走完 那么此时回溯的时候开始找右边的子树
//            if (root.right != null) {
//                dfs(root.right, path, cur, target);
//                path.remove(path.size() - 1);
//            }
////            cur-=root.val;//回溯的时候现在的这个和减去当前节点  这一步要不要都可以 因为执行到这里的时候这个dfs已经结束了 后面无需再用到不加这个节点值的状态
//
//        }
//    }


    public List<List<Integer>> res=new ArrayList<>();
    public LinkedList<Integer> path=new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int target) {

        dfs(root,target);
        return res;
    }

    public void dfs(TreeNode root,int target){

        //遍历到叶子节点就返回了
        if(root==null) return ;

        //减去当前节点的值 表示要加入此节点
        target-=root.val;
        path.add(root.val);
        //当最后target减完了 结果为了 同时它是叶子节点 说明找到一条路径了
        if(target==0&&root.left==null&&root.right==null){
            res.add(new LinkedList<>(path));
            //注意不能在这里就直接返回了 如果要在这里直接返回的时候需要将最后一个加入的结点删除 不然无需在这里返回
        }

        //如果不符合要求 则继续左子树 右子树遍历
        dfs(root.left,target);
        dfs(root.right,target);
        //回溯的时候 弹出最后加入的结点
        path.removeLast();
    }

}
