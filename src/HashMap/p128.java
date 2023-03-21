package HashMap;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName: p128
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/5/10
 * @Time: 9:59
 */
public class p128 {


    /**
     * 最长的连续的有序的序列
     * [100,4,200,1,3,2]
     * 结果最长的是 1 2 3 4 所以长度为4
     * @param nums
     * @return
     */
    public int longestConsecutive(int[] nums) {

        /**
         * 整体思路：
         * 1.遍历到每一个数x 判断其x-1前驱是否在set中
         * 2.如果不在 以x为起始 开始判断x+1 x+2 ...x+y是否在set中
         * 3.当找到y是最后一个在set中的是时候
         * 4.计算当前y-x+1是以x为左端点的最长有序序列
         * 5.判断能否更新一下最大值
         */
        int max=0;
        Set<Integer> set=new HashSet<>();//先去重一下
        for (int num:nums){
            set.add(num);
        }

        for (int x:nums){

            //x的前缀不存在  之所以以x的前缀不存在的情况下来判断是因为
            // 如果x的前缀存在的话 那么x就是作为前缀的一个后续有序序列的数 交给x-1在计算的时候处理
            if(!set.contains(x-1)){

                int y=x;
                while (set.contains(y+1)) y++;//不断往后查找 最后跳出循环的时候 y指向的是以x为左端点的有序序列的最后一个

                max=Math.max(max,y-x+1);

            }
        }
        return max;


    }
}
