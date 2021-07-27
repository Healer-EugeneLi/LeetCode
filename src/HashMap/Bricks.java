package HashMap;

import java.util.*;

/**
 * @ClassName: Bricks
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/5/3
 * @Time: 10:01
 *
 * 554 砖墙
 */
class Solution {
    public int leastBricks(List<List<Integer>> wall) {

        int row=wall.size();
        Map<Integer,Integer> map=new HashMap<>();

        for(int i=0;i<row;i++){

            int curSum=0;
            for(Integer x:wall.get(i)){

                curSum+=x;
                map.put(curSum,map.getOrDefault(curSum,0)+1);

            }
            map.remove(curSum);//移除最后一列
        }

        int MAX=0;
        for(Integer value: map.values()){
            MAX=Math.max(MAX,value);
        }
        return row-MAX;

    }
}
public class Bricks {


    public static void main(String[] args) {

        List<List<Integer>> wall = new ArrayList<List<Integer>>();
        wall.add(Arrays.asList(1, 2, 2,1));
        wall.add(Arrays.asList(3, 1, 2));
        wall.add(Arrays.asList(1, 3, 2));
        wall.add(Arrays.asList(2,4));
        wall.add(Arrays.asList(3, 1, 2));
        wall.add(Arrays.asList(1,3,1,1));

        Solution s=new Solution();

        System.out.println(s.leastBricks(wall));



    }
}
