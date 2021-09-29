package Graph;

import java.util.ArrayList;

/**
 * @ClassName: Node
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/9/29
 * @Time: 9:57
 * //描述节点的结构
 */
public class Node {
    public int value;//当前节点的值
    public int in;//入度
    public int out;//出度
    public ArrayList<Node> nexts;//当前节点出发能到达的点
    public ArrayList<Edge> edges;//当前节点相连的边
    public Node(int value){
        this.value=value;
        in=0;
        out=0;
        nexts=new ArrayList<>();
        edges=new ArrayList<>();
    }
}
