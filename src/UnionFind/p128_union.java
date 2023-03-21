package UnionFind;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName: p128_union
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/5/10
 * @Time: 10:31
 */
public class p128_union {


    /**
     * 使用并查集的做法
     * 所有在一个连续区间内的元素都会在一个连通分量中，且这些元素的根节点都为最远的右边界元素
     * 步骤
     * 1.遍历所有的元素num 如果num+1存在，将num加入到num+1所在的连通分量中
     * 2.重新遍历一遍所有的元素num ，通过find函数找到num所在的分量的根节点，也就是最远的右边界，从而求得连续区间的长度
     */

    class MyUnionFind{
        //记录每个节点的父节点
        private Map<Integer,Integer> parent;
        //记录所在连通分量的节点个数
        private Map<Integer,Integer> count;

        public MyUnionFind(int [] nums){

            parent=new HashMap<>();
            count=new HashMap<>();
            for (int num:nums){
                parent.put(num,num);//每个节点的父节点都是自身 初始化
                count.put(num,1);
            }

        }

        //寻找x的父节点 实际上也是x的最右边界
        public Integer find(int x){

            if (!parent.containsKey(x)){
                return null;
            }
            //遍历找到x的父节点
            //当还未到达最后一个父节点的时候
            int root=x;
            while (root!=parent.get(root)){
                root=parent.get(root);//root不断地往上查找 最后root指向的是x对应的最右边界
            }

            //路径压缩 将x--->root的之间的所有结点 全部设置他们的父亲结点为root
            while (x!=root){
                int cur=x;
                x=parent.get(x);//x往上走
                parent.put(cur,root);
            }
            return root;
        }


        //合并两个连通分量 将num并入到num+1的连续区间中 x是num y是num+1
        //返回值为x所在的连通分量的结点个数
        public int union(int x,int y){
            int rootX=find(x);
            int rootY=find(y);
            if (rootX==rootY)
                return count.get(rootX);
            //将roo根节点设置为rotY
            parent.put(rootX,rootY);
            // 进行合并两个分支 同时计算rootY为根节点的连通分支结点个数
            count.put(rootY,count.get(rootX)+count.get(rootY));
            return count.get(rootY);
        }
    }
    /**
     * 最长的连续的有序的序列
     * [100,4,200,1,3,2]
     * 结果最长的是 1 2 3 4 所以长度为4
     * @param nums
     * @return
     */
    public int longestConsecutive(int[] nums) {

        //去除空
        if(nums.length==0||nums==null){
            return 0;
        }

        MyUnionFind myUnionFind=new MyUnionFind(nums);
        int ans=1;

        for (int num:nums){

            if (myUnionFind.find(num+1)!=null){
                //合并连通分支 最后返回的是num+1
                int curNumber=myUnionFind.union(num,num+1);
                ans=Math.max(ans,curNumber);
            }
        }

        return ans;


    }
}
