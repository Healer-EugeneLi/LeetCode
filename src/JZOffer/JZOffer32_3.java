package JZOffer;

import java.util.*;

/**
 * @ClassName: JZOffer32_3
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/2/12
 * @Time: 11:10
 * 实现一个函数按照之字形顺序打印二叉树，
 * 即第一行按照从左到右的顺序打印，
 * 第二层按照从右到左的顺序打印，
 * 第三行再按照从左到右的顺序打印，其他行以此类推。
 */
public class JZOffer32_3 {

//    public List<List<Integer>> levelOrder(TreeNode root) {
//
//        List<List<Integer>> res=new LinkedList<>();
//        List<Integer> level;
//
//        Deque<TreeNode> deque=new LinkedList<TreeNode>();
//        if (root==null) return new LinkedList<>();
//        deque.add(root);
//
//        boolean flag=true;//true 表示从左到右  false表示从右到左
//
//        while (!deque.isEmpty()){
//
//            int size = deque.size();
//            level=new LinkedList<>();
//            if (flag==true){
//                //从左到右
//                for (int i=0;i<size;i++){
//                    TreeNode cur = deque.pollFirst();//从左边弹出
//                    level.add(cur.val);
//                    //从左到右遍历的时候 直接将左子树 右子树按照顺序添加在尾部
//                    if (cur.left!=null) deque.addLast(cur.left);
//                    if (cur.right!=null) deque.addLast(cur.right);
//                }
//                flag=false;
//                res.add(level);
//            }else {
//                //从右到左
//                for (int i=0;i<size;i++){
//                    TreeNode cur=deque.pollLast();//从尾部弹出
//                    level.add(cur.val);
//                    //从右到左遍历的时候 按照右子树 左子树结点添加到首部 注意顺序
//                    if (cur.right!=null) deque.addFirst(cur.right);
//                    if (cur.left!=null) deque.addFirst(cur.left);
//
//                }
//                flag=true;
//                res.add(level);
//
//            }
//        }
//
//        return res;
//    }


    /**
     * 使用res结果的长度来判断奇偶性 同时在从右到左的时候直接使用倒序
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {

        //res存放当前已经加入的结果了
        List<List<Integer>> res = new LinkedList<>();

        Queue<TreeNode> queue = new LinkedList<>();

        if (root == null) return res;
        queue.add(root);


        while (!queue.isEmpty()) {

            //当前层存放的结点
            List<Integer> level = new LinkedList<>();

            int size = queue.size();//表示当前层有多少个节点数
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                level.add(cur.val);
                if (cur.left != null) queue.add(cur.left);
                if (cur.right != null) queue.add(cur.right);
            }

            //如果当前res里面存放的子列表个数是奇数说明 此时需要从右到左存放了  因为要求 先左后右  再右到左 再左到右...
            if (res.size() % 2 == 1)
                Collections.reverse(level);//也就是我们只需要翻转一下再加入
            res.add(level);
        }
        return res;


    }

}
