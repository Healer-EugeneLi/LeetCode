package PriorityQ;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @ClassName: p215
 * @Description:
 * @Author EugeneLi
 * @Date: 2022/5/1
 * @Time: 11:43
 */
public class p215 {

    /**
     * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {

        //构建一个最小堆 堆顶是最小元素 节点的元素都比堆顶大
        //维护一个k大小的最小堆 最终第k大的肯定是堆顶
        PriorityQueue<Integer> queue=new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });


        for (int num:nums){

            //堆中还没有满 加入该元素
            if (queue.size()<k)
                 queue.add(num);
            else {
                //如果堆已满 而且堆顶的元素小于当前遍历到的元素
                if (queue.size()==k&&queue.peek()<num){
                    //弹出堆顶
                    queue.poll();
                    //加入该元素
                    queue.add(num);
                }
            }

        }

        //最后返回堆顶元素 就是第k
        return queue.peek();
    }

    public static void main(String[] args) {
        int arr[]={-1,2,0};
        int k=2;

        p215 t=new p215();
        int res = t.findKthLargest(arr, k);
        System.out.println(res);
    }
}
