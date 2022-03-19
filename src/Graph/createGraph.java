package Graph;

/**
 * @ClassName: createGraph
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/9/29
 * @Time: 9:51
 */
public class createGraph {


    /**
     * @param matrix N*3 的矩阵 from to weight
     * @return
     */
    public static Graph changeToGraph(Integer[][] matrix) {

        Graph graph = new Graph();
        for (int i = 0; i < matrix.length; i++) {

            Integer from = matrix[i][0];
            Integer to = matrix[i][1];
            Integer weight = matrix[i][2];
            if (!graph.nodes.containsKey(from)) {
                //如果点集里面没有这个点
                graph.nodes.put(from, new Node(from));
            }
            if (!graph.nodes.containsKey(to)) {
                graph.nodes.put(to, new Node(to));
            }

            Node fromNode = graph.nodes.get(from);//获取from节点
            Node toNode = graph.nodes.get(to);
            //创建边
            Edge edge = new Edge(weight, fromNode, toNode);
            //创建完边之后 更新点边的相关信息
            fromNode.nexts.add(toNode);//from这个节点加入与它相连的结点
            fromNode.out++;//出度++
            toNode.in++;
            fromNode.edges.add(edge);//from节点加入与它相连的边
            graph.edges.add(edge);//在整张图的边集加入边
        }

        return graph;
    }
}
