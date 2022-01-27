package Tree;

/**
 * @ClassName: MaxDistance
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/10/28
 * @Time: 20:13
 */
public class MaxDistance {

    /**
     *
     * 返回x为根节点一颗树的最大距离
     *      当最大距离的路径经过x的时候
     *          最大距离=x结点的左子树的高度+x结点的右子树的高度+1
     *       当最大距离的路径经过x的时候
     *          最大距离=max(x结点的左子树的最大距离，x结点的右子树的最大距离)
     *
     */

    //包装信息体
    class Info{
        public int maxDistance;//以某一个结点为树的最大距离
        public int height;//以某一个结点为树的最大高度

        public Info(int dis,int h){
            maxDistance=dis;
            height=h;
        }
    }

    //返回以x为头的整颗树的 两个信息
    public Info process(Node x){

        //递归结束条件 为空的时候最大距离肯定为空啦 最大高度也为空
        if (x==null)
            return new Info(0,0);
        Info leftInfo=process(x.left);
        Info rightInfo=process(x.right);

        //不经过x结点的路径
            //左子树的最大距离
        int leftMaxDistance=leftInfo.maxDistance;
            //右子树的最大距离
        int rightMaxDistance=rightInfo.maxDistance;

        //经过x结点的路径
        int xMaxDistance=leftInfo.height+rightInfo.height+1;

        int max=Math.max(xMaxDistance,Math.max(leftMaxDistance,rightMaxDistance));
        int height=leftInfo.height+rightInfo.height+1;

        return new Info(max,height);

    }

    public static void main(String[] args) {

    }
}
