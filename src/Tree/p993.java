package Tree;

/**
 * @ClassName: p993
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/3/29
 * @Time: 19:36
 *
 * 判断x与y对应的节点是否是堂兄弟节点
 */
public class p993 {

    public int levelX,levelY;//记录x节点的深度、y节点的深度
    public TreeNode xParent,yParent;//分别记录x、y节点的父亲节点
    public boolean isCousins(TreeNode root, int x, int y) {

        dfs(root,root,0,x,y);
        //同样的深度 而且父节点不一样 才是堂兄弟节点
//        System.out.println("xParant"+xParent.val);
//        System.out.println("yParent"+yParent.val);
//        System.out.println("xlevel"+levelX);
//        System.out.println("ylevel"+levelY);
        if (levelX==levelY&&xParent!=yParent)
            return true;
        return false;

    }

    public void dfs(TreeNode root,TreeNode parent,int level,int x,int y){

        if (root==null)
            return;
        //当前节点是 x 则可以记录信息
        if (root.val==x){
            xParent=parent;
            levelX=level;
        }

        //当前节点是 y 则可以记录信息
        if (root.val==y){
            yParent=parent;
            levelY=level;
        }

        dfs(root.left,root,level+1,x,y);
        dfs(root.right,root,level+1,x,y);
    }
}
