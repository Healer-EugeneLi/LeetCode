package JZOffer;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: JZOffer54
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/2/9
 * @Time: 13:16
 * 二叉搜索树的第k大结点
 */
public class JZOffer54 {

    //方法1：二叉搜索树中序遍历 正序 左 根 右 存储遍历到的值 再去获取对应的第k大

//    public List<Integer> list=new ArrayList<>();
//
//    public int kthLargest(TreeNode root, int k) {
//
//        inorder(root);
//        //第k大 比如k=1 就是index=size-1
//        int index=list.size()-k;
//        Integer res = list.get(index);
//        return res;
//    }
//
//    public void inorder(TreeNode root){
//
//        if (root==null) return;
//        inorder(root.left);
//        list.add(root.val);
//        inorder(root.right);
//
//
//    }

    /**
     * 方法2：二叉搜索树 中序遍历倒序 即 右 根 左  然后遍历到第k个的时候停止遍历
     */

    public int count=0;
    public int res=0;//最后结果

    public int kthLargest(TreeNode root, int k) {

        help(root,k);
        return res;
    }

    public void help(TreeNode root,int k){

        if (root==null) return;
        help(root.right,k);

        if (++count==k){
            res=root.val;
            return;
        }
        help(root.left,k);
    }




}
