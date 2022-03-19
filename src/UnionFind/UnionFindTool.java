package UnionFind;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName: UniofFindTool
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/10/8
 * @Time: 14:22
 */
public class UnionFindTool {


    //并查集存的数据
    public static class Node<V> {

        V value;

        public Node(V v) {
            value = v;
        }
    }


    public static class UnionFind<V> {

        public HashMap<V, Node<V>> nodes;
        public HashMap<Node<V>, Node<V>> parents;//key为某个节点  value为其的父亲节点
        public HashMap<Node<V>, Integer> sizeMap;//记录每个集合的结点个数 只有父亲节点才做为key

        /**
         * 初始化并差集  传入一堆数据
         *
         * @param values
         */
        public UnionFind(List<V> values) {

            nodes = new HashMap<>();
            parents = new HashMap<>();
            sizeMap = new HashMap<>();
            //一开始的时候各自是一个集合
            for (V v : values) {
                Node<V> node = new Node<V>(v);
                nodes.put(v, node);
                parents.put(node, node);
                sizeMap.put(node, 1);
            }
        }

        /**
         * 从当前节点往上找 找到父亲节点
         *
         * @param cur
         * @return
         */
        public Node<V> findFather(Node<V> cur) {

            Stack<Node<V>> path = new Stack<>();
            while (cur != parents.get(cur)) {
                //还没找到父亲节点
                path.push(cur);
                cur = parents.get(cur);
            }

            while (!path.isEmpty()) {
                parents.put(path.pop(), cur);
            }
            return cur;//此时已经是父亲节点
        }


        /**
         * 是否是在同一个集合
         *
         * @param a
         * @param b
         * @return
         */
        public boolean isSameSet(V a, V b) {

            //先把数据包装的结点拿出来
            Node<V> aNode = nodes.get(a);
            Node<V> bNode = nodes.get(b);

            //再去寻找是否是同一个父亲节点
            return findFather(aNode) == findFather(bNode);
        }


        /**
         * 将a所在的集合 与b所在的集合进行合并
         *
         * @param a
         * @param b
         */
        public void union(V a, V b) {

            //1.先找出各自的父亲节点
            Node<V> aFather = findFather(nodes.get(a));
            Node<V> bFather = findFather(nodes.get(b));

            //2.判断是否是同一个父亲节点 如果是就不用合并了 不是才需要合并
            if (aFather != bFather) {
                //将节点更少的集合 挂到节点更多的集合

                Integer aFatherSize = sizeMap.get(aFather);
                Integer bFatherSize = sizeMap.get(bFather);
                //取所代表的集合更大的节点
                Node<V> big = aFatherSize >= bFatherSize ? aFather : bFather;
                Node<V> small = big == aFather ? bFather : aFather;

                //集合更小的那个父亲节点 设置其父亲节点为集合更大的那个父亲节点
                //从此这个集合更小的这个父亲节点 再也不是父亲节点了 从sizeMap去掉
                parents.put(small, big);
                sizeMap.put(big, aFatherSize + bFatherSize);//两个集合节点数相加
                sizeMap.remove(small);


            }

        }


        /**
         * 有几个集合
         *
         * @return
         */
        public int sets() {
            return sizeMap.size();
        }


    }

}
