package Sort;

import java.util.*;

/**
 * @ClassName: p347
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/4/17
 * @Time: 22:40
 * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
 *
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 */
public class p347 {

    public int[] topKFrequent(int[] nums, int k) {


        //先使用map存储 每个元素出现的次数
        Map<Integer,Integer> map=new HashMap<>();
        for (int i=0;i<nums.length;i++){

            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }

        //维护一个k个元素的最小堆
        PriorityQueue<Integer> queue=new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o1)-map.get(o2);//注意比较的是压入的该元素的出现次数 即频率
            }
        });

        for (Integer key:map.keySet()){

            //此时堆中的个数小于k个 直接压入
            if (queue.size()<k){
                queue.add(key);//
            }else {

                //此时比堆顶元素还大 说明这个元素出现的次数更多 替换堆顶
                if (map.get(key)>map.get(queue.peek())){
                    queue.poll();
                    queue.add(key);
                }
            }
        }
        int res[]=new int[k];
        int i=0;
        while (!queue.isEmpty()){
            res[i++]=queue.peek();
            queue.poll();
        }
       return res;
    }

    public static void main(String[] args) {

        int arr[]={4,1,-1,2,-1,2,3};

        p347 t=new p347();
        int[] res = t.topKFrequent(arr, 2);
        for (int i=0;i<res.length;i++){
            System.out.println(res[i]);
        }
    }
}
