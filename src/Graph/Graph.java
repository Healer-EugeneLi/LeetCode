package Graph;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @ClassName: Graph
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/9/29
 * @Time: 20:48
 */
public class Graph {
    public HashMap<Integer, Node> nodes;//点集
    public HashSet<Edge> edges;//边集


    public Graph() {
        this.nodes = new HashMap<>();
        this.edges = new HashSet<>();
    }
}
