package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName: p1609
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/3/29
 * @Time: 17:14
 */
public class p1609 {


//    public boolean isEvenOddTree(TreeNode root) {
//
//        //使用层序遍历解决
//
//        if (root==null) return true;
//
//        Queue<TreeNode> queue=new LinkedList<>();
//        queue.add(root);
//
//        List<Integer> value;
//        List<List<Integer>> res=new ArrayList<>();
//
//        while (!queue.isEmpty()){
//
//            value=new ArrayList<>();
//            int size = queue.size();//当前层节点数
//            for (int i = 0; i < size; i++) {
//                TreeNode poll = queue.poll();//弹出当前层节点
//                value.add(poll.val);
//
//                if (poll.left!=null) queue.add(poll.left);
//                if (poll.right!=null) queue.add(poll.right);
//            }
//            res.add(value);
//
//        }
//
//        //开始进行判断
//        for (int i = 0; i < res.size(); i++) {
//
//            List<Integer> curLevel = res.get(i);
//            System.out.println("当前这一层");
//            for (Integer a:curLevel)
//                System.out.print(a+" ");
//
//            if (i%2==0){
//                //如果是偶数层下标
//                for (int j = 0; j <curLevel.size() ; j++) {
//                    int cur=curLevel.get(j);
//                    if (cur%2==0) return false;
//                    if (j+1<curLevel.size()&&curLevel.get(j+1)<=cur) return false;
//
//                }
//            }
//
//            if (i%2==1){
//                //如果是奇数层
//                for (int j = 0; j < curLevel.size(); j++) {
//
//                    int cur=curLevel.get(j);
//                    if (cur%2==1) return false;
//                    if (j+1<curLevel.size()&&curLevel.get(j+1)>=cur) return false;
//                }
//            }
//
//        }
//
//        return true;
//
//    }


    public boolean isEvenOddTree(TreeNode root) {

        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        boolean level=true;// true 表示是偶数层 false表示是奇数层
        while (!queue.isEmpty()){


            int size = queue.size();
            //每层的第一个节点 如果是偶数层的话 第一个节点设置为最小 这样后面才能有机会比它大 然后判断如果后一个更小的话是不符合要求
            int preValue=level?Integer.MIN_VALUE:Integer.MAX_VALUE;
            for (int i = 0; i < size; i++) {

                TreeNode cur = queue.poll();

                if (level){
                    //如果是偶数层 不能是偶数 或者 后一个必须比前一个更大
                    if (cur.val%2==0||cur.val<=preValue) return false;
                }else {
                    //如果是奇数层 不能是奇数 或者 后一个必须比前一个小
                    if (cur.val%2==1||cur.val>=preValue) return false;
                }
                preValue=cur.val;

                if (cur.left!=null) queue.add(cur.left);
                if (cur.right!=null) queue.add(cur.right);

            }
            //偶数层 奇数层 切换
            level=!level;
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
