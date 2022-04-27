package ZS.HuaWei;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: p6041
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/4/24
 * @Time: 10:30
 */
public class p6041 {


    /**
     * 多个数组求交集
     * @param nums
     * @return
     */
    public List<Integer> intersection(int[][] nums) {

        int n=nums.length;//表示有几个子数组
        int count[]=new int[1001];//桶标识一下

        for (int i=0;i<nums.length;i++){
            for (int j=0;j<nums[i].length;j++){

                int cur=nums[i][j];
                count[cur]++;
            }
        }
        List<Integer> list=new ArrayList<>();
        for (int i=0;i<count.length;i++){

            if (count[i]==n)
                list.add(i);
        }

        return list;
    }


}
