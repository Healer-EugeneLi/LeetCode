package Graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName: Dijkstra
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/9/29
 * @Time: 21:40
 */
public class Dijkstra {

    public static Map<Node,Integer> dijkstra(Node head){

        //key：表示从head到key节点
        //value表示从head到key目前最短距离
        Map<Node,Integer> distanceMap=new HashMap<>();
        //表示已经挑选的结点
        Set<Node> selectNode=new HashSet<>();
        distanceMap.put(head,0);
        selectNode.add(head);

        //选取一个目前最短距离的点 且还没有被挑选
        Node minNode=getMinDistancedUnSelectNode(distanceMap,selectNode);

        while (minNode!=null){
            //选取
            selectNode.add(minNode);
            //更新状态
            for (Edge edge: minNode.edges){
                Node to=edge.to;
                if (!distanceMap.containsKey(to)){
                    //还没有距离
                    distanceMap.put(to,distanceMap.get(minNode)+ edge.weight);
                }
                //更新最小值 原来的值与最新的值进行更新
                distanceMap.put(to,Math.min(distanceMap.get(to),distanceMap.get(minNode)+ edge.weight));
            }

            minNode=getMinDistancedUnSelectNode(distanceMap,selectNode);
        }
        return null;


    }

    public static Node getMinDistancedUnSelectNode(Map<Node,Integer> distanceMap,Set<Node> selectNode){

        int distance=Integer.MAX_VALUE;

        Node result=null;
        for (Map.Entry<Node,Integer> entry: distanceMap.entrySet()){
            if (!selectNode.contains(entry.getKey())&&entry.getValue()<distance){
                result=entry.getKey();
                distance=entry.getValue();
            }
        }
        return result;
    }
}
