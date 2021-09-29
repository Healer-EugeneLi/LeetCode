package Graph;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @ClassName: kruscal
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/9/29
 * @Time: 20:57
 * 最小生成树 kruscal 无向图
 *      * 时间复杂度 NlogN   N为边数 适合边稀疏的图
 */
public class kruskal {

    public static Set<Edge> kruskalMST(Graph graph){


        UnionFind unionFind=new UnionFind();
        unionFind.makeSets(graph.nodes.values());//初始化节点

        PriorityQueue<Edge> priorityQueue=new PriorityQueue<Edge>(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.weight-o2.weight;
            }
        });
        //加入所有的边
        priorityQueue.addAll(graph.edges);

        Set<Edge> result=new HashSet<Edge>();
        while (!priorityQueue.isEmpty()){

            Edge edge=priorityQueue.poll();
            if (!unionFind.isSameSet(edge.from, edge.to)){
                //没有连通的边进行连接
                unionFind.union(edge.from, edge.to);
                result.add(edge);
            }
        }

        return result;
    }
}
