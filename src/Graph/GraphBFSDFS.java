package Graph;

import java.util.*;

/**
 * @ClassName: GraphBFS
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/9/29
 * @Time: 10:11
 */
public class GraphBFSDFS {
    /**
     * 从Node出发进行广度优先遍历
     * @param node
     */
    public static void bfs(Node node){
        
        if (node==null){
            return;
        }

        Queue<Node> queue=new LinkedList<>();
        HashSet<Node> set=new HashSet<>();
        queue.add(node);
        set.add(node);//用来查看当前节点是否已经出现过了
        
        while (!queue.isEmpty()){
            Node cur = queue.poll();
            System.out.println(cur.value);//处理过程
            for (Node next:cur.nexts){
                if (!set.contains(next)){//此时这个节点还没有出现过
                    set.add(cur);//加到集合里
                    queue.add(cur);//加到队列
                }
            }

        }
    }


    /**
     * 从node开始进行深度优先遍历
     * @param node
     */
    public static void dfs(Node node){

        HashSet<Node> set=new HashSet<>();
        Stack<Node> stack=new Stack<>();
        stack.push(node);
        set.add(node);
        System.out.println(node.value);
        while (!stack.isEmpty()){

            Node cur = stack.pop();
            for (Node next:cur.nexts){
                if (!set.contains(next)){
                    stack.push(cur);//重新压入此时next的父节点 使得深度优先可以进行
                    stack.push(next);
                    set.add(next);
                    System.out.println(next.value);//处理
                    break;
                }

            }
        }
    }

    /**
     * 输入一张图 进行拓扑排序
     * @param graph
     * @return
     */
    public static List<Node> sortedTopology(Graph graph){

        HashMap<Node,Integer> inMap=new HashMap<>();
        Queue<Node> zeroInQueue=new LinkedList<>();
        //1.先初始化每个图的入度信息

        for (Node node:graph.nodes.values()){
            inMap.put(node,node.in);
            if (node.in==0){//对于入度为0的先加进入这个只存入度为0的结点的队列
                zeroInQueue.add(node);
            }
        }

        //拓扑排序
        List<Node> result=new ArrayList<>();
        while (!zeroInQueue.isEmpty()){

            Node cur = zeroInQueue.poll();
            result.add(cur);
            //移除与当前节点的一些关系信息 消除影响
            for (Node next:cur.nexts){
                inMap.put(next,inMap.get(next)-1);
                if (inMap.get(next)==0)
                    zeroInQueue.add(next);
            }
        }
        return result;

    }
}
