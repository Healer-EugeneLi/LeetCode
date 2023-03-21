import java.util.*;

/**
 * @ClassName: Test
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/6/9
 * @Time: 22:16
 */
public class Test {

//    public static void main(String[] args) {
//
//        List<Integer> list = new ArrayList<>();
//        list.add(1);
//        list.add(2);
//
//        System.out.println(list);
//        list.remove(1);
//        System.out.println(list);
//    }
//
//    public static class Node<V> {
//        V value;
//
//        public Node(V v) {
//            value = v;
//        }
//    }
//
//    public static class UnionFind<V> {
//        public HashMap<V, Node<V>> nodes;
//        public HashMap<Node<V>, Node<V>> parents;
//        public HashMap<Node<V>, Integer> sizeMap;
//
//        public UnionFind(List<V> values) {
//            nodes = new HashMap<>();
//            parents = new HashMap<>();
//            sizeMap = new HashMap<>();
//            for (V cur : values) {
//                Node<V> node = new Node<>(cur);
//                nodes.put(cur, node);
//                parents.put(node, node);
//                sizeMap.put(node, 1);
//            }
//        }
//
//        // 给你一个节点，请你往上到不能再往上，把代表返回
//        public Node<V> findFather(Node<V> cur) {
//            Stack<Node<V>> path = new Stack<>();
//            while (cur != parents.get(cur)) {
//                path.push(cur);
//                cur = parents.get(cur);
//            }
//            while (!path.isEmpty()) {
//                parents.put(path.pop(), cur);
//            }
//            return cur;
//        }
//
//        public boolean isSameSet(V a, V b) {
//            return findFather(nodes.get(a)) == findFather(nodes.get(b));
//        }
//
//        public void union(V a, V b) {
//            Node<V> aHead = findFather(nodes.get(a));
//            Node<V> bHead = findFather(nodes.get(b));
//            if (aHead != bHead) {
//                int aSetSize = sizeMap.get(aHead);
//                int bSetSize = sizeMap.get(bHead);
//                Node<V> big = aSetSize >= bSetSize ? aHead : bHead;
//                Node<V> small = big == aHead ? bHead : aHead;
//                parents.put(small, big);
//                sizeMap.put(big, aSetSize + bSetSize);
//                sizeMap.remove(small);
//            }
//        }
//
//        public int sets() {
//            return sizeMap.size();
//        }
//
//    }

    public int findRepeatNumber(int[] nums) {

        int i=0;
        while (i<nums.length){

            //如果当前数字已经放在对应的下标了,此时才i++，换下一个位置。
            // 也就是说某一个数字交换完之后 还要进来重新比较一下被交换到这个位置上的数字是不是也是在他应该在的位置 所以后续的地方都没有i++的地方
            if(nums[i]==i){
                i++;
                continue;
            }

            //如果没有判断是否需要进行交换

            //当前数字 在以该值为下标的位置上已经存在了，因此直接返回，出现重复数字
            if(nums[i]==nums[nums[i]]) return nums[i];

            //到此，说明不出现重复则进行交换，
            //将当前数字放到他应该的位置 比如nums[i]=5 那么将这个5跟原先下标为5位置上的值进行交换

            int temp=nums[i];//当前位置上的值
            nums[i]=nums[temp];//当前位置跟以其值为下标位置上的值交换
            nums[temp]=temp;


        }
        return -1;


    }
    public static void main(String[] args) {
//        int nums[]={3,4,2,1,1,0};
//        Test test=new Test();
//        int res = test.findRepeatNumber(nums);
//        System.out.println(res);

        int[][] temp={
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };

        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[0].length; j++) {
                System.out.print(temp[i][j]+" ");
            }
            System.out.println('\n');
        }

        System.out.println(Arrays.deepToString(temp));


    }
}
