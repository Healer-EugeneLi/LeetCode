package Graph;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @ClassName: Prim
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/9/29
 * @Time: 20:57
 * 最小生成树 prim 无向图 适合边稠密
 * 时间复杂度 N^2 N为节点
 */
public class Prim {

    public static Set<Edge> primMST(Graph graph) {

        //小根堆 存放其他节点到主部分的距离
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.weight - o2.weight;
            }
        });

        //存主部分已经挑选
        Set<Node> set = new HashSet<Node>();
        Set<Edge> result = new HashSet<>();//存放挑选的边
        for (Node node : graph.nodes.values()) {
            //防止出现森林

            //node是当前树的开始节点
            if (!set.contains(node)) {
                set.add(node);
                //加入首节点，扩张它的边
                priorityQueue.addAll(node.edges);
                while (!priorityQueue.isEmpty()) {
                    Edge edge = priorityQueue.poll();//从距离主部分的所有边中挑选一个最近
                    Node toNode = edge.to;
                    if (!set.contains(toNode)) {
                        set.add(toNode);
                        result.add(edge);
                        priorityQueue.addAll(toNode.edges);
                    }
                }
            }
        }
        return result;
    }
}
