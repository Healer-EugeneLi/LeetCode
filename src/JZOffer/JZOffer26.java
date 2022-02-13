package JZOffer;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: JZOffer26
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/1/28
 * @Time: 10:26
 * 判断一棵树是否是另一颗树的子结构
 */
public class JZOffer26 {


    /**
     * 判断B树是否是A树的子结构
     * @param A
     * @param B
     * @return
     */
    public boolean isSubStructure(TreeNode A, TreeNode B) {

        if (A==null||B==null) return false;

        //A的根节点如果与B的根节点一致 开始判断
        //或者判断B是否是A的左子树的子结构
        //或者判断B是否是A的右子树的子结构
        return check(A,B)||isSubStructure(A.left,B)||isSubStructure(A.right,B);
    }

    //先序遍历判断是否符合子结构
    public boolean check(TreeNode a,TreeNode b){

        if (b==null) return true;//匹配结束
        if (a==null) return false;//a已经遍历完 没有匹配成功
        if (a.val!=b.val) return false;//值不一致

        //a的左子树与b的左子树一致  a的右子树与b的右子树一致
        return check(a.left,b.left)&&check(a.right,b.right);
    }
}
