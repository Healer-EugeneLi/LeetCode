package Greedy;


import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * 输入：people = [[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]]
 * 输出：[[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]]
 *
 */
public class p406 {

    public int[][] reconstructQueue(int[][] people) {


        //对people数组中的第1个关键字 使用降序排序 方便在插入的时候尽量先让大的排在前面
        //当第1个关键字相等时 对第2个关键字使用升序排序 这样的话就能确保答案是对的
        //比如[5,0] [5,2] 最后[5,0]肯定是排在[5,2]的前面

        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {

                //当第一个关键字相等的时候 对第2个关键字升序
                if (o1[0]==o2[0])
                    return o1[1]-o2[1];
                else //第一个关键字不相等的时候 对第1个关键字降序
                    return o2[0]-o1[0];
            }
        });

        //存放结果集
        List<int[]> res=new LinkedList<>();


        for (int i=0;i<people.length;i++){
            //每遍历到people中的一个[,]的话 就根据当前结果集中是否个数<=这个[,]的第2个关键字
            if (res.size()<=people[i][1])
                res.add(people[i]);  // 如果小于此时直接将这个元组插入到集合的最后
            else // 如果大于的话 插入到集合中索引为[,]的第2个关键字
                res.add(people[i][1],people[i]);
        }

        return res.toArray(new int[res.size()][]);
    }
}
