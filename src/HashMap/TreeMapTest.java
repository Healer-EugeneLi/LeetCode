package HashMap;

import java.util.TreeMap;
import java.util.TreeSet;

/**
 * @ClassName: TreeMapTest
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/9/26
 * @Time: 16:42
 */
public class TreeMapTest {


    public static void main(String[] args) {

        TreeSet treeSet=new TreeSet();

        TreeMap<Integer,String> treeMap=new TreeMap<>();
        treeMap.put(1,"1");
        treeMap.put(3,"1");
        treeMap.put(5,"1");
        treeMap.put(2,"1");
        treeMap.put(4,"1");
        treeMap.put(6,"1");

        System.out.println(treeMap.firstKey());//最小的key 1
        System.out.println(treeMap.lastKey());//最大的key 6
        System.out.println(treeMap.ceilingKey(3));//>=3 且离3最近的key 3
        System.out.println(treeMap.floorKey(3));//<=3 且离3最近的key
        System.out.println(treeMap.higherKey(4));//>4 且离3最近的key 5
        System.out.println(treeMap.lowerKey(4));//<4 且离4最近的key 3

        System.out.println(treeMap.lastEntry());//6=1


    }
}
