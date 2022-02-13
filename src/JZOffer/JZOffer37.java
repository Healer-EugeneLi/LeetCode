package JZOffer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName: JZOffer37
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/2/11
 * @Time: 8:51
 * 输入：root = [1,2,3,null,null,4,5]
 * 输出：[1,2,3,null,null,4,5]
 */
public class JZOffer37 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        if (root==null) return "[]";
        StringBuilder res=new StringBuilder("[");
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){

            TreeNode node = queue.poll();
            //当前节点不为空的时候 加入对应的值
            if (node!=null){

                res.append(node.val+",");//加入值
                queue.add(node.left);
                queue.add(node.right);
            }else {
                //当是null空节点的时候在res中加入null
                res.append("null,");
            }

        }
        res.deleteCharAt(res.length()-1);
        res.append("]");

        return res.toString();

    }

    // Decodes your encoded data to tree.
    //[1,2,3,null,null,4,5] 反序列化
    public TreeNode deserialize(String data) {

        if (data.equals("[]")) return null;
        String[] split = data.substring(1, data.length() - 1).split(",");



        TreeNode root=new TreeNode(Integer.parseInt(split[0]));//根节点


        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        int i=1;
        while (!queue.isEmpty()){

            TreeNode cur = queue.poll();

            //字符串中这个位置不是null 说明cur当前节点的左子树有节点 设置为root的left 同时加入队列
            if (!split[i].equals("null")){
                cur.left=new TreeNode(Integer.parseInt(split[i]));
                queue.add(cur.left);
            }
            i++;//下一个位置进行判断 此时判断的是是否有右子树
            if (!split[i].equals("null")){
                cur.right=new TreeNode(Integer.parseInt(split[i]));
                queue.add(cur.right);
            }
            i++;//同时进行下一个位置的++


        }
        return root;

    }
}
