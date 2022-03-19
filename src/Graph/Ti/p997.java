package Graph.Ti;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName: p997
 * @Description:
 * @Author EugeneLi
 * @Date: 2021/9/29
 * @Time: 11:35
 */
public class p997 {


    class Info {

        int in = 0;
        int out = 0;

        public Info(int in, int out) {
            this.in = in;
            this.out = out;
        }
    }

    public int findJudge(int n, int[][] trust) {

        HashMap<Integer, Info> map = new HashMap<>();

        //[[1,3],[1,4],[2,3],[2,4],[4,3]]
        for (int i = 0; i < trust.length; i++) {//多少对数据

            int[] edge = trust[i];// 1 3 表明1连到3 ，1的出度+1 3的入度+1

            Info a = new Info(map.getOrDefault(edge[0], new Info(0, 0)).in, map.getOrDefault(edge[0], new Info(0, 0)).out + 1);//入度不变 出度+1
            map.put(edge[0], a);

            Info b = new Info(map.getOrDefault(edge[1], new Info(0, 0)).in + 1, map.getOrDefault(edge[1], new Info(0, 0)).out);
            map.put(edge[1], b);
        }

        Set<Map.Entry<Integer, Info>> entries = map.entrySet();
        for (Map.Entry<Integer, Info> temp : entries) {
            if (temp.getValue().in == n - 1 && temp.getValue().out == 0) {
                return temp.getKey();
            }
        }

        return -1;
    }
}
