package Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: DFSTree
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/5/11
 * @Time: 21:00
 */
public class DFSTree {


    static class TreeNode{
        int val;
        TreeNode(int val){
            this.val=val;
        };

        TreeNode left;
        TreeNode right;
    }
    public static List<Integer> res=new ArrayList<>();
    public static void dfs(TreeNode root){

        if (root==null) return;
        res.add(root.val);
        dfs(root.left);
        dfs(root.right);

    }
    public static void main(String[] args) {

//        int arr[]={1,2,3,4,5,6};

        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);

        root.left.left=new TreeNode(4);
        root.left.right=new TreeNode(5);
        root.right.left=new TreeNode(6);
        root.right.right=new TreeNode(7);

        dfs(root);
        for (Integer temp:res){
            System.out.println(temp);
        }

    }
}
